package com.example.Lesson_10;


import com.example.Lesson_10.model.Person;
import com.example.Lesson_10.repository.PersonRepository;
import com.example.Lesson_10.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class TransferServiceIntegrationTest {
    @MockitoBean
    public PersonRepository repository;
    @Autowired
    public PersonService service;

    @Test
    public void moneyTransfer() {
        Person sender = new Person();
        sender.setId(1L);
        sender.setName("Kate");
        sender.setAmount(new BigDecimal(1000));
        Person receiver = new Person();
        receiver.setId(2L);
        receiver.setName("Ann");
        receiver.setAmount(new BigDecimal(1000));
        given(repository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(repository.findById(receiver.getId())).willReturn(Optional.of(receiver));
        service.changeAmount(1L, 2L, new BigDecimal(100));
        verify(repository).updateAmount(1L, new BigDecimal(900));
        verify(repository).updateAmount(2L, new BigDecimal(1100));
    }
}
