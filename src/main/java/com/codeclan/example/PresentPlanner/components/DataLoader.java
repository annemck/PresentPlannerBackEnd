package com.codeclan.example.PresentPlanner.components;

import com.codeclan.example.PresentPlanner.models.Event;
import com.codeclan.example.PresentPlanner.models.Item;
import com.codeclan.example.PresentPlanner.models.Person;
import com.codeclan.example.PresentPlanner.repositories.events.EventRepository;
import com.codeclan.example.PresentPlanner.repositories.items.ItemRepository;
import com.codeclan.example.PresentPlanner.repositories.persons.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    EventRepository eventRepository;

    public DataLoader(){
    }

    public void run(ApplicationArguments args){

        Person dad = new Person("Dad");
        personRepository.save(dad);

        Person mum = new Person("Mum");
        personRepository.save(mum);

        Event dadBirthday = new Event("Birthday", "30-06-2018", dad);
        eventRepository.save(dadBirthday);

        Event mumBirthday = new Event("Birthday", "29-06-2019", mum);
        eventRepository.save(mumBirthday);

        Item lego = new Item("Lego", "Racing Car", "Lego Shop, Glasgow", 24.99, "www.legoShop.com", "Similar to the car I previously bought him", false, dad);
        itemRepository.save(lego);

        Item bag = new Item("Handbag", "Modalu", "Debenhams", 100, "instore", "Saw it in the window of debenhams as I walked by",true, mum);
        itemRepository.save(bag);
    }

}
