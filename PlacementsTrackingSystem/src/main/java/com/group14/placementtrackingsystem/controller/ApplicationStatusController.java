package com.group14.placementtrackingsystem.controller;
/*
By Abdulqader - This supports the feature of students being able
to view the status of their placement authorisation request, without having a login,
but filling out a form with their unique ID (from the thank-you page in the
authorisation request form) to receive their application status.
 */

import com.group14.placementtrackingsystem.model.Placement;
import com.group14.placementtrackingsystem.repository.PPFProviderDetailsRepo;
import com.group14.placementtrackingsystem.repository.PlacementRepository;
import com.group14.placementtrackingsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/public")
public class ApplicationStatusController {

    // Repositories to access the database
    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private PPFProviderDetailsRepo companyRepo;

    @Autowired
    private PlacementRepository placementRepo;

    // A list of response strings.
    private String[] appStates = {"Received", "Approved", "Waiting Approval", "Rejected"};


    /**
     * @return the jsp file location for the application status form
     * @author @aamd1
     */
    @RequestMapping("/ApplicationStatusForm")
    public String getAppStatusForm() {
        return "Student/ApplicationStatusForm";
    }

    /**
     * This method finds the status of the application, stores the application status in the model
     *
     * @param model         model controller's model
     * @param studentNumber Application's student number
     * @param companyName   Application's company name
     * @param uniqueID      Application's unique ID
     * @return the jsp file location for the application result page
     * @author @aamd1
     */
    @RequestMapping("/ApplicationResult")
    public String getApplicationResult(Model model, @RequestParam("studentID") String studentNumber,
                                       @RequestParam("companyName") String companyName,
                                       @RequestParam("uniqueID") int uniqueID) {
        Placement placement = placementRepo.findById(uniqueID).orElse(null);
        if (placement == null) {
            model.addAttribute("status", "The unique ID is incorrect.");
            return "Student/ApplicationResult";
        }

        if (placement.getStudent().getStudentNumber().equals(studentNumber) && placement.getCompany().getOrganisationName().strip().toLowerCase().equals(companyName.strip().toLowerCase())) {
            model.addAttribute("status", "Application with ID " + uniqueID + " was " + appStates[placement.getApprovalStatus()] + ".");
        } else {
            if (!placement.getStudent().getStudentNumber().equals(studentNumber)) {
                model.addAttribute("status", "The requested student does not exist!");
            }
            else{
                model.addAttribute("status", "There is no relation between the company, the student and the placement.");

            }
        }

        return "Student/ApplicationResult";
    }

    /**
     * This method gets the unique ID and redirect the student to the thank-you page.
     * The student reaches this page once they fill out the placement authorisation request form
     *
     * @param model    controller's model
     * @param uniqueID The unique ID for
     * @return the jsp file location for the thank-you page
     * @author @aamd1
     */
    @RequestMapping("/studentThankYou")
    public String getUniqueID(Model model, @RequestParam("uniqueID") int uniqueID) {
        model.addAttribute("uniqueID", uniqueID);

        return "Student/StudentThankYou";

    }
}
