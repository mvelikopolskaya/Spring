package com.example.Lesson_5_1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Lesson_5_1.model.Person;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
