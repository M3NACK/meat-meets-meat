package Controllers.Login;

import Controllers.Homepage.UserInfoController;
import Controllers.Util.QueryConstructor;
import Controllers.Util.SwitchScene;
import Models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private Label loginStatus;


    @FXML
    public void initialize(){
        loginButton.setOnAction( event -> {
            System.out.println(loginField.getText());
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
        SwitchScene.switchScene(loader, "Welcome to Meats Meets Meat!");
    }

    private User verifyUser(String username, String passsword) throws ClassNotFoundException, SQLException {
        return QueryConstructor.selectFromUsersVerify(username, passsword);
    }





}
