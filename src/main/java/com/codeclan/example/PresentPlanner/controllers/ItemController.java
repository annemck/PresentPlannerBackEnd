package com.codeclan.example.PresentPlanner.controllers;

import com.codeclan.example.PresentPlanner.models.Item;
import com.codeclan.example.PresentPlanner.repositories.items.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping(value="/person/{id}")
    public List<Item> getItemsByPersonId(@PathVariable Long id){
        return itemRepository.getItemsByPersonId(id);
    }

    @Configuration
    public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
        @Override
        public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
            config.exposeIdsFor(Item.class);
        }
    }
}
