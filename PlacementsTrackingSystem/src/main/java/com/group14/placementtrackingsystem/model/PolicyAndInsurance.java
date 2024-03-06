package com.group14.placementtrackingsystem.model;
//By Abdulqader and Maryam
//This is the PolicyAndInsurance model class which holds the attributes that are filled out
//in the ninth section of the Student Authorisation Placement Request Form.
//Contains : studentTravelApplication, riskAssessmentEscalation
//Please look at PoliciesAndInsurance jsp to get more context on what the attributes describe

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PolicyAndInsurance {
    @Id
    @GeneratedValue
    private int id;

    private boolean studentTravelApplication;
    private boolean riskAssessmentEscalation;

    //Below are getters and setter methods, and toString methods

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @OneToOne
    private Student student;


    public int getId() {
        return id;
    }

    public String toString() {
        return "PoliciesAndInsurance{" +
                "id=" + id +
                ", studentTravelApplication=" + studentTravelApplication +
                ", riskAssessmentEscalation=" + riskAssessmentEscalation +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStudentTravelApplication() {
        return studentTravelApplication;
    }

    public void setStudentTravelApplication(boolean studentTravelApplication) {
        this.studentTravelApplication = studentTravelApplication;
    }

    public boolean isRiskAssessmentEscalation() {
        return riskAssessmentEscalation;
    }

    public void setRiskAssessmentEscalation(boolean riskAssessmentEscalation) {
        this.riskAssessmentEscalation = riskAssessmentEscalation;
    }


}
