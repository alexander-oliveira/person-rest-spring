package dev.xndr.peopleapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import dev.xndr.peopleapi.dto.response.MessageResponseDTO;
import dev.xndr.peopleapi.entity.Person;
import dev.xndr.peopleapi.repository.PersonRepository;

@Service
public class PersonService {
    
    private PersonRepository personRepository;

    @Autowired
    public void PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }
}
