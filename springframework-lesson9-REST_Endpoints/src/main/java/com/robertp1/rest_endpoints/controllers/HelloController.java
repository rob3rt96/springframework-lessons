package com.robertp1.rest_endpoints.controllers;

import com.robertp1.rest_endpoints.dto.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(path = "/goodbye")
    public String goodbye(@RequestBody Person p) {      // The Person object will be taken from the body of the request. The response will be converted from JSON to a java Object.
        return "Goodbye, " + p.getName() + "!";
    }

    @GetMapping(path = "/get")
    public Person getPerson() {
        Person p1 = new Person();
        p1.setName("Andreea");

        return p1;
    }

    @GetMapping(path = "/getAll")
    public List<Person> getAllPersons() {
        Person p1 = new Person();
        p1.setName("Andreea");

        Person p2 = new Person();
        p2.setName("John");

        return List.of(p1, p2);
    }
}
