package com.group14.placementtrackingsystem.controller;

import com.group14.placementtrackingsystem.model.Placement;
import com.group14.placementtrackingsystem.repository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FlaggedController {
    @Autowired
    public PlacementRepository placementRepository; //takes the information from the placement repo

    @GetMapping("/flagged")
    public String getAllFlaggedPlacements(Model model){
        List<Placement> placements = placementRepository.findAllByApprovalStatus(2);
        model.addAttribute("placements",placements);

        return "Placement/Flagged";
    }
}
