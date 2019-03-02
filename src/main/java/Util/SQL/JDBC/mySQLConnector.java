package Util.SQL.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mySQLConnector {

    private Connection connection;
    private static mySQLConnector connector;

    public static mySQLConnector getInstance() throws ClassNotFoundException, SQLException {
        if (connector == null) {
            connector = new mySQLConnector();
        }
        return connector;
    }

    private mySQLConnector() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = establishConnection();
    }

    private Connection establishConnection() throws SQLException {
        return DriverManager.getConnection(Constants.dbUrl, Constants.username, Constants.password);
    }

    public static void main (String[] args) throws ClassNotFoundException, SQLException {
        mySQLConnector c = mySQLConnector.getInstance();
        c.establishConnection();
    }

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = establishConnection();
        }
        return connection;
    }
}
