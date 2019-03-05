package Util.SQL.QueryStatements.SelectQueries;

import Models.UserPassPair;
import Util.PasswordHash;
import Util.SQL.JDBC.mySQLConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

import static Util.SQL.JDBC.Constants.salt;

public class SelectFromBeerChoices implements SelectQuery {

    public ResultSet execute(Object u) {
        String username = (String) u;
        //String username = user.getUsername();
        ResultSet rs = null;
        try {
            Connection dbConn = mySQLConnector.getInstance().getConnection();
            Statement stmt = dbConn.createStatement();
            String sql = "SELECT * FROM beer_choices WHERE ";
            StringJoiner sj = new StringJoiner(",");
            sj.add("username='" +username+ "'");
            String select = sql + sj.toString() + ";";
            System.out.println(select);
            rs = stmt.executeQuery(select);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
