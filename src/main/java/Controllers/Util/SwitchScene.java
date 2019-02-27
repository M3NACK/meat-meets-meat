package Controllers.Util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.sun.javafx.scene.control.skin.Utils.getResource;

public class SwitchScene {

    public static void switchScene(FXMLLoader loader, String title) {
        Stage stage = new Stage();
        stage.setTitle(title);
        Pane layout = null;
        try {
            layout = (Pane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene landingScene = new Scene(layout);
        stage.setScene(landingScene);
        stage.show();
    }
}
