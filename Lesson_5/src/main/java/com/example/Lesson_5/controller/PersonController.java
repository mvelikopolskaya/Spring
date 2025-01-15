package com.example.Lesson_5.controller;

import com.example.Lesson_5.service.PersonService;
import com.example.Lesson_5.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping
    public List<Person> getAllBook() {
        return service.getAllPerson();
    }

    @GetMapping("/{id}")
    public String findPersonById(@PathVariable("id") Long id) {
        return service.getPersonById(id).toString();
    }

    @PostMapping("/add")
    public void savePerson(@RequestBody Person person) {
        service.addPerson(person);
    }

    @PutMapping("/update/{id}")
    public void updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        service.updatePerson(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        service.deleteBook(id);
    }
}
