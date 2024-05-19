package backend;

interface FavoritesTemplateInterface {

    String getUID();

    void setUID(String UID);

    String getfavoritesID();

    void setfavoritesID(String favID);

    String getMovieID();

    void setMovieID(String movieID);
}

public class FavoritesTemplate implements FavoritesTemplateInterface {

    private String UID;
    private String movieID;
    private String favoritesID;

    public FavoritesTemplate(String UID, String favoritesID, String movieID) {
        this.UID = UID;
        this.favoritesID = favoritesID;
        this.movieID = movieID;
    }
    public FavoritesTemplate() {
    }

    @Override
    public String getUID() {
        return UID;
    }

    @Override
    public void setUID(String UID) {
        this.UID = UID;
    }

    @Override
    public String getfavoritesID() {
        return favoritesID;
    }

    @Override
    public void setfavoritesID(String favID) {
        this.favoritesID = favID;
    }

    @Override
    public String getMovieID() {
        return movieID;
    }

    @Override
    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }
}
