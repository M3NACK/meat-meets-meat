package Util.SQL.QueryStatements.InsertQueries;

import Models.BeerChoice;
import Util.SQL.JDBC.mySQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

public class InsertIntoChoices implements InsertQuery {
    public Boolean execute(Object o) {
        BeerChoice choice = (BeerChoice) o;
        try {
            Connection dbConn = mySQLConnector.getInstance().getConnection();
            Statement stmt = dbConn.createStatement();
            String sql = "INSERT INTO beer_choices VALUES (DEFAULT, ";
            StringJoiner sj = new StringJoiner(",");
            sj.add("'" + choice.getUsername() + "'");
            sj.add("'" + choice.getBid() + "'");
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
