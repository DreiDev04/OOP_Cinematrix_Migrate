package backend;

public class MovieTemplate {

    private String title;
    private String posterUrl;

    public MovieTemplate(String title, String posterUrl) {
        this.title = title;
        this.posterUrl = posterUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }
}
