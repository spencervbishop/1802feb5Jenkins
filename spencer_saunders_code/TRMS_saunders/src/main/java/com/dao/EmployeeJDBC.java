package com.dao;

import com.beans.Employee;
import com.beans.EmployeeType;
import com.beans.Supervisor;
import com.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeJDBC implements EmployeeDao{

    //CONNECT TO SERVER
    ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    @Override
    public Employee getEmployee(String username) {
        try(Connection conn = connectionUtil.getConnection()) {

            String query = "SELECT * FROM employees WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, username);
            ResultSet result = ps.executeQuery();
            if(result.next()){
                int id = result.getInt("emp_id");
                String fname = result.getString("first_name");
                String lname = result.getString("last_name");
                String pass = result.getString("password");
                int ds = result.getInt("super_id");
                int benco = result.getInt("benco_id");
                boolean isDs = result.getBoolean("isds");
                boolean isDh = result.getBoolean("isdh");
                boolean isBenco = result.getBoolean("isbenco");
                int dept = result.getInt("dept_id");
                double amount = result.getDouble("avail_amount");
               return new Employee(id, fname, lname, username, pass, ds, benco, isDs, isDh, isBenco, dept, amount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getEmployeesOfASupervisor(Employee emp) {
        try(Connection conn = connectionUtil.getConnection()) {

            String query = "SELECT * FROM employees WHERE super_id = ? OR dh "

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int newEmployee(Employee emp) { //USE AN ENUM SWITCH CASE HERE!
        try(Connection conn = connectionUtil.getConnection()) {
            EmployeeType title = emp.getTitle();

            String query = "INSERT INTO employees (first_name, last_name, username, password, title, super_id, benco_id, " +
                    "avail_amt, isds, isdh, isbenco, dept_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, emp.getFirst_name());
            ps.setString(2, emp.getLast_name());
            ps.setString(3, emp.getUsername());
            ps.setString(4, emp.getPassword());
            ps.setInt(6, emp.getSuper_id());
            ps.setInt(7, emp.getBenco_id());
            ps.setDouble(8, emp.getAvail_amount());
            ps.setInt(12, emp.getDepartment());

            switch(title){
                case EMPLOYEE:{
                    ps.setInt(5,0);
                    ps.setBoolean(8, false);
                    ps.setBoolean(9, false);
                    ps.setBoolean(10, false);
                    break;
                }
                case DIRECT_SUPERVISOR:{
                    ps.setInt(5,1);
                    ps.setBoolean(8, true);
                    ps.setBoolean(9, false);
                    ps.setBoolean(10, false);
                    break;
                }
                case DEPT_HEAD:{
                    ps.setInt(5,2);
                    ps.setBoolean(8, false);
                    ps.setBoolean(9, true);
                    ps.setBoolean(10, false);
                    break;
                }
                case BENCO:{
                    ps.setInt(5,3);
                    ps.setBoolean(8, false);
                    ps.setBoolean(9, false);
                    ps.setBoolean(10, true);
                    break;
                }
            }
            ResultSet results = ps.executeQuery();
            if(results.next()){
                int emp_id = results.getInt("emp_id");
                return emp_id;
            }
            return -1;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void updateEmployee(int id, Employee e) {
        try(Connection conn = connectionUtil.getConnection()) {

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int emp_id) {
        try(Connection conn = connectionUtil.getConnection()) {

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
