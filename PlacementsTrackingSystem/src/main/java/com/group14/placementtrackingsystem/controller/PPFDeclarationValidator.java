package com.group14.placementtrackingsystem.controller;

import com.group14.placementtrackingsystem.model.PPFDeclaration;
import com.group14.placementtrackingsystem.repository.PPFDeclarationRepo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
 *
 * This code validates Placement Provider Delcaration Form (PPF)
 *
 * */
public class PPFDeclarationValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return PPFDeclaration.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PPFDeclaration s = (PPFDeclaration) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "Please enter a valid name.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "jobTitle", "", "Invalid Job Title.");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "", "Invalid Date");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "signature", "", "Invalid Signature.");
    }
}
