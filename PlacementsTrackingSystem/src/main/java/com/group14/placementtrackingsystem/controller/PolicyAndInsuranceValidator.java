package com.group14.placementtrackingsystem.controller;


import com.group14.placementtrackingsystem.model.PolicyAndInsurance;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PolicyAndInsuranceValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return PolicyAndInsurance.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PolicyAndInsurance p = (PolicyAndInsurance) target;
    }
}
