package com.example.Lesson_4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;


    public List<Person> getAllPersons() {
        repository.save(new Person(null, "Maria", "google@com"));
        return repository.findAllPersons();
    }

    public Person getPersonById(Long id) {
        return repository.findPersonById(id);
    }
}
