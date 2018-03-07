package com.dao;

import com.beans.Employee;
import com.beans.Event;
import com.util.ConnectionUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventJDBCTest {


    @Mock
    ConnectionUtil cu;

    @Mock
    Connection conn;

    @Mock
    PreparedStatement ps;

    @Mock
    ResultSet result;

    @Mock
    EmployeeJDBC mock;

    @Before
    public void setup() throws Exception{
        when(cu.getConnection()).thenReturn(conn);
        when(conn.prepareStatement(anyString())).thenReturn(ps);
        when(ps.executeQuery()).thenReturn(result);
        when(ps.executeUpdate()).thenReturn(1);
        when(result.next()).thenReturn(true).thenReturn(false);
        when(result.getString(anyString())).thenReturn("tested");
    }


    @Test
    public void testCreateEvent() throws Exception {
        EventJDBC dao = new EventJDBC(cu);
        when(result.getInt(anyString())).thenReturn(1);

        Event newEvt = new Event(0.8, "format", "University course");
        dao.createEvent(newEvt);
        assertTrue(1== newEvt.getEvent_id());
    }

    @Test
    public void getEvent() throws Exception{

        EventJDBC dao = new EventJDBC(cu);
        Event evt = dao.getEvent(1);
        assertTrue("tested".equals(evt.getTestingVar()));
    }

    @Test
    public void updateEvent() {
        EventJDBC dao = new EventJDBC(cu);

        Event newEvt = new Event(0.8, "format", "University course");
        assertTrue(1==dao.updateEvent(1, newEvt));
    }

    @Test
    public void deleteEvent() {
    }
}