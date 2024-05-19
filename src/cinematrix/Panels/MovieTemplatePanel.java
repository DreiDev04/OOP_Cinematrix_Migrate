
package cinematrix.Panels;

import backend.Database;
import backend.FavoritesTemplate;
import backend.Session;
import cinematrix.Overview;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.UUID;


public class MovieTemplatePanel extends javax.swing.JPanel {

    public MovieTemplatePanel(JSONObject movie) throws MalformedURLException, IOException {
        initComponents();
        
        
        System.out.println(movie);
        lbl_movieTitle.setText(movie.getString("title"));
        lbl_movieRating.setText("ratings: " + movie.getDouble("vote_average"));
        
        
        String posterPathURL = "https://image.tmdb.org/t/p/w500" + movie.getString("poster_path");
                  
        URL posterUrl = new URL(posterPathURL);
        BufferedImage originalImage = ImageIO.read(posterUrl);
        ImageIcon icon = new ImageIcon(originalImage);
        
        int desiredWidth = 170;
        int desiredHeight = 190;
        Image resizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        
        lbl_moviePoster.setIcon(resizedIcon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_poster = new javax.swing.JPanel();
        lbl_moviePoster = new javax.swing.JLabel();
        pnl_title = new javax.swing.JPanel();
        lbl_movieRating = new javax.swing.JLabel();
        lbl_movieTitle = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 153, 153));
        setForeground(new java.awt.Color(153, 153, 153));
        setMaximumSize(new java.awt.Dimension(170, 240));
        setMinimumSize(new java.awt.Dimension(170, 240));
        setPreferredSize(new java.awt.Dimension(170, 240));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_poster.setBackground(new java.awt.Color(153, 153, 153));
        pnl_poster.setMaximumSize(new java.awt.Dimension(170, 190));
        pnl_poster.setMinimumSize(new java.awt.Dimension(170, 190));
        pnl_poster.setPreferredSize(new java.awt.Dimension(170, 190));
        pnl_poster.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_moviePoster.setFont(new java.awt.Font("Dubai", 1, 18)); // NOI18N
        lbl_moviePoster.setText("No Poster Found");
        pnl_poster.add(lbl_moviePoster, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 190));

        add(pnl_poster, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnl_title.setBackground(new java.awt.Color(31, 41, 55));
        pnl_title.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnl_title.setMaximumSize(new java.awt.Dimension(170, 50));
        pnl_title.setMinimumSize(new java.awt.Dimension(170, 50));
        pnl_title.setPreferredSize(new java.awt.Dimension(170, 50));
        pnl_title.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_movieRating.setFont(new java.awt.Font("Cascadia Code", 0, 12)); // NOI18N
        lbl_movieRating.setForeground(new java.awt.Color(229, 231, 235));
        lbl_movieRating.setText("rating: ");
        pnl_title.add(lbl_movieRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 170, 20));

        lbl_movieTitle.setFont(new java.awt.Font("Cascadia Code", 0, 12)); // NOI18N
        lbl_movieTitle.setForeground(new java.awt.Color(229, 231, 235));
        lbl_movieTitle.setText("Movie Title");
        pnl_title.add(lbl_movieTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        add(pnl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_moviePoster;
    private javax.swing.JLabel lbl_movieRating;
    private javax.swing.JLabel lbl_movieTitle;
    private javax.swing.JPanel pnl_poster;
    private javax.swing.JPanel pnl_title;
    // End of variables declaration//GEN-END:variables
}
