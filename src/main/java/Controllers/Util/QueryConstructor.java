package Controllers.Util;

import Models.User;
import javafx.fxml.FXMLLoader;

import java.sql.*;
import java.util.StringJoiner;

public class QueryConstructor {

    private static Connection dbConn;

    private static void getdbConn() throws ClassNotFoundException, SQLException{
        if (dbConn == null) {
            dbConn = JDBC.mySQLConnector.getInstance().getConnection();
        }
    }

    public static boolean insertIntoUsers(User user) throws ClassNotFoundException, SQLException {
        getdbConn();
        Statement stmt = dbConn.createStatement();
        String sql = "INSERT INTO users VALUES (";
        StringJoiner sj = new StringJoiner(",");
        sj.add("'"+user.getUsername()+"'");
        sj.add("'"+user.getPassword()+"'");
        sj.add("'"+user.getFirst()+"'");
        sj.add("'"+user.getLast()+"'");
        sj.add(user.getAid().toString());
        String insert = sql + sj.toString() + ");";
        try {
            stmt.executeUpdate(insert);
        } catch (SQLIntegrityConstraintViolationException e) {
            return false;
        }
        return true;
    }

    public static boolean selectFromUsers(String username, String password) throws ClassNotFoundException, SQLException {
        getdbConn();
        Statement stmt = dbConn.createStatement();
        String sql = "SELECT * FROM users WHERE ";
        StringJoiner sj = new StringJoiner(",");
        sj.add("username="+"'"+username+"'" + " AND " + "password="+"'"+password+"'");
        String select = sql + sj.toString() + ";";
        System.out.println(select);
        ResultSet rs = stmt.executeQuery(select);
        if (rs.next()) {
            String sqlUser = rs.getString("username");
            String sqlPass = rs.getString("password");
            if (sqlUser.equals(username) && sqlPass.equals(password)) {
                return true;
            }
        }
        return false;
    }

}
