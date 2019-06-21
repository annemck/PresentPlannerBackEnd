package com.codeclan.example.PresentPlanner.repositories.persons;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class PersonRepositoryImpl implements PersonRespositoryCustom {
    @Autowired
    EntityManager entityManager;

}
