package com.group14.placementtrackingsystem.controller;
//By Abdulqader and Maryam. This is the HealthEnvironmentalFactorsValidator class which only validates the attributes of the HealthEnvironemntalFactors model class which corresponds to section 7 of the student form.

import com.group14.placementtrackingsystem.model.HealthEnvironmentalFactors;
import com.group14.placementtrackingsystem.model.Role;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class HealthEnvironmentalFactorsValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return HealthEnvironmentalFactors.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        HealthEnvironmentalFactors h = (HealthEnvironmentalFactors) target;
        //These validators are used to check if the shown options are selected (and they haven’t been messed with in the inspect element html code)
        //precautionaryMeasuresAware
        if (!(h.getPrecautionaryMeasuresAware().equals(true) || h.getPrecautionaryMeasuresAware().equals(false))) {
            errors.rejectValue("precautionaryMeasuresAware", "", "You need to select Yes or No" );
        }

        //precautionaryMeasuresDescription
        //Checks that if yes is entered for knowing about precautionary measures, then they have to answer the following question. If no, then it is optional for them and can be left out.
        if (h.getPrecautionaryMeasuresAware().equals(true)){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "precautionaryMeasuresDescription", "", "Please provide details of known precautionary measures");
        }

        //safezoneDownloaded
        if (!(h.getSafezoneDownloaded().equals(true) || h.getSafezoneDownloaded().equals(false))) {
            errors.rejectValue("safezoneDownloaded", "", "You need to select Yes or No" );
        }
        //gliCard is optional so left out
    }
}
