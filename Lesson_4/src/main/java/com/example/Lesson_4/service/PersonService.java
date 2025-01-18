package com.example.Lesson_4.service;

import com.example.Lesson_4.model.Person;
import com.example.Lesson_4.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;


    public List<Person> getAllPersons() {
        repository.save(new Person(null, "Maria", "google@com"));
        repository.save(new Person(null, "Kate", "yandex@ru"));
        repository.save(new Person(null, "Anton", "mail@ru"));
        return repository.findAllPersons();
    }

    public Person getPersonById(Long id) {
        return repository.findPersonById(id);
    }
}
