package Util.SQL.QueryStatements.InsertQueries;

import Util.PasswordHash;
import Models.User;
import Util.SQL.JDBC.Constants;
import Util.SQL.JDBC.mySQLConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

public class InsertIntoUsers implements InsertQuery {

    public Boolean execute(Object u) {
        User user =  (User) u;
        try {
            Connection dbConn = mySQLConnector.getInstance().getConnection();
            Statement stmt = dbConn.createStatement();
            String sql = "INSERT INTO users VALUES (";
            StringJoiner sj = new StringJoiner(",");
            sj.add("'" + user.getUsername() + "'");
            sj.add("'" + PasswordHash.get_SHA_256_SecurePassword(user.getPassword(), Constants.salt) + "'");
            sj.add("'" + user.getFirst() + "'");
            sj.add("'" + user.getLast() + "'");
            sj.add(user.getAid().toString());
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
