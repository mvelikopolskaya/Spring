package com.example.Lesson_6.controller;


import com.example.Lesson_6.model.Person;
import com.example.Lesson_6.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService service;


    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(service.getAllPersons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable("id") Long id) {
        Person requiredPerson = null;
        try {
            requiredPerson = service.getPersonById(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(requiredPerson, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        return new ResponseEntity<>(service.addPerson(person), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Person> update(@PathVariable("id") Long id, @RequestBody Person person) {
        return new ResponseEntity<>(service.updatePerson(id, person), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.deletePerson(id);
        return ResponseEntity.ok().build();
    }
}
