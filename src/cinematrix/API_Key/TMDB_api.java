package cinematrix.API_Key;

import java.util.HashMap;

public class TMDB_api {

    private final String TOKEN_AUTH = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NDAxZWJiYTI1OThhNzUwYTcxNGM1NzcyZWQwNWE4MiIsInN1YiI6IjY2MTk3YTZkZTRjOWViMDE0OTJhM2EyZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.MIhpoHFGzh7zeoF8xdVRzh1wIxJ10CfnR7cKpS0PPk8";
    private final String API_AUTH = "8401ebba2598a750a714c5772ed05a82";
    
    public TMDB_api() {
    }

    public String getTOKEN() {
        return TOKEN_AUTH;
    }

    public String getAPI() {
        return API_AUTH;
    }

}
