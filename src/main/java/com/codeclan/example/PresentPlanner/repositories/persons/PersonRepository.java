package com.codeclan.example.PresentPlanner.repositories.persons;

import com.codeclan.example.PresentPlanner.models.Person;
import com.codeclan.example.PresentPlanner.projections.EmbedPersons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = EmbedPersons.class)
public interface PersonRepository extends JpaRepository<Person, Long>, PersonRespositoryCustom {

    Person getPersonById(Long id);
    List<Person> getPersonsByEventOrder();



}


