package com.example.Lesson_10.controller;



import com.example.Lesson_10.dto.TransferRequest;
import com.example.Lesson_10.model.Person;
import com.example.Lesson_10.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathVariable("id") Long id, @RequestBody Person person) {
        return new ResponseEntity<>(service.updatePerson(id, person), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.deletePerson(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/transfer")
    public ResponseEntity<Void> transferMoney(@RequestBody TransferRequest request)
    {
        service.changeAmount(request.getIdSender(),
                            request.getIdReceiver(),
                            request.getAmount()
        );
        return ResponseEntity.ok().build();
    }
}
