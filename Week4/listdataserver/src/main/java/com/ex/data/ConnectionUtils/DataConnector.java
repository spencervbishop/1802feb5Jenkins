package com.ex.data.ConnectionUtils;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataConnector {
    Connection openConnection() throws SQLException;
}
