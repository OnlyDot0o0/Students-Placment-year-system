package com.group14.placementtrackingsystem.controller;

import com.group14.placementtrackingsystem.model.PPFFactors;
import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import com.group14.placementtrackingsystem.repository.PPFFactorsRepo;
import com.group14.placementtrackingsystem.repository.PPFProviderDetailsRepo;
import com.group14.placementtrackingsystem.repository.PPFWorkFactorsRepo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
 *
 * This code validates Placement Provider Factors Form (PPF)
 *
 * */
public class PPFFactorsValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return PPFFactors.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PPFFactors s = (PPFFactors) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "travelSites", "", "Invalid Travel Sites.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "travelReqOverseas", "", "Invalid working overseas.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "locationRisk", "", "Invalid Location Risks.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "healthPrecautionary", "", "Invalid Health Precautions.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "persoFactors", "", "Invalid Personal Factors.");
    }
}
