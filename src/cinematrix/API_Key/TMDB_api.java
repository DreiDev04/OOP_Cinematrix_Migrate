package cinematrix.API_Key;

import java.util.HashMap;

public class TMDB_api {

    private final String TOKEN_AUTH = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NDAxZWJiYTI1OThhNzUwYTcxNGM1NzcyZWQwNWE4MiIsInN1YiI6IjY2MTk3YTZkZTRjOWViMDE0OTJhM2EyZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.MIhpoHFGzh7zeoF8xdVRzh1wIxJ10CfnR7cKpS0PPk8";
    private final String API_AUTH = "8401ebba2598a750a714c5772ed05a82";
    
    public HashMap<String, String> requestMovie = new HashMap<>();
    public HashMap<String, String> requestTV = new HashMap<>();
    
    public TMDB_api() {
        
        requestMovie.put("getTrendingDay", "https://api.themoviedb.org/3/trending/movie/day?language=en-US");
        requestMovie.put("getTrendingWeek", "https://api.themoviedb.org/3/trending/movie/week?language=en-US");
        requestMovie.put("getTopRatedPH", "https://api.themoviedb.org/3/movie/popular?language=en-US&page=1&region=ph");
        requestMovie.put("getUpCommingPH", "https://api.themoviedb.org/3/movie/upcoming?language=en-US&page=1&region=ph");
        
        requestTV.put("getNetflixOrigPH", "https://api.themoviedb.org/3/discover/tv?include_adult=false&include_null_first_air_dates=false&language=en-US&page=1&sort_by=popularity.desc&watch_region=Ph&with_networks=213");
        
    }

    public String getTOKEN() {
        return TOKEN_AUTH;
    }

    public String getAPI() {
        return API_AUTH;
    }

}
