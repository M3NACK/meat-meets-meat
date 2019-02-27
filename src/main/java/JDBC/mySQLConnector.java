package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static JDBC.Constants.*;

public class mySQLConnector {

    private static mySQLConnector connection;

    public static void main (String[] args) throws ClassNotFoundException, SQLException {
        mySQLConnector c = mySQLConnector.getInstance();
        c.establishConnection();
    }

    public static mySQLConnector getInstance() throws ClassNotFoundException {
        if (connection == null) {
            connection = new mySQLConnector();
        }
        return connection;
    }

    private mySQLConnector() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }

    private Connection establishConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }

}
