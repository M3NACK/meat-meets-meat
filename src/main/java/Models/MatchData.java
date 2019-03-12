package Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class MatchData {

    private User matchUser;
    private ObservableList<Beer> matchedBeers;

    public MatchData(User u, List<Beer> beers)
    {
        this.matchUser = u;
        matchedBeers = FXCollections.observableArrayList();
        matchedBeers.addAll(beers);
    }

    public User getMatchedUser() { return matchUser; }

    public ObservableList<Beer> getMatchedBeers() { return matchedBeers; }

    public StringProperty usernameProperty() {
        return new SimpleStringProperty(matchUser.getUsername());
    }

    public StringProperty beerProperty()
    {
        StringJoiner sj = new StringJoiner(", ");
        for (Beer beer : matchedBeers)
        {
            sj.add(beer.getBrewName());
        }
        String beers = sj.toString();
        return new SimpleStringProperty(beers);
    }
}

