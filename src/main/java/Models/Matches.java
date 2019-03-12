package Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Matches {

    private HashMap<String, MatchData> matchData;

    public Matches()
    {
        matchData = new HashMap<>();
    }

    public ObservableList<MatchData> getMatches()
    {
        ObservableList<MatchData> matches = FXCollections.observableArrayList();
        for (String key : matchData.keySet())
        {
            matches.add(matchData.get(key));
        }
        return matches;
    }

    public void addMatch(User u, Beer b)
    {
        if (matchData.containsKey(u.getUsername()))
        {
            matchData.get(u.getUsername()).getMatchedBeers().add(b);
        }
        else
        {
           List<Beer> beers = new ArrayList<>();
           beers.add(b);
           matchData.put(u.getUsername(), new MatchData(u, beers));
        }
    }

}
