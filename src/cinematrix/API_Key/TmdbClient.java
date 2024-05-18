package cinematrix.API_Key;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import cinematrix.API_Key.TMDB_api;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class TmdbClient {

    private final OkHttpClient client;
    TMDB_api api = new TMDB_api();
    String apiKey = api.getTOKEN();

    public TmdbClient() {
        this.client = new OkHttpClient();
    }

    // Method to fetch popular movies
    public String fetchPopularMovies() throws IOException {
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    public String fetchTopRatedMovies() throws IOException {
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/top_rated?language=en-US&page=1")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    public String fetchUpcommingPH() throws IOException {
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/upcoming?language=en-US&page=1&region=ph")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    public String fetchTrendingDay() throws IOException {
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/trending/movie/day?language=en-US")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    public String fetchNetflix() throws IOException {
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/discover/tv?include_adult=false&include_null_first_air_dates=false&language=en-US&page=1&sort_by=popularity.desc&watch_region=Ph&with_networks=213")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            return response.body().string();
        }
    }

    // Method to request poster image for a given movie ID
    public String requestPoster(int movieId) throws IOException {
        String url = "https://api.themoviedb.org/3/tv/" + movieId + "/images";

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String responseBody = response.body().string();

            if (responseBody != null) {
                JSONObject jsonResponse = new JSONObject(responseBody);
                JSONArray results = jsonResponse.getJSONArray("backdrops");
                JSONObject bestFitPoster = null;

                for (int i = 0; i < results.length(); i++) {
                    JSONObject bg = results.getJSONObject(i);
                    if (bg.getDouble("aspect_ratio") >= 1) {
                        if (bestFitPoster == null || isBetterFit(bg, bestFitPoster)) {
                            bestFitPoster = bg;
                        }
                    }
                }

                if (bestFitPoster != null) {
                    return "https://image.tmdb.org/t/p/w500" + bestFitPoster.getString("file_path");
                }
            }
        }
        return null;
    }

    private boolean isBetterFit(JSONObject newPoster, JSONObject currentBest) {
        int newWidth = newPoster.getInt("width");
        int newHeight = newPoster.getInt("height");
        int currentWidth = currentBest.getInt("width");
        int currentHeight = currentBest.getInt("height");
        return Math.abs(newWidth - 1080) + Math.abs(newHeight - 300) < Math.abs(currentWidth - 1080) + Math.abs(currentHeight - 300);
    }
}
