package com.codeclan.example.PresentPlanner.controllers;

import com.codeclan.example.PresentPlanner.repositories.persons.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


 @RestController
 @RequestMapping("/persons")

public class PersonController {

    @Autowired
    PersonRepository personRepository;



    }


