package com.robertp1.springbootmore_on_rest.controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping(path = "/test")
    public String test(
            @RequestHeader String h1,
            @RequestHeader String h2
    ) {
        return h1 + " " + h2;
    }

    // You can have multiple types of input into the endpoint, in the form of @PathVariable, @RequestHeader or @RequestBody.
    // These are some ways to output data from the endpoint.
    @PostMapping(path = "/test/{name}")
    public String test(
            @PathVariable String name,
            @RequestHeader String h1,
            @RequestHeader String h2,
            @RequestBody String body,
            HttpServletResponse response
    ) {
        response.addHeader("ExampleResponse", "This is the response");

        return name + " has " + h1 + " apples and " + h2 + " carrots in the " + body;
    }

    // In this way we can get all the RequestHeaders and save them in a Map, which will be automatically populated by Springboot.
    // The RequestHeaders will be returned to the Body of the response, in the form of a Map collection.
    @GetMapping(path = "/all")
    public Map<String, String> all(@RequestHeader Map<String, String> headers) {
        return headers;
    }

    // In this way we can export an image, pdf, or other MediaType from the endpoint. It is possible by sending the data as an array of bytes.
    @GetMapping(path = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] file() {
        byte[] file = new byte[100];

        return file;
    }
}
