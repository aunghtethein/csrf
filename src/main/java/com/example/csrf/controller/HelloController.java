package com.example.csrf.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @PostMapping("/a")
    public String postEndpointA(){
        return "Works!";
    }

    @GetMapping("/a")
    public String getEndpointA(){
        return "Works!";
    }

    @PostMapping("/a/b")
    public String postEndpointB(){
        return "Works!";
    }

    @GetMapping("/a/b/c")
    public String getEndpointC(){
        return "Works!";
    }

    @GetMapping("/product/{code}")
    public String productCode(){
        return "Work";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @GetMapping("/email/{email}")
    public String emailTest(@PathVariable String email){
        return "Allowed for email "+ email;
    }



}

