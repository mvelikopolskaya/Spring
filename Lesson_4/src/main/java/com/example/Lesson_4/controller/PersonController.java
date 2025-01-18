package com.example.Lesson_4.controller;

import com.example.Lesson_4.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
     public String listPersons(Model model) {
         model.addAttribute("persons", service.getAllPersons());
         return "persons";
     }

    @GetMapping("/{id}")
    public String getPerson(@PathVariable Long id, Model model) {
        model.addAttribute("person", service.getPersonById(id));
        return "person_profile";
    }
}
