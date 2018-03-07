package com.services;

import com.beans.Department;
import com.beans.Event;
import com.dao.DepartmentJDBC;
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

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DepartmentServiceTest {

    @Mock
    ConnectionUtil cu;

    @Mock
    Connection conn;

    @Mock
    PreparedStatement ps;

    @Mock
    ResultSet result;

    @Mock
    DepartmentJDBC mock;

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
    public void getDepartment() throws Exception{
        DepartmentService service = new DepartmentService(cu);
        Department dept = service.getDepartment(1);
        assertTrue("service tested".equals(dept.getTestingVar()));
    }

    @Test
    public void createDepartment() throws Exception{
        DepartmentService service = new DepartmentService(cu);

        Department newDept = new Department("Department1");
        service.createDepartment(newDept);
        assertTrue(1==newDept.getDept());
    }

    @Test
    public void updateDepartment() throws Exception {
        DepartmentService service = new DepartmentService(cu);

        Department newDept = new Department(1, "Department1");
        assertTrue(1==service.updateDepartmentInfo(1, newDept));
    }

    @Test
    public void deleteDepartment() {
    }
}