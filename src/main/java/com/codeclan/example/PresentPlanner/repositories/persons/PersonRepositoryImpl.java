package com.codeclan.example.PresentPlanner.repositories.persons;

import com.codeclan.example.PresentPlanner.models.Event;
import com.codeclan.example.PresentPlanner.models.Person;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class PersonRepositoryImpl implements PersonRespositoryCustom {
    @Autowired
    EntityManager entityManager;
    @Transactional
    public List<Person> getPersonsByEventOrder(){
        List<Person> persons = null;
//        List<Person> sortedPersons = null;
        Session session = entityManager.unwrap(Session.class);
        Criteria cr = session.createCriteria(Person.class);
        cr.createAlias("dates","date");
        cr.addOrder(Order.asc("date.days"));

       persons = cr.list();
        return persons;



    }


}
