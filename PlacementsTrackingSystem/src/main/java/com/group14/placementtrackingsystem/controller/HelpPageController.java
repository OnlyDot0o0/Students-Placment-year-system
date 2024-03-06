package com.group14.placementtrackingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//help page controller with simple mapping to the help page jsp
@Controller
public class HelpPageController {

    @GetMapping("/help")
        public String HelpPage(){
        return "HelpPage/HelpPage";
    }
}
