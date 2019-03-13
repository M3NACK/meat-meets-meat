package Controllers.Login;

import Controllers.Homepage.UserInfoController;
import Util.SQL.QueryStatements.SelectQueries.SelectQuery;
import Util.SQL.QueryFactory.SelectQueryFactory;
import Util.SwitchScene;
import Models.Tables;
import Models.UserPassPair;
import Models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private Label loginStatus;


    @FXML
    public void initialize(){
        loginButton.setOnAction( event -> {
            try {
                    User u = verifyUser(loginField.getText(), passwordField.getText());
                    if (u != null) {
                        switchToLandingScene(u);
                    } else {
                    loginStatus.setText("Invalid Login!");
                }
            } catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
        });
        registerButton.setOnAction( event -> {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            switchToRegisterScene();
        });
    }

    private void switchToRegisterScene() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("FXML/Register.fxml"));
        SwitchScene.switchScene(loader, "Register");
    }

    private void switchToLandingScene(User u) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("FXML/infoDisplay.fxml"));
        UserInfoController uc = new UserInfoController(u);
        loader.setController(uc);
        SwitchScene.switchScene(loader, "Hello " + loginField.getText() + ", Welcome to Meats Meets Meat!");
    }

    private User verifyUser(String username, String password) throws ClassNotFoundException, SQLException {
        SelectQuery u = SelectQueryFactory.getQuery(Tables.users);
        try (ResultSet rs = u.execute(new UserPassPair(username, password), false)) {
            if (rs.next()) {
                String sqlUser = rs.getString("username");
                String sqlPass = rs.getString("password");
                String sqlFirst = rs.getString("first");
                String sqlLast = rs.getString("last");
                Integer sqlAid = rs.getInt("aid");
                return new User(sqlUser, sqlPass, sqlFirst, sqlLast, sqlAid);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }





}
