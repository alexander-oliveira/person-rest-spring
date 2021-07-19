package dev.xndr.peopleapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import dev.xndr.peopleapi.dto.request.PersonDTO;
import dev.xndr.peopleapi.dto.response.MessageResponseDTO;
import dev.xndr.peopleapi.entity.Person;
import dev.xndr.peopleapi.exception.PersonNotFoundException;
import dev.xndr.peopleapi.mapper.PersonMapper;
import dev.xndr.peopleapi.repository.PersonRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @PostMapping
    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {

        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
                
        return personMapper.toDTO(person);
    }

}
