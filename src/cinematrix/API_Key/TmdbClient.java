package cinematrix.API_Key;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import cinematrix.API_Key.TMDB_api;
import okhttp3.HttpUrl;

public class TmdbClient {

    private final OkHttpClient client;
    TMDB_api api = new TMDB_api();
    String apiKey = api.getTOKEN();

    private static final String API_URL = "https://api.themoviedb.org/3/search/movie";

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

    public String fetchCinemaPH() throws IOException {
        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/movie/now_playing?language=en-US&page=1&region=ph")
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

    public String requestPoster(int movieId) throws IOException {
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "/images";

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
                JSONArray backdrops = jsonResponse.getJSONArray("backdrops");
                JSONObject bestFitPoster = null;

                for (int i = 0; i < backdrops.length(); i++) {
                    JSONObject backdrop = backdrops.getJSONObject(i);
                    if (backdrop.getDouble("aspect_ratio") >= 1) {
                        if (bestFitPoster == null || isBetterFit(backdrop, bestFitPoster)) {
                            bestFitPoster = backdrop;
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

    // Method to request poster image for a given movie ID
    public JSONObject querySearch(String query) throws IOException {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(API_URL).newBuilder();
        urlBuilder.addQueryParameter("query", query);

        String url = urlBuilder.build().toString();

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
            return new JSONObject(responseBody);
        }
    }

    public JSONObject searchID(int movieId) throws IOException {

        String url = "https://api.themoviedb.org/3/movie/" + movieId + "?language=en-US";

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
            return new JSONObject(responseBody);
        }
    }

    private boolean isBetterFit(JSONObject newPoster, JSONObject currentBest) {
        int newWidth = newPoster.getInt("width");
        int newHeight = newPoster.getInt("height");
        int currentWidth = currentBest.getInt("width");
        int currentHeight = currentBest.getInt("height");
        return Math.abs(newWidth - 1080) + Math.abs(newHeight - 300) < Math.abs(currentWidth - 1080) + Math.abs(currentHeight - 300);
    }
}
