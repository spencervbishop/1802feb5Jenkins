package com.util;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static ConnectionUtil connectionUtil = new ConnectionUtil();

    static{
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private ConnectionUtil(){
        super();
    }

    public static ConnectionUtil getConnectionUtil(){
        //might want to test for null
        return connectionUtil;
    }

    public Connection getConnection(){
        try{
            Properties prop = new Properties();
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("database.properties");
            if(in != null){

                prop.load(in);

            }
            return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
