package com.group14.placementtrackingsystem.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * This code is the entity for the Placement Provider details section of the Placement Provider Form (PPF)
 *
 * */

@Entity
public class PPFPlacementProviderDetails {
    @Id
    @GeneratedValue
    private int id;

    private String organisationName;
    private String placementAddress;
    private String postCode;
    private String webAddress;
    private byte engagesRegulatedActivities;
    private String  engagesRegulatedActivitiesYes;

    @OneToMany
    private List<PPFPlacementProviderNamedContact> NamedContactList = new ArrayList<PPFPlacementProviderNamedContact>();
    @OneToOne
    private PPFDeclaration declaration;
    @OneToOne
    private PPFFactors factor;
    @OneToOne
    private PPFhealth health;
    @OneToOne
    private PPFPoliciesAndInsuranceOVERSEAS polciesInsOverseas;
    @OneToOne
    private PPFPoliciesAndInsuranceUK polciesInsUk;
    @OneToOne
    private PPFUniAccess uniAccess;
    @OneToOne
    private PPFWorkFactors workFactors;

    @OneToOne
    private Role role;

    @OneToOne
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getPlacementAddress() {
        return placementAddress;
    }

    public void setPlacementAddress(String placementAddress) {
        this.placementAddress = placementAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getWebAddress() {
        return webAddress;
    }

    public void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public byte getEngagesRegulatedActivities() {
        return engagesRegulatedActivities;
    }

    public void setEngagesRegulatedActivities(byte engagesRegulatedActivities) {
        this.engagesRegulatedActivities = engagesRegulatedActivities;
    }

    public String getEngagesRegulatedActivitiesYes() {
        return engagesRegulatedActivitiesYes;
    }

    public void setEngagesRegulatedActivitiesYes(String engagesRegulatedActivitiesYes) {
        this.engagesRegulatedActivitiesYes = engagesRegulatedActivitiesYes;
    }

    public List<PPFPlacementProviderNamedContact> getNamedContactList() {
        return NamedContactList;
    }

    public void setNamedContactList(List<PPFPlacementProviderNamedContact> namedContactList) {
        NamedContactList = namedContactList;
    }

    public PPFDeclaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(PPFDeclaration declaration) {
        this.declaration = declaration;
    }

    public PPFFactors getFactor() {
        return factor;
    }

    public void setFactor(PPFFactors factor) {
        this.factor = factor;
    }

    public PPFhealth getHealth() {
        return health;
    }

    public void setHealth(PPFhealth health) {
        this.health = health;
    }

    public PPFPoliciesAndInsuranceOVERSEAS getPolciesInsOverseas() {
        return polciesInsOverseas;
    }

    public void setPolciesInsOverseas(PPFPoliciesAndInsuranceOVERSEAS polciesInsOverseas) {
        this.polciesInsOverseas = polciesInsOverseas;
    }

    public PPFPoliciesAndInsuranceUK getPolciesInsUk() {
        return polciesInsUk;
    }

    public void setPolciesInsUk(PPFPoliciesAndInsuranceUK polciesInsUk) {
        this.polciesInsUk = polciesInsUk;
    }

    public PPFUniAccess getUniAccess() {
        return uniAccess;
    }

    public void setUniAccess(PPFUniAccess uniAccess) {
        this.uniAccess = uniAccess;
    }

    public PPFWorkFactors getWorkFactors() {
        return workFactors;
    }

    public void setWorkFactors(PPFWorkFactors workFactors) {
        this.workFactors = workFactors;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return information in regards to the placement provider details.
     */
    public String toString() {
        return "PPFPlacementProviderDetails{" +
                "id=" + id +
                ", organisationName='" + organisationName + '\'' +
                ", placementAddress='" + placementAddress + '\'' +
                ", postCode='" + postCode + '\'' +
                ", webAddress='" + webAddress + '\'' +
                ", engagesRegulatedActivities=" + engagesRegulatedActivities +
                ", engagesRegulatedActivitiesYes='" + engagesRegulatedActivitiesYes + '\'' +
                ", NamedContactList=" + NamedContactList +
                ", declaration=" + declaration +
                ", factor=" + factor +
                ", health=" + health +
                ", polciesInsOverseas=" + polciesInsOverseas +
                ", polciesInsUk=" + polciesInsUk +
                ", uniAccess=" + uniAccess +
                ", workFactors=" + workFactors +
                ", student=" + student +
                '}';
    }
}
