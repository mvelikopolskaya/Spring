package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceB")
public class HelloController {

    @GetMapping
    public String hello() {
        return "Hello, I'm Microservice 2";
    }
}
