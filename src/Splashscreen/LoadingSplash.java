package Splashscreen;

import backend.Session;
import cinematrix.MainFrame;
import javax.swing.SwingUtilities;

public class LoadingSplash extends javax.swing.JFrame {
    private Session _session;
    private MainFrame mf;

    public LoadingSplash(Session session) {
        initComponents();
        this._session = session;
        
        mf = new MainFrame(_session, this);
        mf.setVisible(false);
        
        
        
    }
    // </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        BackGroundPanel = new javax.swing.JPanel();
        ProgressBar = new javax.swing.JProgressBar();
        LoadingLabel = new javax.swing.JLabel();
        LoadingValue = new javax.swing.JLabel();
        BackGroundImage = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        BackGroundPanel.setBackground(new java.awt.Color(0, 0, 0));
        BackGroundPanel.setForeground(new java.awt.Color(0, 0, 0));
        BackGroundPanel.setPreferredSize(new java.awt.Dimension(525, 400));
        BackGroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ProgressBar.setBackground(new java.awt.Color(204, 102, 0));
        BackGroundPanel.add(ProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 580, 10));

        LoadingLabel.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        LoadingLabel.setText("LOADING... ");
        BackGroundPanel.add(LoadingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        LoadingValue.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        LoadingValue.setText("0%");
        BackGroundPanel.add(LoadingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, -1, -1));

        BackGroundImage.setBackground(new java.awt.Color(0, 0, 0));
        BackGroundImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Splashscreen/Assets/Untitled design.png"))); // NOI18N
        BackGroundImage.setText("jLabel1");
        BackGroundPanel.add(BackGroundImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackGroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BackGroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void updateProgress(int progress, String message) {
        SwingUtilities.invokeLater(() -> {
            LoadingValue.setText(progress + "%");
            ProgressBar.setValue(progress);
            LoadingLabel.setText(message);
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGroundImage;
    private javax.swing.JPanel BackGroundPanel;
    public javax.swing.JLabel LoadingLabel;
    public javax.swing.JLabel LoadingValue;
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JFrame jFrame1;
    // End of variables declaration//GEN-END:variables
}
