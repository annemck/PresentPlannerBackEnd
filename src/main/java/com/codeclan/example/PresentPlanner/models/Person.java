package com.codeclan.example.PresentPlanner.models;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    @Column (name = "person")
    private String name;

    @Column (name = "date)of_birth")
    private Date dateOfBirth;

    @JsonIgnoreProperties("person")

    @OneToMany(mappedBy = "person")
    private  List<Event> events;

    @OneToMany(mappedBy = "person")
    private List<Items> items;

    public Person(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.events =   new ArrayList<>();
        this.items = new ArrayList<>();
    }
    public Person(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
    public void addDate(Event  events){
        this.events.add(event);
    }
    public void addITems(Items item){
        this.items.add(item);
    }
}
