package com.group14.placementtrackingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Date;


/*
 *
 * This code is the entity for the Placement Provider Declaration section of the Placement Provider Form (PPF)
 *
 * */
@Entity
public class PPFDeclaration {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String jobTitle;
    private String signature;
    private Date date;


    @OneToOne
    private PPFPlacementProviderDetails company;

    /**
     * @return name of declaration signer.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name set name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return job title
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * @param jobTitle The job title.
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * @return signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * @param signature signature
     */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * @return value of date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date set the date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return class of Placement Provider Details.
     */
    public PPFPlacementProviderDetails getCompany() {
        return company;
    }

    /**
     * @param company The placement Provider Details.
     */
    public void setCompany(PPFPlacementProviderDetails company) {
        this.company = company;
    }
}
