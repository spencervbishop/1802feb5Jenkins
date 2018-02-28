package com.services;

import com.beans.Event;
import com.dao.EventJDBC;
import com.util.ConnectionUtil;

public class EventService {
    EventJDBC dao;

    public EventService(ConnectionUtil cu){
        dao = new EventJDBC(cu);
    }

    public EventService(){
        dao = new EventJDBC();
    }

    public Event getEvent(int event_id){
        Event event = dao.getEvent(event_id);
        event.setTestingVar("service tested");
        return event;
    }

    public int createEvent(Event evt){
        int id = dao.createEvent(evt);
        return id;
    }

    public int updateEventInfo(int id, Event evt){
        int rows = dao.updateEvent(id, evt);
        return rows;
    }

    public void deleteEvent(){

    }

}
