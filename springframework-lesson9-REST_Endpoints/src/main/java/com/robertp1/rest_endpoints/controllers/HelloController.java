package com.robertp1.rest_endpoints.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {


//    @RequestMapping(
//            method = RequestMethod.GET,
//            path = "/hello"
//    )
//    public String hello() {
//        return "Hello there!";
//    }

    @GetMapping(path = "/hello/{name}")
    public String hello(@PathVariable("name") String name) {    // The @PathVariable's parameter, "name", is not mandatory if the method's parameter name is the same as the path variable declared in the @RequestMapping's path parameter.
        return "Hello there, " + name + "!";
    }
}