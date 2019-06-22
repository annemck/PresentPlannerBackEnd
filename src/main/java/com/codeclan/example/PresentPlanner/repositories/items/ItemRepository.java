package com.codeclan.example.PresentPlanner.repositories.items;

import com.codeclan.example.PresentPlanner.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item, Long>, ItemRepositoryCustom {

    List<Item> getItemsByPersonId(Long id);
}
