package com.robertp1.springboot101.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/*@ResponseBody
@Controller                     // Using this annotation will automatically provide you functionality as an action in a servlet, that is run in Tomcat. */
@RestController             // This is the equivalent of @ResponseBody and @Controller in one annotation
public class HelloController {

    @RequestMapping("/hello")
    /*@ResponseBody                   // Tells Spring that you already returned the response's body from the method, and that id doesn't need to search for a static resource in the "static" folder to render*/
    public String hello() {
        return "Hello";
    }
}
