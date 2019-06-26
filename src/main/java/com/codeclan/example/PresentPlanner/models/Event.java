package com.codeclan.example.PresentPlanner.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="event_name")
    private String eventName;

    @DateTimeFormat(pattern = "d-MM-yyyy")
    @Column(name="date")
    private LocalDate eventDate;

    @Column(name="days")
    private Long days;

    @JsonIgnoreProperties({"items", "dates"})
    @ManyToOne
    @JoinColumn(name = "persons_id", nullable = false)
    private Person person;


    public Event(String eventName, String eventDate, Person person) {
        this.eventName = eventName;
        this.person = person;
        DateTimeFormatter dateType = DateTimeFormatter.ofPattern("d-MM-yyyy");
        this.eventDate = LocalDate.parse(eventDate, dateType);
        this.calculateDaysToGo();
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDate getEventDate() {
        DateTimeFormatter dateType = DateTimeFormatter.ofPattern("d-MM-yyyy");
        String stringDate = this.eventDate.format(dateType);
        return LocalDate.parse(stringDate, dateType);
    }

    public void setEventDate(String eventDate) {
        DateTimeFormatter dateType = DateTimeFormatter.ofPattern("d-MM-yyyy");
        this.eventDate = LocalDate.parse(eventDate, dateType);
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public void calculateDaysToGo(){
        int todayDays = LocalDate.now().getDayOfYear();
        int eventDays = this.eventDate.getDayOfYear();
        MonthDay todayShort = MonthDay.now();
        LocalDate today = null;
        LocalDate event = null;
        today = todayShort.atYear(0000);
        if (eventDays > todayDays) {
            event = this.eventDate.withYear(0000);
        } else {
            event = this.eventDate.withYear(0001);
        }
        this.days = DAYS.between(today, event);
    }

    public int getDays() {
        int newDays = this.days.intValue();
        return newDays;
    }

    public void setDays(Long days) {
        this.days = days;
    }
}
