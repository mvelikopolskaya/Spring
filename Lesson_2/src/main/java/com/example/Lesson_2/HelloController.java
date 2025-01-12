package com.example.Lesson_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

        @GetMapping("/hello")
        public String hello() {
        String user = helloService.getUserName();
        return "Hello, " + user + "!";
        }

}
