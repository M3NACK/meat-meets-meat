package Controllers.Login;

import Controllers.Util.SwitchScene;
import Models.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

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
    public void initialize(){
        loginButton.setOnAction( event -> {
            System.out.println(loginField.getText());
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



}
