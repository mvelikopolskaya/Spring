package com.example.Lesson_8.service;

import com.example.Lesson_8.aspects.ToLogAround;
import com.example.Lesson_8.model.Person;
import com.example.Lesson_8.repository.PersonRepository;
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
    public Person updatePerson(Long id, Person updatedPerson) {
        Person person = getPersonById(id);
        if (!updatedPerson.getName().isEmpty()) {
            person.setName(updatedPerson.getName());
        }
        if (updatedPerson.getAmount() != null) {
            person.setAmount(updatedPerson.getAmount());
        }
        return repository.save(person);
    }

    @ToLogAround
    public void updateAmount(Long id, BigDecimal amount) {
        Person person = getPersonById(id);
        person.setAmount(amount);
    }

    @ToLogAround
    public void deletePerson(Long id) {
        repository.deleteById(id);
    }

    @ToLogAround
    @Transactional
    public void changeAmount(Long idSender, Long idReceiver, BigDecimal amount) {
        Person sender = getPersonById(idSender);
        Person receiver = getPersonById(idReceiver);
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);
        updateAmount(idSender, senderNewAmount);
        updateAmount(idReceiver, receiverNewAmount);
        repository.save(sender);
        repository.save(receiver);
    }
}
