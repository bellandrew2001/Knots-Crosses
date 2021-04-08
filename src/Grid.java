public class Grid {
    
    public Integer id;
    public String picture;

    public Grid(Integer id) {
        this.id = id;
        this.picture = null;
    }

    public Integer getId() {
        return this.id;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return this.picture;
    }
}
