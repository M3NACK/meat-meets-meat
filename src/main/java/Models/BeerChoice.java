package Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BeerChoice {

    private String username;
    private Integer bid;
    private StringProperty bcid;

    public BeerChoice(String username, Integer bid, String bcid) {
        this.username = username;
        this.bid = bid;
        this.bcid = new SimpleStringProperty(bcid);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBcid() {
        return bcid.get();
    }

    public void setBcid(String bcid) {
        this.bcid.set(bcid);
    }
}
