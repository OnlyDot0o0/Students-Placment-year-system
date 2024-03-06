package com.group14.placementtrackingsystem.controller;
//By Abdulqader and Maryam. This is the transportTravelFactorsValidator class which only validates the attributes of the transportTravelFactors model class which corresponds to section 5 of the student form.

import com.group14.placementtrackingsystem.model.TransportTravelFactors;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class TransportTravelFactorsValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return TransportTravelFactors.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TransportTravelFactors t = (TransportTravelFactors) target;
        if (t.getWorkLocationConfirmed()==true){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "workLocationConfirmedFurtherDetails", "", "Please enter details");
        }

    //Haven’t included much validation methods here compared to other validators, as all of the questions are drop down lists, so freedom of input is not easily available to need to validate.

    }
}
