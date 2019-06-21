package com.codeclan.example.PresentPlanner.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="event-name")
    private String eventName;

    @Column(name="event-events")
    private java.util.Date eventDate;

    @JsonIgnoreProperties({"items", "dates"})
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Event(String event, String eventDate, Person person) {
        this.eventName = event;
        SimpleDateFormat newDate = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.eventDate = newDate.parse(eventDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.person = person;
    }

    public Event() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String event) {
        this.eventName = event;
    }

    public String getDate() {
        java.util.Date savedDate = this.eventDate;
        String date = new SimpleDateFormat("dd-MM-yyyy").format(savedDate);
        return date;
    }

    public void setDate(String newDate) {
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.eventDate = date.parse(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
