package com.example.Lesson_2;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getUserName() {
       User user = new User("New User");
       return user.getName();
    }
}
