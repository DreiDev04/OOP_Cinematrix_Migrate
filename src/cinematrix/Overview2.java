package cinematrix;

import backend.Database;
import backend.Session;
import org.json.JSONObject;
import cinematrix.API_Key.TmdbClient;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Overview2 extends javax.swing.JFrame {

    TmdbClient apiClient = new TmdbClient();
    private Database db = new Database();
    private Session _currUser;
    private String _movieID;

    public Overview2(int movieID, Session currUser) throws IOException {
        _currUser = currUser;
        _movieID = String.valueOf(movieID);

        initComponents();

        System.out.println(movieID);
        JSONObject response = apiClient.searchID(movieID);

        lbl_overviewTitle.setText("<html>" + response.getString("original_title") + "<html>");
        lbl_overviewDescription.setText("<html>" + response.getString("overview") + "</html>");
        lbl_overviewRating.setText("Rating:" + response.get("vote_average").toString());
        lbl_overviewTime.setText("Duration: " + response.get("runtime"));
        lbl_overviewReleaseDate.setText(response.getString("release_date"));

        String posterPathURL = "";
        String backdropPath = response.optString("backdrop_path", "");
        if (!backdropPath.isEmpty()) {
            posterPathURL = "https://image.tmdb.org/t/p/w500" + backdropPath;
            BufferedImage image = ImageIO.read(new URL(posterPathURL));
            lbl_overvierPoster.setIcon(new ImageIcon(image));
        } else {
            lbl_overvierPoster.setText("No Poster");
            lbl_overvierPoster.setForeground(Color.white);
            lbl_overvierPoster.setFont(new Font("Cascadia Code", Font.BOLD, 14));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_overvierPoster = new javax.swing.JLabel();
        lbl_overviewPoster = new javax.swing.JPanel();
        lbl_overviewTitle = new javax.swing.JLabel();
        lbl_overviewReleaseDate = new javax.swing.JLabel();
        lbl_overviewTime = new javax.swing.JLabel();
        lbl_overviewRating = new javax.swing.JLabel();
        btn_overviewExitBtn = new javax.swing.JButton();
        lbl_overviewDescription = new javax.swing.JLabel();
        btn_removeFav = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 255, 51));
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 700));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 700));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(55, 65, 81));
        jPanel2.setPreferredSize(new java.awt.Dimension(600, 300));
        jPanel2.setLayout(new java.awt.GridBagLayout());
        jPanel2.add(lbl_overvierPoster, new java.awt.GridBagConstraints());

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        lbl_overviewPoster.setBackground(new java.awt.Color(38, 43, 48));
        lbl_overviewPoster.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_overviewTitle.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        lbl_overviewTitle.setForeground(new java.awt.Color(229, 231, 235));
        lbl_overviewTitle.setText("Tittle Movie");
        lbl_overviewPoster.add(lbl_overviewTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 560, -1));
        lbl_overviewTitle.getAccessibleContext().setAccessibleName("lbl_overviewTitle");

        lbl_overviewReleaseDate.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        lbl_overviewReleaseDate.setForeground(new java.awt.Color(229, 231, 235));
        lbl_overviewReleaseDate.setText("Release Date:");
        lbl_overviewPoster.add(lbl_overviewReleaseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 350, 20));
        lbl_overviewReleaseDate.getAccessibleContext().setAccessibleName("lbl_overviewYear");

        lbl_overviewTime.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        lbl_overviewTime.setForeground(new java.awt.Color(229, 231, 235));
        lbl_overviewTime.setText("Duration:");
        lbl_overviewPoster.add(lbl_overviewTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 350, -1));
        lbl_overviewTime.getAccessibleContext().setAccessibleName("lbl_overviewGenre");

        lbl_overviewRating.setFont(new java.awt.Font("Cascadia Code", 1, 14)); // NOI18N
        lbl_overviewRating.setForeground(new java.awt.Color(229, 231, 235));
        lbl_overviewRating.setText("Rating: ");
        lbl_overviewPoster.add(lbl_overviewRating, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 280, -1));
        lbl_overviewRating.getAccessibleContext().setAccessibleName("lbl_overviewTime");

        btn_overviewExitBtn.setText("Close");
        btn_overviewExitBtn.setBorder(null);
        btn_overviewExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_overviewExitBtnActionPerformed(evt);
            }
        });
        lbl_overviewPoster.add(btn_overviewExitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 60, 30));
        btn_overviewExitBtn.getAccessibleContext().setAccessibleName("btn_overviewExitBtn");

        lbl_overviewDescription.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        lbl_overviewDescription.setForeground(new java.awt.Color(229, 231, 235));
        lbl_overviewDescription.setText("<html>In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document or a typeface without relying on meaningful content. Lorem ipsum may be used as a placeholder before the final copy is available.</html>");
        lbl_overviewDescription.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbl_overviewPoster.add(lbl_overviewDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 570, 200));

        btn_removeFav.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        btn_removeFav.setText("Remove");
        btn_removeFav.setBorder(null);
        btn_removeFav.setPreferredSize(new java.awt.Dimension(110, 30));
        btn_removeFav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_removeFavMouseClicked(evt);
            }
        });
        btn_removeFav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeFavActionPerformed(evt);
            }
        });
        lbl_overviewPoster.add(btn_removeFav, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        jPanel1.add(lbl_overviewPoster, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_overviewExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_overviewExitBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_overviewExitBtnActionPerformed

    private void btn_removeFavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_removeFavMouseClicked
        if (_movieID != null) {
            if (db.isMovieAlreadyInFavorites(_currUser.getUserUID(), _movieID)) {
                db.removeFavorites(_currUser.getUserUID(), _movieID);
                JOptionPane.showMessageDialog(null, "Movie removed from favorites.");
            } else {
                JOptionPane.showMessageDialog(null, "Movie not found in favorites.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Movie ID is null.");
        }

    }//GEN-LAST:event_btn_removeFavMouseClicked

    private void btn_removeFavActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeFavActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_removeFavActionPerformed

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
            java.util.logging.Logger.getLogger(Overview2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Overview2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Overview2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Overview2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_overviewExitBtn;
    private javax.swing.JButton btn_removeFav;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_overvierPoster;
    private javax.swing.JLabel lbl_overviewDescription;
    private javax.swing.JPanel lbl_overviewPoster;
    private javax.swing.JLabel lbl_overviewRating;
    private javax.swing.JLabel lbl_overviewReleaseDate;
    private javax.swing.JLabel lbl_overviewTime;
    private javax.swing.JLabel lbl_overviewTitle;
    // End of variables declaration//GEN-END:variables

    
}
