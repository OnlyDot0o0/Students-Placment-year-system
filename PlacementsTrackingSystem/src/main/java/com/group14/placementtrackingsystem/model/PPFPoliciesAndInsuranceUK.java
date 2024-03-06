package com.group14.placementtrackingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Date;

/*
 *
 * This code is the entity for the Policies and Insurance UK only section of the Placement Provider Form (PPF)
 *
 * */
@Entity
public class PPFPoliciesAndInsuranceUK {

    @Id @GeneratedValue
    private int Id;

    private byte publicLiabilityIns;
    private String PlNameProvider;
    private Date PlExpiry;
    private String PlNo;
    private byte employerLiabilityIns;
    private String ElNameProvider;
    private Date ElExpiry;
    private String ElNo;
    private byte proIndemIns;
    private String proNameProvider;
    private Date proExpiry;


    @OneToOne
    private PPFPlacementProviderDetails company;

    public byte getPublicLiabilityIns() {
        return publicLiabilityIns;
    }

    public void setPublicLiabilityIns(byte publicLiabilityIns) {
        this.publicLiabilityIns = publicLiabilityIns;
    }

    public String getPlNameProvider() {
        return PlNameProvider;
    }

    public void setPlNameProvider(String plNameProvider) {
        PlNameProvider = plNameProvider;
    }

    public Date getPlExpiry() {
        return PlExpiry;
    }

    public void setPlExpiry(Date plExpiry) {
        PlExpiry = plExpiry;
    }

    public String getPlNo() {
        return PlNo;
    }

    public void setPlNo(String plNo) {
        PlNo = plNo;
    }

    public byte getEmployerLiabilityIns() {
        return employerLiabilityIns;
    }

    public void setEmployerLiabilityIns(byte employerLiabilityIns) {
        this.employerLiabilityIns = employerLiabilityIns;
    }

    public String getElNameProvider() {
        return ElNameProvider;
    }

    public void setElNameProvider(String elNameProvider) {
        ElNameProvider = elNameProvider;
    }

    public Date getElExpiry() {
        return ElExpiry;
    }

    public void setElExpiry(Date elExpiry) {
        ElExpiry = elExpiry;
    }

    public String getElNo() {
        return ElNo;
    }

    public void setElNo(String elNo) {
        ElNo = elNo;
    }

    public byte getProIndemIns() {
        return proIndemIns;
    }

    public void setProIndemIns(byte proIndemIns) {
        this.proIndemIns = proIndemIns;
    }

    public String getProNameProvider() {
        return proNameProvider;
    }

    public void setProNameProvider(String proNameProvider) {
        this.proNameProvider = proNameProvider;
    }

    public Date getProExpiry() {
        return proExpiry;
    }

    public void setProExpiry(Date proExpiry) {
        this.proExpiry = proExpiry;
    }

    public PPFPlacementProviderDetails getCompany() {
        return company;
    }

    public void setCompany(PPFPlacementProviderDetails company) {
        this.company = company;
    }
}
