package com.example.Lesson_10_1.service;

import com.example.Lesson_10_1.model.Person;
import com.example.Lesson_10_1.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public List<Person> getAllPerson() {
        return repository.findAll();
    }

    public Person getPersonById(Long id) {
        return repository.findById(id).get();
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
            if (updatedPerson.getAmount() != null) {
                person.setAmount(updatedPerson.getAmount());
            }
            repository.save(person);
        } else {
            throw new IllegalArgumentException("Person with id " + id + " wasn't found");
        }
    }

    public void deletePerson(Long id) {
        repository.deleteById(id);
    }

    public void changeAmount(Long idSender, Long idReceiver, BigDecimal amount) {
        Person sender = getPersonById(idSender);
        Person receiver = getPersonById(idReceiver);
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
        repository.updateAmount(idSender, senderNewAmount);
        repository.updateAmount(idReceiver, receiverNewAmount);
        repository.save(sender);
        repository.save(receiver);
    }
}
