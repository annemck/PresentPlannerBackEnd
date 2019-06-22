package com.codeclan.example.PresentPlanner.repositories.persons;

import com.codeclan.example.PresentPlanner.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long>, PersonRespositoryCustom {
}


