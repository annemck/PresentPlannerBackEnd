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

        Person anne = new Person("Anne");
        personRepository.save(anne);

        Person sri = new Person("Sri");
        personRepository.save(sri);

        Person david = new Person("David");
        personRepository.save(david);

        Event dadBirthday = new Event("Birthday", "30-06-2018", dad);
        eventRepository.save(dadBirthday);

        Event davidBirthday = new Event("Birthday", "01-08-2018", david);
        eventRepository.save(davidBirthday);

        Event davidAnniversary = new Event("Anniversary", "21-05-2016", david);
        eventRepository.save(davidAnniversary);

        Event mumBirthday = new Event("Birthday", "29-06-2019", mum);
        eventRepository.save(mumBirthday);

        Event sriBirthday = new Event("Birthday", "20-12-2019", sri);
        eventRepository.save(sriBirthday);

        Event anneBirthday = new Event("Birthday", "15-02-2019", anne);
        eventRepository.save(anneBirthday);

        Item lego = new Item("Lego", "Racing Car", "Lego Shop, Glasgow", 24.99, "www.Shop.lego.com", "Similar to the car I previously bought him", false, dad);
        itemRepository.save(lego);

        Item bag = new Item("Handbag", "Modalu", "Debenhams", 100, "instore", "Saw it in the window of debenhams as I walked by",true, mum);
        itemRepository.save(bag);

        Item hpbook = new Item("Harry Potter", "Book", "Waterstones", 10, "instore", "David said he hadn't read any of the books",false, david);
        itemRepository.save(hpbook);

        Item bracelet = new Item("Bracelet", "Pandora", "Pandora", 50, "uk.pandora.net", "She would love this",true, anne);
        itemRepository.save(bracelet);

        Item laptop = new Item("Apple Macbook", "Laptop", "Apple Shop", 1000, "Apple shop", "she needs a new one",false, sri);
        itemRepository.save(laptop);
    }

}
