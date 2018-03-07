package com.controller;

import com.beans.Employee;
import com.beans.Supervisor;
import com.dao.EmployeeJDBC;
import com.services.EmployeeService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainMethodforFun {
    public static void main(String[] args) throws Exception{
        EmployeeService employeeService = new EmployeeService();
        //Employee emp = new Employee("spencer", "saunders", "spencer111", "tylerbishop", 1, true, false, false, 1, 1000.00);

        Employee emp = employeeService.getEmployee("depthead1");
        System.out.println(emp.getPassword());
    }
}
