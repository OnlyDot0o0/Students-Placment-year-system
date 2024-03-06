package com.group14.placementtrackingsystem.controller;
//By Abdulqader and Maryam. This is the RoleValidator class which only validates the attributes of the Role model class which corresponds to section 3 of the student form. 

import com.group14.placementtrackingsystem.PlacementTrackingSystemApplication;
import com.group14.placementtrackingsystem.model.Role;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.sql.Date;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 *
 * This code validates Placement Provider Roles Form (PPF)
 *
 * */
public class PPFRoleValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Role.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Role r = (Role) target;
        //roleTitle - text
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleTitle", "", "You need to enter your Placement Job/Role Title");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ppfStudentName", "", "You need to enter a valid student name.");

        //roleStartDate //unsure whether to check if it is of type date, need to see what it looks like after the html version before making java check the same thing
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleStartDate", "", "You need to enter your start date for your Placement Role");
        if ((!(r.getRoleStartDate() instanceof Date))){ //Date here is SQL Not Java util
            errors.rejectValue("roleStartDate", "", "Please enter your start date for your Placement Role");
        }

        //roleEndDate //CHECK POST IT NOTE
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleEndDate", "", "You need to enter your end date for your Placement Role");
        if ((!(r.getRoleEndDate() instanceof Date))){ //Date here is SQL Not Java util
            errors.rejectValue("roleEndDate", "", "Please enter your end date for your Placement Role");
        }

        //workingHoursWeek
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "workingHoursWeek", "", "You need to enter the amount of working hours you have per week");
        if(r.getWorkingHoursWeek()<=0){
            errors.rejectValue("workingHoursWeek", "", "Please enter a valid number of working hours");
        }
        //probationPeriod
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "probationPeriod", "", "Please enter Yes or No");
        if(!(r.isProbationPeriod()==true || r.isProbationPeriod()==false)){ //Not sure if this will be problem later as is not 0 or 1
            errors.rejectValue("probationPeriod", "", "Please select from the list");
        }


    }
}
