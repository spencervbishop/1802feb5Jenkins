package com.dao;

import com.beans.Employee;
import com.beans.EmployeeType;
import com.beans.Supervisor;
import com.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.getInt;

public class EmployeeJDBC implements EmployeeDao{

    //CONNECT TO SERVER
    ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    public EmployeeJDBC(){

    }
    public EmployeeJDBC(ConnectionUtil util){
        this.connectionUtil = util;

    }

    @Override
    public Employee getEmployee(String username) {
        try(Connection conn = connectionUtil.getConnection()) {

            String query = "SELECT * FROM employees WHERE username = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, username);
            ResultSet result = ps.executeQuery();
            Employee emp = new Employee();
            if(result.next()){
                int id = result.getInt("emp_id");
                String fname = result.getString("first_name");
                String lname = result.getString("last_name");
                String pass = result.getString("password");
                int ds;
//                if(result.getInt("super_id")!= null){
                    ds = result.getInt("super_id");
//                }else{
//                    ds = 0;
//                }
                int benco = result.getInt("benco_id");
                boolean isDs = result.getBoolean("isds");
                boolean isDh = result.getBoolean("isdh");
                boolean isBenco = result.getBoolean("isbenco");
                int dept = result.getInt("dept_id");
                double amount = result.getDouble("avail_amt");

               Employee employee = new Employee(id, fname, lname, username, pass, ds, benco, isDs, isDh, isBenco, dept, amount);
               employee.setTestingVar("tested");
               return employee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> getEmployeesOfASupervisor(Employee emp) {
        try(Connection conn = connectionUtil.getConnection()) {

            String query_s = "SELECT * FROM employees WHERE super_id = ?";
            String query_h = "SELECT * FROM employees NATURAL JOIN departments WHERE head_id = ?";
            String query_b = "SELECT * FROM employees WHERE benco_id = ?";
            PreparedStatement pss = conn.prepareStatement(query_s);
            PreparedStatement psh = conn.prepareStatement(query_h);
            PreparedStatement psb = conn.prepareStatement(query_b);

            int id = emp.getEmp_id();

            List<Employee> supervisees = new ArrayList<>();

            switch(emp.getTitle()){
                case DIRECT_SUPERVISOR:{
                    //COLLECT ALL SUPERVISEES
                    pss.setInt(1, id);
                    ResultSet results = pss.executeQuery();
                    return fillSuperviseeList(supervisees,results);
                }
                case DEPT_HEAD:{
                    //COLLECT ALL EMPLOYEES IN DEPARTMENT
                    psh.setInt(1, id);
                    ResultSet resulth = psh.executeQuery();
                    return fillSuperviseeList(supervisees, resulth);

                }
                case BENCO:{
                    //COLLECT ALL SUPERVISEES IN YOUR SUB DEPARTMENTS
                    psb.setInt(1, id);
                    ResultSet resultb = psb.executeQuery();

                    return fillSuperviseeList(supervisees, resultb);
                }
                default:{
                    //IF EMPLOYEE PASSED IN IS NOT A SUPERVISOR
                    return supervisees;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //AUTMATES THE LIST BUILDING PROCESS
    private List<Employee> fillSuperviseeList(List<Employee> list, ResultSet resulth) throws SQLException {
        while(resulth.next()) {
            int emp_id = resulth.getInt("emp_id");
            String fname = resulth.getString("first_name");
            String lname = resulth.getString("last_name");
            String username = resulth.getString("username");
            String pass = resulth.getString("password");
            int ds = resulth.getInt("super_id");
            int benco = resulth.getInt("benco_id");
            boolean isDs = resulth.getBoolean("isds");
            boolean isDh = resulth.getBoolean("isdh");
            boolean isBenco = resulth.getBoolean("isbenco");
            int dept = resulth.getInt("dept_id");
            double amount = resulth.getDouble("avail_amt");
            Employee supervisee = new Employee(emp_id, fname, lname, username, pass, ds, benco, isDs, isDh,
                    isBenco, dept, amount);
            list.add(supervisee);
        }
            return list;
    }

    @Override
    public int saveEmployee(Employee emp) { //USE AN ENUM SWITCH CASE HERE!
        try(Connection conn = connectionUtil.getConnection()) {
            EmployeeType title = emp.getTitle();

            String query = "INSERT INTO employees (first_name, last_name, username, password, title, super_id, benco_id, " +
                    "avail_amt, isds, isdh, isbenco, dept_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) RETURNING emp_id";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, emp.getFirst_name());
            ps.setString(2, emp.getLast_name());
            ps.setString(3, emp.getUsername());
            ps.setString(4, emp.getPassword());
            ps.setInt(5, emp.getTitleNumber());
            ps.setInt(6, emp.getSuper_id());
            ps.setInt(7, emp.getBenco_id());
            ps.setDouble(8, emp.getAvail_amount());
            ps.setBoolean(9, emp.isDs());
            ps.setBoolean(10, emp.isDh());
            ps.setBoolean(11, emp.isBenco());
            ps.setInt(12, emp.getDepartment());

            ResultSet results = ps.executeQuery();
            if(results.next()){
                int emp_id = results.getInt("emp_id");
                emp.setEmp_id(emp_id);
                return emp_id;
            }
            return -1;

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int updateEmployee(int id, Employee emp) {
        try(Connection conn = connectionUtil.getConnection()) {
            String query = "UPDATE employees SET first_name = ?, last_name = ?, username = ?, password = " +
                    "?, title = ?, super_id = ?, benco_id = ?, avail_amt = ?, isds = ?, isdh = ?, isbenco = ?, dept_id = " +
                    "? WHERE emp_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, emp.getFirst_name());
            ps.setString(2, emp.getLast_name());
            ps.setString(3, emp.getUsername());
            ps.setString(4, emp.getPassword());
            ps.setInt(5, emp.getTitleNumber());
            ps.setInt(6, emp.getSuper_id());
            ps.setInt(7, emp.getBenco_id());
            ps.setDouble(8, emp.getAvail_amount());
            ps.setBoolean(9, emp.isDs());
            ps.setBoolean(10, emp.isDh());
            ps.setBoolean(11, emp.isBenco());
            ps.setInt(12, emp.getDepartment());

            int rows = ps.executeUpdate();
            return rows;
        }catch(SQLException e){
            e.printStackTrace();

            }
        return -1;
    }

    //DONT KNOW IF I SHOULD MAKE THIS...
    @Override
    public void deleteEmployee(int emp_id) {
        try(Connection conn = connectionUtil.getConnection()) {

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
