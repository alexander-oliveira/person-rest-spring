package dev.xndr.peopleapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import dev.xndr.peopleapi.dto.request.PersonDTO;
import dev.xndr.peopleapi.entity.Person;

public class PersonUtils {
    private static final String FIRST_NAME = "Full";
    private static final String LAST_NAME = "Name";
    private static final String CPF_NUMBER = "992.437.384-70";
    private static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
            .firstName(FIRST_NAME)
            .lastName(LAST_NAME)
            .cpf(CPF_NUMBER)
            .birthDate(BIRTH_DATE)
            .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
            .build();
    }
}
