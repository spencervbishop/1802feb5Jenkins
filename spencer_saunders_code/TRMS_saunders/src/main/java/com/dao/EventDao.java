package com.dao;

import com.beans.Event;

public interface EventDao {

    public int createEvent(Event evt);

    public Event getEvent(int evt_id);

    public int updateEvent(int evt_id, Event evt);

    public void deleteEvent(int evt_id);
}
