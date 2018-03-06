package com.dao;


import com.beans.Application;
import com.beans.Employee;
import com.beans.Event;
import com.beans.Reimbursement;
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
public class ReimbursementJDBCTest {

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
        when(result.getInt(anyString())).thenReturn(1);
    }

    @Test
    public void saveReimbursement() throws Exception {
        ReimbursementJDBC dao = new ReimbursementJDBC(cu);
        Date date = new Date();

        Employee newEmp = new Employee(1, "firstname", "lastname", "username", "password", 2,
                3, true, false, false, 1, 1000.00);
        Event newEvt = new Event(0.8, "format", "University course");
        Application newApp = new Application(newEmp, newEvt, date, "disneyworld", 1000.00, "course at disney world", "lots of fun",
                true, 20);
        Reimbursement newReimb = new Reimbursement(newApp, 1000.00);

        assertTrue(1==dao.saveReimbursement(newReimb));
    }

    @Test
    public void getReimbursement() throws Exception{
        ReimbursementJDBC dao = new ReimbursementJDBC(cu);

        Reimbursement reimbursement = dao.getReimbursement(1);
        assertTrue("tested".equals(reimbursement.getTestingVar()));
    }

    @Test
    public void updateReimbursement() throws Exception{
        ReimbursementJDBC dao = new ReimbursementJDBC(cu);
        Date date = new Date();

        Employee newEmp = new Employee(1, "firstname", "lastname", "username", "password", 2,
                3, true, false, false, 1, 1000.00);
        Event newEvt = new Event(0.8, "format", "University course");
        Application newApp = new Application(newEmp, newEvt, date, "disneyworld", 1000.00, "course at disney world", "lots of fun",
                true, 20);
        Reimbursement newReimb = new Reimbursement(newApp, 1000.00);
        assertTrue(1==dao.updateReimbursement(1, newReimb));

    }

    @Test
    public void deleteReimbursement() {
    }
}