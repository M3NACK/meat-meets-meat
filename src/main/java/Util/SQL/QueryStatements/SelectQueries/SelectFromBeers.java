package Util.SQL.QueryStatements.SelectQueries;

import Models.UserPassPair;
import Util.SQL.JDBC.mySQLConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

public class SelectFromBeers implements SelectQuery {

    public ResultSet execute(Object o, boolean notequals) {
        String bid = (String) o;
        ResultSet rs = null;
        try {
            Connection dbConn = mySQLConnector.getInstance().getConnection();
            Statement stmt = dbConn.createStatement();
            String sql = "SELECT * FROM beers WHERE ";
            StringJoiner sj = new StringJoiner(",");
            sj.add("bid" + bid);
            String select = sql + sj.toString() + ";";
            System.out.println(select);
            rs = stmt.executeQuery(select);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
