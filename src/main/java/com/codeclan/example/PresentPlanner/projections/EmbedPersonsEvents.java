package com.codeclan.example.PresentPlanner.projections;

import com.codeclan.example.PresentPlanner.models.Event;
import com.codeclan.example.PresentPlanner.models.Person;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;

@Projection(name = "embedPersonsEvents", types = Event.class)
public interface EmbedPersonsEvents {

    Long getId();
    String getEventName();
    LocalDate getEventDate();
    Person getPerson();

}
