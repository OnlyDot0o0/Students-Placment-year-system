package com.group14.placementtrackingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Date;

/*
 *
 * This code is the entity for the Policies and Insurance Overseas only section of the Placement Provider Form (PPF)
 *
 * */
@Entity
public class PPFPoliciesAndInsuranceOVERSEAS {
    @Id
    @GeneratedValue
    private int id;

    private byte liabilityIns;
    private String liNameProvider;
    private Date liExpiry;

    private byte roleIns;
    private String roleInsProviderName;
    private Date roleInsExpiry;


    private byte compCosts;
    private String compCostsProviderName;
    private Date compCostsExpiry;

    @OneToOne
    private PPFPlacementProviderDetails company;


    public byte getLiabilityIns() {
        return liabilityIns;
    }

    public void setLiabilityIns(byte liabilityIns) {
        this.liabilityIns = liabilityIns;
    }

    public String getLiNameProvider() {
        return liNameProvider;
    }

    public void setLiNameProvider(String liNameProvider) {
        this.liNameProvider = liNameProvider;
    }

    public Date getLiExpiry() {
        return liExpiry;
    }

    public void setLiExpiry(Date liExpiry) {
        this.liExpiry = liExpiry;
    }

    public byte getRoleIns() {
        return roleIns;
    }

    public void setRoleIns(byte roleIns) {
        this.roleIns = roleIns;
    }

    public String getRoleInsProviderName() {
        return roleInsProviderName;
    }

    public void setRoleInsProviderName(String roleInsProviderName) {
        this.roleInsProviderName = roleInsProviderName;
    }

    public Date getRoleInsExpiry() {
        return roleInsExpiry;
    }

    public void setRoleInsExpiry(Date roleInsExpiry) {
        this.roleInsExpiry = roleInsExpiry;
    }

    public byte getCompCosts() {
        return compCosts;
    }

    public void setCompCosts(byte compCosts) {
        this.compCosts = compCosts;
    }

    public String getCompCostsProviderName() {
        return compCostsProviderName;
    }

    public void setCompCostsProviderName(String compCostsProviderName) {
        this.compCostsProviderName = compCostsProviderName;
    }

    public Date getCompCostsExpiry() {
        return compCostsExpiry;
    }

    public void setCompCostsExpiry(Date compCostsExpiry) {
        this.compCostsExpiry = compCostsExpiry;
    }

    public PPFPlacementProviderDetails getCompany() {
        return company;
    }

    public void setCompany(PPFPlacementProviderDetails company) {
        this.company = company;
    }
}
