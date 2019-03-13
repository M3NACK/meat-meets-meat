package Util.SQL.QueryStatements.InsertQueries;

import Models.Beer;
import Models.User;
import Util.PasswordHash;
import Util.SQL.JDBC.Constants;
import Util.SQL.JDBC.mySQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

public class InsertIntoBeers implements InsertQuery {

    public Boolean execute(Object o) {
        Beer beer = (Beer) o;
        try {
            Connection dbConn = mySQLConnector.getInstance().getConnection();
            Statement stmt = dbConn.createStatement();
            String sql = "INSERT INTO beers VALUES (DEFAULT, ";
            StringJoiner sj = new StringJoiner(",");
            sj.add("'" + beer.getBrewery() + "'");
            sj.add("'" + beer.getBrewName() + "'");
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
