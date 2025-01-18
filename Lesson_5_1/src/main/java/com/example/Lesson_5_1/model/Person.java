package com.example.Lesson_5_1.model;

import jakarta.persistence.*;


@Entity
@Table(name = "person_db")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column
    String name;
    @Column
    String email;

    public Person(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id).append('\n');
        sb.append("Name: ").append(name).append('\n');
        sb.append("Email: ").append(email).append('\n');
        return sb.toString();
    }
}
