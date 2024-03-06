package com.group14.placementtrackingsystem.controller;
//By Abdulqader and Maryam. This is the PersonalFactorsValidator class which only validates the attributes of the PersonalFactors model class which corresponds to section 8 of the student form.

import com.group14.placementtrackingsystem.model.PersonalFactors;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonalFactorsValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return PersonalFactors.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println(target);
        PersonalFactors p = (PersonalFactors) target;
        System.out.println(p);

        //As the values for this are 1,2,3. Checks if one of the list is selected and that it hasn’t been adjusted in the html code. 
        if ( 1 > p.getEmployerDisabilityAdjustments() || p.getEmployerDisabilityAdjustments()> 3){
            errors.rejectValue("employerDisabilityAdjustments", "", "Please select from the list");
        }
    }
}
