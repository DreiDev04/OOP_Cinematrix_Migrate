package cinematrix;

import Splashscreen.LoadingSplash;
import backend.Session;
import cinematrix.API_Key.TMDB_api;
import cinematrix.API_Key.TmdbClient;
import cinematrix.Panels.Features;
import cinematrix.custom_ui.CustomScrollBarUI;
import java.io.IOException;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.swing.ImageIcon;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Random;



public class MainFrame extends javax.swing.JFrame {

    // <editor-fold defaultstate="collapsed" desc="Code For HttpRequest">   
    static { //Chat-GPT code hjehehe
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(
                          java.security.cert.X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(
                          java.security.cert.X509Certificate[] certs, String authType) {
                }
            }
        };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
    }
    // </editor-fold>  

    //Declaration and Initialization
    TMDB_api tmdb = new TMDB_api();
    Session _currUser = new Session();
    TmdbClient apiClient = new TmdbClient();
    LoadingSplash loadingSplash;

    public MainFrame(Session currUser, LoadingSplash ls) {
        initComponents();
        loadingSplash = ls;
        body.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        
        
        if (currUser == null) {
            throw new IllegalArgumentException("currUser cannot be null");
        }
        _currUser = currUser;

        
        fetchAndDisplayMovies();
        


    }
    private void fetchAndDisplayMovies() {
        try {
            // Fetch popular movies
            String popularMoviesJson = apiClient.fetchPopularMovies();
            displayMovies(popularMoviesJson, "Popular Movies");

            // Fetch top-rated movies
            String topRatedMoviesJson = apiClient.fetchTopRatedMovies();
            displayMovies(topRatedMoviesJson, "Top Rated Movies");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void displayMovies(String moviesJson, String title) throws IOException {
        JSONObject jsonObject = new JSONObject(moviesJson);
        JSONArray results = jsonObject.getJSONArray("results");
        
        main.add(new Features(results, title, loadingSplash, this));

    }


    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nav = new javax.swing.JPanel();
        lbl_Logo = new javax.swing.JLabel();
        body = new javax.swing.JScrollPane();
        pnl_body = new javax.swing.JPanel();
        hero = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbl_movieRatings = new javax.swing.JLabel();
        lbl_movieDescription = new javax.swing.JLabel();
        lbl_movieTitle = new javax.swing.JLabel();
        lbl_bgImg = new javax.swing.JLabel();
        main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cinematrix");
        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1080, 720));

        nav.setBackground(new java.awt.Color(17, 24, 39));
        nav.setMaximumSize(new java.awt.Dimension(1070, 50));
        nav.setMinimumSize(new java.awt.Dimension(1070, 50));
        nav.setPreferredSize(new java.awt.Dimension(1070, 50));
        nav.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Logo.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 36)); // NOI18N
        lbl_Logo.setForeground(new java.awt.Color(229, 231, 235));
        lbl_Logo.setText("CineMatrix");
        nav.add(lbl_Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 200, 50));
        lbl_Logo.getAccessibleContext().setAccessibleName("lbl_Logo");

        getContentPane().add(nav, java.awt.BorderLayout.PAGE_START);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        body.setMaximumSize(new java.awt.Dimension(1070, 670));
        body.setMinimumSize(new java.awt.Dimension(1070, 670));
        body.setPreferredSize(new java.awt.Dimension(1070, 670));

        pnl_body.setBackground(new java.awt.Color(31, 41, 55));
        pnl_body.setPreferredSize(new java.awt.Dimension(1080, 4000));
        pnl_body.setLayout(new java.awt.BorderLayout());

        hero.setBackground(new java.awt.Color(31, 41, 55));
        hero.setMaximumSize(new java.awt.Dimension(1920, 1080));
        hero.setMinimumSize(new java.awt.Dimension(1080, 300));
        hero.setPreferredSize(new java.awt.Dimension(1080, 300));
        hero.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_movieRatings.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        lbl_movieRatings.setForeground(new java.awt.Color(229, 231, 235));
        lbl_movieRatings.setText("<html>0.0 / 10</html>");
        jPanel1.add(lbl_movieRatings, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 80, 20));

        lbl_movieDescription.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        lbl_movieDescription.setForeground(new java.awt.Color(229, 231, 235));
        lbl_movieDescription.setText("<html> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. . </html>");
        jPanel1.add(lbl_movieDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 470, 90));

        lbl_movieTitle.setFont(new java.awt.Font("Cascadia Mono", 1, 24)); // NOI18N
        lbl_movieTitle.setForeground(new java.awt.Color(229, 231, 235));
        lbl_movieTitle.setText("<html> Movie Title</html>");
        jPanel1.add(lbl_movieTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 310, 90));

        lbl_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/placeholders/1080x300.png"))); // NOI18N
        jPanel1.add(lbl_bgImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        hero.add(jPanel1, new java.awt.GridBagConstraints());

        pnl_body.add(hero, java.awt.BorderLayout.PAGE_START);

        main.setBackground(new java.awt.Color(31, 41, 55));
        main.setPreferredSize(new java.awt.Dimension(1077, 1080));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0);
        flowLayout1.setAlignOnBaseline(true);
        main.setLayout(flowLayout1);
        pnl_body.add(main, java.awt.BorderLayout.CENTER);

        body.setViewportView(pnl_body);

        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleName("MainFrame");
        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane body;
    private javax.swing.JPanel hero;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Logo;
    private javax.swing.JLabel lbl_bgImg;
    private javax.swing.JLabel lbl_movieDescription;
    private javax.swing.JLabel lbl_movieRatings;
    private javax.swing.JLabel lbl_movieTitle;
    private javax.swing.JPanel main;
    private javax.swing.JPanel nav;
    private javax.swing.JPanel pnl_body;
    // End of variables declaration//GEN-END:variables

    private void Discover_Movies(String movieURL) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                  .url(movieURL)
                  .get()
                  .addHeader("accept", "application/json")
                  .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NDAxZWJiYTI1OThhNzUwYTcxNGM1NzcyZWQwNWE4MiIsInN1YiI6IjY2MTk3YTZkZTRjOWViMDE0OTJhM2EyZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.MIhpoHFGzh7zeoF8xdVRzh1wIxJ10CfnR7cKpS0PPk8")
                  .build();

        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            if (responseBody != null) {
                String jsonData = responseBody.string();
                JSONObject jsonResponse = new JSONObject(jsonData);
                JSONArray results = jsonResponse.getJSONArray("results");
                for (int i = 0; i < results.length(); i++) {
                    JSONObject movie = results.getJSONObject(i);

                    String title = movie.getString("title");
                    String posterPath = movie.getString("poster_path");
                    String overview = movie.getString("overview");

                    String posterPathURL = "https://image.tmdb.org/t/p/w500" + posterPath;
                    int movieID = movie.getInt("id");
                    JSONArray genres = movie.getJSONArray("genre_ids");
                    System.out.println("Title: " + title);
                    System.out.println("ID: " + movieID);
                    System.out.println("Genres: " + genres);
                    System.out.println("Path: " + posterPathURL);
                    System.out.println("Overview: " + overview);
                    System.out.println("-------------------------------------");

                }
            }

        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Discover_TV(String TVUrl) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                  .url(TVUrl)
                  .get()
                  .addHeader("accept", "application/json")
                  .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NDAxZWJiYTI1OThhNzUwYTcxNGM1NzcyZWQwNWE4MiIsInN1YiI6IjY2MTk3YTZkZTRjOWViMDE0OTJhM2EyZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.MIhpoHFGzh7zeoF8xdVRzh1wIxJ10CfnR7cKpS0PPk8")
                  .build();

        try {
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();

            if (responseBody != null) {
                String jsonData = responseBody.string();
                JSONObject jsonResponse = new JSONObject(jsonData);
                JSONArray results = jsonResponse.getJSONArray("results");

                SetBGPoster(results);

                for (int i = 0; i < results.length(); i++) {
                    JSONObject movie = results.getJSONObject(i);
                    String title = movie.getString("name");
                    String posterPath = movie.getString("poster_path");
                    String posterPathURL = "https://image.tmdb.org/t/p/w500" + posterPath;
//                    System.out.println("Title: " + title);
//                    System.out.println("Path: " + posterPathURL);

                }
            }

        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void SetBGPoster(JSONArray results) throws IOException {
        ArrayList<JSONObject> TVList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < results.length(); i++) {
            JSONObject movie = results.getJSONObject(i);
            TVList.add(movie);
        }

        int randomIndex = random.nextInt(TVList.size());
        JSONObject randomElement = TVList.get(randomIndex);
        String posterPath = requestPoster(randomElement.getInt("id"));
        String posterPathURL = "https://image.tmdb.org/t/p/w500" + posterPath;

        try {
            URL posterUrl = new URL(posterPathURL);
            BufferedImage originalImage = ImageIO.read(posterUrl);

            // Desired width and height
            int desiredWidth = 1080;
            int desiredHeight = 300;

            // Calculate the aspect ratio of the original image
            double aspectRatio = (double) originalImage.getWidth() / originalImage.getHeight();

            // Calculate the desired width and height based on the aspect ratio
            int targetWidth = (int) Math.round(desiredHeight * aspectRatio);
            int targetHeight = (int) Math.round(desiredWidth / aspectRatio);

            // Determine which dimension to crop
            int cropX = 0;
            int cropY = 0;
            int cropWidth = originalImage.getWidth();
            int cropHeight = originalImage.getHeight();
            if (targetWidth > desiredWidth) {
                cropWidth = (int) Math.round(originalImage.getHeight() * (desiredWidth / (double) targetWidth));
                cropX = (originalImage.getWidth() - cropWidth) / 2;
            } else {
                cropHeight = (int) Math.round(originalImage.getWidth() * (desiredHeight / (double) targetHeight));
                cropY = (originalImage.getHeight() - cropHeight) / 2;
            }

            // Crop the image
            BufferedImage croppedImage = originalImage.getSubimage(cropX, cropY, cropWidth, cropHeight);

            // Scale the cropped image to fit within the desired dimensions
            Image scaledImage = croppedImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);

            // Create a new ImageIcon with the scaled image
            ImageIcon icon = new ImageIcon(scaledImage);

            // Set the ImageIcon to the JLabel
            lbl_bgImg.setIcon(icon);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String requestPoster(int movieId) throws IOException {
        OkHttpClient client = new OkHttpClient();

        String url = "https://api.themoviedb.org/3/tv/" + movieId + "/images";

        Request request = new Request.Builder()
                  .url(url)
                  .get()
                  .addHeader("accept", "application/json")
                  .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NDAxZWJiYTI1OThhNzUwYTcxNGM1NzcyZWQwNWE4MiIsInN1YiI6IjY2MTk3YTZkZTRjOWViMDE0OTJhM2EyZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.MIhpoHFGzh7zeoF8xdVRzh1wIxJ10CfnR7cKpS0PPk8")
                  .build();

        // Execute the request and handle the response
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }
            String responseBody = response.body().string();

            if (responseBody != null) {
                String jsonData = responseBody;
                JSONObject jsonResponse = new JSONObject(jsonData);
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
}
