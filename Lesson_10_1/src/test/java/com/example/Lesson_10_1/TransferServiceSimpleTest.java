package com.example.Lesson_10_1;


import com.example.Lesson_10_1.model.Person;
import com.example.Lesson_10_1.repository.PersonRepository;
import com.example.Lesson_10_1.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class TransferServiceSimpleTest {
    @Mock
    public PersonRepository repository;
    @InjectMocks
    public PersonService service;


    @Test
    public void showPersonsTest() {
        Person person1 = new Person(1L, "Kate", new BigDecimal(1000));
        Person person2 = new Person(2L, "Ann", new BigDecimal(1000));
        List<Person> expectedPersons = new ArrayList<>();
        expectedPersons.add(person1);
        expectedPersons.add(person2);
        when(repository.findAll()).thenReturn(expectedPersons);
        List<Person> actualPersons = service.getAllPerson();
        assertEquals(expectedPersons, actualPersons);
    }

    @Test
    public void findPersonTest() {
        Person person = new Person(1L, "Kate", new BigDecimal(1000));
        given(repository.findById(person.getId())).willReturn(Optional.of(person));
        service.getPersonById(1L);
        verify(repository).findById(1L);
    }

    @Test
    public void updatePersonTest() {
        Person person1 = new Person(1L, "Kate", new BigDecimal(1000));
        Person person2 = new Person(2L, "Ann", new BigDecimal(1000));
        given(repository.findById(person1.getId())).willReturn(Optional.of(person1));
        service.updatePerson(1L, person2);
        verify(repository).findById(1L);
        verify(repository).save(person1);
    }

    @Test
    public void moneyTransferTest() {
        Person sender = new Person(1L, "Kate", new BigDecimal(1000));
        given(repository.findById(1L)).willReturn(Optional.of(sender));
        given(repository.findById(2L))
                .willReturn(Optional.empty());

        assertThrows(
               Exception.class,
                () -> service.changeAmount(1L, 2L, new BigDecimal(100))
        );
        verify(repository, never()).updateAmount(anyLong(), any());
    }
}
