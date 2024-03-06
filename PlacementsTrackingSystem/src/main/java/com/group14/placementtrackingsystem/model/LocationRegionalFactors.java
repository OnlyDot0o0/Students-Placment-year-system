package com.group14.placementtrackingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class LocationRegionalFactors {

    @Id
    @GeneratedValue
    private int id;

    private String accommodationArrangements;

    private boolean fcdoInfo;

    public boolean isFcdoInfo() {
        return fcdoInfo;
    }

    public void setFcdoInfo(boolean fcdoInfo) {
        this.fcdoInfo = fcdoInfo;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private int riskAware;

    private String riskDescription;

    @OneToOne
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccommodationArrangements() {
        return accommodationArrangements;
    }

    public void setAccommodationArrangements(String accommodationArrangements) {
        this.accommodationArrangements = accommodationArrangements;
    }

    public Boolean getFcdoInfo() {
        return fcdoInfo;
    }

    public void setFcdoInfo(Boolean fcdoInfo) {
        this.fcdoInfo = fcdoInfo;
    }

    public int getRiskAware() {
        return riskAware;
    }

    public void setRiskAware(int riskAware) {
        this.riskAware = riskAware;
    }

    public String getRiskDescription() {
        return riskDescription;
    }

    public void setRiskDescription(String riskDescription) {
        this.riskDescription = riskDescription;
    }

    public String toString() {
        return "LocationRegionalFactors{" +
                "id=" + id +
                ", accommodationArrangements='" + accommodationArrangements + '\'' +
                ", fcdoInfo=" + fcdoInfo +
                ", riskAware=" + riskAware +
                ", riskDescription='" + riskDescription + '\'' +
                ", student=" + student +
                '}';
    }
}
