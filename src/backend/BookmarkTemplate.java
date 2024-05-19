package backend;

interface BookmarkTemplateInterface {

    String getUID();

    void setUID(String UID);

    String getBookmarkID();

    void setBookmarkID(String bookmarkID);
    
    String getMovieID();

    void setMovieID(String movieID);
}

public class BookmarkTemplate implements BookmarkTemplateInterface {

    private String UID;
    private String bookmarkID;
    private String movieID;
    
    public BookmarkTemplate(String UID, String bookmarkID, String movieID) {
        this.UID = UID;
        this.bookmarkID = bookmarkID;
        this.movieID = movieID;
    }
    public BookmarkTemplate() {

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
    public String getBookmarkID() {
        return bookmarkID;
    }

    @Override
    public void setBookmarkID(String bookmarkID) {
        this.bookmarkID = bookmarkID;
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
