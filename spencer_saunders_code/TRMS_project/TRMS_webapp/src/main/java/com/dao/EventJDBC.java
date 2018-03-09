package com.dao;

import com.beans.Event;
import com.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventJDBC implements EventDao {
    //CONNECT TO SERVER
    ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    public EventJDBC(){

    }
    public EventJDBC(ConnectionUtil util){
        this.connectionUtil = util;

    }

    @Override
    public int createEvent(Event evt) {
        try(Connection conn = connectionUtil.getConnection()){
            String query = "INSERT INTO events (event_type, grading_format, reimburse_rate)" +
                    " VALUES (?,?,?) RETURNING event_id";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, evt.getEvent_type());
            ps.setString(2, evt.getGrading_format());
            ps.setDouble(3, evt.getRate());

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int id = rs.getInt("event_id");
                evt.setEvent_id(id);
                return id;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public Event getEvent(int evt_id) {
        try(Connection conn = connectionUtil.getConnection()){
            String query = "SELECT * FROM events WHERE event_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1,evt_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String type = rs.getString("event_type");
                String format = rs.getString("grading_format");
                double rate = rs.getDouble("reimburse_rate");
                Event evt = new Event(rate, format, type);
                evt.setEvent_id(evt_id);
                evt.setTestingVar("tested");
                return evt;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateEvent(int evt_id, Event evt) {
        try(Connection conn = connectionUtil.getConnection()){
            String query = "UPDATE events SET event_type = ?, reimburse_rate = ?, grading_format = ? WHERE event_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, evt.getEvent_type());
            ps.setDouble(2, evt.getRate());
            ps.setString(3, evt.getGrading_format());
            int rows = ps.executeUpdate();
            return rows;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public void deleteEvent(int evt_id) {

    }
}
