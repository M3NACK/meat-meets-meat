package Models;

public class User {

    private String username;
    private String password;
    private String first;
    private String last;
    private Integer aid;

    public User(String username, String password, String first, String last, Integer aid) {
        this.username = username;
        this.password = password;
        this.first = first;
        this.last = last;
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public boolean equals(Object o)
    {
        System.out.println("COMPARING USER");
        if (o == this)
        {
            return true;
        }
        if (!(o instanceof User))
        {
            return false;
        }
        User u = (User) o;
        return (u.username.equals(username) && u.first.equals(first) && u.last.equals(last) && u.aid == aid);
    }
}
