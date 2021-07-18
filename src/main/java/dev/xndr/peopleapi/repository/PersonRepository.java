package dev.xndr.peopleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.xndr.peopleapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
    
}
