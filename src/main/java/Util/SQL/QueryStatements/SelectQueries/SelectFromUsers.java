package Util.SQL.QueryStatements.SelectQueries;

import Util.PasswordHash;
import Models.UserPassPair;
import Util.SQL.JDBC.mySQLConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

import static Util.SQL.JDBC.Constants.salt;

public class SelectFromUsers implements SelectQuery {

    public ResultSet execute(Object u, boolean notequals) {
        UserPassPair user = (UserPassPair) u;
        String username = user.getUsername();
        String password = user.getPassword();
        ResultSet rs = null;
        try {
            Connection dbConn = mySQLConnector.getInstance().getConnection();
            Statement stmt = dbConn.createStatement();
            String sql = "SELECT * FROM users WHERE ";
            StringJoiner sj = new StringJoiner(",");
            sj.add("username=" + "'" + username + "'" + " AND " + "password=" + "'" + PasswordHash.get_SHA_256_SecurePassword(password, salt) + "'");
            String select = sql + sj.toString() + ";";
            System.out.println(select);
            rs = stmt.executeQuery(select);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return rs;

    }
}
