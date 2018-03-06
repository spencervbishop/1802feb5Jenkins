package com.dao;

import com.beans.Department;
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
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentJDBCTest {

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
    public void testCreateDepartment() throws Exception{
        DepartmentJDBC dao = new DepartmentJDBC(cu);
        Department dept = new Department("dept_name");
        assertTrue(1==dao.createDepartment(dept));
    }

    @Test
    public void testGetDepartment() throws Exception {
        DepartmentJDBC dao = new DepartmentJDBC(cu);
        Department dept = dao.getDepartment(1);
        assertTrue("tested".equals(dept.getTestingVar()));
    }

    @Test
    public void testUpdateDepartment() throws Exception{
        DepartmentJDBC dao = new DepartmentJDBC(cu);
        Department dept = new Department();
        assertTrue(1==dao.updateDepartment(1, dept));
    }

    @Test
    public void testDeleteDepartment(){

    }
}