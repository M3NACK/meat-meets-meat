package Controllers.Homepage;

import Models.Avatar;
import Models.AvatarMapping;
import Models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sun.font.TextLabel;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class UserInfoController {

    @FXML
    private Label usernameLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label avatarLabel;
    @FXML
    private TableView usernameView;
    @FXML
    private TableColumn usernameColumn;
    @FXML
    private TableColumn avatarColumn;
    @FXML
    private ImageView avatarImage;

    private String username;
    private String avatarName;
    private String firstname;
    private String lastname;

    public UserInfoController(User u) {
        setUsername(u.getUsername());
        setAvatarName(AvatarMapping.getReverseMapping(u.getAid()));
        setFirstname(u.getFirst());
        setLastname(u.getLast());
    }

    @FXML
    public void initialize() throws IOException {
        usernameLabel.setText(username);
        avatarLabel.setText(avatarName);
        nameLabel.setText(firstname+" "+lastname);
        Image image = new Image(AvatarMapping.getPhotoPathMapping(avatarName));
        avatarImage.setImage(image);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
