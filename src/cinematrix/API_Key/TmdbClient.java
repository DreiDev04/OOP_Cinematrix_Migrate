package cinematrix.API_Key;

import backend.MovieTemplate;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import cinematrix.API_Key.TMDB_api;
import java.util.ArrayList;
import java.util.List;


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

    // Method to handle the API response
//    private List<MovieTemplate> handleResponse(Response response) throws IOException {
//        List<MovieTemplate> movies = new ArrayList<>();
//        if (response.isSuccessful()) {
//            String jsonData = response.body().string();
//            JSONObject jsonObject = new JSONObject(jsonData);
//
//            JSONArray results = jsonObject.getJSONArray("results");
//            for (int i = 0; i < results.length(); i++) {
//                JSONObject movie = results.getJSONObject(i);
//                String title = movie.getString("title");
//                String moviePoster = "https://image.tmdb.org/t/p/w500" + movie.getString("poster_path");
//                movies.add(new MovieTemplate(title, moviePoster));
//            }
//        } else {
//            System.out.println("Error: " + response.code() + " " + response.message());
//        }
//        return movies;
//    }

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

                for (int i = 0; i < results.length(); i++) {
                    JSONObject bg = results.getJSONObject(i);
                    if (bg.getDouble("aspect_ratio") >= 1) {
                        return "https://image.tmdb.org/t/p/w500" + bg.getString("file_path");
                    }
                }
            }
        }
        return null;
    }
}
