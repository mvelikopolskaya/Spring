package com.example.Lesson_10_1.controller;

import com.example.Lesson_10_1.dto.TransferRequest;
import com.example.Lesson_10_1.model.Person;
import com.example.Lesson_10_1.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    private PersonService service;

    @GetMapping
    public List<Person> getAllPersons() {
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

    @PutMapping("/{id}")
    public String updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        service.updatePerson(id, person);
        return person.toString();
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        service.deletePerson(id);
    }

    @PostMapping("/transfer")
    public void transferMoney(@RequestBody TransferRequest request)
    {
        service.changeAmount(request.getIdSender(),
                request.getIdReceiver(),
                request.getAmount()
        );
    }
}
