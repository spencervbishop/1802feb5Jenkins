package com.services;

import com.beans.Department;
import com.dao.DepartmentJDBC;
import com.util.ConnectionUtil;

public class DepartmentService {
    DepartmentJDBC dao;

    public DepartmentService(ConnectionUtil cu){
        dao = new DepartmentJDBC(cu);
    }

    public DepartmentService(){
        dao = new DepartmentJDBC();
    }

    public Department getDepartment(int dept_id){
        Department dept = dao.getDepartment(dept_id);
        dept.setTestingVar("service tested");
        return dept;
    }

    public int createDepartment(Department dept){
        int id = dao.createDepartment(dept);
        return id;
    }

    public int updateDepartmentInfo(int dept_id, Department dept){
        int rows = dao.updateDepartment(dept_id, dept);
        return rows;
    }

    public void deleteDepartment(){

    }
}
