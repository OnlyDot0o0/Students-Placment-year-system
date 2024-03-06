package com.group14.placementtrackingsystem.controller;
/* 
By Abdulqader and Maryam. This is the Student Controller class
which is the only controller class in our student form.
It contains all the Request mapping methods and post methods to allow 
users to navigate throughout the form.
It also contains code for implementing the validators to check the Model attributes
being received from the students entering their details in the form.
There are 9 form sections , which are:
Student Details, Placement Provider Details,
 Placement Role Details, Work Factors,
  Transport and Travel Factors, Location and Regional Factors,
  Health and Environmental Factors, Personal Factors, 
  and Policies and Insurance Factors (Overseas Placement)
*/
import com.group14.placementtrackingsystem.PlacementTrackingSystemApplication;
import com.group14.placementtrackingsystem.model.*;
import com.group14.placementtrackingsystem.model.PolicyAndInsurance;
import com.group14.placementtrackingsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;


@Controller
@RequestMapping("/public")
public class StudentController {

    // These are the initBinders to add the validators to the Controller
    @InitBinder("student_form")
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(new StudentValidator());

    }

    @InitBinder("role_form")
    protected void initBinderRole (WebDataBinder binder){
        binder.addValidators(new RoleValidator());

    }
    @InitBinder("workFactor_form")
    protected void initBinderWorkFactors(WebDataBinder binder){
        binder.addValidators(new PPFWorkFactorsValidator());

    }
    @InitBinder("transportFactor_form")
    protected void initBinderTransportTravelFactors(WebDataBinder binder){
        binder.addValidators(new TransportTravelFactorsValidator());
    }
    @InitBinder("locationFactor_form")
    protected void initBinderLocationRegionalFactors(WebDataBinder binder){
        binder.addValidators(new LocationRegionalFactorsValidator());
    }
    @InitBinder("health_form")
    protected void initBinderHealthEnvironmentalFactors(WebDataBinder binder){
        binder.addValidators(new HealthEnvironmentalFactorsValidator());
    }

    @InitBinder("personalFactors_form")
    protected void initBinderPersonalFactors(WebDataBinder binder){
        binder.addValidators(new PersonalFactorsValidator());
    }

    @InitBinder("policyInsurance_form")
    protected void initBinderPoliciesAndInsurance(WebDataBinder binder){
        binder.addValidators(new PolicyAndInsuranceValidator());
    }
    @InitBinder("placementA_form")
    protected void initBinderPlacementA(WebDataBinder binder){
        binder.addValidators(new PPFProviderDetailsValidator());
    }
    @InitBinder("namedContact_form")
    protected void initBinderNamedContact(WebDataBinder binder){
        binder.addValidators(new PPFPlacementProviderNamedContactValidator());
    }


    // Autowired Repositories to access the database
    @Autowired
    private StudentRepository StuRepo;
    @Autowired
    private HealthEnvironmentalFactorsRepository HealthRepo;
    @Autowired
    private RoleRepository RoleRepo;
    @Autowired
    private PPFWorkFactorsRepo WorkFactorRepo;
    @Autowired
    private TransportTravelFactorsRepository TransportRepo;
    @Autowired
    private LocationRegionalFactorsRepository LocationRepo;
    @Autowired
    private PersonalFactorsRepository PersonalFactorRepo;
    @Autowired
    private PolicyAndInsuranceRepository PolicyInsuranceRepo;
    @Autowired
    private PPFProviderDetailsRepo providerDetailsRepo;
    @Autowired
    private PPFPNamedContactRepo namedContactRepo;

    @Autowired
    private PlacementRepository PlacementRepo;

    @Autowired
    private DatesofFormCompletionRepository datesRepo;

    // This controller will show the student form.
    @RequestMapping("/newStudent")
    public String newStudent(Model model){
        Student student = new Student();
        model.addAttribute("student_form" , student);
        return "Student/StudentForm";
    }

    @PostMapping("/addStudent")
    public String addStudent( @Valid @ModelAttribute("student_form") Student student_form, BindingResult resultStudent, Model model){

        if (resultStudent.hasErrors()){
            return "Student/StudentForm ";
        }
        model.addAttribute("student_id" , student_form.getStudentNumber());

        student_form = StuRepo.save(student_form);
        return "redirect:/public/newPlacementA_form?id=" + model.getAttribute("student_id");
    }


    // These method will show the Placement Role  Form
    @RequestMapping("/newPlacementA_form")
    public String newPlacementA(Model model, @RequestParam String id){
        PPFPlacementProviderDetails ppfPlacementProviderDetails = new PPFPlacementProviderDetails();

        ppfPlacementProviderDetails.setStudent(StuRepo.findByStudentNumber(id));
        model.addAttribute("placementA_form",ppfPlacementProviderDetails);
        model.addAttribute("student_id", id);

        return "Student/PlacementProviderDetails";
    }


    @PostMapping("/addPlacementA_form")
    public String addPlacementA( @Valid @ModelAttribute("placementA_form") PPFPlacementProviderDetails placementA_form, BindingResult result, @RequestParam String id, Model model){

        if (result.hasErrors()){
            model.addAttribute("student_id" , id );
            return "Student/PlacementProviderDetails";
        }

        placementA_form.setStudent(StuRepo.findByStudentNumber(String.valueOf(id)));
        placementA_form = providerDetailsRepo.save(placementA_form);

        return "redirect:/public/newContact_form?id="+id;
    }

    // These method will show the Placement Role  Form
    @RequestMapping("/newContact_form")
    public String newNamedContact(Model model, @RequestParam String id){
        PPFPlacementProviderNamedContact namedContact = new PPFPlacementProviderNamedContact();
        namedContact.setStudent(StuRepo.findByStudentNumber(String.valueOf(id)));

        model.addAttribute("namedContact_form",namedContact );
        model.addAttribute("student_id", id);

        return "Student/PlacementProviderDetailsB";
    }


    @PostMapping("/addContact_form")
    public String addNamedContact( @Valid @ModelAttribute("namedContact_form") PPFPlacementProviderNamedContact namedContact_form, BindingResult result, @RequestParam String id, Model model){


        if (result.hasErrors()){
            model.addAttribute("student_id" , id );
            return "Student/PlacementProviderDetailsB";
        }

        namedContact_form.setStudent(StuRepo.findByStudentNumber(String.valueOf(id)));
        namedContact_form = namedContactRepo.save(namedContact_form);
//        namedContact_form = RoleRepo.save(role_form);

        return "redirect:/public/newRole_form?id=" + id;
    }

    // These method will show the Placement Role  Form
    @RequestMapping("/newRole_form")
    public String newRole(Model model, @RequestParam String id){
        Role role = new Role();
        role.setStudent(StuRepo.findByStudentNumber(String.valueOf(id)));
        model.addAttribute("role_form",role );
        model.addAttribute("student_id", id);

        return "Student/Role";
    }


    @PostMapping("/addRole_form")
    public String addRole( @Valid @ModelAttribute("role_form") Role role_form, BindingResult result, @RequestParam String id, Model model){
        System.out.println(result);
        System.out.println("id === "+id);

        if (result.hasErrors()){
            model.addAttribute("student_id" , id );
            return "Student/Role";
        }

        role_form.setStudent(StuRepo.findByStudentNumber(String.valueOf(id)));
        role_form = RoleRepo.save(role_form);

        return "redirect:/public/newWork_form?id="+id;
    }


    // These method will show the Work Factors  Form
    @RequestMapping("/newWork_form")
    public String newWorkFactor(Model model,  @RequestParam String id){
        PPFWorkFactors workFactors = new PPFWorkFactors();
        model.addAttribute("workFactor_form", workFactors);
        model.addAttribute("student_id", id);
        return "Student/WorkFactors";
    }

    @PostMapping("/addWork_form")
    public String addWorkFactor(Model model, @Valid @ModelAttribute("workFactor_form") PPFWorkFactors workFactor_form, BindingResult result, @RequestParam String id){
        if (result.hasErrors()){
            model.addAttribute("student_id", id);

            return "Student/WorkFactors";
        }
        workFactor_form.setStudent(StuRepo.findByStudentNumber(id ));
        workFactor_form = WorkFactorRepo.save(workFactor_form);

        return "redirect:/public/newTransport_form?id="+id;
    }



    // These method will show the Transport and Travel Factors Form
    @RequestMapping("/newTransport_form")
    public String newTransportFactors(Model model,  @RequestParam String id){
        TransportTravelFactors transportTravelFactors = new TransportTravelFactors();
        model.addAttribute("student_id", id);

        model.addAttribute("transportFactor_form", new TransportTravelFactors());
        return "Student/TransportTravelFactor";
    }

    @PostMapping("/addTransport_form")
    public String addTransportFactors(Model model, @Valid @ModelAttribute("transportFactor_form") TransportTravelFactors transportFactor_form, BindingResult result , @RequestParam String id){
        if (result.hasErrors()){
            model.addAttribute("student_id", id);
            return "Student/TransportTravelFactor";
        }
        transportFactor_form.setStudent(StuRepo.findByStudentNumber(id ));
        transportFactor_form = TransportRepo.save(transportFactor_form);
        return "redirect:/public/newLocation_form?id="+id;
    }

    // These method will show the Location Factors Form
    @RequestMapping("/newLocation_form")
    public String newLocationFactors(Model model, @RequestParam String id){
        LocationRegionalFactors locationRegionalFactors = new LocationRegionalFactors();
        model.addAttribute("locationFactor_form", locationRegionalFactors);
        model.addAttribute("student_id", id);
        model.addAttribute("accommodationOptions" , PlacementTrackingSystemApplication.accommodationOptions);
        return "Student/LocationRegionalFactors";
    }

    @PostMapping("/addLocation_form")
    public String addLocationFactors(Model model, @Valid @ModelAttribute("locationFactor_form") LocationRegionalFactors locationFactor_form, BindingResult result, @RequestParam String id){
        if (result.hasErrors()){
            model.addAttribute("student_id", id);

            return "Student/LocationRegionalFactors";
        }
        locationFactor_form.setStudent(StuRepo.findByStudentNumber(id ));
        locationFactor_form = LocationRepo.save(locationFactor_form);
        return "redirect:/public/newHealth_form?id="+id;
    }

    // These method will show the Health Form
    @RequestMapping("/newHealth_form")
    public String newHealth(Model model, @RequestParam String id){
        HealthEnvironmentalFactors healthEnvironmentalFactors = new HealthEnvironmentalFactors();
        model.addAttribute("health_form", healthEnvironmentalFactors);
        model.addAttribute("student_id" , id);
        return "Student/HealthEnvironmentalFactors";
    }

    @PostMapping("/addHealth_form")
    public String addHealth(Model model, @Valid @ModelAttribute("health_form") HealthEnvironmentalFactors health_form, BindingResult result, @RequestParam String id){
        if (result.hasErrors()){
            model.addAttribute("student_id", id);

            return "Student/HealthEnvironmentalFactors";
        }
        health_form.setStudent(StuRepo.findByStudentNumber(id ));

        health_form = HealthRepo.save(health_form);

        return "redirect:/public/newPersonalFactor_form?id="+id;
    }

    // These method will show the Personal Factors Form
    @RequestMapping("/newPersonalFactor_form")
    public String newPersonalFactor(Model model, @RequestParam String id){
        PersonalFactors personalFactors = new PersonalFactors();
        model.addAttribute("personalFactors_form", new PersonalFactors());
        model.addAttribute("student_id", id );
        return "Student/PersonalFactors";
    }

    @PostMapping("/addPersonalFactor_form")
    public String addPersonalFactor(Model model, @Valid @ModelAttribute("personalFactors_form") PersonalFactors personalFactors_form, BindingResult result, @RequestParam String id){
        if (result.hasErrors()){
            model.addAttribute("student_id", id);

            return "Student/PersonalFactors";
        }
        personalFactors_form.setStudent(StuRepo.findByStudentNumber(id ));

        personalFactors_form = PersonalFactorRepo.save(personalFactors_form);

        return "redirect:newPolicy_form?id="+id;
    }


    // These method will show the Policy and Insurance Form
    @RequestMapping("/newPolicy_form")
    public String newPolicy(Model model, @RequestParam String id){
        PolicyAndInsurance policyAndInsurance  = new PolicyAndInsurance();
        model.addAttribute("policyInsurance_form", policyAndInsurance);
        model.addAttribute("student_id" , id);
        return "Student/PoliciesAndInsurance";
    }

    @PostMapping("/addPolicy_form")
    public String addPolicy(Model model, @Valid @ModelAttribute("policyInsurance_form") PolicyAndInsurance policyInsurance_form, BindingResult result, @RequestParam String id){
        if (result.hasErrors()){
            model.addAttribute("student_id", id);
            return "Student/PoliciesAndInsurance";
        }
        policyInsurance_form.setStudent(StuRepo.findByStudentNumber(id ));

        policyInsurance_form = PolicyInsuranceRepo.save(policyInsurance_form);

        Placement placement = new Placement();
        placement.setStudent(StuRepo.findByStudentNumber(id));
        placement.setCompany(providerDetailsRepo.findByStudent_StudentNumber(id));
        placement.setRole(RoleRepo.findByStudent_StudentNumber(id));
        placement.setProviderNamedContact(namedContactRepo.findByStudent_StudentNumber(id));
        placement.setWorkFactors(WorkFactorRepo.findByStudent_StudentNumber(id));
        placement.setHealthEnvironmentalFactors(HealthRepo.findByStudent_StudentNumber(id));
        placement.setTransportTravelFactors(TransportRepo.findByStudent_StudentNumber(id));
        placement.setLocationRegionalFactors(LocationRepo.findByStudent_StudentNumber(id));
        placement.setPersonalFactors(PersonalFactorRepo.findByStudent_StudentNumber(id));
        placement.setPolicyAndInsurance(PolicyInsuranceRepo.findByStudent_StudentNumber(id));
        placement = PlacementRepo.save(placement);

        //For database conversion feature
        DatesOfFormCompletions dates = new DatesOfFormCompletions();
        dates.setStudent(placement.getStudent());
        dates.setCompany(placement.getCompany());
        dates.setStudentAuthorisationRequestFormReceived(java.sql.Date.valueOf(String.valueOf(LocalDateTime.now())));
        dates= (DatesOfFormCompletions) datesRepo.save(dates);

        model.addAttribute("uniqueID", placement.getId());
        return "Student/StudentThankYou";
    }

}
