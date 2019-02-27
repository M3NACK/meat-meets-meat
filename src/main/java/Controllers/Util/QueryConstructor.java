package Controllers.Util;

import Models.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringJoiner;

public class QueryConstructor {

    private static Connection dbConn;

    public static String insertIntoUsers(User user) throws ClassNotFoundException, SQLException {
        dbConn = JDBC.mySQLConnector.getInstance().getConnection();
        Statement stmt = dbConn.createStatement();
        String sql = "INSERT INTO users VALUES (";
        StringJoiner sj = new StringJoiner(",");
        sj.add("'"+user.getUsername()+"'");
        sj.add("'"+user.getPassword()+"'");
        sj.add("'"+user.getFirst()+"'");
        sj.add("'"+user.getLast()+"'");
        sj.add(user.getAid().toString());
        return sql + sj.toString() + ");";
    }
}
