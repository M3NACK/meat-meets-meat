package Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Beer {

    private final StringProperty bid;
    private final StringProperty brewery;
    private final StringProperty brewName;

    public Beer(String bid, String brewery, String brewName) {
        this.bid = new SimpleStringProperty(bid);
        this.brewery = new SimpleStringProperty(brewery);
        this.brewName = new SimpleStringProperty(brewName);
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

    public String getBrewery() {
        return brewery.get();
    }

    public StringProperty breweryProperty() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery.set(brewery);
    }

    public String getBrewName() {
        return brewName.get();
    }

    public StringProperty brewNameProperty() {
        return brewName;
    }

    public void setBrewName(String brewName) {
        this.brewName.set(brewName);
    }
}
