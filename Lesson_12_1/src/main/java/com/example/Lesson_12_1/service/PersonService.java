package com.example.Lesson_12_1.service;


import com.example.Lesson_12_1.aspects.ToLogAround;
import com.example.Lesson_12_1.model.Person;
import com.example.Lesson_12_1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    private Logger logger = Logger.getLogger(Person.class.getName());

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @ToLogAround
    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    @ToLogAround
    public Person getPersonById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Person with id " + id + " wasn't found"));
    }

    @ToLogAround
    public Person addPerson(Person person) {
        return repository.save(person);
    }

    @ToLogAround
    public void updatePerson(Long id, Person updatedPerson) {
        Person person = getPersonById(id);
        if (updatedPerson != null && !updatedPerson.getName().isEmpty()) {
            person.setName(updatedPerson.getName());
        }
        if (updatedPerson != null && !updatedPerson.getEmail().isEmpty()) {
            person.setEmail(updatedPerson.getEmail());
        }
        repository.save(person);
    }


    @ToLogAround
    public void deletePerson(Long id) {
        repository.deleteById(id);
    }

}
