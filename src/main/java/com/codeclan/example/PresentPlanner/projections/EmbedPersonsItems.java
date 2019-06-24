package com.codeclan.example.PresentPlanner.projections;

import com.codeclan.example.PresentPlanner.models.Item;
import com.codeclan.example.PresentPlanner.models.Person;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "embedPersonsItems", types = Item.class)
public interface EmbedPersonsItems {

    Long getId();
    String getName();
    String getDescription();
    String getLocation();
    double getPrice();
    String getLink();
    String getadditionalDetail();
    boolean getStarItem();
    Person getPerson();

}
