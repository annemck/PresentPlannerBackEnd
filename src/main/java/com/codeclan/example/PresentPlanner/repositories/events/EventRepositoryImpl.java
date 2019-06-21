package com.codeclan.example.PresentPlanner.repositories.events;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class EventRepositoryImpl {

    @Autowired
    EntityManager entityManager;
}
