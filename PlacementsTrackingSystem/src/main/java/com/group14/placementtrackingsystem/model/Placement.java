package com.group14.placementtrackingsystem.model;

import javax.persistence.*;
import java.sql.Date;


/*
this is the placement class made by Zaina and Moaz.
This class connects the Students, Role and PPFPlacementProviderDetails class by using
relationship annotations which are @OneToOne
Here we have an id attribute of type Integer which is autogenerated by the system
and an attribute called today of type Date which shows the current date
and an attribute called remotework of type String which tells us if the student is
working from home or not, so the output is either Yes or No
 */
@Entity
@Table(name="PlacementStudents")

public class Placement{
    @Id
    @GeneratedValue
    private int id;
    private Date today;
    private String remoteWork;

    private int approvalStatus = 0; // 0 WAITING APPROVAL, 1 APPROVED , 2 FLAGGED, 3 Rejected

    private String statusReason = "No Reason"; // Reason for why an action was taken.

    @OneToOne
    private Student student;
    @OneToOne
    private PPFPlacementProviderDetails company;
    @OneToOne
    private Role role;
    @OneToOne
    private PPFWorkFactors workFactors;

    @OneToOne
    private PPFPlacementProviderNamedContact providerNamedContact;
    @OneToOne
    private TransportTravelFactors transportTravelFactors;
    @OneToOne
    private LocationRegionalFactors locationRegionalFactors;
    @OneToOne
    private HealthEnvironmentalFactors healthEnvironmentalFactors;
    @OneToOne
    private PersonalFactors personalFactors;
    @OneToOne
    private PolicyAndInsurance policyAndInsurance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public String getRemoteWork() {
        return remoteWork;
    }

    public void setRemoteWork(String remoteWork) {
        this.remoteWork = remoteWork;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public PPFPlacementProviderDetails getCompany() {
        return company;
    }

    public void setCompany(PPFPlacementProviderDetails company) {
        this.company = company;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public PPFWorkFactors getWorkFactors() {
        return workFactors;
    }

    public void setWorkFactors(PPFWorkFactors workFactors) {
        this.workFactors = workFactors;
    }

    public PPFPlacementProviderNamedContact getProviderNamedContact() {
        return providerNamedContact;
    }

    public void setProviderNamedContact(PPFPlacementProviderNamedContact providerNamedContact) {
        this.providerNamedContact = providerNamedContact;
    }

    public TransportTravelFactors getTransportTravelFactors() {
        return transportTravelFactors;
    }

    public void setTransportTravelFactors(TransportTravelFactors transportTravelFactors) {
        this.transportTravelFactors = transportTravelFactors;
    }

    public LocationRegionalFactors getLocationRegionalFactors() {
        return locationRegionalFactors;
    }

    public void setLocationRegionalFactors(LocationRegionalFactors locationRegionalFactors) {
        this.locationRegionalFactors = locationRegionalFactors;
    }

    public HealthEnvironmentalFactors getHealthEnvironmentalFactors() {
        return healthEnvironmentalFactors;
    }

    public void setHealthEnvironmentalFactors(HealthEnvironmentalFactors healthEnvironmentalFactors) {
        this.healthEnvironmentalFactors = healthEnvironmentalFactors;
    }

    public PersonalFactors getPersonalFactors() {
        return personalFactors;
    }

    public void setPersonalFactors(PersonalFactors personalFactors) {
        this.personalFactors = personalFactors;
    }

    public PolicyAndInsurance getPolicyAndInsurance() {
        return policyAndInsurance;
    }

    public void setPolicyAndInsurance(PolicyAndInsurance policyAndInsurance) {
        this.policyAndInsurance = policyAndInsurance;
    }

    public int getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(int approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

        @Override
    public String toString() {
        return "Placement{" +
                "id=" + id +
                ", today=" + today +
                ", remoteWork='" + remoteWork + '\'' +
                ", student=" + student +
                ", company=" + company +
                ", role=" + role +
                ", workFactors=" + workFactors +
                ", providerNamedContact=" + providerNamedContact +
                ", transportTravelFactors=" + transportTravelFactors +
                ", locationRegionalFactors=" + locationRegionalFactors +
                ", healthEnvironmentalFactors=" + healthEnvironmentalFactors +
                ", personalFactors=" + personalFactors +
                ", policyAndInsurance=" + policyAndInsurance +
                '}';
    }
}
