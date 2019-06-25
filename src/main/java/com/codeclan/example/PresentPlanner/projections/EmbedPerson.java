package com.codeclan.example.PresentPlanner.projections;

import com.codeclan.example.PresentPlanner.models.Event;
import com.codeclan.example.PresentPlanner.models.Item;
import com.codeclan.example.PresentPlanner.models.Person;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedPersonsItems", types = Person.class)
public interface EmbedPerson {

    Long getId();
    String getName();
    List<Item> getItems();
    List<Event> getDates();
}
