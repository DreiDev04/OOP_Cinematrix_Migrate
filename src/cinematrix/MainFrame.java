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
import javax.swing.Icon;

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
            String trendingDay = apiClient.fetchTrendingDay();
            displayMovies(trendingDay, "Trending Today");

            // Fetch upcommingPH movies
            String upcommingPH = apiClient.fetchUpcommingPH();
            displayMovies(upcommingPH, "Up Comming in the Philippines");

            // Fetch top-rated movies
            String topRatedMoviesJson = apiClient.fetchTopRatedMovies();
            displayMovies(topRatedMoviesJson, "Top Rated Movies");

            // Fetch Neflix Series
            String netflixSeries = apiClient.fetchNetflix();
            setMovie(netflixSeries);
            displayMovies(netflixSeries, "Netflix Series");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayMovies(String moviesJson, String title) throws IOException {
        JSONObject jsonObject = new JSONObject(moviesJson);
        JSONArray results = jsonObject.getJSONArray("results");

        main.add(new Features(results, title, loadingSplash, this));

    }

    private void setMovie(String moviesJson) throws IOException {
        JSONObject jsonObject = new JSONObject(moviesJson);
        JSONArray results = jsonObject.getJSONArray("results");

        if (results.length() > 0) {
            int randomIndex = (int) (Math.random() * results.length());
            JSONObject randomMovie = results.getJSONObject(randomIndex);

            lbl_movieTitle.setText("<html>" + randomMovie.getString("original_name")+ "<html>");
            lbl_movieDescription.setText("<html>" + randomMovie.getString("overview") + "</html>");
            lbl_movieRatings.setText(randomMovie.get("vote_average").toString());

            int movieID = randomMovie.getInt("id");
            String posterPath = apiClient.requestPoster(movieID);
            
            BufferedImage image = ImageIO.read(new URL(posterPath));
            
            lbl_bgImg.setIcon(new ImageIcon(image));

        }
    }

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        nav = new javax.swing.JPanel();
        lbl_Logo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        asidePanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        MainLayeredPane = new javax.swing.JLayeredPane();
        body = new javax.swing.JScrollPane();
        pnl_body = new javax.swing.JPanel();
        hero = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbl_movieRatings = new javax.swing.JLabel();
        lbl_movieDescription = new javax.swing.JLabel();
        lbl_movieTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_bgImg = new javax.swing.JLabel();
        main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cinematrix");
        setBackground(new java.awt.Color(31, 41, 55));
        setMaximumSize(new java.awt.Dimension(1080, 720));
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setPreferredSize(new java.awt.Dimension(1080, 720));

        nav.setBackground(new java.awt.Color(17, 24, 39));
        nav.setForeground(new java.awt.Color(31, 41, 55));
        nav.setMaximumSize(new java.awt.Dimension(1070, 50));
        nav.setMinimumSize(new java.awt.Dimension(1070, 50));
        nav.setPreferredSize(new java.awt.Dimension(1070, 50));
        java.awt.GridBagLayout navLayout = new java.awt.GridBagLayout();
        navLayout.columnWidths = new int[] {0};
        navLayout.columnWeights = new double[] {1.0};
        nav.setLayout(navLayout);

        lbl_Logo.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 36)); // NOI18N
        lbl_Logo.setForeground(new java.awt.Color(229, 231, 235));
        lbl_Logo.setText("CineMatrix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 70, 0, 0);
        nav.add(lbl_Logo, gridBagConstraints);
        lbl_Logo.getAccessibleContext().setAccessibleName("lbl_Logo");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Log out");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        nav.add(jLabel5, gridBagConstraints);

        getContentPane().add(nav, java.awt.BorderLayout.PAGE_START);

        asidePanel.setBackground(new java.awt.Color(17, 22, 29));
        asidePanel.setMaximumSize(new java.awt.Dimension(250, 10));
        asidePanel.setMinimumSize(new java.awt.Dimension(50, 10));
        asidePanel.setPreferredSize(new java.awt.Dimension(250, 10));

        jPanel3.setBackground(new java.awt.Color(17, 22, 29));
        jPanel3.setMaximumSize(new java.awt.Dimension(250, 75));
        jPanel3.setMinimumSize(new java.awt.Dimension(250, 75));
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 75));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<Username>");
        jLabel1.setName(""); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 180, 30));

        asidePanel.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(17, 22, 29));
        jPanel4.setMaximumSize(new java.awt.Dimension(250, 300));
        jPanel4.setMinimumSize(new java.awt.Dimension(250, 300));
        jPanel4.setPreferredSize(new java.awt.Dimension(250, 300));

        jPanel5.setBackground(new java.awt.Color(75, 85, 99));
        jPanel5.setMaximumSize(new java.awt.Dimension(250, 50));
        jPanel5.setMinimumSize(new java.awt.Dimension(250, 50));
        jPanel5.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search");
        jPanel5.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(75, 85, 99));
        jPanel6.setMaximumSize(new java.awt.Dimension(250, 50));
        jPanel6.setMinimumSize(new java.awt.Dimension(250, 50));
        jPanel6.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Favorites");
        jPanel6.add(jLabel3, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(75, 85, 99));
        jPanel7.setMaximumSize(new java.awt.Dimension(250, 50));
        jPanel7.setMinimumSize(new java.awt.Dimension(250, 50));
        jPanel7.setPreferredSize(new java.awt.Dimension(250, 50));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel4.setBackground(new java.awt.Color(17, 22, 29));
        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Bookmark");
        jPanel7.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel7);

        asidePanel.add(jPanel4);

        getContentPane().add(asidePanel, java.awt.BorderLayout.WEST);

        MainLayeredPane.setBackground(new java.awt.Color(31, 41, 55));
        MainLayeredPane.setForeground(new java.awt.Color(31, 41, 55));
        MainLayeredPane.setMaximumSize(new java.awt.Dimension(1080, 32767));
        MainLayeredPane.setMinimumSize(new java.awt.Dimension(1080, 0));
        MainLayeredPane.setPreferredSize(new java.awt.Dimension(1080, 100));
        MainLayeredPane.setLayout(new java.awt.BorderLayout());

        body.setBackground(new java.awt.Color(31, 41, 55));
        body.setForeground(new java.awt.Color(31, 41, 55));
        body.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        body.setMaximumSize(new java.awt.Dimension(1080, 670));
        body.setMinimumSize(new java.awt.Dimension(1080, 670));
        body.setPreferredSize(new java.awt.Dimension(1080, 670));

        pnl_body.setBackground(new java.awt.Color(31, 41, 55));
        pnl_body.setForeground(new java.awt.Color(31, 41, 55));
        pnl_body.setPreferredSize(new java.awt.Dimension(1080, 4000));
        pnl_body.setLayout(new java.awt.BorderLayout());

        hero.setBackground(new java.awt.Color(31, 41, 55));
        hero.setForeground(new java.awt.Color(31, 41, 55));
        hero.setMaximumSize(new java.awt.Dimension(1920, 1080));
        hero.setMinimumSize(new java.awt.Dimension(1080, 300));
        hero.setPreferredSize(new java.awt.Dimension(1080, 300));
        hero.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(31, 41, 55));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(540, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(540, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(540, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_movieRatings.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        lbl_movieRatings.setForeground(new java.awt.Color(229, 231, 235));
        lbl_movieRatings.setText("<html>0.0 / 10</html>");
        jPanel1.add(lbl_movieRatings, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 80, 20));

        lbl_movieDescription.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        lbl_movieDescription.setForeground(new java.awt.Color(229, 231, 235));
        lbl_movieDescription.setText("<html> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. . </html>");
        jPanel1.add(lbl_movieDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 450, 150));

        lbl_movieTitle.setFont(new java.awt.Font("Cascadia Mono", 1, 24)); // NOI18N
        lbl_movieTitle.setForeground(new java.awt.Color(229, 231, 235));
        lbl_movieTitle.setText("<html> Movie Title</html>");
        jPanel1.add(lbl_movieTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 440, 140));

        hero.add(jPanel1, new java.awt.GridBagConstraints());

        jPanel2.setBackground(new java.awt.Color(31, 41, 55));
        jPanel2.setForeground(new java.awt.Color(31, 41, 55));
        jPanel2.setMaximumSize(new java.awt.Dimension(540, 300));
        jPanel2.setMinimumSize(new java.awt.Dimension(540, 300));
        jPanel2.setPreferredSize(new java.awt.Dimension(540, 300));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_bgImg.setForeground(new java.awt.Color(0, 102, 102));
        lbl_bgImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/placeholders/1080x300.png"))); // NOI18N
        lbl_bgImg.setMaximumSize(new java.awt.Dimension(540, 300));
        lbl_bgImg.setMinimumSize(new java.awt.Dimension(540, 300));
        lbl_bgImg.setPreferredSize(new java.awt.Dimension(540, 300));
        jPanel2.add(lbl_bgImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 310));

        hero.add(jPanel2, new java.awt.GridBagConstraints());

        pnl_body.add(hero, java.awt.BorderLayout.PAGE_START);

        main.setBackground(new java.awt.Color(31, 41, 55));
        main.setForeground(new java.awt.Color(31, 41, 55));
        main.setPreferredSize(new java.awt.Dimension(1077, 1080));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0);
        flowLayout1.setAlignOnBaseline(true);
        main.setLayout(flowLayout1);
        pnl_body.add(main, java.awt.BorderLayout.CENTER);

        body.setViewportView(pnl_body);

        MainLayeredPane.add(body, java.awt.BorderLayout.CENTER);

        getContentPane().add(MainLayeredPane, java.awt.BorderLayout.CENTER);

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
    private javax.swing.JLayeredPane MainLayeredPane;
    private javax.swing.JPanel asidePanel;
    private javax.swing.JScrollPane body;
    private javax.swing.JPanel hero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_Logo;
    private javax.swing.JLabel lbl_bgImg;
    private javax.swing.JLabel lbl_movieDescription;
    private javax.swing.JLabel lbl_movieRatings;
    private javax.swing.JLabel lbl_movieTitle;
    private javax.swing.JPanel main;
    private javax.swing.JPanel nav;
    private javax.swing.JPanel pnl_body;
    // End of variables declaration//GEN-END:variables

//    private void Discover_Movies(String movieURL) {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url(movieURL)
//                .get()
//                .addHeader("accept", "application/json")
//                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NDAxZWJiYTI1OThhNzUwYTcxNGM1NzcyZWQwNWE4MiIsInN1YiI6IjY2MTk3YTZkZTRjOWViMDE0OTJhM2EyZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.MIhpoHFGzh7zeoF8xdVRzh1wIxJ10CfnR7cKpS0PPk8")
//                .build();
//
//        try {
//            Response response = client.newCall(request).execute();
//            ResponseBody responseBody = response.body();
//            if (responseBody != null) {
//                String jsonData = responseBody.string();
//                JSONObject jsonResponse = new JSONObject(jsonData);
//                JSONArray results = jsonResponse.getJSONArray("results");
//                for (int i = 0; i < results.length(); i++) {
//                    JSONObject movie = results.getJSONObject(i);
//
//                    String title = movie.getString("title");
//                    String posterPath = movie.getString("poster_path");
//                    String overview = movie.getString("overview");
//
//                    String posterPathURL = "https://image.tmdb.org/t/p/w500" + posterPath;
//                    int movieID = movie.getInt("id");
//                    JSONArray genres = movie.getJSONArray("genre_ids");
//                    System.out.println("Title: " + title);
//                    System.out.println("ID: " + movieID);
//                    System.out.println("Genres: " + genres);
//                    System.out.println("Path: " + posterPathURL);
//                    System.out.println("Overview: " + overview);
//                    System.out.println("-------------------------------------");
//
//                }
//            }
//
//        } catch (IOException ex) {
//            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    private void Discover_TV(String TVUrl) {
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url(TVUrl)
//                .get()
//                .addHeader("accept", "application/json")
//                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NDAxZWJiYTI1OThhNzUwYTcxNGM1NzcyZWQwNWE4MiIsInN1YiI6IjY2MTk3YTZkZTRjOWViMDE0OTJhM2EyZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.MIhpoHFGzh7zeoF8xdVRzh1wIxJ10CfnR7cKpS0PPk8")
//                .build();
//
//        try {
//            Response response = client.newCall(request).execute();
//            ResponseBody responseBody = response.body();
//
//            if (responseBody != null) {
//                String jsonData = responseBody.string();
//                JSONObject jsonResponse = new JSONObject(jsonData);
//                JSONArray results = jsonResponse.getJSONArray("results");
//
//                SetBGPoster(results);
//
//                for (int i = 0; i < results.length(); i++) {
//                    JSONObject movie = results.getJSONObject(i);
//                    String title = movie.getString("name");
//                    String posterPath = movie.getString("poster_path");
//                    String posterPathURL = "https://image.tmdb.org/t/p/w500" + posterPath;
////                    System.out.println("Title: " + title);
////                    System.out.println("Path: " + posterPathURL);
//
//                }
//            }
//
//        } catch (IOException ex) {
//            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public void SetBGPoster(JSONArray results) throws IOException {
//        ArrayList<JSONObject> TVList = new ArrayList<>();
//        Random random = new Random();
//
//        for (int i = 0; i < results.length(); i++) {
//            JSONObject movie = results.getJSONObject(i);
//            TVList.add(movie);
//        }
//
//        int randomIndex = random.nextInt(TVList.size());
//        JSONObject randomElement = TVList.get(randomIndex);
//        String posterPath = requestPoster(randomElement.getInt("id"));
//        String posterPathURL = "https://image.tmdb.org/t/p/w500" + posterPath;
//
//        try {
//            URL posterUrl = new URL(posterPathURL);
//            BufferedImage originalImage = ImageIO.read(posterUrl);
//
//            // Desired width and height
//            int desiredWidth = 1080;
//            int desiredHeight = 300;
//
//            // Calculate the aspect ratio of the original image
//            double aspectRatio = (double) originalImage.getWidth() / originalImage.getHeight();
//
//            // Calculate the desired width and height based on the aspect ratio
//            int targetWidth = (int) Math.round(desiredHeight * aspectRatio);
//            int targetHeight = (int) Math.round(desiredWidth / aspectRatio);
//
//            // Determine which dimension to crop
//            int cropX = 0;
//            int cropY = 0;
//            int cropWidth = originalImage.getWidth();
//            int cropHeight = originalImage.getHeight();
//            if (targetWidth > desiredWidth) {
//                cropWidth = (int) Math.round(originalImage.getHeight() * (desiredWidth / (double) targetWidth));
//                cropX = (originalImage.getWidth() - cropWidth) / 2;
//            } else {
//                cropHeight = (int) Math.round(originalImage.getWidth() * (desiredHeight / (double) targetHeight));
//                cropY = (originalImage.getHeight() - cropHeight) / 2;
//            }
//
//            // Crop the image
//            BufferedImage croppedImage = originalImage.getSubimage(cropX, cropY, cropWidth, cropHeight);
//
//            // Scale the cropped image to fit within the desired dimensions
//            Image scaledImage = croppedImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
//
//            // Create a new ImageIcon with the scaled image
//            ImageIcon icon = new ImageIcon(scaledImage);
//
//            // Set the ImageIcon to the JLabel
//            lbl_bgImg.setIcon(icon);
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public String requestPoster(int movieId) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//
//        String url = "https://api.themoviedb.org/3/tv/" + movieId + "/images";
//
//        Request request = new Request.Builder()
//                .url(url)
//                .get()
//                .addHeader("accept", "application/json")
//                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NDAxZWJiYTI1OThhNzUwYTcxNGM1NzcyZWQwNWE4MiIsInN1YiI6IjY2MTk3YTZkZTRjOWViMDE0OTJhM2EyZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.MIhpoHFGzh7zeoF8xdVRzh1wIxJ10CfnR7cKpS0PPk8")
//                .build();
//
//        // Execute the request and handle the response
//        try (Response response = client.newCall(request).execute()) {
//            if (!response.isSuccessful()) {
//                throw new IOException("Unexpected code " + response);
//            }
//            String responseBody = response.body().string();
//
//            if (responseBody != null) {
//                String jsonData = responseBody;
//                JSONObject jsonResponse = new JSONObject(jsonData);
//                JSONArray results = jsonResponse.getJSONArray("backdrops");
//
//                for (int i = 0; i < results.length(); i++) {
//                    JSONObject bg = results.getJSONObject(i);
//                    if (bg.getDouble("aspect_ratio") >= 1) {
//                        return bg.getString("file_path");
//                    }
//                }
//            }
//        }
//        return null;
//    }
}
