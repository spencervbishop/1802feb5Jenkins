package com.services;

import com.beans.Employee;
import com.dao.EmployeeJDBC;
import com.util.ConnectionUtil;

public class EmployeeService {
    EmployeeJDBC dao;

    public EmployeeService(ConnectionUtil cu){
        dao = new EmployeeJDBC(cu);
    }

    public EmployeeService(){
        dao = new EmployeeJDBC();
    }

    public void saveEmployee(Employee emp){
        dao.saveEmployee(emp);
        emp.setTestingVar("service tested");
    }

    public Employee getEmployee(String username){
        Employee emp = dao.getEmployee(username);
        emp.setTestingVar("service tested");
        return emp;
    }

    public int updateEmployeeInfo(int id, Employee emp){
        int rows = dao.updateEmployee(id, emp);
        return rows;
    }

    public void deleteEmployee(int id){

    }
}