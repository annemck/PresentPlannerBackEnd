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

//	@Test
//	public void canGetNextFiveEvents() {
//		Person person = new Person("mum");
//		personRepository.save(person);
//		Event event1 = new Event("Birthday", "01-02-1954", person);
//		eventRepository.save(event1);
//		Event event2 = new Event("Anniversay", "09-04-1973", person);
//		eventRepository.save(event2);
//		Event event3 = new Event("Mother's Day", "05-05-2019", person);
//		eventRepository.save(event3);
//		Event event4 = new Event("Christmas", "25-12-2019", person);
//		eventRepository.save(event4);
//		Event event5 = new Event("random Holiday", "31-10-2017", person);
//		eventRepository.save(event5);
////		System.out.println(eventRepository.nextFiveEvents(););
//		assertEquals(5, eventRepository.nextFiveEvents());
//	}
}
