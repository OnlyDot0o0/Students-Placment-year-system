package com.group14.placementtrackingsystem.controller;
/*By Maryam. This is the Contact Controller which can send an email
* to the student or the placement provider, where the user (placement team)
* will be able to request any additional data which will support their
* decision of accepting/rejecting the placement for the student */
import com.group14.placementtrackingsystem.model.Contact;
import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import com.group14.placementtrackingsystem.model.Placement;
import com.group14.placementtrackingsystem.repository.PPFPNamedContactRepo;
import com.group14.placementtrackingsystem.repository.PPFProviderDetailsRepo;
import com.group14.placementtrackingsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//NEEDED TO COMMENT OUT MODEL ATTRIBUTE AS CANT ADD IN UNTIL MERGE
@Controller
public class ContactController {
    //Difference between ContactCompany and ContactStudent method is the
    //default text that is shown, to help personalise the email depending
    //on the context

    @Autowired
    StudentRepository studentRepo;
    @Autowired
    PPFProviderDetailsRepo ppfProviderDetailsRepo;

    @Autowired
    PPFPNamedContactRepo contactRepo;

    //When "contactCompany" is visited, the "ContactCompany" jsp is shown
    @RequestMapping("/contactCompany") //@ModelAttribute  PPFPlacementProviderNamedContact companyContact
    public String contactCompany(@RequestParam int studentID, Model model, OAuth2AuthenticationToken token) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("company", (ppfProviderDetailsRepo.findByStudent_StudentNumber(String.valueOf(studentID))));
        model.addAttribute("companyContact", (contactRepo.findByStudent_StudentNumber(String.valueOf(studentID))));
        model.addAttribute("student", studentRepo.findByStudentNumber(String.valueOf(studentID)));
        model.addAttribute("accountName", token.getPrincipal().getAttributes());
        return "Contact/ContactCompany";
    }
    //When "contactStudent" is visited, the "ContactStudent" jsp is shown
    @RequestMapping("/contactStudent")
    public String contactStudent(@RequestParam int studentID, Model model, OAuth2AuthenticationToken token) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("student", studentRepo.findByStudentNumber(String.valueOf(studentID)));
        model.addAttribute("company", (ppfProviderDetailsRepo.findByStudent_StudentNumber(String.valueOf(studentID))));
        model.addAttribute("accountName", token.getPrincipal().getAttributes());

        return "Contact/ContactStudent";
    }

    //After ContactStudent and ContactCompany, this method uses the filled
    //in details to open the default email client with the fields automatically
    //filled in where the user(placement team) can send the email
    @PostMapping(value = "/contactLoading")
    public ModelAndView method(@ModelAttribute Contact contact, Model model) {
        String action = "mailto:" + contact.getEmailTo() + "?subject=" + contact.getSubject() + "&body=" + contact.getBody();
        action = action.replaceAll("[\\r\\n]+", " "); //Have to replace or error with "Invalid characters (CR/LF) in header Location" appears
        return new ModelAndView("redirect:" + action);
    }
}
