package com.codeclan.example.PresentPlanner.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="event_name")
    private String eventName;

    @Column(name="date")
    private Date eventDate;

    @JsonIgnoreProperties({"items", "dates"})
    @ManyToOne
    @JoinColumn(name = "persons_id", nullable = false)
    private Person person;

    @Column(name = "day_and_month")
    private Date dayAndMonth;

    public Event(String eventName, String eventDate, Person person) {
        this.eventName = eventName;
        SimpleDateFormat newDate = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.eventDate = newDate.parse(eventDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.person = person;
        this.addDayAndMonth();
    }

    public Event() { }

    private void addDayAndMonth() {
        SimpleDateFormat dateType = new SimpleDateFormat("dd-MM");
        String date = dateType.format(this.eventDate);
        String shortDate = date.substring(0, 5);
        try {
            this.eventDate = dateType.parse(shortDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.eventDate = date.parse(eventDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.addDayAndMonth();
    }

    public Date getDayAndMonth() {
        return dayAndMonth;
    }

    public void setDayAndMonth(Date dayAndMonth) {
        this.dayAndMonth = dayAndMonth;
    }


}
