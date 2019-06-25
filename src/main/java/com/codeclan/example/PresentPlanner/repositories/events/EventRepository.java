package com.codeclan.example.PresentPlanner.repositories.events;

import com.codeclan.example.PresentPlanner.models.Event;
import com.codeclan.example.PresentPlanner.projections.EmbedPersonsEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = EmbedPersonsEvents.class)
public interface EventRepository extends JpaRepository<Event, Long>, EventRepositoryCustom {

        List<Event> getAllEventsByPersonIdOrderByDaysAsc(Long id);


}
