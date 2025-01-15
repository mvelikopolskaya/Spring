package com.example.Lesson_5.service;

import com.example.Lesson_5.model.Person;
import com.example.Lesson_5.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public List<Person> getAllPerson() {
        return repository.findAll();
    }

    public String getPersonById(Long id) {
        Person person = repository.findById(id).get();
        return person.toString();
    }

    public void addPerson(Person person) {
        repository.save(person);
    }

    public void updatePerson(Long id, Person updatedPerson) {
        Optional<Person> optionalPerson = repository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            if (updatedPerson.getName() != null) {
                person.setName(updatedPerson.getName());
            }
            if (updatedPerson.getEmail() != null) {
                person.setEmail(updatedPerson.getEmail());
            }
            repository.save(person);
        } else {
            throw new IllegalArgumentException("Person with id " + id + " wasn't found");
        }
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
