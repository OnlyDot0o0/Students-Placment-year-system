package com.group14.placementtrackingsystem.controller;

import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import com.group14.placementtrackingsystem.model.PPFUniAccess;
import com.group14.placementtrackingsystem.repository.PPFProviderDetailsRepo;
import com.group14.placementtrackingsystem.repository.PPFUniAccessRepo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class PPFUniAccessValidator implements Validator {

//    private PPFUniAccessRepo arepo;
//
//    public PPFUniAccessValidator(PPFUniAccessRepo arepo) {
//        this.arepo = arepo;
//    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PPFUniAccess.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PPFUniAccess s = (PPFUniAccess) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "visits", "", "Please specify if staff can visit students.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Issues_Conf", "", "Please specify if there are issues relating to confidentiality.");
    }
}
