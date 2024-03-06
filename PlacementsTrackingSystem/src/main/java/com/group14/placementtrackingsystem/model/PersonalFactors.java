package com.group14.placementtrackingsystem.model;
//By Abdulqader and Maryam
//This is the PersonalFactors model class which holds the attributes that are filled out
//in the eighth section of the Student Authorisation Placement Request Form.
//Contains : employerDisabilityAdjustments
//Please look at PersonalFactors jsp to get more context on what the attributes describe

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PersonalFactors {

    @Id
    @GeneratedValue
    private int id;
    private int employerDisabilityAdjustments;

    @OneToOne
    private Student student;

    //Below are getters and setters and toString methods
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getEmployerDisabilityAdjustments() {
        return employerDisabilityAdjustments;
    }

    public void setEmployerDisabilityAdjustments(int employerDisabilityAdjustments) {
        this.employerDisabilityAdjustments = employerDisabilityAdjustments;
    }

    public String toString() {
        return "PersonalFactors{" +
                "id=" + id +
                ", employerDisabilityAdjustments=" + employerDisabilityAdjustments +
                '}';
    }


}
