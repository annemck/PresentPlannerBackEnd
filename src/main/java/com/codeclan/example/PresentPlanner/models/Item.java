package com.codeclan.example.PresentPlanner.models;


import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String location;

    @Column
    private double price;

    @Column
    private String link;

    @Column(name = "additional_detail")
    private String additionalDetail;

    @Column(name = "star_item")
    private boolean starItem;

    @ManyToOne
    @JoinColumn(name="persons_id", nullable = false)
    private Person person;

    public Item(String name, String description, String location, double price, String link, String additionalDetail, boolean starItem, Person person) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.price = price;
        this.link = link;
        this.additionalDetail = additionalDetail;
        this.starItem = starItem;
        this.person = person;
    }

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getAdditionalDetail() {
        return additionalDetail;
    }

    public void setAdditionalDetail(String additionalDetail) {
        this.additionalDetail = additionalDetail;
    }

    public boolean isStarItem() {
        return starItem;
    }

    public void setStarItem(boolean starItem) {
        this.starItem = starItem;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

