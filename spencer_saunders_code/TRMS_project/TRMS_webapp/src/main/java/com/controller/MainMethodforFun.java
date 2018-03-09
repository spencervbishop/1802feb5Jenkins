package com.controller;

import com.beans.Application;
import com.beans.Employee;
import com.beans.Event;
import com.beans.Supervisor;
import com.dao.ApplicationJDBC;
import com.dao.EmployeeJDBC;
import com.dao.EventJDBC;
import com.services.ApplicationService;
import com.services.EmployeeService;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainMethodforFun {
    public static void main(String[] args) throws Exception{
        EmployeeJDBC dao = new EmployeeJDBC();
        System.out.println(dao.getEmployee("spencer111"));
//        EmployeeService employeeService = new EmployeeService();
//        Employee employee = new Employee("tyler", "bishop", "tyler111", "tylerbishop", 7, false, false, false, 7, 1000.00);
//        employeeService.saveEmployee(employee);
////        Employee emp = employeeService.getEmployee("depthead1");
////        System.out.println(emp.getPassword());
//
//
//        EmployeeService service = new EmployeeService();
////       EmployeeController controller = new EmployeeController();
//        String username = "depthead1";
//        String password = "depthead1";
//
//        Employee emp = service.getEmployee(username);
////
////        System.out.println(controller.getEmployee(username, password).toString());
//        ApplicationService applicationService = new ApplicationService();
 //       EventJDBC edao = new EventJDBC();
//        ApplicationJDBC dao = new ApplicationJDBC();
//        Event evt = edao.getEvent(1);
//        System.out.println(evt.getEvent_type());
//
//           Application app = new Application(emp.getEmp_id(), evt.getEvent_id(), "02-02-2020", "location",
//                   25.00, "description", "work just", false, false,
//                   false, false, 25, 1000, false);
//
//        dao.saveApplication(app);


    }
}
