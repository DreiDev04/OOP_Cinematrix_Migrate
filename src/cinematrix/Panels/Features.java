
package cinematrix.Panels;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JPanel;
import org.json.JSONArray;
import org.json.JSONObject;

import cinematrix.custom_ui.CustomScrollBarUI;

public class Features extends javax.swing.JPanel {

    public Features(JSONArray results, String title) throws IOException {
        initComponents();
        lbl_featureTitle.setText(title);
        
        jScrollPane1.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        jScrollPane1.getHorizontalScrollBar().setUI(new CustomScrollBarUI());
        
        for (int i = 0; i < results.length(); i++) {
            JSONObject movie = results.getJSONObject(i);
            JPanel panel = new moviepanel(movie);
            panel.setBackground(new Color(0x374151, false));
            
            pnl_carousel.add(panel);
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
        lbl_featureTitle.setForeground(new java.awt.Color(229, 231, 235));
        lbl_featureTitle.setText("<Feature Title>");
        add(lbl_featureTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1080, 100));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1080, 100));

        pnl_carousel.setBackground(new java.awt.Color(31, 41, 55));
        pnl_carousel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 0));
        jScrollPane1.setViewportView(pnl_carousel);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 1000, 280));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_featureTitle;
    private javax.swing.JPanel pnl_carousel;
    // End of variables declaration//GEN-END:variables
}
