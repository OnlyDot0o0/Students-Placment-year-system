package com.group14.placementtrackingsystem.controller;


import com.group14.placementtrackingsystem.model.*;
import com.group14.placementtrackingsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static com.group14.placementtrackingsystem.PlacementTrackingSystemApplication.annualPlacementSalaryRangeOptions;

/*
 *
 * This code integrates all the Placement Provider classes together.
 *
 * */
@Controller
@RequestMapping("/public")
public class ppfController {


    @Autowired
    public PPFDeclarationRepo declarationRepo;
    @Autowired
    public PPFFactorsRepo factorsRepo;
    @Autowired
    public PPFHealthRepo healthRepo;
    @Autowired
    public PPFPNamedContactRepo namedContactRepo;
    @Autowired
    public PPFPoliciesInsurenceOverseasRepo policiesOverseasRepo;
    @Autowired
    public PPFPoliciesInsurenceUkRepo policiesUkRepo;
    @Autowired
    public PPFProviderDetailsRepo companyRepo;
    @Autowired
    public PPFUniAccessRepo uniAccessRepo;
    @Autowired
    public PPFWorkFactorsRepo workFactorsRepo;

    @Autowired
    public RoleRepository roleRepo;

// Binder for the provider details form (connects validator with controller)
    @InitBinder("providerDetails_form")
    protected void initBinderProviderDetails(WebDataBinder binder) {
                binder.addValidators(new PPFProviderDetailsValidator());

    }
// Binder for the role details form (connects validator with controller)
    @InitBinder("ppfrole_form")
    protected void initBinderPPPFRole (WebDataBinder binder){
        binder.addValidators(new PPFRoleValidator());

    }
// Binder for the provider named contact form (connects validator with controller)
    @InitBinder("namedContact_form")
    protected void initBinderPlacementProviderNamedContact(WebDataBinder binder) {
        binder.addValidators(new PPFPlacementProviderNamedContactValidator());
    }
// Binder for the work factors form (connects validator with controller)
    @InitBinder("workFactors_form")
    protected void initBinderWorkFactors(WebDataBinder binder) {
        binder.addValidators(new PPFWorkFactorsValidator());
    }
// Binder for the factors form (connects validator with controller)
    @InitBinder("factors_form")
    protected void initBinderFactors(WebDataBinder binder) {
        binder.addValidators(new PPFFactorsValidator());
    }
// Binder for the insurance and policies uk form (connects validator with controller)
    @InitBinder("policiesuk_form")
    protected void initBinderPoliciesAndInsuranceUK(WebDataBinder binder) {
        binder.addValidators(new PPFPoliciesAndInsuranceUKValidator());
    }
// Binder for the insurance and policies overseas form (connects validator with controller)
    @InitBinder("policiesOverseas_form")
    protected void initBinderPoliciesAndInsuranceOVERSEAS(WebDataBinder binder) {
        binder.addValidators(new PPFPoliciesAndInsuranceOVERSEASValidator());
    }
// Binder for the health form (connects validator with controller)
    @InitBinder("health_form")
    protected void initBinderhealth(WebDataBinder binder) {
        binder.addValidators(new PPFHealthValidator());
    }
// Binder for the uni access form (connects validator with controller)
    @InitBinder("uniAccess_form")
    protected void initBinderUniAccess(WebDataBinder binder) {
        binder.addValidators(new PPFUniAccessValidator());
    }
// Binder for the declaration form (connects validator with controller)
    @InitBinder("declaration_form")
    protected void initBinderDeclaration(WebDataBinder binder) {
        binder.addValidators(new PPFDeclarationValidator());
    }

    // Handling the request for the Provider Details section
//THIS IS THE FIRST PAGE OF THE FORM
    @RequestMapping("/PPFProviderDetails")
    public String PPFProviderDetails(Model model) {
        model.addAttribute("providerDetails_form", new PPFPlacementProviderDetails());

        return "Company/PPFProviderDetails";
    }
// Handling the request for the thank you page.
    @RequestMapping("/c")
    public String home() {
        return "ThankYou";
    }
// Handling the request for the declaration section
    @RequestMapping("/PPFDeclaration")
    public String PPFDeclaration(@RequestParam int id, Model model) {

        PPFDeclaration declaration = new PPFDeclaration();
        model.addAttribute("declaration_form", declaration);
        model.addAttribute("id", id);
        return "Company/PPFDeclaration";
    }

// Adding the declaration information.
    @PostMapping("/addDeclaration")
    public String addDeclaration(Model model, @Valid @ModelAttribute("declaration_form") PPFDeclaration declaration_form, BindingResult result, @RequestParam int id) {
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return "Company/PPFDeclaration";
        }
        PPFPlacementProviderDetails comp = companyRepo.findById(id);
        comp.setDeclaration(declaration_form);
        declaration_form.setCompany(comp);
        declaration_form = declarationRepo.save(declaration_form);
        return "redirect:/public/c";
    }

// Handling the request for the factors section
    @RequestMapping("/PPFFactors")
    public String PPFFactors(@RequestParam int id, Model model) {

        PPFFactors factors = new PPFFactors();
        model.addAttribute("factors_form", factors);
        model.addAttribute("id", id);
        return "Company/PPFFactors";
    }
// Adds the factors information.
    @PostMapping("/addFactors")
    public String addFactors(@Valid @ModelAttribute PPFFactors factors_form, BindingResult result, @RequestParam int id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return "Company/PPFFactors";
        }

        PPFPlacementProviderDetails comp = companyRepo.findById(id);
        comp.setFactor(factors_form);
        factors_form.setCompany(comp);
        factors_form = factorsRepo.save(factors_form);
        return "redirect:/public/PPFPoliciesAndInsuranceUK?id=" + id;
    }

// Handling the request for the health section
    @RequestMapping("/PPFHealth")
    public String PPFHealth(@RequestParam int id, Model model) {

        PPFhealth health = new PPFhealth();
        model.addAttribute("health_form", health);
        model.addAttribute("id", id);
        return "Company/PPFHealth";
    }
// Adding the health information.
    @PostMapping("/addHealth")
    public String addFactors(@Valid @ModelAttribute PPFhealth health_form, BindingResult result, @RequestParam int id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return "Company/PPFHealth";
        }
        PPFPlacementProviderDetails comp = companyRepo.findById(id);
        comp.setHealth(health_form);
        health_form.setCompany(comp);
        health_form = healthRepo.save(health_form);
        return "redirect:/public/PPFUniAccess?id=" + id;
    }
// Handling the request for the placement prvoider named contact section
    @RequestMapping("/PPFPlacementProviderNamedContact")
    public String PPFPlacementProviderNamedContact(@RequestParam int id, Model model) {
        PPFPlacementProviderNamedContact providerNamedContact = new PPFPlacementProviderNamedContact();

        model.addAttribute("namedContact_form", providerNamedContact);
        model.addAttribute("id", id);

        return "Company/PPFPlacementProviderNamedContact";
    }
// Adding the placement provider named contact information.
    @PostMapping("/addContact")
    public String addFactors(Model model, @Valid @ModelAttribute("namedContact_form") PPFPlacementProviderNamedContact namedContact_form, BindingResult result, @RequestParam int id) {
        if (result.hasErrors()) {

            model.addAttribute("id", id);
            return "Company/PPFPlacementProviderNamedContact";
        }


        ArrayList<PPFPlacementProviderNamedContact> L = new ArrayList<>();
        L.add(namedContact_form);
        companyRepo.findById(id).setNamedContactList(L);
        namedContact_form.setCompany(companyRepo.findById(id));
        namedContact_form = namedContactRepo.save(namedContact_form);

        return "redirect:/public/PPFWorkFactors?id=" + id;
    }
// Handling the request for the Policies and insurance overseas section
    @RequestMapping("/PPFPoliciesAndInsuranceOVERSEAS")
    public String PPFPoliciesAndInsuranceOVERSEAS(@RequestParam int id, Model model) {
        PPFPoliciesAndInsuranceOVERSEAS policiesOverseas = new PPFPoliciesAndInsuranceOVERSEAS();
        model.addAttribute("policiesOverseas_form", policiesOverseas);
        model.addAttribute("id", id);
        return "Company/PPFPoliciesAndInsuranceOVERSEAS";
    }
// Adding Policies and insurance overseas information
    @PostMapping("/addPoliciesOverseas")
    public String addPoliciesOverseas(@Valid @ModelAttribute PPFPoliciesAndInsuranceOVERSEAS policiesOverseas_form, BindingResult result, @RequestParam int id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return "Company/PPFPoliciesAndInsuranceOVERSEAS" ;
        }


        PPFPlacementProviderDetails comp = companyRepo.findById(id);
        comp.setPolciesInsOverseas(policiesOverseas_form);
        policiesOverseas_form.setCompany(comp);
        policiesOverseas_form = policiesOverseasRepo.save(policiesOverseas_form);
        return "redirect:/public/PPFHealth?id=" + id;
    }
// Handling the request for the Policies and insurance UK section
    @RequestMapping("/PPFPoliciesAndInsuranceUK")
    public String PPFPoliciesAndInsuranceUK(@RequestParam int id, Model model) {

        PPFPoliciesAndInsuranceUK policiesUK = new PPFPoliciesAndInsuranceUK();
        model.addAttribute("policiesuk_form", policiesUK);
        model.addAttribute("id", id);
        return "Company/PPFPoliciesAndInsuranceUK";
    }
// Adding the Policies and insurance UK information
    @PostMapping("/addPoliciesUk")
    public String addPoliciesUK(@Valid @ModelAttribute PPFPoliciesAndInsuranceUK policiesuk_form, BindingResult result, @RequestParam int id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return "Company/PPFPoliciesAndInsuranceUK";
        }
        PPFPlacementProviderDetails comp = companyRepo.findById(id);
        comp.setPolciesInsUk(policiesuk_form);
        policiesuk_form.setCompany(comp);
        policiesuk_form = policiesUkRepo.save(policiesuk_form);
        return "redirect:/public/PPFPoliciesAndInsuranceOVERSEAS?id=" + id;
    }
// Handling the request for the University Access section
    @RequestMapping("/PPFUniAccess")
    public String PPFUniAccess(@RequestParam int id, Model model) {

        PPFUniAccess UniAccess = new PPFUniAccess();
        model.addAttribute("uniAccess_form", UniAccess);
        model.addAttribute("id", id);
        return "Company/PPFUniAccess";
    }
// Adding University Access Information
    @PostMapping("/addUniAccess")
    public String addUniAccess(@Valid @ModelAttribute PPFUniAccess uniAccess_form, BindingResult result, @RequestParam int id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return "Company/PPFUniAccess";
        }
        PPFPlacementProviderDetails comp = companyRepo.findById(id);
        comp.setUniAccess(uniAccess_form);
        uniAccess_form.setCompany(comp);
        uniAccess_form = uniAccessRepo.save(uniAccess_form);
        return "redirect:/public/PPFDeclaration?id=" + id;
    }


// Adding the provider details information.
    @PostMapping("/addProviderDetails")
    public String addProviderDetails(Model model, @Valid @ModelAttribute("providerDetails_form") PPFPlacementProviderDetails providerDetails_form, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("providerDetails_form", providerDetails_form);
            return "Company/PPFProviderDetails";
        }
        providerDetails_form = companyRepo.save(providerDetails_form);
        return "redirect:/public/PPFRole?id=" + providerDetails_form.getId();
    }

// Handling the request for the Roles section
    @RequestMapping("/PPFRole")
    public String PPFRole(@RequestParam int id, Model model) {

        Role role = new Role();
        model.addAttribute("ppfrole_form", role);
        model.addAttribute("id", id);
        return "Company/PPFRole";
    }
// Adding the Roles information
    @PostMapping("/addPPFRole")
    public String addPPFRole(@Valid @ModelAttribute("ppfrole_form") Role ppfrole_form, BindingResult result, @RequestParam int id, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("id", id);
            return "Company/PPFRole";
        }
        int salaryNum=ppfrole_form.getAnnualSalary();
        if (salaryNum==0){
            ppfrole_form.setAnnualSalaryRange(annualPlacementSalaryRangeOptions[5]);
        }
        else if (salaryNum>0 && salaryNum<5000){
            ppfrole_form.setAnnualSalaryRange(annualPlacementSalaryRangeOptions[0]);
        }
        else if (salaryNum>=5000 && salaryNum<10000){
            ppfrole_form.setAnnualSalaryRange(annualPlacementSalaryRangeOptions[1]);
        }
        else if (salaryNum>=10000 && salaryNum<20000){
            ppfrole_form.setAnnualSalaryRange(annualPlacementSalaryRangeOptions[2]);
        }
        else if (salaryNum>=20000 && salaryNum<30000){
            ppfrole_form.setAnnualSalaryRange(annualPlacementSalaryRangeOptions[3]);
        }
        else if (salaryNum>=30000){
            ppfrole_form.setAnnualSalaryRange(annualPlacementSalaryRangeOptions[4]);
        }
        else{
            ppfrole_form.setAnnualSalaryRange(annualPlacementSalaryRangeOptions[9]);
        }
        PPFPlacementProviderDetails comp = companyRepo.findById(id);
        roleRepo.save(ppfrole_form);
        return "redirect:/public/PPFPlacementProviderNamedContact?id=" + id;
    }

// Handling the request for the Work Factors section
    @RequestMapping("/PPFWorkFactors")
    public String PPFWorkFactors(@RequestParam int id, Model model) {
        PPFWorkFactors workFactors = new PPFWorkFactors();
        model.addAttribute("workFactors_form", workFactors);
        model.addAttribute("id", id);
        return "Company/PPFWorkFactors";
    }
// Adding the Work Factors information
    @PostMapping("/addWorkFactors")
    public String addWorkFactors(Model model, @Valid @ModelAttribute PPFWorkFactors workFactors_form, BindingResult result, @RequestParam int id) {
            if (result.hasErrors()) {
                model.addAttribute("id", id);
                return "Company/PPFWorkFactors";
            }
        PPFPlacementProviderDetails comp = companyRepo.findById(id);
        comp.setWorkFactors(workFactors_form);
        workFactors_form.setCompany(comp);
        workFactors_form = workFactorsRepo.save(workFactors_form);
        return "redirect:/public/PPFFactors?id=" + id;
    }
}
