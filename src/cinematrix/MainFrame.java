package cinematrix;

import Splashscreen.LoadingSplash;
import backend.Session;
import cinematrix.API_Key.TMDB_api;
import cinematrix.API_Key.TmdbClient;
import cinematrix.Panels.Features;
import cinematrix.Panels.moviepanel;
import cinematrix.custom_ui.CustomScrollBarUI;
import java.awt.Color;
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
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

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
        jcp_main.getVerticalScrollBar().setUI(new CustomScrollBarUI());

        if (currUser == null) {
            throw new IllegalArgumentException("currUser cannot be null");
        }
        _currUser = currUser;

        lbl_username.setText("<html>" + _currUser.getUsername() + "</html>");

        fetchAndDisplayMovies();

    }

    private void fetchAndDisplayMovies() {
        try {

            // Fetch popular movies
            String popularMoviesJson = apiClient.fetchPopularMovies();
            displayMovies(popularMoviesJson, "Popular Movies");
            setMovie(popularMoviesJson);
            // Fetch top-rated movies
            String trendingDay = apiClient.fetchTrendingDay();
            displayMovies(trendingDay, "Trending Today");

            // Fetch upcommingPH movies
            String upcommingPH = apiClient.fetchUpcommingPH();
            displayMovies(upcommingPH, "Up Comming in the Philippines");

            // Fetch top-rated movies
            String topRatedMoviesJson = apiClient.fetchTopRatedMovies();
            displayMovies(topRatedMoviesJson, "Top Rated Movies");

            // Fetch top-rated movies
            String cinemaPH = apiClient.fetchCinemaPH();
            displayMovies(cinemaPH, "Now Showing Movies");

            // KULANG SA TIME SIR KAYA DI TATANGGALIN KO NA TONG NETFLIX
            // Fetch Neflix Series
//            String netflixSeries = apiClient.fetchNetflix();
//            setMovie(netflixSeries);
//            displayMovies(netflixSeries, "Netflix Series");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayMovies(String moviesJson, String title) throws IOException {
        JSONObject jsonObject = new JSONObject(moviesJson);
        JSONArray results = jsonObject.getJSONArray("results");

        main.add(new Features(results, title, loadingSplash, this, _currUser));

    }

    private void setMovie(String moviesJson) throws IOException {
        JSONObject jsonObject = new JSONObject(moviesJson);
        JSONArray results = jsonObject.getJSONArray("results");

        if (results.length() > 0) {
            int randomIndex = (int) (Math.random() * results.length());
            JSONObject randomMovie = results.getJSONObject(randomIndex);

            lbl_movieTitle.setText("<html>" + randomMovie.getString("original_title") + "<html>");
            lbl_movieDescription.setText("<html>" + randomMovie.getString("overview") + "</html>");
            lbl_movieRatings.setText(randomMovie.get("vote_average").toString());

            int movieID = randomMovie.getInt("id");
            String posterPath = apiClient.requestPoster(movieID);

            if (posterPath != null) {
                BufferedImage image = ImageIO.read(new URL(posterPath));
                lbl_bgImg.setIcon(new ImageIcon(image));
            } else {
                // Handle case where posterPath is null
            }
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
        lbl_username = new javax.swing.JLabel();
        lbl_username1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pnl_home = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnl_search = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnl_fav = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pnl_book = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        MainLayeredPane = new javax.swing.JLayeredPane();
        jcp_main = new javax.swing.JScrollPane();
        pnl_body = new javax.swing.JPanel();
        hero = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbl_movieRatings = new javax.swing.JLabel();
        lbl_movieDescription = new javax.swing.JLabel();
        lbl_movieTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_bgImg = new javax.swing.JLabel();
        main = new javax.swing.JPanel();
        jcp_search = new javax.swing.JScrollPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        pnl_searchResult = new javax.swing.JPanel();
        jcp_fav = new javax.swing.JScrollPane();
        favoritesFlowPanel = new javax.swing.JPanel();
        jcp_bookmark = new javax.swing.JScrollPane();
        bookmarkedFlowPanel = new javax.swing.JPanel();

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

        lbl_username.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setText("Welcome!");
        lbl_username.setName(""); // NOI18N
        jPanel3.add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 40));

        lbl_username1.setFont(new java.awt.Font("Candara Light", 1, 14)); // NOI18N
        lbl_username1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username1.setText("Welcome!");
        lbl_username1.setName(""); // NOI18N
        jPanel3.add(lbl_username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 230, 40));

        asidePanel.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(17, 22, 29));
        jPanel4.setMaximumSize(new java.awt.Dimension(250, 300));
        jPanel4.setMinimumSize(new java.awt.Dimension(250, 300));
        jPanel4.setPreferredSize(new java.awt.Dimension(250, 300));

        pnl_home.setBackground(new java.awt.Color(75, 85, 99));
        pnl_home.setMaximumSize(new java.awt.Dimension(250, 50));
        pnl_home.setMinimumSize(new java.awt.Dimension(250, 50));
        pnl_home.setPreferredSize(new java.awt.Dimension(250, 50));
        pnl_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_homeMouseClicked(evt);
            }
        });
        pnl_home.setLayout(new java.awt.BorderLayout());

        jLabel6.setBackground(new java.awt.Color(17, 22, 29));
        jLabel6.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Home");
        pnl_home.add(jLabel6, java.awt.BorderLayout.CENTER);

        jPanel4.add(pnl_home);

        pnl_search.setBackground(new java.awt.Color(75, 85, 99));
        pnl_search.setMaximumSize(new java.awt.Dimension(250, 50));
        pnl_search.setMinimumSize(new java.awt.Dimension(250, 50));
        pnl_search.setPreferredSize(new java.awt.Dimension(250, 50));
        pnl_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_searchMouseClicked(evt);
            }
        });
        pnl_search.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Search");
        pnl_search.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel4.add(pnl_search);

        pnl_fav.setBackground(new java.awt.Color(75, 85, 99));
        pnl_fav.setMaximumSize(new java.awt.Dimension(250, 50));
        pnl_fav.setMinimumSize(new java.awt.Dimension(250, 50));
        pnl_fav.setPreferredSize(new java.awt.Dimension(250, 50));
        pnl_fav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_favMouseClicked(evt);
            }
        });
        pnl_fav.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Favorites");
        pnl_fav.add(jLabel3, java.awt.BorderLayout.CENTER);

        jPanel4.add(pnl_fav);

        pnl_book.setBackground(new java.awt.Color(75, 85, 99));
        pnl_book.setMaximumSize(new java.awt.Dimension(250, 50));
        pnl_book.setMinimumSize(new java.awt.Dimension(250, 50));
        pnl_book.setPreferredSize(new java.awt.Dimension(250, 50));
        pnl_book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_bookMouseClicked(evt);
            }
        });
        pnl_book.setLayout(new java.awt.BorderLayout());

        jLabel4.setBackground(new java.awt.Color(17, 22, 29));
        jLabel4.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Bookmark");
        pnl_book.add(jLabel4, java.awt.BorderLayout.CENTER);

        jPanel4.add(pnl_book);

        asidePanel.add(jPanel4);

        getContentPane().add(asidePanel, java.awt.BorderLayout.WEST);

        MainLayeredPane.setBackground(new java.awt.Color(31, 41, 55));
        MainLayeredPane.setForeground(new java.awt.Color(31, 41, 55));
        MainLayeredPane.setMaximumSize(new java.awt.Dimension(1080, 32767));
        MainLayeredPane.setMinimumSize(new java.awt.Dimension(1080, 0));
        MainLayeredPane.setPreferredSize(new java.awt.Dimension(1080, 100));
        MainLayeredPane.setLayout(new java.awt.CardLayout());

        jcp_main.setBackground(new java.awt.Color(31, 41, 55));
        jcp_main.setForeground(new java.awt.Color(31, 41, 55));
        jcp_main.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jcp_main.setMaximumSize(new java.awt.Dimension(1080, 670));
        jcp_main.setMinimumSize(new java.awt.Dimension(1080, 670));
        jcp_main.setPreferredSize(new java.awt.Dimension(1080, 670));

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

        jcp_main.setViewportView(pnl_body);

        MainLayeredPane.setLayer(jcp_main, javax.swing.JLayeredPane.PALETTE_LAYER);
        MainLayeredPane.add(jcp_main, "card2");

        jcp_search.setBackground(new java.awt.Color(31, 41, 55));
        jcp_search.setMinimumSize(new java.awt.Dimension(580, 100));
        jcp_search.setPreferredSize(new java.awt.Dimension(580, 100));

        jPanel10.setBackground(new java.awt.Color(31, 41, 55));
        jPanel10.setPreferredSize(new java.awt.Dimension(580, 1000));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(17, 22, 29));
        jPanel8.setMaximumSize(new java.awt.Dimension(100, 75));
        jPanel8.setMinimumSize(new java.awt.Dimension(100, 75));
        jPanel8.setPreferredSize(new java.awt.Dimension(100, 75));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(75, 85, 99));
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(107, 114, 128)));
        jTextField1.setMaximumSize(new java.awt.Dimension(300, 30));
        jTextField1.setMinimumSize(new java.awt.Dimension(300, 30));
        jTextField1.setName(""); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel8.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 40));

        btn_search.setBackground(new java.awt.Color(75, 85, 99));
        btn_search.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
        btn_search.setText("Search");
        btn_search.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btn_search.setMaximumSize(new java.awt.Dimension(100, 30));
        btn_search.setMinimumSize(new java.awt.Dimension(100, 30));
        btn_search.setPreferredSize(new java.awt.Dimension(100, 30));
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchMouseClicked(evt);
            }
        });
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel8.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, 40));

        jPanel10.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        pnl_searchResult.setBackground(new java.awt.Color(31, 41, 55));
        pnl_searchResult.setMaximumSize(new java.awt.Dimension(580, 3000));
        pnl_searchResult.setMinimumSize(new java.awt.Dimension(580, 100));
        pnl_searchResult.setPreferredSize(new java.awt.Dimension(580, 1000));
        jPanel10.add(pnl_searchResult, java.awt.BorderLayout.CENTER);

        jcp_search.setViewportView(jPanel10);

        MainLayeredPane.setLayer(jcp_search, javax.swing.JLayeredPane.PALETTE_LAYER);
        MainLayeredPane.add(jcp_search, "card3");

        favoritesFlowPanel.setBackground(new java.awt.Color(31, 41, 55));
        jcp_fav.setViewportView(favoritesFlowPanel);

        MainLayeredPane.add(jcp_fav, "card4");

        bookmarkedFlowPanel.setBackground(new java.awt.Color(31, 41, 55));
        jcp_bookmark.setViewportView(bookmarkedFlowPanel);

        MainLayeredPane.add(jcp_bookmark, "card5");

        getContentPane().add(MainLayeredPane, java.awt.BorderLayout.CENTER);

        getAccessibleContext().setAccessibleName("MainFrame");
        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnl_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_searchMouseClicked
        System.out.println("Search");
        MainLayeredPane.removeAll();
        MainLayeredPane.add(jcp_search);
        MainLayeredPane.repaint();
        MainLayeredPane.revalidate();
    }//GEN-LAST:event_pnl_searchMouseClicked

    private void pnl_favMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_favMouseClicked
        System.out.println("Favorite");
        MainLayeredPane.removeAll();
        MainLayeredPane.add(jcp_fav);
        MainLayeredPane.repaint();
        MainLayeredPane.revalidate();
    }//GEN-LAST:event_pnl_favMouseClicked

    private void pnl_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_bookMouseClicked
        System.out.println("Bookmark");
        MainLayeredPane.removeAll();
        MainLayeredPane.add(jcp_bookmark);
        MainLayeredPane.repaint();
        MainLayeredPane.revalidate();
    }//GEN-LAST:event_pnl_bookMouseClicked

    private void pnl_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_homeMouseClicked
        System.out.println("Home");
        MainLayeredPane.removeAll();
        MainLayeredPane.add(jcp_main);
        MainLayeredPane.repaint();
        MainLayeredPane.revalidate();
    }//GEN-LAST:event_pnl_homeMouseClicked

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        pnl_searchResult.removeAll();
        String query = jTextField1.getText().toString();
        try {
            JSONObject searchResult = apiClient.querySearch(query);
            JSONArray results = searchResult.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {
                JSONObject movie = results.getJSONObject(i);
                JPanel panel = new moviepanel(movie, _currUser);
                panel.setBackground(new Color(0x374151, false));
                pnl_searchResult.add(panel);
            }

            // Repaint and revalidate the search result panel to reflect the changes
            pnl_searchResult.revalidate();
            pnl_searchResult.repaint();
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_searchMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchActionPerformed

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
    private javax.swing.JPanel bookmarkedFlowPanel;
    private javax.swing.JButton btn_search;
    private javax.swing.JPanel favoritesFlowPanel;
    private javax.swing.JPanel hero;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane jcp_bookmark;
    private javax.swing.JScrollPane jcp_fav;
    private javax.swing.JScrollPane jcp_main;
    private javax.swing.JScrollPane jcp_search;
    private javax.swing.JLabel lbl_Logo;
    private javax.swing.JLabel lbl_bgImg;
    private javax.swing.JLabel lbl_movieDescription;
    private javax.swing.JLabel lbl_movieRatings;
    private javax.swing.JLabel lbl_movieTitle;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JLabel lbl_username1;
    private javax.swing.JPanel main;
    private javax.swing.JPanel nav;
    private javax.swing.JPanel pnl_body;
    private javax.swing.JPanel pnl_book;
    private javax.swing.JPanel pnl_fav;
    private javax.swing.JPanel pnl_home;
    private javax.swing.JPanel pnl_search;
    private javax.swing.JPanel pnl_searchResult;
    // End of variables declaration//GEN-END:variables

}
