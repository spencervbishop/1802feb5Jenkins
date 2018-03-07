package com.dao;

import com.beans.Application;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationJDBCTest {

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
    public void getApplication() throws Exception{
        ApplicationJDBC dao = new ApplicationJDBC(cu);
        Application application = dao.getApplication(1);
        assertTrue("tested".equals(application.getTestingVar()));
    }

    @Test
    public void saveApplication() throws Exception {

        when(result.getInt(anyString())).thenReturn(1);
        Date date = new Date();


        ApplicationJDBC dao = new ApplicationJDBC(cu);
        Employee newEmp = new Employee(1, "firstname", "lastname", "username", "password", 2,
                3, true, false, false, 1, 1000.00);
        Event newEvt = new Event(0.8, "format", "University course");
        Application newApp = new Application(newEmp, newEvt, date, "disneyworld", 1000.00, "course at disney world", "lots of fun",
                true, 20);
        dao.saveApplication(newApp);
        assertTrue(1 == newApp.getApp_id());
    }

    @Test
    public void updateApplication() throws Exception{
        ApplicationJDBC dao = new ApplicationJDBC(cu);
        Date date = new Date();

        Employee newEmp = new Employee(1, "firstname", "lastname", "username", "password", 2,
                3, true, false, false, 1, 1000.00);
        Event newEvt = new Event(0.8, "format", "University course");
        Application newApp = new Application(newEmp, newEvt, date, "disneyworld", 1000.00, "course at disney world", "lots of fun",
                true, 20);
        assertTrue(1 == dao.updateApplication(1, newApp));
    }

    @Test
    public void deleteApplication() {
    }
}