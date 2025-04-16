package com.edex.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

    @GetMapping("/hi")
    public String sayHi(){
        return "Hello World";
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "<h1>Mother Earth</h1>";
    }

    @PostMapping("/login2")
    public String login(){
        return "Login Success";
    }
}
/*
 GET
 POST
 PUT
 DELETE
 OPTIONS
 PATCH
 HEAD
 */

