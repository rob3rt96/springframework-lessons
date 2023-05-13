package com.robertp1.springframeworktheactuator.actuator.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component

// With this annotation you can create a custom endpoint inside localhost:9090/actuator/{myCustomEndpoint}
@Endpoint(id = "myCustomEndpoint")
public class MyCustomEndpoint {

    @ReadOperation
    public String test() {
        return ":)";
    }
}
