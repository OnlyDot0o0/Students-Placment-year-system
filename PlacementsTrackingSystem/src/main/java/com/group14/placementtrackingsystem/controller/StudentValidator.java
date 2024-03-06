package com.group14.placementtrackingsystem.controller;
/*
By Abdulqader and Maryam
This is the StudentValidator class which validates
only the details entered in the Student section (1)
in the Student form.
*/
import com.group14.placementtrackingsystem.PlacementTrackingSystemApplication;
import com.group14.placementtrackingsystem.model.Student;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {

        return Student.class.equals(clazz);
    }

    @Override //Below validates the Student Model attributes. Most/All lists that         are used for the drop down inputs are accessed from the Spring Boot application
    public void validate(Object target, Errors errors) {
        Student s = (Student) target;

        //first-name field - this cell will only accept text
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "", "You need to enter your First Name");

        //surname field - this cell will only accept text
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "", "You need to enter your Last Name");

        //Student number field
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "studentNumber", "", "You need to enter your student number");

        //email field - this cell will only accept a full @student.le.ac.uk email address
        if (!(s.getUniEmailAddress().endsWith("@student.le.ac.uk"))){
            errors.rejectValue("uniEmailAddress", "", "Please enter your Student email address");
        }

        //student type field - is a drop down list that only includes Undergraduate or Postgraduate field
        List<String> studentType= new ArrayList<String>(Arrays.asList(PlacementTrackingSystemApplication.studentType));
        if (!(studentType.contains(s.getStudentType()))){
            errors.rejectValue("studentType", "", "Choose your student type");
        }

        //school/department field - drop down list
        List<String> departmentOrSchool= new ArrayList<String>(Arrays.asList(PlacementTrackingSystemApplication.departmentOrSchool));
        if (!(departmentOrSchool.contains(s.getDepartmentOrSchool()))){
            errors.rejectValue("departmentOrSchool", "", "Choose the department/school you study under");
        }

        //year of study - drop down list
        //Using years 1 to 7 here + a gap year
        List<String> yearOfStudy= new ArrayList<String>(Arrays.asList(PlacementTrackingSystemApplication.yearOfStudy));
        if (!(yearOfStudy.contains(s.getYearOfStudy()))){
            errors.rejectValue("yearOfStudy", "", "Choose the year of study you are currently doing");
        }

        //programme - string input
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "programme", "", "Please enter your full degree course title e.g. BSc Computer Science");

        //telephoneNumber
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "telephoneNumber", "", "Please enter your phone number");

        //student status - home or international - drop down list
        List<String> studentStatus= new ArrayList<String>(Arrays.asList(PlacementTrackingSystemApplication.studentStatus));
        if (!(studentStatus.contains(s.getStudentStatus()))){
            errors.rejectValue("studentStatus", "", "Please select your student status");
        }

        //courseTransferRequired and additionalNotes are not validated here as they are not entered in by the student in the student form, they would be done by the placement team.

    }
}
