package com.robertp1.springframeworkwebscopes.part3.controllers;

import com.robertp1.springframeworkwebscopes.part3.services.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // With proxyMode = INTERFACES Spring is not injecting the value of the bean from the Context, but is now injecting
    // a proxy that manages, or decorates, the bean. Now it is a collection of different beans, which are linked correctly
    // to each of the created threads.
    @Autowired
    private NumberService numberService;


    // This method represents the action in the Controller mapped to the index.html file
    @GetMapping(path = "/home")
    public String indexAction(Model model) {
        model.addAttribute("message", numberService.getValue());

        return "index.html";
    }
}
