package com.codeclan.example.PresentPlanner.repositories.events;

import com.codeclan.example.PresentPlanner.models.Event;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class EventRepositoryImpl implements EventRepositoryCustom{

    @Autowired
    EntityManager entityManager;

    @DateTimeFormat(pattern = "d-MM")
    @Transactional
    public List<Event> nextFiveEvents() {
        List<Event> events = null;
        List<Event> sortedEvents = null;
        Session session = entityManager.unwrap(Session.class);

        Date dateToday = new Date();
        SimpleDateFormat dateType = new SimpleDateFormat("d-MM");
        String dateString = dateType.format(dateToday);
        Date date = null;
        try {
            date = dateType.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

//        need algorithm to sort dates?
        try {
            Criteria cr = session.createCriteria(Event.class);
            cr.add(Restrictions.ge("dayAndMonth", date));
            events = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }


        return events;
    }
}
