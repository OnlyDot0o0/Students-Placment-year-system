package com.group14.placementtrackingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*
*
* This code is the entity for the Health and Safety section of the Placement Provider Form (PPF)
*
* */
@Entity
public class PPFhealth {

    @Id
    @GeneratedValue
    private int id;

    private byte recRepAcc;
    private byte writtenHS;
    private byte hSTrain;

    @OneToOne
    private PPFPlacementProviderDetails company;


    public byte getRecRepAcc() {
        return recRepAcc;
    }


    public void setRecRepAcc(byte recRepAcc) {
        this.recRepAcc = recRepAcc;
    }

    public byte getWrittenHS() {
        return writtenHS;
    }

    public void setWrittenHS(byte writtenHS) {
        this.writtenHS = writtenHS;
    }

    public byte gethSTrain() {
        return hSTrain;
    }

    public void sethSTrain(byte hSTrain) {
        this.hSTrain = hSTrain;
    }

    public PPFPlacementProviderDetails getCompany() {
        return company;
    }

    public void setCompany(PPFPlacementProviderDetails company) {
        this.company = company;
    }
}
