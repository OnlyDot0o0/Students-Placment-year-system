package com.group14.placementtrackingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Date;
/*
By Maryam. This file was created in order to save certain details from the
old Excel Master Tracker database to our new system database
 */
@Entity
public class DatesOfFormCompletions {

    @Id
    @GeneratedValue
    private int id;


    //Date of authorisation request form received
    private java.sql.Date studentAuthorisationRequestFormReceived;


    //Date of Placement Provider Form Received (from riskForm)
    private java.sql.Date providerFormReceived;


    //Date of Placement Assessment Form Received (from riskForm)
    private java.sql.Date assessmentFormReceived;

    @OneToOne
    private RiskForm riskForm; //for placementAssessmentFormReceived

    @OneToOne
    private Student student;

    @OneToOne
    private PPFPlacementProviderDetails company;


    //Getter and setter methods
    public PPFPlacementProviderDetails getCompany() {
        return company;
    }

    public void setCompany(PPFPlacementProviderDetails company) {
        this.company = company;
    }

    public RiskForm getRiskForm() {
        return riskForm;
    }

    public void setRiskForm(RiskForm riskForm) {
        this.riskForm = riskForm;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getStudentAuthorisationRequestFormReceived() {
        return studentAuthorisationRequestFormReceived;
    }

    public void setStudentAuthorisationRequestFormReceived(Date studentAuthorisationRequestFormReceived) {
        this.studentAuthorisationRequestFormReceived = studentAuthorisationRequestFormReceived;
    }

    public Date getProviderFormReceived() {
        return providerFormReceived;
    }

    public void setProviderFormReceived(Date providerFormReceived) {
        this.providerFormReceived = providerFormReceived;
    }

    public Date getAssessmentFormReceived() {
        return assessmentFormReceived;
    }

    public void setAssessmentFormReceived(Date assessmentFormReceived) {
        this.assessmentFormReceived = assessmentFormReceived;
    }
}
