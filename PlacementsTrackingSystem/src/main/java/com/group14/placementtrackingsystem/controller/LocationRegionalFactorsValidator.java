package com.group14.placementtrackingsystem.controller;
//By Abdulqader and Maryam. This is the LocationRegionalFactors validator class which only validates the attributes of the LocationRegionalFactors model class which corresponds to section 6 of the student form.

import com.group14.placementtrackingsystem.model.LocationRegionalFactors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LocationRegionalFactorsValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return LocationRegionalFactors.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
