package com.controller;

import com.beans.Employee;
import com.services.EmployeeService;

public class EmployeeController implements Controller {

    EmployeeService employeeService = new EmployeeService();

    public Employee getEmployee(String username, String password){

        Employee emp = employeeService.getEmployee(username);
        if(emp.getPassword().equals(password)){
         return emp;
        }else{
            return null;
        }
    }
}
