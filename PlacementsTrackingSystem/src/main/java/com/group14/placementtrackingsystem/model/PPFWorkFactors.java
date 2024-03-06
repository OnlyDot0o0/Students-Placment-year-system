package com.group14.placementtrackingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*
 *
 * This code is the entity for the Work Factors  section of the Placement Provider Form (PPF)
 *
 * */
@Entity
public class PPFWorkFactors {

    @Id
    @GeneratedValue
    private int id;
    private byte exposeToHazard;
    private byte trainingReq;
    private byte remoteWork; // Yes = 1, N0 = 0
    private byte remoteWorkYes;

    private String remoteWorkYesSupport;
    private String exposeToHazardYes;
    private String trainingReqYes;

    private  String romoteWorkYesReason;
    @OneToOne
    private PPFPlacementProviderDetails company;

    @OneToOne
    private Student student;

    public String getRomoteWorkYesReason() {
        return romoteWorkYesReason;
    }

    public void setRomoteWorkYesReason(String romoteWorkYesReason) {
        this.romoteWorkYesReason = romoteWorkYesReason;
    }



    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public byte getExposeToHazard() {
        return exposeToHazard;
    }

    public void setExposeToHazard(byte exposeToHazard) {
        this.exposeToHazard = exposeToHazard;
    }

    public byte getTrainingReq() {
        return trainingReq;
    }

    public void setTrainingReq(byte trainingReq) {
        this.trainingReq = trainingReq;
    }

    public byte getRemoteWork() {
        return remoteWork;
    }

    public void setRemoteWork(byte remoteWork) {
        this.remoteWork = remoteWork;
    }

    public byte getRemoteWorkYes() {
        return remoteWorkYes;
    }

    public void setRemoteWorkYes(byte remoteWorkYes) {
        this.remoteWorkYes = remoteWorkYes;
    }

    public String getRemoteWorkYesSupport() {
        return remoteWorkYesSupport;
    }

    public void setRemoteWorkYesSupport(String remoteWorkYesSupport) {
        this.remoteWorkYesSupport = remoteWorkYesSupport;
    }

    public String getExposeToHazardYes() {
        return exposeToHazardYes;
    }

    public void setExposeToHazardYes(String exposeToHazardYes) {
        this.exposeToHazardYes = exposeToHazardYes;
    }

    public String getTrainingReqYes() {
        return trainingReqYes;
    }

    public void setTrainingReqYes(String trainingReqYes) {
        this.trainingReqYes = trainingReqYes;
    }

    public PPFPlacementProviderDetails getCompany() {
        return company;
    }

    public void setCompany(PPFPlacementProviderDetails company) {
        this.company = company;
    }


    public String toString() {
        return "PPFWorkFactors{" +
                "id=" + id +
                ", exposeToHazard=" + exposeToHazard +
                ", trainingReq=" + trainingReq +
                ", remoteWork=" + remoteWork +
                ", remoteWorkYes=" + remoteWorkYes +
                ", remoteWorkYesSupport='" + remoteWorkYesSupport + '\'' +
                ", exposeToHazardYes='" + exposeToHazardYes + '\'' +
                ", trainingReqYes='" + trainingReqYes + '\'' +
                ", romoteWorkYesReason='" + romoteWorkYesReason + '\'' +
                ", company=" + company +
                ", student=" + student +
                '}';
    }
}
