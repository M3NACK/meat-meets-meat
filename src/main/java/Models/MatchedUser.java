package Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MatchedUser {

    private String username;
    private String match;
    private Integer bid;
    private StringProperty mid;

    public MatchedUser(String username, String match, Integer bid, String mid) {
        this.username = username;
        this.match = match;
        this.bid = bid;
        this.mid = new SimpleStringProperty(mid);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getMid() {
        return mid.get();
    }

    public void setMid(String mid) {
        this.mid.set(mid);
    }
}
