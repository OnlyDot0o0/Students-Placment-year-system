package com.group14.placementtrackingsystem.controller;
//By Abdulqader and Maryam. This is the RoleValidator class which only validates the attributes of the Role model class which corresponds to section 3 of the student form. 

import com.group14.placementtrackingsystem.model.Role;
import com.group14.placementtrackingsystem.model.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.group14.placementtrackingsystem.PlacementTrackingSystemApplication;

public class RoleValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Role.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println(target );
        Role r = (Role) target;
        //roleTitle - text
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleTitle", "", "You need to enter your Placement Job/Role Title");

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

        //probationLength
        if(r.isProbationPeriod()==true){
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "probationLength", "", "Please state the length of your probation period");
        }

        //annualSalary
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "annualSalary", "", "Please enter your annual salary");
        if (r.getAnnualSalary()<0){
            errors.rejectValue("annualSalary", "", "Please enter a valid number for your salary");
        }

        //roleSource
        List<String> roleSources= new ArrayList<String>(Arrays.asList(PlacementTrackingSystemApplication.roleSources));
        if (!(roleSources.contains(r.getRoleSource()))){
            errors.rejectValue("roleSource", "", "Please select from the list where you found out about the role");
        }

        //providerInformedDegree
        if (!(r.getProviderInformedDegree() == true || r.getProviderInformedDegree()==false)){
            errors.rejectValue("providerInformedDegree", "", "Please select Yes or No");
        }
        //roleDescription
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "roleDescription", "", "Please provide a role description");

    }
}
