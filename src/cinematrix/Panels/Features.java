package cinematrix.Panels;

import Splashscreen.LoadingSplash;
import backend.Session;
import cinematrix.MainFrame;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JPanel;
import org.json.JSONArray;
import org.json.JSONObject;

import cinematrix.custom_ui.CustomScrollBarUI;
import javax.swing.JOptionPane;

public class Features extends javax.swing.JPanel {

    LoadingSplash loadingSplash;
    MainFrame mainFrame;
    Session _currUser;

    public Features(JSONArray results, String title, LoadingSplash ls, MainFrame mf, Session currUser) throws IOException {
        initComponents();
        loadingSplash = ls;
        mainFrame = mf;
        this._currUser = currUser;
        lbl_featureTitle.setText(title);

        jScrollPane1.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
        java.awt.EventQueue.invokeLater(() -> {
            new Thread(() -> {
                try {
                    int totalItems = results.length();
                    for (int i = 0; i < totalItems; i++) {
                        JSONObject movie = results.getJSONObject(i);
                        JPanel panel = new moviepanel(movie, _currUser);
                        panel.setBackground(new Color(0x374151, false));
                        pnl_carousel.add(panel);

                        double progress = (double) (i + 1) / totalItems * 100;
                        loadingSplash.updateProgress((int) progress, getMessageForProgress((int) progress));

                    }
                    loadingSplash.setVisible(false);
                    mainFrame.setVisible(true);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                    System.out.println(e);
                }
            }).start();

        });
    }
    private static String getMessageForProgress(int progress) {
        if (progress >= 0 && progress < 10) {
            return "Initializing...";
        } else if (progress >= 10 && progress < 20) {
            return "Turning On Modules...";
        } else if (progress >= 20 && progress < 50) {
            return "Loading Modules...";
        } else if (progress >= 50 && progress < 70) {
            return "Connecting to Database...";
        } else if (progress >= 70 && progress < 80) {
            return "Connection Successful...";
        } else if (progress >= 80 && progress < 100) {
            return "Launching Application...";
        } else {
            return "Loading...";
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_featureTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnl_carousel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(31, 41, 55));
        setMaximumSize(new java.awt.Dimension(1080, 400));
        setMinimumSize(new java.awt.Dimension(1080, 400));
        setPreferredSize(new java.awt.Dimension(1080, 400));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_featureTitle.setFont(new java.awt.Font("Cascadia Mono", 1, 24)); // NOI18N
        lbl_featureTitle.setForeground(new java.awt.Color(204, 204, 204));
        lbl_featureTitle.setText("<Feature Title>");
        add(lbl_featureTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, -1));

        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1080, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1080, 100));

        pnl_carousel.setBackground(new java.awt.Color(31, 41, 55));
        pnl_carousel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 0));
        jScrollPane1.setViewportView(pnl_carousel);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 950, 280));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_featureTitle;
    private javax.swing.JPanel pnl_carousel;
    // End of variables declaration//GEN-END:variables
}
