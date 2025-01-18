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

    public Person addPerson(Person person) {
        return repository.save(person);
    }

    public Person updatePerson(Long id, Person updatedPerson) {
        Optional<Person> optionalPerson = repository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            if (!updatedPerson.getName().isEmpty()) {
                person.setName(updatedPerson.getName());
            }
            if (!updatedPerson.getEmail().isEmpty()) {
                person.setEmail(updatedPerson.getEmail());
            }
            return repository.save(person);
        } else {
            throw new IllegalArgumentException("Person with id " + id + " wasn't found");
        }
    }

    public void deletePerson(Long id) {
        repository.deleteById(id);
    }
}
