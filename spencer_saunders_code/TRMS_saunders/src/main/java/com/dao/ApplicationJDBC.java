package com.dao;

import com.beans.Application;
import com.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ApplicationJDBC implements ApplicationDao {

    //CONNECT TO SERVER
    ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    public ApplicationJDBC(){

    }
    public ApplicationJDBC(ConnectionUtil util){
        this.connectionUtil = util;

    }


    @Override
    public Application getApplication(int app_id) {
        try(Connection conn = connectionUtil.getConnection()){
            String query = "SELECT * FROM applications WHERE app_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, app_id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){

                int emp_id = rs.getInt("emp_id");
                int event_id = rs.getInt("event_id");
                Date event_time = rs.getDate("event_time"); //CHECK ON THIS.
                String event_loc = rs.getString("event_loc");
                double event_cost = rs.getDouble("event_cost");
                String desc = rs.getString("event_desc");
                String just = rs.getString("work_just");
                boolean ds_approved = rs.getBoolean("ds_approved");
                boolean dh_approved = rs.getBoolean("dh_approved");
                boolean benco_approved = rs.getBoolean("benco_approved");
                boolean appEmail = rs.getBoolean("approval_email");
                int hours = rs.getInt("work_time_missed");
                double proj_reimb = rs.getDouble("proj_reimb");
                boolean urgent = rs.getBoolean("urgent");

                Application application = new Application(app_id, emp_id, event_id, event_time, event_loc, event_cost, desc,
                        just, ds_approved, dh_approved, benco_approved, appEmail, hours, proj_reimb, urgent);
                application.setTestingVar("tested");
                return application;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
       return null;
    }

    @Override
    public List<Application> getApplicationsOfEmployee(int emp_id) {
        return null;
    }

    @Override
    public int saveApplication(Application app) {
        try(Connection conn = connectionUtil.getConnection()){
            String query = "INSERT INTO applications (emp_id, event_id, event_time, event_loc, event_cost, event_desc, " +
                    "work_just, ds_approved, dh_approved, benco_approved, approval_email, work_time_missed, proj_reimb," +
                    "urgent) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, app.getEmp_id());
            ps.setInt(2, app.getEvent_id());
            ps.setDate(3, new java.sql.Date(app.getEvent_date().getTime()));
            ps.setString(4, app.getLocation());
            ps.setDouble(5, app.getCost());
            ps.setString(6, app.getDescription());
            ps.setString(7, app.getWork_just());
            ps.setBoolean(8, app.isDs_approved());
            ps.setBoolean(9, app.isDh_approved());
            ps.setBoolean(10, app.isBenco_approved());
            ps.setBoolean(11, app.isApproval_email());
            ps.setInt(12, app.getWork_time_missed());
            ps.setDouble(13, app.getProj_reimb());
            ps.setBoolean(14, app.isUrgent());

            ResultSet result = ps.executeQuery();
            if(result.next()){
                int id = result.getInt("app_id");
                app.setApp_id(id);
                return id;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    //Date newDate = new Date(result.getDate("VALUEDATE").getTime());

    @Override
    public int updateApplication(int app_id, Application app) {
        try(Connection conn = connectionUtil.getConnection()) {
            String query = "UPDATE applications SET emp_id = ?, event_id = ?, event_loc = ?, event_cost = " +
                    "?, event_desc = ?, work_just = ?, ds_approved = ?, dh_approved = ?, benco_approved = ?, approval_email = " +
                    "?, work_time_missed = ?, proj_reimb = ?, urgent=? WHERE app_id =?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, app.getEmp_id());
            ps.setInt(2, app.getEvent_id());
            ps.setString(3, app.getLocation());
            ps.setDouble(4, app.getCost());
            ps.setString(5, app.getDescription());
            ps.setString(6, app.getWork_just());
            ps.setBoolean(7, app.isDs_approved());
            ps.setBoolean(8, app.isDh_approved());
            ps.setBoolean(9, app.isBenco_approved());
            ps.setBoolean(10, app.isApproval_email());
            ps.setInt(11, app.getWork_time_missed());
            ps.setDouble(12, app.getProj_reimb());
            ps.setBoolean(13, app.isUrgent());

            int rows = ps.executeUpdate();
            return rows;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void deleteApplication(int app_id) {

    }

    @Override
    public void approveApplication(int app_id) {

    }
}
