package com.ex.data.ConnectionUtils;

import com.ex.connector.H2Connector;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Serves as a Utility class for opening connections to a database.
 * This implementation opens connections using the H2Connector
 * for interfacing with an in memory database. Yes it is a singleton.
 */
public class H2DataConnector implements DataConnector{

    private H2Connector connector;
    private final static H2DataConnector instance = new H2DataConnector();

    static {
        instance.connector = H2Connector.CONNECTOR;
    }

    /**
     * @return An open connection to the database
     * @throws SQLException
     */
    public Connection openConnection() throws SQLException {
        Properties props = connector.getProperties();
        String username = props.getProperty("username");
        String password = props.getProperty("password");
        String url = props.getProperty("url");

        return DriverManager.getConnection(url, username, password);
    }

    public void unregisterDriver() {
        Properties props = connector.getProperties();
        String driver_name = props.getProperty("driver_name");
        try {
            Driver driver = DriverManager.getDriver(driver_name);
            DriverManager.deregisterDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return The instance of the connector used to open connections
     *         to the database
     */
    public static H2DataConnector connector() {
        return instance;
    }
}
