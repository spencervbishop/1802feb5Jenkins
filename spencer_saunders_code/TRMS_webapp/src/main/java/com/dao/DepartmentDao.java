package com.dao;

import com.beans.Department;

public interface DepartmentDao {

    public int createDepartment(Department dept);

    public Department getDepartment(int dept_id);

    public int updateDepartment(int dept_id, Department dept);

    public void deleteDepartment(int dept_id);
}
