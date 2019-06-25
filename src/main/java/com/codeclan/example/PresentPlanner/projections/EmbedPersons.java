package com.codeclan.example.PresentPlanner.projections;

import com.codeclan.example.PresentPlanner.models.Event;
import com.codeclan.example.PresentPlanner.models.Item;
import com.codeclan.example.PresentPlanner.models.Person;
import com.sun.tools.javac.jvm.Items;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name= "embedPersons", types = Person.class)
public interface EmbedPersons {


    Long getId();
    String getName();
    List<Item> getItems();
    List<Event> getDates();

}

