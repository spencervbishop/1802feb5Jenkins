package com.services;

import com.beans.Employee;
import com.dao.EmployeeJDBC;
import com.util.ConnectionUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

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
        when(result.getString(anyString())).thenReturn("service tested");

    }

    @Test
    public void testGetEmployee() throws Exception{
        EmployeeService service = new EmployeeService(cu);
        Employee newEmp = new Employee("firstname", "lastname", "username", "password", 1,
                true, false, false, 1, 1000.00);
        Employee newEmp2 = service.getEmployee("username");
        System.out.println(newEmp2.getTestingVar());
        assertTrue("service tested".equals(newEmp2.getTestingVar()));
    }

    @Test
    public void testSaveEmployee() throws Exception{
        EmployeeService service = new EmployeeService(cu);
        Employee newEmp = new Employee("firstname", "lastname", "username", "password", 1,
                true, false, false, 1, 1000.00);
        service.saveEmployee(newEmp);
        assertTrue("service tested".equals(newEmp.getTestingVar()));
    }

    @Test
    public void testUpdateEmployeeInfo() throws Exception{
        EmployeeService service = new EmployeeService(cu);
        Employee emp = new Employee("firstname", "lastname", "username", "password", 1,
                true, false, false, 1, 1000.00);
        assertTrue(1==service.updateEmployeeInfo(1, emp));

    }

    @Test
    public void testDeleteEmployee() {
    }
}