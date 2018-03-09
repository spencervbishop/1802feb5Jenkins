package com.services;

import com.beans.Application;
import com.beans.Employee;
import com.beans.Event;
import com.dao.ApplicationJDBC;
import com.util.ConnectionUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationServiceTest {

    @Mock
    ConnectionUtil cu;

    @Mock
    Connection conn;

    @Mock
    PreparedStatement ps;

    @Mock
    ResultSet result;

    @Mock
    ApplicationJDBC mock;

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
    public void testGetApplication() throws Exception{
        ApplicationService service = new ApplicationService(cu);
        Application newApp = service.getApplication(1);
        assertTrue("service tested".equals(newApp.getTestingVar()));
    }

    @Test
    public void testSaveApplication() throws Exception {
        ApplicationService service = new ApplicationService(cu);
        String date = "date";
        Employee newEmp = new Employee(1, "firstname", "lastname", "username", "password", 2,
                3, true, false, false, 1, 1000.00);
        Event newEvt = new Event(0.8, "format", "University course");
        Application newApp = new Application(newEmp, newEvt, date, "disneyworld", 1000.00, "course at disney world", "lots of fun",
                true, 20);
        service.saveApplication(newApp);
        assertTrue(1==newApp.getApp_id());
    }

    @Test
    public void testUpdateApplicationInfo() throws Exception {
        ApplicationService service = new ApplicationService(cu);
        String date = "date";

        Employee newEmp = new Employee(1, "firstname", "lastname", "username", "password", 2,
                3, true, false, false, 1, 1000.00);
        Event newEvt = new Event(0.8, "format", "University course");
        Application newApp = new Application(newEmp, newEvt, date, "disneyworld", 1000.00, "course at disney world", "lots of fun",
                true, 20);
        assertTrue(1==service.updateApplicationInfo(1, newApp));

    }

    @Test
    public void testDeleteApplication() {
    }

}