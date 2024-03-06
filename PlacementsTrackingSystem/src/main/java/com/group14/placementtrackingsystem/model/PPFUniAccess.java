package com.group14.placementtrackingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*
 *
 * This code is the entity for the University Access  section of the Placement Provider Form (PPF)
 *
 * */
@Entity
public class PPFUniAccess {

    @Id
    @GeneratedValue
    private int id;

    private byte visits;
    private byte Issues_Conf;
    private String visitsNo;
    private String issuesYes;

    @OneToOne
    private PPFPlacementProviderDetails company;


    public byte getVisits() {
        return visits;
    }

    public void setVisits(byte visits) {
        this.visits = visits;
    }

    public byte getIssues_Conf() {
        return Issues_Conf;
    }

    public void setIssues_Conf(byte issues_Conf) {
        Issues_Conf = issues_Conf;
    }

    public String getVisitsNo() {
        return visitsNo;
    }

    public void setVisitsNo(String visitsNo) {
        this.visitsNo = visitsNo;
    }

    public String getIssuesYes() {
        return issuesYes;
    }

    public void setIssuesYes(String issuesYes) {
        this.issuesYes = issuesYes;
    }

    public PPFPlacementProviderDetails getCompany() {
        return company;
    }

    public void setCompany(PPFPlacementProviderDetails company) {
        this.company = company;
    }
}
