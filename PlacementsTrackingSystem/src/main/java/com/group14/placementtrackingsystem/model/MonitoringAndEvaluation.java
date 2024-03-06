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
public class MonitoringAndEvaluation {
    @Id
    @GeneratedValue
    private int id;

    //The date of contact with the placement provider to
    //check the student has started the placement
    private java.sql.Date dateOfPlacementProviderStartCheck;

    //The date of contact with the student to
    //check they have started the placement
    private java.sql.Date dateOfPlacementStudentStartCheck;

    private String studentResidentialAddressWhileOnPlacement;

    //The student's work placement email address
    private String studentWorkEmail;

    //Date of last monthly reflective journal submitted on blackboard by student
    private java.sql.Date dateOfMostRecentMonthlyReflectiveJournal;

    //If blackboard check-in or monthly reflective journal is out of date,
    //start the tier 4 escalation process with Student Immigration Advice and Compliance
    // (SIAC) and note the date that started here
    private java.sql.Date dateOfStudentVisaEscalation; //date that student visa escalation process started with compliance team

    //The date that SIAC reported the placement details to the UKVI
    private String dateOfSIACReportingToUKVI; //This is a string, not a date, as there is no validation for it in old database cell

    //The date the first placement visit took place
    private java.sql.Date dateOfFirstPlacementVisitCompleted;

    //The date the second plaecment visit took place
    private java.sql.Date dateOfSecondPlacementVisitCompleted;

    //The date when the placement provider evaluation form
    //was received from the placement provider and saved in student folder
    private java.sql.Date dateOfPlacementProviderEvaluationFormReceived;

    //The date when the placement student evaluation form  was received
    //from the placement provider and saved in student folder
    private java.sql.Date dateOfPlacementStudentEvaluationFormReceived;

    //how the placement ended : placementComplete, health, dismissedByEmployer,
    //providerCeasedTrading, studentDisliked, safetyConcerns, other
    private String placementEndReason;

    private java.sql.Date MScProjectStartDate;

    private java.sql.Date estimatedDateOfMScProjectCompletion;

    @OneToOne
    private Student student;

    @OneToOne
    private PPFPlacementProviderDetails company;

    //Getter and setter methods
    public Date getMScProjectStartDate() {
        return MScProjectStartDate;
    }

    public void setMScProjectStartDate(Date MScProjectStartDate) {
        this.MScProjectStartDate = MScProjectStartDate;
    }

    public Date getEstimatedDateOfMScProjectCompletion() {
        return estimatedDateOfMScProjectCompletion;
    }

    public void setEstimatedDateOfMScProjectCompletion(Date estimatedDateOfMScProjectCompletion) {
        this.estimatedDateOfMScProjectCompletion = estimatedDateOfMScProjectCompletion;
    }

    public Date getDateOfPlacementProviderStartCheck() {
        return dateOfPlacementProviderStartCheck;
    }

    public void setDateOfPlacementProviderStartCheck(Date dateOfPlacementProviderStartCheck) {
        this.dateOfPlacementProviderStartCheck = dateOfPlacementProviderStartCheck;
    }

    public Date getDateOfPlacementStudentStartCheck() {
        return dateOfPlacementStudentStartCheck;
    }

    public void setDateOfPlacementStudentStartCheck(Date dateOfPlacementStudentStartCheck) {
        this.dateOfPlacementStudentStartCheck = dateOfPlacementStudentStartCheck;
    }

    public String getStudentResidentialAddressWhileOnPlacement() {
        return studentResidentialAddressWhileOnPlacement;
    }

    public void setStudentResidentialAddressWhileOnPlacement(String studentResidentialAddressWhileOnPlacement) {
        this.studentResidentialAddressWhileOnPlacement = studentResidentialAddressWhileOnPlacement;
    }

    public String getStudentWorkEmail() {
        return studentWorkEmail;
    }

    public void setStudentWorkEmail(String studentWorkEmail) {
        this.studentWorkEmail = studentWorkEmail;
    }

    public Date getDateOfMostRecentMonthlyReflectiveJournal() {
        return dateOfMostRecentMonthlyReflectiveJournal;
    }

    public void setDateOfMostRecentMonthlyReflectiveJournal(Date dateOfMostRecentMonthlyReflectiveJournal) {
        this.dateOfMostRecentMonthlyReflectiveJournal = dateOfMostRecentMonthlyReflectiveJournal;
    }

    public Date getDateOfStudentVisaEscalation() {
        return dateOfStudentVisaEscalation;
    }

    public void setDateOfStudentVisaEscalation(Date dateOfStudentVisaEscalation) {
        this.dateOfStudentVisaEscalation = dateOfStudentVisaEscalation;
    }

    public String getDateOfSIACReportingToUKVI() {
        return dateOfSIACReportingToUKVI;
    }

    public void setDateOfSIACReportingToUKVI(String dateOfSIACReportingToUKVI) {
        this.dateOfSIACReportingToUKVI = dateOfSIACReportingToUKVI;
    }

    public Date getDateOfFirstPlacementVisitCompleted() {
        return dateOfFirstPlacementVisitCompleted;
    }

    public void setDateOfFirstPlacementVisitCompleted(Date dateOfFirstPlacementVisitCompleted) {
        this.dateOfFirstPlacementVisitCompleted = dateOfFirstPlacementVisitCompleted;
    }

    public Date getDateOfSecondPlacementVisitCompleted() {
        return dateOfSecondPlacementVisitCompleted;
    }

    public void setDateOfSecondPlacementVisitCompleted(Date dateOfSecondPlacementVisitCompleted) {
        this.dateOfSecondPlacementVisitCompleted = dateOfSecondPlacementVisitCompleted;
    }

    public Date getDateOfPlacementProviderEvaluationFormReceived() {
        return dateOfPlacementProviderEvaluationFormReceived;
    }

    public void setDateOfPlacementProviderEvaluationFormReceived(Date dateOfPlacementProviderEvaluationFormReceived) {
        this.dateOfPlacementProviderEvaluationFormReceived = dateOfPlacementProviderEvaluationFormReceived;
    }

    public Date getDateOfPlacementStudentEvaluationFormReceived() {
        return dateOfPlacementStudentEvaluationFormReceived;
    }

    public void setDateOfPlacementStudentEvaluationFormReceived(Date dateOfPlacementStudentEvaluationFormReceived) {
        this.dateOfPlacementStudentEvaluationFormReceived = dateOfPlacementStudentEvaluationFormReceived;
    }

    public String getPlacementEndReason() {
        return placementEndReason;
    }

    public void setPlacementEndReason(String placementEndReason) {
        this.placementEndReason = placementEndReason;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public PPFPlacementProviderDetails getCompany() {
        return company;
    }

    public void setCompany(PPFPlacementProviderDetails company) {
        this.company = company;
    }
}


