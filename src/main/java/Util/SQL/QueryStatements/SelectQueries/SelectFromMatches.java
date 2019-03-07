package Util.SQL.QueryStatements.SelectQueries;

import Util.SQL.JDBC.mySQLConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

public class SelectFromMatches implements SelectQuery {
    public ResultSet execute(Object o, boolean setNotEqual) {
        String username = (String) o;
        ResultSet rs = null;
        try {
            Connection dbConn = mySQLConnector.getInstance().getConnection();
            Statement stmt = dbConn.createStatement();
            String sql = "SELECT * FROM matches WHERE ";
            StringJoiner sj = new StringJoiner(",");
            sj.add("username='" + username + "'");
            String select = sql + sj.toString() + ";";
            System.out.println(select);
            rs = stmt.executeQuery(select);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
