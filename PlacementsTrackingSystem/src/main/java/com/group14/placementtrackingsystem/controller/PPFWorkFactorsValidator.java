package com.group14.placementtrackingsystem.controller;

import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import com.group14.placementtrackingsystem.model.PPFWorkFactors;
import com.group14.placementtrackingsystem.repository.PPFProviderDetailsRepo;
import com.group14.placementtrackingsystem.repository.PPFWorkFactorsRepo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/*
 *
 * This code validates Placement Provider Work Factors Form (PPF)
 *
 * */

public class PPFWorkFactorsValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PPFWorkFactors.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PPFWorkFactors s = (PPFWorkFactors) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "exposeToHazard", "", "Invalid Exposure to Hazards");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trainingReq", "", "Invalid Training Request.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "remoteWork", "", "Invalid Remote Work");
    }
}
