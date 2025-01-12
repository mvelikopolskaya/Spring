package com.example.Lesson_4;

import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class PersonRepository {
    private final Map<Long, Person> persons = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Person> findAllPersons() {
        return new ArrayList<>(persons.values());
    }

    public Person findPersonById(Long id) {
        return persons.get(id);
    }

    public void save(Person person) {
        if (person.getId() == null) {
            person.setId(counter.incrementAndGet());
        }
        persons.put(person.getId(), person);
    }
}
