package com.services;

import com.beans.Application;
import com.beans.Reimbursement;
import com.beans.Employee;
import com.beans.Event;
import com.dao.ReimbursementJDBC;
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
public class ReimbursementServiceTest {

    @Mock
    ConnectionUtil cu;

    @Mock
    Connection conn;

    @Mock
    PreparedStatement ps;

    @Mock
    ResultSet result;

    @Mock
    ReimbursementJDBC mock;

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
    public void testGetReimbursement() throws Exception{
        ReimbursementService service = new ReimbursementService(cu);
        Reimbursement reimbursement = service.getReimbursement(1);
        assertTrue("service tested".equals(reimbursement.getTestingVar()));
    }

    @Test
    public void testSaveReimbursement() throws Exception {
        when(result.getInt(anyString())).thenReturn(1);
        ReimbursementService service = new ReimbursementService(cu);
        String date = "date";
        Employee newEmp = new Employee(1, "firstname", "lastname", "username", "password", 2,
                3, true, false, false, 1, 1000.00);
        Event newEvt = new Event(0.8, "format", "University course");
        Application newApp = new Application(newEmp, newEvt, date, "disneyworld", 1000.00, "course at disney world", "lots of fun",
                true, 20);
        Reimbursement newReimb = new Reimbursement(newApp, 1000.00);
        service.saveReimbursement(newReimb);
        assertTrue(1==newReimb.getReimbursement_id());
    }

    @Test
    public void testUpdateReimbursementInfo() throws Exception {
        ReimbursementService service = new ReimbursementService(cu);
        String date = "date";

        Employee newEmp = new Employee(1, "firstname", "lastname", "username", "password", 2,
                3, true, false, false, 1, 1000.00);
        Event newEvt = new Event(0.8, "format", "University course");
        Application newApp = new Application(newEmp, newEvt, date, "disneyworld", 1000.00, "course at disney world", "lots of fun",
                true, 20);
        Reimbursement newReimb = new Reimbursement(newApp, 1000.00);
        assertTrue(1==service.updateReimbursementInfo(1, newReimb));
    }

    @Test
    public void testDeleteReimbursement() {
    }

}