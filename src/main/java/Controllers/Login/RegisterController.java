package Controllers.Login;

import Controllers.Util.QueryConstructor;
import Controllers.Util.SwitchScene;
import Models.Avatar;
import Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegisterController {
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField lastnameField;
    @FXML
    private ChoiceBox characterPicker;
    @FXML
    private Button registerButton;
    @FXML
    private Label registerStatus;

    @FXML
    public void initialize() {
        initializeAvatars();
        registerButton.setOnAction( event -> {
            User user = new User(loginField.getText(), passwordField.getText(),
                firstnameField.getText(), lastnameField.getText(),
                    1);
            try {
                if (registerUser(user)) {
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                    switchToLoginScene();
                } else {
                    registerStatus.setText("Username is taken");
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void switchToLoginScene() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("FXML/Login.fxml"));
        SwitchScene.switchScene(loader, "Login");
    }

    private boolean registerUser(User user) throws ClassNotFoundException, SQLException {
        return QueryConstructor.insertIntoUsers(user);
    }

    private void initializeAvatars() {
        List<String> avatarNames = Stream.of(Avatar.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        ObservableList<String> avatarList = FXCollections.observableArrayList();
        avatarList.addAll(avatarNames);
        characterPicker.setItems(avatarList);
        characterPicker.getSelectionModel().selectFirst();
    }

}
