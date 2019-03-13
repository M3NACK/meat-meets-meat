package Controllers.Login;

import Util.SQL.QueryStatements.InsertQueries.InsertQuery;
import Util.SQL.QueryFactory.InsertQueryFactory;
import Util.SwitchScene;
import Models.Avatar;
import Models.AvatarMapping;
import Models.Tables;
import Models.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RegisterController {
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
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
        registerButton.setOnAction(event -> {
            if (loginField.getText().isEmpty() || passwordField.getText().isEmpty() || firstnameField.getText().isEmpty() || lastnameField.getText().isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all fields\n");
                alert.showAndWait();
            }
            else {
                User user = new User(loginField.getText(), passwordField.getText(),
                        firstnameField.getText(), lastnameField.getText(), AvatarMapping.getMapping(characterPicker.getValue().toString()));
                if (registerUser(user)) {
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    switchToLoginScene();
                } else {
                    registerStatus.setText("Username is taken");
                }
            }
        });
    }

    private void switchToLoginScene() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("FXML/Login.fxml"));
        SwitchScene.switchScene(loader, "Login");
    }

    private boolean registerUser(User user) {
        InsertQuery insert = InsertQueryFactory.getQuery(Tables.users);
        return insert.execute(user);
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
