package com.example.Lesson_10;


import com.example.Lesson_10.model.Person;
import com.example.Lesson_10.repository.PersonRepository;
import com.example.Lesson_10.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class TransferServiceSimpleTest {
    @Mock
    public PersonRepository repository;
    @InjectMocks
    public PersonService service;


    @Test
    public void moneyTransferDestinationAccountNotFoundFlow() {
        Person sender = new Person();
        sender.setId(1L);
        sender.setAmount(new BigDecimal(1000));

        given(repository.findById(1L)).willReturn(Optional.of(sender));

        given(repository.findById(2L))
                .willReturn(Optional.empty());

        assertThrows(
                IllegalArgumentException.class,
                () -> service.changeAmount(1L, 2L, new BigDecimal(100))
        );

        verify(repository, never()).updateAmount(anyLong(), any());
    }
}
