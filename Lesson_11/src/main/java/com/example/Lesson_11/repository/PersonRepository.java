package com.example.Lesson_11.repository;




import com.example.Lesson_11.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    default void updateAmount(Long id, BigDecimal amount) {
        Person person = findById(id).get();
        person.setAmount(amount);
    }

}
