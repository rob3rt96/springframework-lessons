package com.robertp1.springbootmore_on_rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/test")
    public String test(
            @RequestHeader String h1,
            @RequestHeader String h2
    ) {
        return h1 + " " + h2;
    }
}
