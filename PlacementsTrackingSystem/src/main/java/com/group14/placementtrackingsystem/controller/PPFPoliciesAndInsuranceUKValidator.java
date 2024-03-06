package com.group14.placementtrackingsystem.controller;

import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import com.group14.placementtrackingsystem.model.PPFPoliciesAndInsuranceUK;
import com.group14.placementtrackingsystem.repository.PPFPoliciesInsurenceUkRepo;
import com.group14.placementtrackingsystem.repository.PPFProviderDetailsRepo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/*
 *
 * This code validates Placement Provider Policies and Insurance UK Form (PPF)
 *
 * */

public class PPFPoliciesAndInsuranceUKValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PPFPoliciesAndInsuranceUK.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PPFPoliciesAndInsuranceUK s = (PPFPoliciesAndInsuranceUK) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "publicLiabilityIns", "", "Invalid publicLiabilityIns");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employerLiabilityIns", "", "INVALID EMPLOYER LIABILITY INSURANCE.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "proIndemIns", "", "Invalid Professional Indemnity Insurance");
    }
}
