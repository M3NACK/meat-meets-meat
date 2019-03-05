package Controllers.Homepage;

import Models.*;
import Util.SQL.QueryFactory.InsertQueryFactory;
import Util.SQL.QueryFactory.SelectQueryFactory;
import Util.SQL.QueryStatements.InsertQueries.InsertQuery;
import Util.SQL.QueryStatements.SelectQueries.SelectQuery;
import com.github.javafaker.Faker;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserInfoController {

    @FXML
    private Label usernameLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label avatarLabel;
    @FXML
    private TableView<Beer> brewTableView;
    @FXML
    private TableColumn<Beer, String> brewColumn;
    @FXML
    private TableColumn<Beer, String> breweryColumn;
    @FXML
    private TableView<Beer> beerDbTable;
    @FXML
    private TableColumn<Beer, String> beerDbBrewName;
    @FXML
    private TableColumn<Beer, String> beerDbBrewery;
    @FXML
    private ImageView avatarImage;
    @FXML
    private Label chucknorrisLabel;
    @FXML
    private TextField breweryTextField;
    @FXML
    private TextField brewnameTextField;
    @FXML
    private Button addBeerButton;


    private ObservableList<Beer> beerData = FXCollections.observableArrayList();
    private ObservableList<Beer> beerDbData = FXCollections.observableArrayList();



    private int chuckNorrisDuration = 15;
    private String username;
    private String avatarName;
    private String firstname;
    private String lastname;
    private Faker f = new Faker();

    public UserInfoController(User u) {
        setUsername(u.getUsername());
        setAvatarName(AvatarMapping.getReverseMapping(u.getAid()));
        setFirstname(u.getFirst());
        setLastname(u.getLast());
    }

    @FXML
    public void initialize() throws IOException {
        //brewTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        brewColumn.setCellValueFactory(cellData -> cellData.getValue().brewNameProperty());
        breweryColumn.setCellValueFactory(cellData -> cellData.getValue().breweryProperty());
        beerDbBrewName.setCellValueFactory(cellData -> cellData.getValue().brewNameProperty());
        beerDbBrewery.setCellValueFactory(cellData -> cellData.getValue().breweryProperty());
        usernameLabel.setText(firstname + " " + lastname);
        Image image = new Image(AvatarMapping.getPhotoPathMapping(avatarName));
        avatarImage.setImage(image);
        chucknorrisLabel.setText(f.chuckNorris().fact());
        initChuckNorrisFacts();
        populateUserBeers(username);
        populateBeerDb();
        brewTableView.setItems(beerData);
        beerDbTable.setItems(beerDbData);
        addBeerButton.setOnAction( event -> {
            String brewery = breweryTextField.getText();
            String brewName = brewnameTextField.getText();
            Beer b = new Beer("DEFAULT", brewery, brewName); //dont need BID since auto increment on insert
            InsertQuery insertIntoBeers = InsertQueryFactory.getQuery(Tables.beers);
            insertIntoBeers.execute(b);
            beerDbData.add(b);
            beerDbTable.setItems(beerDbData);
            /*
            beerDbTable.getItems().clear(); //clear
            populateBeerDb(); //reselect all beers from db
            beerDbTable.setItems(beerDbData); //repopulate with new beers
            */
        });

    }

    private void populateBeerDb() {
        SelectQuery selectFromBeers = SelectQueryFactory.getQuery(Tables.beers);
        ResultSet rs = selectFromBeers.execute("> -1");
        try {
            while (rs.next()) {
                String beerID = rs.getString("bid");
                String brewName = rs.getString("brewname");
                String brewery = rs.getString("brewery");
                Beer beer = new Beer(beerID, brewery, brewName);
                beerDbData.add(beer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void populateUserBeers(String username) {
        ArrayList<Integer> bidData = new ArrayList<>();
        SelectQuery selectBeerChoice = SelectQueryFactory.getQuery(Tables.beer_choices);
        ResultSet beerResults = selectBeerChoice.execute(username);
        //find all the beer choices for this user
        try {
            while (beerResults.next()) {
                String bid = beerResults.getString("bid");
                bidData.add(new Integer(bid));
            }
            SelectQuery selectFromBeers = SelectQueryFactory.getQuery(Tables.beers);
            //populate the beer model for user beer in this users beer choice list
            for (Integer bid : bidData) {
                ResultSet rs = selectFromBeers.execute("="+bid.toString());
                if (rs.next()) {
                    String beerID = rs.getString("bid");
                    String brewName = rs.getString("brewname");
                    String brewery = rs.getString("brewery");
                    Beer beer = new Beer(beerID, brewery, brewName);
                    beerData.add(beer);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initChuckNorrisFacts() {
        Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(chuckNorrisDuration), event -> chucknorrisLabel.setText(f.chuckNorris().fact())));
        fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
        fiveSecondsWonder.play();
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
