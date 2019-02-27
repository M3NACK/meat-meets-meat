package Models;

public class Character {

    private Integer cid;
    private String name;
    private String asciiArt;

    public Character(Integer cid, String name, String asciiArt) {
        this.cid = cid;
        this.name = name;
        this.asciiArt = asciiArt;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAsciiArt() {
        return asciiArt;
    }

    public void setAsciiArt(String asciiArt) {
        this.asciiArt = asciiArt;
    }
}
