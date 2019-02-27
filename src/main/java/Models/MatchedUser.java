package Models;

public class MatchedUser {

    private String username;
    private String match;
    private Integer bid;
    private Integer mid;

    public MatchedUser(String username, String match, Integer bid, Integer mid) {
        this.username = username;
        this.match = match;
        this.bid = bid;
        this.mid = mid;
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

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }
}
