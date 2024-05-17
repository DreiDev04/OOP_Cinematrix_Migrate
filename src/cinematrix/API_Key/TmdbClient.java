package cinematrix.API_Key;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import cinematrix.API_Key.TMDB_api;

public class TmdbClient {
    
    private final OkHttpClient client;
    TMDB_api api = new TMDB_api();
    
    
    
    public TmdbClient() {
        this.client = new OkHttpClient();
    }

    // Method to fetch popular movies
    public void fetchPopularMovies() {
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=en-US&page=1&sort_by=popularity.desc")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer "+ api.getTOKEN())
                .build();

        try {
            Response response = client.newCall(request).execute();
            handleResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to fetch top-rated movies
    public void fetchTopRatedMovies() {
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/top_rated?language=en-US&page=1")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + api.getTOKEN())
                .build();

        try {
            Response response = client.newCall(request).execute();
            handleResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to handle the API response
    private void handleResponse(Response response) {
        if (response.isSuccessful()) {
            try {
                String jsonData = response.body().string();
                JSONObject jsonObject = new JSONObject(jsonData);

                // Process the JSON data here
                JSONArray results = jsonObject.getJSONArray("results");
                for (int i = 0; i < results.length(); i++) {
                    JSONObject movie = results.getJSONObject(i);
                    String title = movie.getString("title");
                    String moviePoster = "https://image.tmdb.org/t/p/w500" + movie.getString("poster_path");
                    System.out.println("Title: " + title);
                    System.out.println("Poster URL: " + moviePoster);
                    System.out.println();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error: " + response.code() + " " + response.message());
        }
    }

    public String requestPoster(int movieId) throws IOException {
        String url = "https://api.themoviedb.org/3/tv/" + movieId + "/images";

        Request request = new Request.Builder()
                .url(url)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer " + api.getTOKEN())
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
                        return bg.getString("file_path");
                    }
                }
            }
        }
        return null;
    }
    
//    public static void main(String[] args) {
//        TmdbClient apiClient = new TmdbClient();
//        
//        // Fetch popular movies
//        apiClient.fetchPopularMovies();
//        
//        // Fetch top-rated movies
//        apiClient.fetchTopRatedMovies();
//    }
}
