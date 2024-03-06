package com.group14.placementtrackingsystem.controller;


import com.group14.placementtrackingsystem.model.RiskForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.Date;



public class RiskFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RiskForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RiskForm r = (RiskForm) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"StudentName","","Enter a name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"Organisation","NotEmpty.Organisation","Please enter an organisation");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"TutorDate","","Please select a date");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"Impact_on_reputation","NotEmpty.Impact_on_reputation","Please select an option");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "Information_match", "NotEmpty.Information_match","Please select an option");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"FulfilledDuration", "NotEmpty.FulfilledDuration","Please select an option");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"Fulfilled_AcademicRequirement","NotEmpty.Fulfilled_AcademicRequirement","Please select an option");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"ConfirmedResponsibility","NotEmpty.ConfirmedResponsibility","Please select an option");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"ApprovedProvider","NotEmpty.ApprovedProvider","Please select an option");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"VisaNeeded","NotEmpty.VisaNeeded","Please select an option");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"VisaStartDate","NotEmpty.VisaStartDate","Please select an option");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"CompanyEnvironment","NotEmpty.CompanyEnvironment","Please select an option");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"StudentTraining","NotEmpty.StudentTraining","Please select an option");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"RemoteWorking","NotEmpty.RemoteWorking","Please select an option");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"SecondSignature", "NotEmpty.SecondSignature","Please Sign here!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"PlacementSupervisor","NotEmpty.PlacementSupervisor","Please enter the supervisor name!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"TutorName", "NotEmpty.TutorName","Please enter the tutor name here!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"DecisionReason", "NotEmpty.DecisionReason","Please enter the reason for your decision here!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"PlacementDecision", "NotEmpty.PlacementDecision","Please select the an option for the placement decision!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"Confidentiality", "NotEmpty.Confidentiality","Please select an option!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"UniVisit", "NotEmpty.UniVisit","Please select an option!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"SafetyPolicy", "NotEmpty.SafetyPolicy","Please select an option!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"ProfessionalInsurance", "NotEmpty.ProfessionalInsurance","Please select an option!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"EmployLiabilityInsurance", "NotEmpty.EmployLiabilityInsurance","Please select an option!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"PublicLiabilityInsurance", "NotEmpty.PublicLiabilityInsurance","Please select an option!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"PersonalFactors", "NotEmpty.PersonalFactors","Please select an option!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"Precautionary", "NotEmpty.Precautionary","Please select an option!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"StudentAccommodation", "NotEmpty.StudentAccommodation","Please select an option!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"PlacementLocation", "NotEmpty.PlacementLocation","Please select an option!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"MultiSites", "NotEmpty.MultiSites","Please select an option!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"TravelIssues", "NotEmpty.TravelIssues","Please select an option!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"InternationalRemote", "NotEmpty.InternationalRemote","Please select an option!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"Sign", "NotEmpty.Sign","Please Sign here!");
























    }
}
