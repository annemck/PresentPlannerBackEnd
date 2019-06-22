package com.codeclan.example.PresentPlanner.repositories.events;

import com.codeclan.example.PresentPlanner.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface EventRepository extends JpaRepository<Event, Long>, EventRepositoryCustom {
}
