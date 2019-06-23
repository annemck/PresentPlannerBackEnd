package com.codeclan.example.PresentPlanner.controllers;


import com.codeclan.example.PresentPlanner.models.Event;
import com.codeclan.example.PresentPlanner.repositories.events.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.MonthDay;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventRepository eventRepository;
//
//    @GetMapping(value = "/ordered-events")
//    public List<Event> getEventsInOrder() {
//        return eventRepository.getAllEventsAfterShortDate(MonthDay.now());
//    }
}
