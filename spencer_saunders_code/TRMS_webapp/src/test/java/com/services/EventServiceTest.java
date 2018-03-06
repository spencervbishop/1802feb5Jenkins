package com.services;

import com.beans.Application;
import com.beans.Employee;
import com.beans.Event;
import com.beans.Event;
import com.dao.EventJDBC;
import com.dao.EventJDBC;
import com.util.ConnectionUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    @Mock
    ConnectionUtil cu;

    @Mock
    Connection conn;

    @Mock
    PreparedStatement ps;

    @Mock
    ResultSet result;

    @Mock
    EventJDBC mock;

    @Before
    public void setup() throws Exception{
        when(cu.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(ps);
        when(ps.executeQuery()).thenReturn(result);
        when(ps.executeUpdate()).thenReturn(1);
        when(result.next()).thenReturn(true).thenReturn(false);
        when(result.getString(anyString())).thenReturn("service tested");
        when(result.getInt(anyString())).thenReturn(1);
    }

    @Test
    public void getEvent() throws Exception{
        EventService service = new EventService(cu);
        Event event = service.getEvent(1);
        assertTrue("service tested".equals(event.getTestingVar()));
    }

    @Test
    public void createEvent() throws Exception{
        EventService service = new EventService(cu);

        Event newEvt = new Event(0.8, "format", "University course");
        service.createEvent(newEvt);
        assertTrue(1==newEvt.getEvent_id());
    }

    @Test
    public void updateEvent() throws Exception {
        EventService service = new EventService(cu);

        Event newEvt = new Event(0.8, "format", "University course");
        assertTrue(1==service.updateEventInfo(1, newEvt));
    }

    @Test
    public void deleteEvent() {
    }
}