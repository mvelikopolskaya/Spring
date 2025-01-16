package com.example.Lesson_6.service;


import com.example.Lesson_6.model.Person;
import com.example.Lesson_6.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public List<Person> getAllPersons() {
        return repository.findAll();
    }

    public Person getPersonById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Person with id " + id + " wasn't found"));
    }

    public Person addPerson(String name, String email) {
        Person person = new Person(null, name, email);
        return repository.save(person);
    }

    public Person updatePerson(Long id, String name, String email) {
        Person newPerson = new Person(null, name, email);
        Optional<Person> optionalPerson = repository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            if (newPerson.getName() != null && !newPerson.getName().isEmpty()) {
                person.setName(newPerson.getName());
            }
            if (newPerson.getEmail() != null && !newPerson.getEmail().isEmpty()) {
                person.setEmail(newPerson.getEmail());
            }
            return repository.save(person);
        } else {
            throw new IllegalArgumentException("Person with id " + id + " wasn't found");
        }
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
