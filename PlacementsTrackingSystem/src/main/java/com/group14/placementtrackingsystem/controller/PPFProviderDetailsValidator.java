package com.group14.placementtrackingsystem.controller;

import com.group14.placementtrackingsystem.model.PPFDeclaration;
import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import com.group14.placementtrackingsystem.repository.PPFDeclarationRepo;
import com.group14.placementtrackingsystem.repository.PPFProviderDetailsRepo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/*
 *
 * This code validates Placement Provider Details Form (PPF)
 *
 * */

public class PPFProviderDetailsValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PPFPlacementProviderDetails.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        PPFPlacementProviderDetails s = (PPFPlacementProviderDetails) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "organisationName", "", "Invalid Organisation Name");
        if ((!(s.getOrganisationName() instanceof String))){
            errors.rejectValue("organisationName", "", "Please enter text for the organisation name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "placementAddress", "", "Invalid Placement Address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postCode", "", "Invalid Postcode");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "webAddress", "", "Invalid Web Address");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "engagesRegulatedActivities", "", "Please specify if your company engages in regulated activities.");

        

    }
}
