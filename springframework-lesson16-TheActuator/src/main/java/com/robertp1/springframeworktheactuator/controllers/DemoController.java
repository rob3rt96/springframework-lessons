package com.robertp1.springframeworktheactuator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private HealthEndpoint healthEndpoint;    // We can also use MetricsEndpoint class.

    @GetMapping(path = "/demo")
    public String demo() {
        return healthEndpoint.health().toString();
    }
}
