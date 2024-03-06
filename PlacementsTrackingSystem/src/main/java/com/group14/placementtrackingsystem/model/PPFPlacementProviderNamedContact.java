package com.group14.placementtrackingsystem.model;

import javax.persistence.*;

/*
 *
 * This code is the entity for the Named Contact section of the Placement Provider Form (PPF)
 *
 * */

@Entity
public class PPFPlacementProviderNamedContact {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String jobTitle;
    private String email;
    private String telNumber;

    @ManyToOne
    private PPFPlacementProviderDetails company;

    @OneToOne
    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public PPFPlacementProviderDetails getCompany() {
        return company;
    }

    public void setCompany(PPFPlacementProviderDetails company) {
        this.company = company;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
