package com.group14.placementtrackingsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*
 *
 * This code is the entity for the Placement Provider Factors section of the Placement Provider Form (PPF)
 *
 * */

@Entity
public class PPFFactors {

    @Id
    @GeneratedValue
    private int id;
    private byte travelSites;
    private byte travelReqOverseas;
    private byte locationRisk;
    private byte healthPrecautionary;
    private byte persoFactors;
    private String travelSitesYes;
    private String locationRiskYes;
    private String healthPrecautionaryYes;

    @OneToOne
    private PPFPlacementProviderDetails company;


    /**
     * @return the travel sites.
     */
    public byte getTravelSites() {
        return travelSites;
    }

    /**
     * @param travelSites the travel sites.
     */
    public void setTravelSites(byte travelSites) {
        this.travelSites = travelSites;
    }

    /**
     * @return Travel Request Overseas (True or False).
     */
    public byte getTravelReqOverseas() {
        return travelReqOverseas;
    }

    /**
     * @param travelReqOverseas Travel request overseas (can be true or false)
     */
    public void setTravelReqOverseas(byte travelReqOverseas) {
        this.travelReqOverseas = travelReqOverseas;
    }

    /**
     * @return if the risk of the location is yes or no.
     */
    public byte getLocationRisk() {
        return locationRisk;
    }

    /**
     * @param locationRisk set the value of risk of the location.
     */
    public void setLocationRisk(byte locationRisk) {
        this.locationRisk = locationRisk;
    }

    /**
     * @return return the value of the health precautions.
     */
    public byte getHealthPrecautionary() {
        return healthPrecautionary;
    }

    /**
     * @param healthPrecautionary set the value of health and precaution
     */
    public void setHealthPrecautionary(byte healthPrecautionary) {
        this.healthPrecautionary = healthPrecautionary;
    }

    /**
     * @return personal factors.
     */
    public byte getPersoFactors() {
        return persoFactors;
    }

    /**
     * @param persoFactors personal factors
     */
    public void setPersoFactors(byte persoFactors) {
        this.persoFactors = persoFactors;
    }

    /**
     * @return
     */
    public String getTravelSitesYes() {
        return travelSitesYes;
    }

    /**
     * @param travelSitesYes
     */
    public void setTravelSitesYes(String travelSitesYes) {
        this.travelSitesYes = travelSitesYes;
    }

    /**
     * @return
     */
    public String getLocationRiskYes() {
        return locationRiskYes;
    }

    /**
     * @param locationRiskYes
     */
    public void setLocationRiskYes(String locationRiskYes) {
        this.locationRiskYes = locationRiskYes;
    }

    /**
     * @return
     */
    public String getHealthPrecautionaryYes() {
        return healthPrecautionaryYes;
    }

    /**
     * @param healthPrecautionaryYes
     */
    public void setHealthPrecautionaryYes(String healthPrecautionaryYes) {
        this.healthPrecautionaryYes = healthPrecautionaryYes;
    }

    /**
     * @return
     */
    public PPFPlacementProviderDetails getCompany() {
        return company;
    }

    /**
     * @param company
     */
    public void setCompany(PPFPlacementProviderDetails company) {
        this.company = company;
    }
}
