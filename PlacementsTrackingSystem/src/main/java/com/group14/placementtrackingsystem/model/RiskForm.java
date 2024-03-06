package com.group14.placementtrackingsystem.model;

//This form was created by ma913(Moaz)
//Has some additions from Maryam for purpose of old Excel Master Database conversion


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "RiskAssessment")
public class RiskForm {
        // hidden from the user - hidden value
        @Id
        @GeneratedValue
        private int id;

        // Student name - 1a - text box
        @Column(name = "student_name")
        private String StudentName;

        //Student number - Maryam added for purpose of student repository searching by ID
        @Column(name = "student_number")
        private String studentNumber;

        //Company name - 2a - text box
        @Column(name = "organisation")
        private String Organisation;

        // uni reputation - 2b - radio button
        @Column(name = "impact_on_reputation")
        private String Impact_on_reputation;

        // matching the information of the student and company - 3a - radio button
        @Column(name = "information_match")
        private String Information_match;

        // checking for duration - 4a - radio button
        @Column(name = "ful_filled_duration")
        private String FulfilledDuration;

        // Student requirements for the placement - 4b - radio button
        @Column(name = "full_filled_academic_requirement")
        private String Fulfilled_AcademicRequirement;

        // checking with the placement provider - 4c - radio button
        @Column(name = "confirmed_responsibility")
        private String ConfirmedResponsibility;

        //Is the placement provider appropriate ? - 4d - radio button
        @Column(name = "approved_provider")
        private String ApprovedProvider;

        //Visa related - 4e - radio button
        @Column(name = "visa_needed")
        private String VisaNeeded;

        //visa related - 4f - radio button
        @Column(name = "visa_start_date")
        private String VisaStartDate;

        //Company Environment - 5a - radio button
        @Column(name = "company_environment")
        private String CompanyEnvironment;

        // would the student get appropriate training - 5b - radio button
        @Column(name = "student_training")
        private String StudentTraining;

        //Can the student work from home - 5c - radio button
        @Column(name = "remote_working")
        private String RemoteWorking;

        //International remote working - 5d - radio button
        @Column(name = "international_remote")
        private String InternationalRemote;

        //Travel problems for the student - 6a - radio button
        @Column(name = "travel_issues")
        private String TravelIssues;

        //Would the student work on multiple sites - 6b - radio button
        @Column(name = "multi_sites")
        private String MultiSites;

        //Placement location risks - 7a - radio button
        @Column(name = "placement_location")
        private String PlacementLocation;

        //student accommodation problems - 7b - radio button
        @Column(name = "student_accommodation")
        private String StudentAccommodation;

        //Health and environmental - 8a - radio button
        @Column(name = "precautionary")
        private String Precautionary;

        //Personal factors - 9a - radio button
        @Column(name = "personal_factors")
        private String PersonalFactors;

        //Policies and Insurance
        @Column(name = "public_liability_insurance")
        private String PublicLiabilityInsurance; // 10a - radio button

        @Column(name = "employ_liability_insurance")
        private String EmployLiabilityInsurance; // 10b - radio button

        @Column(name = "professional_insurance")
        private String ProfessionalInsurance; // 10c - radio button

        @Column(name = "safety_policy")
        private String SafetyPolicy; // 10d - radio button


        //University Access and Support
        @Column(name = "uni_visit")
        private String UniVisit; // 11a - radio button

        @Column(name = "confidentiality")
        private String Confidentiality; // 11b - radio button

        //Placement Tutor Declaration and Signature - section 12
        @Column(name = "placement_decision")
        private String PlacementDecision; // radio button

        @Column(name = "decision_reason")
        private String DecisionReason; // text area
        @Column(name = "tutor_name")
        private String TutorName; // text box

        @Column(name = "signature")
        private String Sign;

        //The date tutor fills the form
        @Column(name = "Date")
        private java.sql.Date TutorDate;

        //Allocated Placement Supervisor:
        @Column(name = "placement_supervisor")
        private String PlacementSupervisor; // text box

        //Overseas Placements Only College Director of Operations Sign Off - section 13
        // Signature of the placement provider
        @Column(name = "second_signature")
        private String SecondSignature;

        //Date of the placement provider filling the form
        @Column(name = "placement_date")
        private java.sql.Date PlacementDate;

        //Date of placement briefing attended (Maryam)
        @Column(name = "placement_briefing_attended")
        private java.sql.Date placementBriefing;

        //SIAC Notes The University’s Student Immigration Advice and Compliance team (SIAC) - (Maryam)
        @Column(name = "siac_notes")
        private String siacNotes;

        //confirm whether insurance is needed for overseas placement (Maryam)
        @Column(name = "insurance_issued")
        private String insuranceIssued;

        @OneToOne
        private Student student;



        // getters and setters


    public String getInsuranceIssued() {
        return insuranceIssued;
    }

    public void setInsuranceIssued(String insuranceIssued) {
        this.insuranceIssued = insuranceIssued;
    }

    public Date getPlacementBriefing() {
        return placementBriefing;
    }

    public void setPlacementBriefing(Date placementBriefing) {
        this.placementBriefing = placementBriefing;
    }

    public String getSiacNotes() {
        return siacNotes;
    }

    public void setSiacNotes(String siacNotes) {
        this.siacNotes = siacNotes;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getStudentName() {
            return StudentName;
        }

        public void setStudentName(String studentName) {
            StudentName = studentName;
        }

        public String getOrganisation() {
            return Organisation;
        }

        public void setOrganisation(String organisation) {
            Organisation = organisation;
        }

        public String getImpact_on_reputation() {
            return Impact_on_reputation;
        }

        public void setImpact_on_reputation(String impact_on_reputation) {
            Impact_on_reputation = impact_on_reputation;
        }

        public String getInformation_match() {
            return Information_match;
        }

        public void setInformation_match(String information_match) {
            Information_match = information_match;
        }

        public String getFulfilledDuration() {
            return FulfilledDuration;
        }

        public void setFulfilledDuration(String fulfilledDuration) {
            FulfilledDuration = fulfilledDuration;
        }

        public String getFulfilled_AcademicRequirement() {
            return Fulfilled_AcademicRequirement;
        }

        public void setFulfilled_AcademicRequirement(String fulfilled_AcademicRequirement) {
            Fulfilled_AcademicRequirement = fulfilled_AcademicRequirement;
        }

        public String getConfirmedResponsibility() {
            return ConfirmedResponsibility;
        }

        public void setConfirmedResponsibility(String confirmedResponsibility) {
            ConfirmedResponsibility = confirmedResponsibility;
        }

        public String getApprovedProvider() {
            return ApprovedProvider;
        }

        public void setApprovedProvider(String approvedProvider) {
            ApprovedProvider = approvedProvider;
        }

        public String getVisaNeeded() {
            return VisaNeeded;
        }

        public void setVisaNeeded(String visaNeeded) {
            VisaNeeded = visaNeeded;
        }

        public String getVisaStartDate() {
            return VisaStartDate;
        }

        public void setVisaStartDate(String visaStartDate) {
            VisaStartDate = visaStartDate;
        }

        public String getCompanyEnvironment() {
            return CompanyEnvironment;
        }

        public void setCompanyEnvironment(String companyEnvironment) {
            CompanyEnvironment = companyEnvironment;
        }

        public String getStudentTraining() {
            return StudentTraining;
        }

        public void setStudentTraining(String studentTraining) {
            StudentTraining = studentTraining;
        }

        public String getRemoteWorking() {
            return RemoteWorking;
        }

        public void setRemoteWorking(String remoteWorking) {
            RemoteWorking = remoteWorking;
        }

        public String getInternationalRemote() {
            return InternationalRemote;
        }

        public void setInternationalRemote(String internationalRemote) {
            InternationalRemote = internationalRemote;
        }

        public String getTravelIssues() {
            return TravelIssues;
        }

        public void setTravelIssues(String travelIssues) {
            TravelIssues = travelIssues;
        }

        public String getMultiSites() {
            return MultiSites;
        }

        public void setMultiSites(String multiSites) {
            MultiSites = multiSites;
        }

        public String getPlacementLocation() {
            return PlacementLocation;
        }

        public void setPlacementLocation(String placementLocation) {
            PlacementLocation = placementLocation;
        }

        public String getStudentAccommodation() {
            return StudentAccommodation;
        }

        public void setStudentAccommodation(String studentAccommodation) {
            StudentAccommodation = studentAccommodation;
        }

        public String getPrecautionary() {
            return Precautionary;
        }

        public void setPrecautionary(String precautionary) {
            Precautionary = precautionary;
        }

        public String getPersonalFactors() {
            return PersonalFactors;
        }

        public void setPersonalFactors(String personalFactors) {
            PersonalFactors = personalFactors;
        }

        public String getPublicLiabilityInsurance() {
            return PublicLiabilityInsurance;
        }

        public void setPublicLiabilityInsurance(String publicLiabilityInsurance) {
            PublicLiabilityInsurance = publicLiabilityInsurance;
        }

        public String getEmployLiabilityInsurance() {
            return EmployLiabilityInsurance;
        }

        public void setEmployLiabilityInsurance(String employLiabilityInsurance) {
            EmployLiabilityInsurance = employLiabilityInsurance;
        }

        public String getProfessionalInsurance() {
            return ProfessionalInsurance;
        }

        public void setProfessionalInsurance(String professionalInsurance) {
            ProfessionalInsurance = professionalInsurance;
        }

        public String getSafetyPolicy() {
            return SafetyPolicy;
        }

        public void setSafetyPolicy(String safetyPolicy) {
            SafetyPolicy = safetyPolicy;
        }

        public String getUniVisit() {
            return UniVisit;
        }

        public void setUniVisit(String uniVisit) {
            UniVisit = uniVisit;
        }

        public String getConfidentiality() {
            return Confidentiality;
        }

        public void setConfidentiality(String confidentiality) {
            Confidentiality = confidentiality;
        }

        public String getPlacementDecision() {
            return PlacementDecision;
        }

        public void setPlacementDecision(String placementDecision) {
            PlacementDecision = placementDecision;
        }

        public String getDecisionReason() {
            return DecisionReason;
        }

        public void setDecisionReason(String decisionReason) {
            DecisionReason = decisionReason;
        }

        public String getTutorName() {
            return TutorName;
        }

        public void setTutorName(String tutorName) {
            TutorName = tutorName;
        }


        public java.sql.Date getTutorDate() {
            return TutorDate;
        }

        public void setTutorDate(java.sql.Date tutorDate) {
            TutorDate = tutorDate;
        }

        public String getPlacementSupervisor() {
            return PlacementSupervisor;
        }

        public void setPlacementSupervisor(String placementSupervisor) {
            PlacementSupervisor = placementSupervisor;
        }

        public String getSecondSignature() {
            return SecondSignature;
        }

        public void setSecondSignature(String secondSignature) {
            SecondSignature = secondSignature;
        }

        public java.sql.Date getPlacementDate() {
            return PlacementDate;
        }

        public void setPlacementDate(java.sql.Date placementDate) {
            PlacementDate = placementDate;
        }

        public String getSign() {
            return Sign;
        }

        public void setSign(String sign) {
            Sign = sign;
        }

    @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", StudentName='" + StudentName + '\'' +
                    ", Organisation='" + Organisation + '\'' +
                    ", Impact_on_reputation='" + Impact_on_reputation + '\'' +
                    ", Information_match='" + Information_match + '\'' +
                    ", FulfilledDuration='" + FulfilledDuration + '\'' +
                    ", Fulfilled_AcademicRequirement='" + Fulfilled_AcademicRequirement + '\'' +
                    ", ConfirmedResponsibility='" + ConfirmedResponsibility + '\'' +
                    ", ApprovedProvider='" + ApprovedProvider + '\'' +
                    ", VisaNeeded='" + VisaNeeded + '\'' +
                    ", VisaStartDate='" + VisaStartDate + '\'' +
                    ", CompanyEnvironment='" + CompanyEnvironment + '\'' +
                    ", StudentTraining='" + StudentTraining + '\'' +
                    ", RemoteWorking='" + RemoteWorking + '\'' +
                    ", InternationalRemote='" + InternationalRemote + '\'' +
                    ", TravelIssues='" + TravelIssues + '\'' +
                    ", MultiSites='" + MultiSites + '\'' +
                    ", PlacementLocation='" + PlacementLocation + '\'' +
                    ", StudentAccommodation='" + StudentAccommodation + '\'' +
                    ", Precautionary='" + Precautionary + '\'' +
                    ", PersonalFactors='" + PersonalFactors + '\'' +
                    ", PublicLiabilityInsurance='" + PublicLiabilityInsurance + '\'' +
                    ", EmployLiabilityInsurance='" + EmployLiabilityInsurance + '\'' +
                    ", ProfessionalInsurance='" + ProfessionalInsurance + '\'' +
                    ", SafetyPolicy='" + SafetyPolicy + '\'' +
                    ", UniVisit='" + UniVisit + '\'' +
                    ", Confidentiality='" + Confidentiality + '\'' +
                    ", PlacementDecision='" + PlacementDecision + '\'' +
                    ", DecisionReason='" + DecisionReason + '\'' +
                    ", TutorName='" + TutorName + '\'' +
                    ", TutorDate=" + TutorDate + '\'' +
                    ", PlacementSupervisor='" + PlacementSupervisor + '\'' +
                    ", SecondSignature='" + SecondSignature + '\'' +
                    ", SecondSignature='" + Sign + '\'' +
                    ", PlacementDate=" + PlacementDate +
                    '}';
        }



}
