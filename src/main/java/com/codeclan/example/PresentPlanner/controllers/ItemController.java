package com.codeclan.example.PresentPlanner.controllers;

import com.codeclan.example.PresentPlanner.models.Item;
import com.codeclan.example.PresentPlanner.repositories.items.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping(value="/person/{id}")
    public List<Item> getItemsByPersonId(@PathVariable Long id){
        return itemRepository.getItemsByCustomerId(id);
    }
}
