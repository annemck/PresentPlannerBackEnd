package com.codeclan.example.PresentPlanner.models;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.tools.javac.jvm.Items;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "presentplanner")
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
    private  List<Date> dates;

    @OneToMany(mappedBy = "person")
    private List<Items> items;

    public Person(String name, Date dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dates =   new ArrayList<>();
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

    public List<Date> getDate() {
        return dates;
    }

    public void setDate(List<Date> date) {
        this.dates = dates;
    }

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
    public void addDate(Date date){
        this.dates.add(date);
    }
    public void addITems(Items item){
        this.items.add(item);
    }
}
