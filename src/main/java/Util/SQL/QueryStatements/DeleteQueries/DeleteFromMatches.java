package Util.SQL.QueryStatements.DeleteQueries;

import Models.BeerChoice;
import Util.SQL.JDBC.mySQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

public class DeleteFromMatches implements DeleteQuery {
    public Boolean execute(Object u) {
        BeerChoice bc = (BeerChoice) u;
        try {
            Connection dbConn = mySQLConnector.getInstance().getConnection();
            Statement stmt = dbConn.createStatement();
            String sql = "DELETE FROM matches WHERE ";
            StringJoiner sj = new StringJoiner(" ");
            sj.add("username='" + bc.getUsername() + "' and ");
            sj.add("bid=" + bc.getBid());
            String delete = sql + sj.toString() + ";";
            System.out.println(delete);
            stmt.executeUpdate(delete);
        } catch (SQLException | ClassNotFoundException e) {
            return false;
        }
        return true;
    }
}
