package com.group14.placementtrackingsystem.model;
//By Abdulqader and Maryam
//This is the Student Model class which holds the attributes that are filled out
//in the first section of the Student Authorisation Placement Request Form.
//Contains : studentNumber, firstName, surname, uniEmailAddress, studentType,
//departmentOrSchool, yearOfStudy, programme, telephoneNumber, studentStatus
//courseTransferRequired, additionalNotes

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
    //This following section of Student attributes are all obtained in the first section of the student form
    @Id
    private String studentNumber;
    private String firstName;
    private String surname;
    private String uniEmailAddress;
    private String studentType;                                             //Undergraduate or Postgraduate
    private String departmentOrSchool;                                      //e.g. Biochemistry
    private String yearOfStudy;
    private String programme;                                               //e.g. BSc Computer Science
    private String telephoneNumber;
    private String studentStatus;                                           //Home or International
    private Boolean visaDuration;
    //This following section is NOT included in the Student form section, and is entered in by the placement team
    private Boolean courseTransferRequired;
    private String additionalNotes;

    //Below contains getters setters and toString methods

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUniEmailAddress() {
        return uniEmailAddress;
    }

    public void setUniEmailAddress(String uniEmailAddress) {
        this.uniEmailAddress = uniEmailAddress;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    public String getDepartmentOrSchool() {
        return departmentOrSchool;
    }

    public void setDepartmentOrSchool(String departmentOrSchool) {
        this.departmentOrSchool = departmentOrSchool;
    }

    public String getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(String yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }

    public Boolean getCourseTransferRequired() {
        return courseTransferRequired;
    }

    public void setCourseTransferRequired(Boolean courseTransferRequired) {
        this.courseTransferRequired = courseTransferRequired;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Boolean getVisaDuration() {
        return visaDuration;
    }

    public void setVisaDuration(Boolean visaDuration) {
        this.visaDuration = visaDuration;
    }

    public String toString() {
        return "Student{" +
                "studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", uniEmailAddress='" + uniEmailAddress + '\'' +
                ", studentType='" + studentType + '\'' +
                ", departmentOrSchool='" + departmentOrSchool + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                ", programme='" + programme + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", studentStatus='" + studentStatus + '\'' +
                ", courseTransferRequired=" + courseTransferRequired +
                ", additionalNotes='" + additionalNotes + '\'' +
                ", visaDuration=" + visaDuration +
                '}';
    }
}
