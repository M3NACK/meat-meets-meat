package Models;

public class BeerChoice {

    private String username;
    private Integer bid;
    private Integer bcid; //beer choice id

    public BeerChoice(String username, Integer bid, Integer bcid) {
        this.username = username;
        this.bid = bid;
        this.bcid = bcid;
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

    public Integer getBcid() {
        return bcid;
    }

    public void setBcid(Integer bcid) {
        this.bcid = bcid;
    }
}
