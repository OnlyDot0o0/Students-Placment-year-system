package com.group14.placementtrackingsystem.model;
//By Abdulqader and Maryam
//This is the TransportTravelFactors model class which holds the attributes that are filled out
//in the Fifth section of the Student Authorisation Placement Request Form.
//Contains : transportMethods, workLocationConfirmed, workLocationConfirmedFurtherDetails,
// confirmedWorkLocation, overseasPlacement, overseasTravelGuidance
//Please look at Transport Travels Factors jsp to get more context on what the attributes describe

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.swing.text.StyledEditorKit;

@Entity
public class TransportTravelFactors {
    //Below contains the attributes filled out by the student in the fifth form section
    @Id
    @GeneratedValue
    private int id;

    private String transportMethods;

    private Boolean workLocationConfirmed;


    private String workLocationConfirmedFurtherDetails;

    private int confirmedWorkLocation;

    private Boolean overseasPlacement;

    private Boolean overseasTravelGuidance;

    @OneToOne
    private Student student;

    //These are getters and setters, and toString

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTransportMethods() {
        return transportMethods;
    }

    public void setTransportMethods(String transportMethods) {
        this.transportMethods = transportMethods;
    }

    public Boolean getWorkLocationConfirmed() {
        return workLocationConfirmed;
    }

    public void setWorkLocationConfirmed(Boolean workLocationConfirmed) {
        this.workLocationConfirmed = workLocationConfirmed;
    }

    public int getConfirmedWorkLocation() {
        return confirmedWorkLocation;
    }

    public void setConfirmedWorkLocation(int confirmedWorkLocation) {
        this.confirmedWorkLocation = confirmedWorkLocation;
    }

    public Boolean getOverseasPlacement() {
        return overseasPlacement;
    }

    public void setOverseasPlacement(Boolean overseasPlacement) {
        this.overseasPlacement = overseasPlacement;
    }

    public Boolean getOverseasTravelGuidance() {
        return overseasTravelGuidance;
    }

    public void setOverseasTravelGuidance(Boolean overseasTravelGuidance) {
        this.overseasTravelGuidance = overseasTravelGuidance;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getWorkLocationConfirmedFurtherDetails() {
        return workLocationConfirmedFurtherDetails;
    }

    public void setWorkLocationConfirmedFurtherDetails(String workLocationConfirmedFurtherDetails) {
        this.workLocationConfirmedFurtherDetails = workLocationConfirmedFurtherDetails;
    }

    public String toString() {
        return "TransportTravelFactors{" +
                "id=" + id +
                ", transportMethods='" + transportMethods + '\'' +
                ", workLocationConfirmed=" + workLocationConfirmed +
                ", workLocationConfirmedFurtherDetails='" + workLocationConfirmedFurtherDetails + '\'' +
                ", confirmedWorkLocation=" + confirmedWorkLocation +
                ", overseasPlacement=" + overseasPlacement +
                ", overseasTravelGuidance='" + overseasTravelGuidance + '\'' +
                ", student=" + student +
                '}';
    }
}
