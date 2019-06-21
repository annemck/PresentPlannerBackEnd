package com.codeclan.example.PresentPlanner.repositories.date;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DateRepositoryImpl {

    @Autowired
    EntityManager entityManager;
}
