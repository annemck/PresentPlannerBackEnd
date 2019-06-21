package com.codeclan.example.PresentPlanner.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.tools.javac.jvm.Items;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "person")
    private String name;

    @Column(name = "events)of_birth")
    private Event dateOfBirth;

    @JsonIgnoreProperties("person")

    @OneToMany(mappedBy = "person")
    private List<Event> dates;


    @OneToMany(mappedBy = "person")
    private List<Items> items;

    public Person(String name, Event dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dates = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Event getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Event dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    public void addDate(Event date) {
        this.dates.add(date);

    }

    public void addITems(Items item) {
        this.items.add(item);
    }


    public List<Event> getDates() {
        return dates;
    }

    public void setDates(List<Event> dates) {
        this.dates = dates;
    }
}

