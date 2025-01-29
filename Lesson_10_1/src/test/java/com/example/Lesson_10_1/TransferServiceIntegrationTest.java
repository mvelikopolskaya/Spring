package com.example.Lesson_10_1;

import com.example.Lesson_10_1.model.Person;
import com.example.Lesson_10_1.repository.PersonRepository;
import com.example.Lesson_10_1.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@SpringBootTest
public class TransferServiceIntegrationTest {
    @MockitoBean
    PersonRepository repository;
    @Autowired
    PersonService service = new PersonService();

    @Test
    public void moneyTransferIntegrationTest() {
        Person sender = new Person(1L, "Kate", new BigDecimal(1000));
        Person receiver = new Person(2L, "Ann", new BigDecimal(1000));
        given(repository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(repository.findById(receiver.getId())).willReturn(Optional.of(receiver));
        service.changeAmount(1L, 2L, new BigDecimal(100));
        verify(repository).updateAmount(1L, new BigDecimal(900));
        verify(repository).updateAmount(2L, new BigDecimal(1100));
    }
}
