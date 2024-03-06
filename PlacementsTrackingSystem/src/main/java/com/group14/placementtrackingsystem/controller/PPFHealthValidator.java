package com.group14.placementtrackingsystem.controller;

import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import com.group14.placementtrackingsystem.model.PPFhealth;
import com.group14.placementtrackingsystem.repository.PPFHealthRepo;
import com.group14.placementtrackingsystem.repository.PPFProviderDetailsRepo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/*
 *
 * This code validates Placement Provider Health Form (PPF)
 *
 * */
public class PPFHealthValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PPFhealth.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PPFhealth s = (PPFhealth) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "recRepAcc", "", "Invalid recording and reporting procedures.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writtenHS", "", "You need to enter your Last Name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "hSTrain", "", "Invalid health safety training!");
    }
}
