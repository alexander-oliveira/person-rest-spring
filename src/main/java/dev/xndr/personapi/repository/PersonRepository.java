package dev.xndr.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.xndr.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    
    
}
