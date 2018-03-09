package com.dao;

import com.beans.Department;
import com.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentJDBC implements DepartmentDao {

    //CONNECT TO SERVER
    ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    public DepartmentJDBC(){

    }
    public DepartmentJDBC(ConnectionUtil util){
        this.connectionUtil = util;

    }

    @Override
    public int createDepartment(Department dept) {
        //DOES NOT TAKE AN DEPT_HEAD_ID
        try(Connection conn = connectionUtil.getConnection()){
            String query = "INSERT INTO departments (dept_name) VALUES (?) RETURNING dept_id";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, dept.getDept_name());

            ResultSet result = ps.executeQuery();
            if(result.next()){
                int id = result.getInt("dept_id");
                dept.setDept(id);
                return id;
            }

        }catch(SQLException e){
            e.printStackTrace();
            return -1;
        }
        return -1;
    }

    @Override
    public Department getDepartment(int dept_id) {
        try(Connection conn = connectionUtil.getConnection()){
            String query = "SELECT * FROM departments WHERE dept_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, dept_id);

            ResultSet result = ps.executeQuery();
            if(result.next()){
                String dept = result.getString("dept_name");
                int dh = result.getInt("dept_head_id");

                Department department = new Department(dept_id, dh, dept);
                department.setTestingVar("tested");
                return department;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateDepartment(int dept_id, Department dept) {
        try(Connection conn = connectionUtil.getConnection()){
            String query = "UPDATE departments SET dept_name = ?, dept_head_id = ? WHERE dept_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, dept.getDept_name());
            ps.setInt(2, dept.getDh_id());
            ps.setInt(3, dept.getDept());

            int rows = ps.executeUpdate();
            return rows;

        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;

    }

    @Override
    public void deleteDepartment(int dept_id) {

    }
}
