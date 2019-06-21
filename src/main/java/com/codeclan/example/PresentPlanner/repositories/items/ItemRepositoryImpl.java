package com.codeclan.example.PresentPlanner.repositories.items;


import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;


public class ItemRepositoryImpl implements ItemRepositoryCustom {

    @Autowired
    EntityManager entityManager;

}
