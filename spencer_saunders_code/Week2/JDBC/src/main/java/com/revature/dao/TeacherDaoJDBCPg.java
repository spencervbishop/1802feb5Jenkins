package com.revature.dao;

import com.revature.beans.Teacher;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoJDBCPg implements TeacherDao {

    private static ConnectionUtil connectionUtil = ConnectionUtil.getConnectionUtil();

    @Override
    public Teacher getById(int id){
        try(Connection conn = connectionUtil.getConnection()) {
            //Statement---DONT EVER USE STATEMENT
            //Prepare statement--USE THIS ONE.
            //callable--Uses stored procedures.

            String standardQuery = "SELECT first_name, last_name, favorite_quote FROM teachers WHERE teacher_id = ?";
//            Statement statement = conn.createStatement();
//            ResultSet results = statement.executeQuery(standardQuery);

            PreparedStatement ps = conn.prepareStatement(standardQuery);
            ps.setInt(1, id);
            ResultSet results = ps.executeQuery();

            if(results.next()){
                String firstName = results.getString("first_name");
                String lastName = results.getString("last_name");
                String favoriteQuote = results.getString("favorite_quote");
                return new Teacher(id, firstName, lastName, favoriteQuote);
            }
            PreparedStatement preparedStatement = conn.prepareStatement("sql");
            CallableStatement callable = conn.prepareCall("sql");
        }catch(SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Teacher> getByName(String first_name, String last_name) {
        try(Connection conn = connectionUtil.getConnection()) {


            String standardQuery = "SELECT teacher_id, first_name, last_name, favorite_quote FROM teachers WHERE first_name = ? AND last_name = ?";

            PreparedStatement ps = conn.prepareStatement(standardQuery);
            ps.setString(1, first_name);
            ps.setString(2, last_name);
            ResultSet results = ps.executeQuery();

            List<Teacher> teachers = new ArrayList<>();

            while(results.next()){
                String firstName = results.getString("first_name");
                String lastName = results.getString("last_name");
                String fquote = results.getString("favorite_quote");
                int id = results.getInt("teacher_id");

                teachers.add(new Teacher(id, firstName, lastName, fquote));
            }
            return teachers;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void newTeacher(Teacher teacher) {
        try(Connection conn = connectionUtil.getConnection()){
            //Prepare Query
            String query = "INSERT INTO teachers (first_name, last_name, favorite_quote) " +
                    "VALUES (?, ?, ?) RETURNING teacher_id";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setString(1, teacher.getFirstname());
            ps.setString(2, teacher.getLastname());
            ps.setString(3, teacher.getFavoriteQuote());

            //Get result set storing the primary key for the newly inserted object
            ResultSet results = ps.executeQuery();
            if(results.next()){
                teacher.setId(results.getInt("teacher_id"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }



    @Override
    public void update(Teacher teacher) {
        try (Connection conn = connectionUtil.getConnection()) {
            //Prepare Query
            String query = "UPDATE teachers SET first_name = ?, last_name = ?, favorite_quote = ?" +
                    "WHERE teacher_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);

            //Assign parameters
            ps.setString(1, teacher.getFirstname());
            ps.setString(2, teacher.getLastname());
            ps.setString(3, teacher.getFavoriteQuote());
            ps.setInt(4, teacher.getId());

            //Execute Update
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Teacher teacher) {
    try(Connection conn = connectionUtil.getConnection()){
        //Prepare query
        String query = "DELETE FROM teachers WHERE teacher_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, teacher.getId());
        ps.execute();
    }catch(SQLException e){
        e.printStackTrace();
    }
    }
}
