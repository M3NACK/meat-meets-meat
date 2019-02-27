package Models;

public class Beer {

    private Integer bid;
    private String brewery;
    private String brewName;

    public Beer(Integer bid, String brewery, String brewName) {
        this.bid = bid;
        this.brewery = brewery;
        this.brewName = brewName;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getBrewName() {
        return brewName;
    }

    public void setBrewName(String brewName) {
        this.brewName = brewName;
    }
}
