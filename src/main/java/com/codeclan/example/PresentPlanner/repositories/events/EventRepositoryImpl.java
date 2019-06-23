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
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class EventRepositoryImpl implements EventRepositoryCustom{

    @Autowired
    EntityManager entityManager;

//    @DateTimeFormat(pattern = "d-MM")
//    @Transactional
//    public List<Event> getEventsInOrder() {
//        List<Event> eventsList = null;
//        ArrayList<Event> events = null;
//        List<Event> sortedEvents = null;
//        Session session = entityManager.unwrap(Session.class);
//
//        DateTimeFormatter dateType = DateTimeFormatter.ofPattern("yyyy-d-MM");
//        String longDate = LocalDate.now().toString();
//        String shortDate = longDate.substring(4);
//        LocalDate date = LocalDate.parse(shortDate, dateType);
//
//
//
//        try {
//            Criteria cr = session.createCriteria(Event.class);
//            eventsList = cr.list();
//        } catch (HibernateException e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//
//        for (Event event : eventsList){
//            events.add(event);
//        }
//
//
//        int n = events.size();
//        for (int i = 0; i < n-1; i++)
//            for (int j = 0; j < n-i-1; j++)
//                if (events.get(j).getEventDay() > events.get(j+1).getEventDay() &&
//                events.get(j).getEventMonth() >= events.get(j+1).getEventMonth())
//                {
//                    Event temp = events[j];
//                    events[j] = events[j+1];
//                    events[j+1] = temp;
//                }
//
//    }
}
