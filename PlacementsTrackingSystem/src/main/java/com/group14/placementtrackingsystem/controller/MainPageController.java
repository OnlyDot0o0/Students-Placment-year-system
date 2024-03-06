package com.group14.placementtrackingsystem.controller;

import com.group14.placementtrackingsystem.model.Placement;
import com.group14.placementtrackingsystem.repository.PlacementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller

public class MainPageController implements ErrorController {

    @Autowired
    private PlacementRepository placementRepository;

    @GetMapping({"/internal","/"})
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    public String landingPage(OAuth2AuthenticationToken token, Model model){
        List<Placement> placements =  placementRepository.findStudentByOnPlacement(new java.sql.Date(System.currentTimeMillis()));
        placements = placements.stream().filter(placement -> placement.getApprovalStatus() == 1).collect(Collectors.toList());
        model.addAttribute("principal", token.getPrincipal().getAttributes());
        model.addAttribute("placements",placements);

        return "LandingPage";
    }

    @RequestMapping("/error")
    protected String error() {
        return "error";
     }
}
