package com.group14.placementtrackingsystem.model;
//By Abdulqader and Maryam
//This is the HealthEnvironmentalFactors model class which holds the attributes that are filled out
//in the seventh section of the Student Authorisation Placement Request Form.
//Contains : precautionaryMeasuresAware, precautionaryMeasuresDescription,
//safezoneDownloaded, gliCard
//Please look at HealthEnvironmentalFactors jsp to get more context on what the attributes describe
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class HealthEnvironmentalFactors {
    //These attributes contain the seventh section details filled out by the student in the form
    @Id
    @GeneratedValue
    private int id;

    private Boolean precautionaryMeasuresAware;

    private String  precautionaryMeasuresDescription;

    private Boolean safezoneDownloaded;

    private int gliCard;
    @OneToOne
    private Student student;

    //Below are getters and setters, and toString methods

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getPrecautionaryMeasuresAware() {
        return precautionaryMeasuresAware;
    }

    public void setPrecautionaryMeasuresAware(Boolean precautionaryMeasuresAware) {
        this.precautionaryMeasuresAware = precautionaryMeasuresAware;
    }

    public String getPrecautionaryMeasuresDescription() {
        return precautionaryMeasuresDescription;
    }

    public void setPrecautionaryMeasuresDescription(String precautionaryMeasuresDescription) {
        this.precautionaryMeasuresDescription = precautionaryMeasuresDescription;
    }

    public Boolean getSafezoneDownloaded() {
        return safezoneDownloaded;
    }

    public void setSafezoneDownloaded(Boolean safezoneDownloaded) {
        this.safezoneDownloaded = safezoneDownloaded;
    }

    public int getGliCard() {
        return gliCard;
    }

    public void setGliCard(int gliCard) {
        this.gliCard = gliCard;
    }

    public String toString() {
        return "HealthEnvironmentalFactors{" +
                "id=" + id +
                ", precautionaryMeasuresAware=" + precautionaryMeasuresAware +
                ", precautionaryMeasuresDescription='" + precautionaryMeasuresDescription + '\'' +
                ", safezoneDownloaded=" + safezoneDownloaded +
                ", gliCard=" + gliCard +
                '}';
    }



}
