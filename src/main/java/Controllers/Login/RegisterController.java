package Controllers.Login;

import Controllers.Util.QueryConstructor;
import Models.Avatar;
import Models.AvatarMapping;
import Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
    public void initialize() {
        initializeAvatars();
        registerButton.setOnAction( event -> {
            User user = new User(loginField.getText(), passwordField.getText(),
                firstnameField.getText(), lastnameField.getText(),
                    1);
            try {
                registerUser(user);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void registerUser(User user) throws ClassNotFoundException, SQLException {
        QueryConstructor.insertIntoUsers(user);
    }

    private void initializeAvatars() {
        List<String> avatarNames = Stream.of(Avatar.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll(avatarNames);
        characterPicker.setItems(list);
        characterPicker.getSelectionModel().selectFirst();
    }

}
