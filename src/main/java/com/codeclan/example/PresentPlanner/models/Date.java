package com.codeclan.example.PresentPlanner.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Entity
@Table(name="dates")
public class Date {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String event;

    @Column
    private java.util.Date date;

    @JsonIgnoreProperties({"items", "dates"})
    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Date(String event, String date, Person person) {
        this.event = event;
        SimpleDateFormat newDate = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.date = newDate.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.person = person;
    }

    public Date() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        java.util.Date savedDate = this.date;
        String date = new SimpleDateFormat("dd-MM-yyyy").format(savedDate);
        return date;
    }

    public void setDate(String newDate) {
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.date = date.parse(newDate);
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
