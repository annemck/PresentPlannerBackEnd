package com.codeclan.example.PresentPlanner.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

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

    @JsonIgnoreProperties({"items", "dates"})
    @ManyToOne
    @JoinColumn(name = "persons_id", nullable = false)
    private Person person;

    @DateTimeFormat(pattern = "d-MM")
    @Column(name = "day_and_month")
    private MonthDay dayAndMonth;

    public Event(String eventName, String eventDate, Person person) {
        this.eventName = eventName;
        this.person = person;
        DateTimeFormatter dateType = DateTimeFormatter.ofPattern("d-MM-yyyy");
        this.eventDate = LocalDate.parse(eventDate, dateType);
        this.setDayAndMonth();
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
        this.setDayAndMonth();
    }

    public MonthDay getDayAndMonth() {
        return dayAndMonth;
    }

    public void setDayAndMonth() {
        DateTimeFormatter dateTypeOne = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter dateTypeTwo = DateTimeFormatter.ofPattern("d-MM");
        String stringDate = this.eventDate.format(dateTypeOne);
        String shortDate = stringDate.substring(0, 5);
        this.dayAndMonth = MonthDay.parse(shortDate, dateTypeTwo);
    }


}
