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

	//	TEST EXPECTED RESULT CHANGES BY DATE!
	@Test
	public void canGetDaysToGoToEvent() {
		assertEquals(4, eventRepository.getAllEventsByPersonId(2L).get(0).getDays());
		assertEquals(5, eventRepository.getAllEventsByPersonId(1L).get(0).getDays());
	}

	//	TEST EXPECTED RESULT CHANGES BY DATE!
	@Test
	public void canRunGetAllEventsQuery() {
		assertEquals(4, eventRepository.getEventsInOrder().get(0).getDays());
	}

	@Test
	public void canGetPersonsOrderByEvents() {
		assertEquals("Mum",personRepository.getPersonsByEventOrder().get(0).getName());


	}
}
