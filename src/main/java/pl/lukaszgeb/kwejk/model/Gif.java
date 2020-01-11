package pl.lukaszgeb.kwejk.model;

public class Gif {

    private int categoryId;
    private String name;
    private String username;
    private boolean favorite;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Gif() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Gif(String name, String username) {
        this.name = name;
        this.username = username;
    }

    public Gif(String name, String username, int categoryId) {
        this.name = name;
        this.username = username;
        this.categoryId = categoryId;
    }

    public String getUrl() {
        return getName() + ".gif";
    }




}