package com.dao;

import com.beans.Employee;
import com.beans.Supervisor;

import java.util.List;

public interface EmployeeDao {

    public Employee getEmployee(String username);

    public List<Employee> getEmployeesOfASupervisor(Supervisor s);

    public int newEmployee(Employee e);

    public void updateEmployee(int id, Employee e);

    public void deleteEmployee(int emp_id);


}
