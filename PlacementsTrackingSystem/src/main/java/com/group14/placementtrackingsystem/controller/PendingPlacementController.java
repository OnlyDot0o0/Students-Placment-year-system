package com.group14.placementtrackingsystem.controller;

import com.group14.placementtrackingsystem.model.PPFPlacementProviderDetails;
import com.group14.placementtrackingsystem.model.Placement;
import com.group14.placementtrackingsystem.model.Student;
import com.group14.placementtrackingsystem.repository.PPFProviderDetailsRepo;
import com.group14.placementtrackingsystem.repository.PlacementRepository;
import com.group14.placementtrackingsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PendingPlacementController {
    //Autowired connections to the different repositories
    @Autowired
    StudentRepository studentRepo;
    @Autowired
    PPFProviderDetailsRepo ppfProviderDetailsRepo;
    @Autowired
    PlacementRepository placementRepo;

    //Mappings to student and company jsps where the information is displayed when the forms are filled

    @GetMapping("PendingPlacements/student")
    public String student(@RequestParam int id, Model model) {
        model.addAttribute("student", studentRepo.findByStudentNumber(String.valueOf(id)));
        return "Placement/student";
    }

    @GetMapping("PendingPlacements/company")
    public String company(@RequestParam int id, Model model) {
        model.addAttribute("company", (List<Placement>) ppfProviderDetailsRepo.findById(id));
        return "Placement/company";

    }

    @GetMapping("/pendingPlacements")
    public String application(Model model) {
        List<Placement> pendingPlacements = (List<Placement>) placementRepo.findAllByApprovalStatus(0);
        model.addAttribute("pendingPlacements", (List<Placement>) placementRepo.findAllByApprovalStatus(0));
        return "Placement/pendingPlacement";
    }

    /**
     * @param model      the controller's model to store and retrieve values
     * @param combinedID a string combination of three integers : student id, company id  and placement id
     * @param option     a code to approve , flag or reject.
     * @param description a string for the reason of action.
     **/
    @GetMapping("/pendingPlacements/{combinedID}/{option}")
    public String updateApprovalStatus(Model model, @PathVariable(value = "combinedID", required = true) String combinedID,
                                       @PathVariable(value = "option", required = true) int option, @RequestParam String description) {
        String[] identifiers = combinedID.split("_");
        if (identifiers.length != 3) {
            return "redirect:/pendingPlacements";
        }
        try {
            Student student = studentRepo.findByStudentNumber(identifiers[0]);
            PPFPlacementProviderDetails company = ppfProviderDetailsRepo.findById(Integer.parseInt(identifiers[1]));
            Placement placement = (Placement) placementRepo.findById(Integer.valueOf(identifiers[2])).get();
            if (option == 1) { // approve
                placement.setApprovalStatus(1);
            } else if (option == 2) { // flag
                placement.setApprovalStatus(2);
            } else if (option == 3) { // reject
                placement.setApprovalStatus(3);
            }
            placement.setStatusReason(description);
            placementRepo.save(placement);
        } catch (Exception e) {
            return "redirect:/error";
        }

        return "redirect:/pendingPlacements";
    }

}


