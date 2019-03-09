package Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MatchedUser {

    private StringProperty username;
    private StringProperty match;
    private StringProperty bid;
    private StringProperty mid;

    public MatchedUser(String username, String match, String bid, String mid) {
        this.username = new SimpleStringProperty(username);
        this.match = new SimpleStringProperty(match);
        this.bid = new SimpleStringProperty(bid);
        this.mid = new SimpleStringProperty(mid);
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getMatch() {
        return match.get();
    }

    public StringProperty matchProperty() {
        return match;
    }

    public void setMatch(String match) {
        this.match.set(match);
    }

    public String getBid() {
        return bid.get();
    }

    public StringProperty bidProperty() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid.set(bid);
    }

    public String getMid() {
        return mid.get();
    }

    public StringProperty midProperty() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid.set(mid);
    }
}
