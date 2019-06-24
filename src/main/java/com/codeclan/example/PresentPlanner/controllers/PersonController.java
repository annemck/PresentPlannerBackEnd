package com.codeclan.example.PresentPlanner.controllers;

import com.codeclan.example.PresentPlanner.models.Person;
import com.codeclan.example.PresentPlanner.repositories.persons.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


 @RestController
 @RequestMapping("/api/persons")

public class PersonController {

    @Autowired
    PersonRepository personRepository;

     @GetMapping(value="/person/{id}")
     public Person getPersonById(@PathVariable Long id){
         return personRepository.getPersonById(id);
     }

 }


