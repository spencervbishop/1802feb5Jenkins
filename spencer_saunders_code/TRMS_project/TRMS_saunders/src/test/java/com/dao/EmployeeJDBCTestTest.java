package com.dao;

import com.beans.Employee;
import com.util.ConnectionUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.mockito.internal.progress.SequenceNumber.next;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeJDBCTestTest {

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
    public void testGetEmployee() throws Exception{

        EmployeeJDBC dao = new EmployeeJDBC(cu);
        Employee emp = dao.getEmployee("username");
        assertTrue("tested".equals(emp.getTestingVar()));
    }


    @Test
    public void testSaveEmployee() throws Exception {

        when(result.getInt(anyString())).thenReturn(1);

        EmployeeJDBC dao = new EmployeeJDBC(cu);
        Employee newEmp = new Employee("firstname", "lastname", "username", "password", 1,
                true, false, false, 1, 1000.00);
        dao.saveEmployee(newEmp);
        assertTrue(1==newEmp.getEmp_id());
    }

//    @Test
//    public void testGetEmployeesOfASupervisor() throws Exception {
//
//        //when(result.next()).thenAnswer(emp -> emp.getArguments()[0]);
//        when(result.next()).thenReturn(true).thenReturn(false);
//        when(result.getString(anyString())).thenReturn("tested");
//
//        EmployeeJDBC dao = new EmployeeJDBC(cu);
//        Employee newSup1 = new Employee("Supervisor", "One", "super1", "password", 0,
//                true, false, false, 1, 1000.00);
//        dao.saveEmployee(newSup1);
//
//
////        Employee newEmp1 = new Employee("firstname1", "lastname1", "username1", "password", 6,
////                true, false, false, 1, 1000.00);
////
////        Employee newEmp2 = new Employee("firstname2", "lastname2", "username2", "password", 6,
////                true, false, false, 1, 1000.00);
////        dao.saveEmployee(newEmp1);
////        dao.saveEmployee(newEmp2);
//            dao.getEmployeesOfASupervisor(newSup1);
//            assertTrue(2 == list.size());
//
//
//        }

    @Test
    public void testUpdateEmployee() throws Exception{
        EmployeeJDBC dao = new EmployeeJDBC(cu);

        Employee newEmp1 = new Employee("firstname1", "lastname1", "username1", "password", 6,
                true, false, false, 1, 1000.00);
        assertTrue(1 == dao.updateEmployee(1, newEmp1));
    }

    @Test
    public void deleteEmployee() {
    }

//    @Test
//    public void fillSuperviseeList(){
//
//    }
}