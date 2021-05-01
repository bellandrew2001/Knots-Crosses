public class Grid {
    
    public String picture;

    public Grid(String picture) {
        this.picture = picture;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return this.picture;
    }

    
	@Override
	public boolean equals(Object obj) {
		if(obj == null || this.getClass() != obj.getClass()) {
			return false; 
        }
		return ((Grid)obj).picture == this.picture; 
    } 
}
