package com.codeclan.example.PresentPlanner;

import com.codeclan.example.PresentPlanner.models.Event;
import com.codeclan.example.PresentPlanner.models.Person;
import com.codeclan.example.PresentPlanner.repositories.events.EventRepository;
import com.codeclan.example.PresentPlanner.repositories.items.ItemRepository;
import com.codeclan.example.PresentPlanner.repositories.persons.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PresentPlannerApplicationTests {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	EventRepository eventRepository;

	@Autowired
	ItemRepository itemRepository;

	@Test
	public void contextLoads() {
	}


	@Test
	public void canGetItemsByPersonId() {
		assertEquals(1, itemRepository.getItemsByPersonId(1L).size());
		assertEquals(1, itemRepository.getItemsByPersonId(2L).size());
	}

	@Test
	public void canGetPersonById() {
		Person person = new Person("Joe");
		personRepository.save(person);
		assertEquals("Joe", personRepository.getPersonById(person.getId()).getName());
	}

	@Test
	public void canGetEventsByPersonId() {
		assertEquals("Birthday", eventRepository.getAllEventsByPersonId(1L).get(0).getEventName());
	}

	@Test
	public void canGetEventsInOrder() {
		assertEquals(29, eventRepository.getEventsInOrder().get(0).getEventDay());
		assertEquals(6, eventRepository.getEventsInOrder().get(0).getEventMonth());
	}

}
