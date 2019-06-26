package com.codeclan.example.PresentPlanner.repositories.persons;

import com.codeclan.example.PresentPlanner.models.Person;

import java.util.List;

public interface PersonRespositoryCustom {
    List<Person> getPersonsByEventOrder();
}
