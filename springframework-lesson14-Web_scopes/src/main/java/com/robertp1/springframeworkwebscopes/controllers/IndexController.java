package com.robertp1.springframeworkwebscopes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {


    // This method represents the action in the Controller mapped to the index.html file
    @GetMapping(path = "/home")
    public String indexAction(Model model) {
        model.addAttribute("message", "Hello");

        return "index.html";
    }
}
