package com.dao;

import com.beans.Employee;
import com.beans.Supervisor;

import java.util.List;

public interface EmployeeDao {

    public Employee getEmployee(String username);

    public List<Employee> getEmployeesOfASupervisor(Employee s);

    public int saveEmployee(Employee e);

    public int updateEmployee(int id, Employee e);

    public void deleteEmployee(int emp_id);


}
