
package cinematrix;

public class Overview extends javax.swing.JFrame {

    public Overview() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_overviewTitle = new javax.swing.JLabel();
        lbl_overviewYear = new javax.swing.JLabel();
        lbl_overviewDescription = new javax.swing.JLabel();
        lbl_overviewGenre = new javax.swing.JLabel();
        lbl_overviewPanel = new javax.swing.JLabel();
        lbl_overviewTime = new javax.swing.JLabel();
        lbl_overviewHeartBtn = new javax.swing.JLabel();
        lbl_overviewSaveBtn = new javax.swing.JLabel();
        lbl_overviewShareBtn = new javax.swing.JLabel();
        btn_overviewExitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        lbl_overviewTitle.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 36)); // NOI18N
        lbl_overviewTitle.setForeground(new java.awt.Color(229, 231, 235));
        lbl_overviewTitle.setText("Tittle Movie");

        lbl_overviewYear.setFont(new java.awt.Font("Cascadia Mono", 1, 24)); // NOI18N
        lbl_overviewYear.setForeground(new java.awt.Color(229, 231, 235));
        lbl_overviewYear.setText("Year:");

        lbl_overviewDescription.setFont(new java.awt.Font("Cascadia Code", 0, 14)); // NOI18N
        lbl_overviewDescription.setForeground(new java.awt.Color(229, 231, 235));
        lbl_overviewDescription.setText("<html> Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. . </html>");

        lbl_overviewGenre.setFont(new java.awt.Font("Cascadia Code", 1, 16)); // NOI18N
        lbl_overviewGenre.setForeground(new java.awt.Color(229, 231, 235));
        lbl_overviewGenre.setText("Genre:");

        lbl_overviewPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/placeholders/620x300.png"))); // NOI18N

        lbl_overviewTime.setFont(new java.awt.Font("Cascadia Code", 1, 16)); // NOI18N
        lbl_overviewTime.setForeground(new java.awt.Color(229, 231, 235));
        lbl_overviewTime.setText("Time:");

        lbl_overviewHeartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/heart.png"))); // NOI18N

        lbl_overviewSaveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/bookmark.png"))); // NOI18N

        lbl_overviewShareBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/shared.png"))); // NOI18N

        btn_overviewExitBtn.setText("jButton1");
        btn_overviewExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_overviewExitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_overviewPanel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_overviewExitBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_overviewYear, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_overviewTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_overviewHeartBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbl_overviewSaveBtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbl_overviewShareBtn)
                            .addGap(33, 33, 33)
                            .addComponent(lbl_overviewTime, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbl_overviewGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_overviewDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_overviewPanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbl_overviewShareBtn)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_overviewHeartBtn)
                                    .addComponent(lbl_overviewSaveBtn)))
                            .addComponent(lbl_overviewTime, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lbl_overviewTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_overviewYear, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_overviewGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lbl_overviewDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_overviewExitBtn)
                .addGap(42, 42, 42))
        );

        lbl_overviewTitle.getAccessibleContext().setAccessibleName("lbl_overviewTitle");
        lbl_overviewYear.getAccessibleContext().setAccessibleName("lbl_overviewYear");
        lbl_overviewDescription.getAccessibleContext().setAccessibleName("lbl_overviewDescription");
        lbl_overviewGenre.getAccessibleContext().setAccessibleName("lbl_overviewGenre");
        lbl_overviewPanel.getAccessibleContext().setAccessibleName("lbl_overviewPanel");
        lbl_overviewTime.getAccessibleContext().setAccessibleName("lbl_overviewTime");
        lbl_overviewHeartBtn.getAccessibleContext().setAccessibleName("lbl_overviewHeartBtn");
        lbl_overviewSaveBtn.getAccessibleContext().setAccessibleName("lbl_overviewSaveBtn");
        lbl_overviewShareBtn.getAccessibleContext().setAccessibleName("lbl_overviewShareBtn");
        btn_overviewExitBtn.getAccessibleContext().setAccessibleName("btn_overviewExitBtn");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_overviewExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_overviewExitBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_overviewExitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Overview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Overview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Overview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Overview.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Overview().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_overviewExitBtn;
    private javax.swing.JLabel lbl_overviewDescription;
    private javax.swing.JLabel lbl_overviewGenre;
    private javax.swing.JLabel lbl_overviewHeartBtn;
    private javax.swing.JLabel lbl_overviewPanel;
    private javax.swing.JLabel lbl_overviewSaveBtn;
    private javax.swing.JLabel lbl_overviewShareBtn;
    private javax.swing.JLabel lbl_overviewTime;
    private javax.swing.JLabel lbl_overviewTitle;
    private javax.swing.JLabel lbl_overviewYear;
    // End of variables declaration//GEN-END:variables
}
