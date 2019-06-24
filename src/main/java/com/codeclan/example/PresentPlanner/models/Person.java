package com.codeclan.example.PresentPlanner.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "person")
    private String name;

//    @DateTimeFormat(pattern="dd.MM.yyyy hh:mm")

//    @Column(name = "date_of_birth")
//    private String dateOfBirth;

    @JsonIgnoreProperties("person")
    @OneToMany(mappedBy = "person")
    private List<Event> dates;


    @JsonIgnoreProperties("person")
    @OneToMany(mappedBy = "person")
    private List<Item> items;

//    removed dateOfBirth from constructor due to dataloader errors and commented out uses - Anne
    public Person(String name) {
        this.name = name;
//        this.dateOfBirth = dateOfBirth;
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

//    public String getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth( String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addDate(Event date) {
        this.dates.add(date);

    }

    public void addITems(Item item) {
        this.items.add(item);
    }


    public List<Event> getDates() {
        return dates;
    }

    public void setDates(List<Event> dates) {
        this.dates = dates;
    }
}

