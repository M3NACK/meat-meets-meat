package Util.SQL.QueryStatements.InsertQueries;

import Models.MatchedUser;
import Util.SQL.JDBC.mySQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

public class InsertIntoMatches implements InsertQuery {
    public Boolean execute(Object o) {
        MatchedUser match = (MatchedUser) o;
        try {
            Connection dbConn = mySQLConnector.getInstance().getConnection();
            Statement stmt = dbConn.createStatement();
            String sql = "INSERT INTO matches VALUES (DEFAULT, ";
            StringJoiner sj = new StringJoiner(",");
            sj.add("'" + match.getUsername() + "'");
            sj.add("'" + match.getMatch() + "'");
            sj.add("'" + match.getBid() + "'");
            String insert = sql + sj.toString() + ");";
            System.out.println(insert);
            stmt.executeUpdate(insert);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
