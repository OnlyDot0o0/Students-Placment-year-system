package com.group14.placementtrackingsystem.controller;

/*
Created by Zaina and Moaz to handle the Risk assessment form.
Addition has been added by Maryam for sake of old Excel Master Tracker Database conversion
 */

import com.group14.placementtrackingsystem.model.RiskForm;

import com.group14.placementtrackingsystem.model.Student;
import com.group14.placementtrackingsystem.model.DatesOfFormCompletions;
import com.group14.placementtrackingsystem.repository.DatesofFormCompletionRepository;
import com.group14.placementtrackingsystem.repository.RiskRepository;
import com.group14.placementtrackingsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class RiskController {
    @InitBinder("form1")
    protected void initBinder(WebDataBinder binder){
        binder.addValidators(new RiskFormValidator());
    }

    @Autowired
    private RiskRepository riskrepo;

    @Autowired
    private DatesofFormCompletionRepository datesRepo;

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(value="/newForm")
    public String form(Model model){
        model.addAttribute("form1", new RiskForm());

        return "RiskAssessment";
    }

    @PostMapping("/addForm")
    public String addForm(@Valid @ModelAttribute("form1") RiskForm form1, BindingResult result){

        System.out.println(result.hasErrors());
        if(result.hasErrors()){
            return "RiskAssessment";
        }

        Student student = studentRepository.findByStudentNumber(form1.getStudentNumber());
        form1.setStudent(student);
        form1=riskrepo.save(form1);

        DatesOfFormCompletions datesFound = datesRepo.findByStudent(form1.getStudent());
        datesFound.setRiskForm(form1);
        datesFound.setAssessmentFormReceived(form1.getTutorDate()); //Date the tutor does assessment form
        datesFound.setProviderFormReceived(form1.getPlacementDate()); //Date the placement provider does placement provider form
        datesFound= (DatesOfFormCompletions) datesRepo.save(datesFound);


        return "/ThankYou";
    }


}
