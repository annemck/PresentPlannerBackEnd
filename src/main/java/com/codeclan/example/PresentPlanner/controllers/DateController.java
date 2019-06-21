package com.codeclan.example.PresentPlanner.controllers;


import com.codeclan.example.PresentPlanner.repositories.events.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dates")
public class DateController {

    @Autowired
    EventRepository dateRepository;
}
