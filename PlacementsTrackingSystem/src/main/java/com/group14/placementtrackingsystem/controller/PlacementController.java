package com.group14.placementtrackingsystem.controller;

import com.group14.placementtrackingsystem.model.*;
import com.group14.placementtrackingsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;


/*
This is the controller class made by Zaina and Moaz.
The first controller shows all the students that are currently on placement.
All the attributes from the company,student,role and placement class are called here in order to
show the necessary details in the webpage.

The second controller shows the details of the student once the student id is clicked which is displayed as link.
 */
@Controller
public class PlacementController {

    // Autowired Repositories to access the database
    @Autowired
    public PlacementRepository placementRepository;
    @Autowired
    public PPFPNamedContactRepo ppfpNamedContactRepo;
    @Autowired
    public PPFProviderDetailsRepo companyRepo;
    @Autowired
    public StudentRepository StuRepo;
    @Autowired
    public RoleRepository RoleRepo;
    @Autowired
    public PPFWorkFactorsRepo workFactorsRepo;
    @Autowired
    public TransportTravelFactorsRepository transportTravelFactorsRepository;
    @Autowired
    public LocationRegionalFactorsRepository locationRegionalFactorsRepository;
    @Autowired
    public HealthEnvironmentalFactorsRepository healthEnvironmentalFactorsRepository;
    @Autowired
    public PersonalFactorsRepository personalFactorsRepository;
    @Autowired
    public PolicyAndInsuranceRepository policyAndInsuranceRepository;

    @RequestMapping("/Placementstudents")
    public String getCurrentStudents(Model model) {
        java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
        List<Student> students = (List<Student>) StuRepo.findAll();
        List<Role> roles = (List<Role>) RoleRepo.findAll();
        List<PPFPlacementProviderDetails> companies = (List<PPFPlacementProviderDetails>) companyRepo.findAll();
        List<PPFPlacementProviderNamedContact> contacts = (List<PPFPlacementProviderNamedContact>) ppfpNamedContactRepo.findAll();
        List<PPFWorkFactors> workFactors = (List<PPFWorkFactors>) workFactorsRepo.findAll();
        List<TransportTravelFactors> transportTravelFactors = (List<TransportTravelFactors>) transportTravelFactorsRepository.findAll();
        List<LocationRegionalFactors> locationRegionalFactors = (List<LocationRegionalFactors>) locationRegionalFactorsRepository.findAll();
        List<HealthEnvironmentalFactors> healthEnvironmentalFactors = (List<HealthEnvironmentalFactors>) healthEnvironmentalFactorsRepository.findAll();
        List<PersonalFactors> personalFactors = (List<PersonalFactors>) personalFactorsRepository.findAll();
        List<PolicyAndInsurance> policyAndInsurance = (List<PolicyAndInsurance>) policyAndInsuranceRepository.findAll();
        System.out.println(StuRepo.findAll());
        List<Placement> placements = placementRepository.findStudentByOnPlacement(today);
        placements = placements.stream().filter(placement -> placement.getApprovalStatus() == 1).collect(Collectors.toList());
        model.addAttribute("students", students);
        model.addAttribute("roles", roles);
        model.addAttribute("companies", companies);
        model.addAttribute("contacts", contacts);
        model.addAttribute("workFactors", workFactors);
        model.addAttribute("transportTravelFactors", transportTravelFactors);
        model.addAttribute("locationRegionalFactors", locationRegionalFactors);
        model.addAttribute("healthEnvironmentalFactors", healthEnvironmentalFactors);
        model.addAttribute("personalFactors", personalFactors);
        model.addAttribute("policyAndInsurance", policyAndInsurance);
        model.addAttribute("placements", placements);
        return "Placement/OnPlacement";
    }

    @RequestMapping("/students/{id}")
    public String getStudentDetails(@PathVariable("id") String studentNumber, Model model) {
        Student student = StuRepo.findByStudentNumber(studentNumber);
        Placement placement = placementRepository.findByStudent(student);
        model.addAttribute("student", student);
        model.addAttribute("placement", placement);
        return "Placement/StudentDetails";
    }


}
