package cinematrix;

import backend.AuthManager;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class ValidationForms extends javax.swing.JFrame {

    AuthManager auth = new AuthManager();

    public ValidationForms() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        pnl_left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnl_right = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnl_login = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnl_loginusername = new javax.swing.JPanel();
        lbl_loginusername = new javax.swing.JLabel();
        txt_loginusername = new javax.swing.JTextField();
        pnl_loginpassword = new javax.swing.JPanel();
        lbl_loginpassword = new javax.swing.JLabel();
        txt_loginpassword = new javax.swing.JTextField();
        pnl_buttonlogin = new javax.swing.JPanel();
        btn_login = new javax.swing.JButton();
        pnl_signup = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        pnl_firstname = new javax.swing.JPanel();
        lbl_firstname = new javax.swing.JLabel();
        txt_firstname = new javax.swing.JTextField();
        pnl_lastname = new javax.swing.JPanel();
        lbl_lastname = new javax.swing.JLabel();
        txt_lastname = new javax.swing.JTextField();
        pnl_bdayage = new javax.swing.JPanel();
        lbl_birthdate = new javax.swing.JLabel();
        txt_birthday = new javax.swing.JTextField();
        lbl_age = new javax.swing.JLabel();
        txt_age = new javax.swing.JTextField();
        pnl_username = new javax.swing.JPanel();
        lbl_username = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        pnl_password = new javax.swing.JPanel();
        lbl_password = new javax.swing.JLabel();
        txt_password = new javax.swing.JTextField();
        pnl_confirmpassword = new javax.swing.JPanel();
        lbl_confirmpassword = new javax.swing.JLabel();
        txt_confirmpassword = new javax.swing.JTextField();
        pnl_buttonsignup = new javax.swing.JPanel();
        btn_signup = new javax.swing.JButton();
        lbl_exit = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(750, 500));
        setMinimumSize(new java.awt.Dimension(750, 500));
        setName("FormsJframe"); // NOI18N
        setUndecorated(true);
        setResizable(false);

        pnl_left.setBackground(new java.awt.Color(0, 0, 0));
        pnl_left.setPreferredSize(new java.awt.Dimension(375, 500));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/cinehub.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/cinehublogo.png"))); // NOI18N

        javax.swing.GroupLayout pnl_leftLayout = new javax.swing.GroupLayout(pnl_left);
        pnl_left.setLayout(pnl_leftLayout);
        pnl_leftLayout.setHorizontalGroup(
            pnl_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_leftLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(pnl_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_leftLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_leftLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(121, 121, 121))))
        );
        pnl_leftLayout.setVerticalGroup(
            pnl_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_leftLayout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );

        getContentPane().add(pnl_left, java.awt.BorderLayout.LINE_START);

        pnl_right.setBackground(new java.awt.Color(31, 41, 55));

        jTabbedPane1.setBackground(new java.awt.Color(31, 41, 55));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        pnl_login.setBackground(new java.awt.Color(48, 63, 85));

        jPanel1.setBackground(new java.awt.Color(48, 63, 85));

        pnl_loginusername.setBackground(new java.awt.Color(48, 63, 85));
        pnl_loginusername.setPreferredSize(new java.awt.Dimension(280, 50));

        lbl_loginusername.setBackground(new java.awt.Color(255, 255, 255));
        lbl_loginusername.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        lbl_loginusername.setForeground(new java.awt.Color(255, 255, 255));
        lbl_loginusername.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_loginusername.setText("Username");
        lbl_loginusername.setPreferredSize(new java.awt.Dimension(280, 15));

        txt_loginusername.setText("Keazer Love Dabu Forever");
        txt_loginusername.setPreferredSize(new java.awt.Dimension(280, 25));

        javax.swing.GroupLayout pnl_loginusernameLayout = new javax.swing.GroupLayout(pnl_loginusername);
        pnl_loginusername.setLayout(pnl_loginusernameLayout);
        pnl_loginusernameLayout.setHorizontalGroup(
            pnl_loginusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(pnl_loginusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_loginusernameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pnl_loginusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_loginusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_loginusername, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnl_loginusernameLayout.setVerticalGroup(
            pnl_loginusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(pnl_loginusernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_loginusernameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbl_loginusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(txt_loginusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lbl_loginusername.getAccessibleContext().setAccessibleName("lbl_loginusername");
        txt_loginusername.getAccessibleContext().setAccessibleName("txt_loginusername");
        txt_loginusername.getAccessibleContext().setAccessibleDescription("");

        jPanel1.add(pnl_loginusername);
        pnl_loginusername.getAccessibleContext().setAccessibleName("pnl_loginusername");

        pnl_loginpassword.setBackground(new java.awt.Color(48, 63, 85));
        pnl_loginpassword.setPreferredSize(new java.awt.Dimension(280, 50));

        lbl_loginpassword.setBackground(new java.awt.Color(255, 255, 102));
        lbl_loginpassword.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        lbl_loginpassword.setForeground(new java.awt.Color(255, 255, 255));
        lbl_loginpassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_loginpassword.setText("Password");
        lbl_loginpassword.setPreferredSize(new java.awt.Dimension(280, 15));

        txt_loginpassword.setText("Keazer kiniss si dabu");
        txt_loginpassword.setPreferredSize(new java.awt.Dimension(280, 25));

        javax.swing.GroupLayout pnl_loginpasswordLayout = new javax.swing.GroupLayout(pnl_loginpassword);
        pnl_loginpassword.setLayout(pnl_loginpasswordLayout);
        pnl_loginpasswordLayout.setHorizontalGroup(
            pnl_loginpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(pnl_loginpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_loginpasswordLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pnl_loginpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_loginpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_loginpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnl_loginpasswordLayout.setVerticalGroup(
            pnl_loginpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(pnl_loginpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_loginpasswordLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbl_loginpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(txt_loginpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lbl_loginpassword.getAccessibleContext().setAccessibleName("lbl_loginpassword");
        txt_loginpassword.getAccessibleContext().setAccessibleName("txt_loginpassword");

        jPanel1.add(pnl_loginpassword);
        pnl_loginpassword.getAccessibleContext().setAccessibleName("pnl_loginpassword");

        pnl_buttonlogin.setBackground(new java.awt.Color(48, 63, 85));
        pnl_buttonlogin.setPreferredSize(new java.awt.Dimension(280, 50));

        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_buttonloginLayout = new javax.swing.GroupLayout(pnl_buttonlogin);
        pnl_buttonlogin.setLayout(pnl_buttonloginLayout);
        pnl_buttonloginLayout.setHorizontalGroup(
            pnl_buttonloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_buttonloginLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btn_login, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_buttonloginLayout.setVerticalGroup(
            pnl_buttonloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_buttonloginLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btn_login)
                .addContainerGap())
        );

        btn_login.getAccessibleContext().setAccessibleName("btn_login");

        jPanel1.add(pnl_buttonlogin);
        pnl_buttonlogin.getAccessibleContext().setAccessibleName("pnl_login");
        pnl_buttonlogin.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout pnl_loginLayout = new javax.swing.GroupLayout(pnl_login);
        pnl_login.setLayout(pnl_loginLayout);
        pnl_loginLayout.setHorizontalGroup(
            pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnl_loginLayout.setVerticalGroup(
            pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loginLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Login", pnl_login);

        pnl_signup.setBackground(new java.awt.Color(48, 63, 85));

        jPanel5.setBackground(new java.awt.Color(48, 63, 85));
        jPanel5.setMinimumSize(new java.awt.Dimension(280, 29));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        pnl_firstname.setBackground(new java.awt.Color(48, 63, 85));
        pnl_firstname.setPreferredSize(new java.awt.Dimension(280, 50));

        lbl_firstname.setBackground(new java.awt.Color(255, 255, 255));
        lbl_firstname.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        lbl_firstname.setForeground(new java.awt.Color(255, 255, 255));
        lbl_firstname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_firstname.setText("First Name:");
        lbl_firstname.setPreferredSize(new java.awt.Dimension(280, 15));

        txt_firstname.setText("Keazer");
        txt_firstname.setToolTipText("");
        txt_firstname.setPreferredSize(new java.awt.Dimension(280, 25));

        javax.swing.GroupLayout pnl_firstnameLayout = new javax.swing.GroupLayout(pnl_firstname);
        pnl_firstname.setLayout(pnl_firstnameLayout);
        pnl_firstnameLayout.setHorizontalGroup(
            pnl_firstnameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(pnl_firstnameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_firstnameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pnl_firstnameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnl_firstnameLayout.setVerticalGroup(
            pnl_firstnameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(pnl_firstnameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_firstnameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbl_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(txt_firstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lbl_firstname.getAccessibleContext().setAccessibleName("lbl_firstname");
        txt_firstname.getAccessibleContext().setAccessibleName("txt_firstname");

        jPanel5.add(pnl_firstname);
        pnl_firstname.getAccessibleContext().setAccessibleName("pnl_name");

        pnl_lastname.setBackground(new java.awt.Color(48, 63, 85));
        pnl_lastname.setPreferredSize(new java.awt.Dimension(280, 50));

        lbl_lastname.setBackground(new java.awt.Color(255, 255, 255));
        lbl_lastname.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        lbl_lastname.setForeground(new java.awt.Color(255, 255, 255));
        lbl_lastname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_lastname.setText("Last Name:");
        lbl_lastname.setPreferredSize(new java.awt.Dimension(280, 15));

        txt_lastname.setText("Love Dabu");
        txt_lastname.setPreferredSize(new java.awt.Dimension(280, 25));

        javax.swing.GroupLayout pnl_lastnameLayout = new javax.swing.GroupLayout(pnl_lastname);
        pnl_lastname.setLayout(pnl_lastnameLayout);
        pnl_lastnameLayout.setHorizontalGroup(
            pnl_lastnameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(pnl_lastnameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_lastnameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pnl_lastnameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnl_lastnameLayout.setVerticalGroup(
            pnl_lastnameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(pnl_lastnameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_lastnameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbl_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(txt_lastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lbl_lastname.getAccessibleContext().setAccessibleName("lbl_lastname");
        txt_lastname.getAccessibleContext().setAccessibleName("txt_lastname");

        jPanel5.add(pnl_lastname);
        pnl_lastname.getAccessibleContext().setAccessibleName("pnl_lastname");

        pnl_bdayage.setBackground(new java.awt.Color(48, 63, 85));
        pnl_bdayage.setPreferredSize(new java.awt.Dimension(280, 50));

        lbl_birthdate.setBackground(new java.awt.Color(255, 255, 102));
        lbl_birthdate.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        lbl_birthdate.setForeground(new java.awt.Color(255, 255, 255));
        lbl_birthdate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_birthdate.setText("Birthday: (MM-dd-YYYY)");
        lbl_birthdate.setPreferredSize(new java.awt.Dimension(280, 15));

        txt_birthday.setText("01-13-0001");
        txt_birthday.setPreferredSize(new java.awt.Dimension(280, 25));

        lbl_age.setBackground(new java.awt.Color(255, 255, 102));
        lbl_age.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        lbl_age.setForeground(new java.awt.Color(255, 255, 255));
        lbl_age.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_age.setText("Age:");
        lbl_age.setPreferredSize(new java.awt.Dimension(280, 15));

        txt_age.setText("99");
        txt_age.setToolTipText("");
        txt_age.setPreferredSize(new java.awt.Dimension(280, 25));

        javax.swing.GroupLayout pnl_bdayageLayout = new javax.swing.GroupLayout(pnl_bdayage);
        pnl_bdayage.setLayout(pnl_bdayageLayout);
        pnl_bdayageLayout.setHorizontalGroup(
            pnl_bdayageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_bdayageLayout.createSequentialGroup()
                .addGap(0, 172, Short.MAX_VALUE)
                .addGroup(pnl_bdayageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_age, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
            .addGroup(pnl_bdayageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_bdayageLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pnl_bdayageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_birthday, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addComponent(lbl_birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGap(0, 124, Short.MAX_VALUE)))
        );
        pnl_bdayageLayout.setVerticalGroup(
            pnl_bdayageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_bdayageLayout.createSequentialGroup()
                .addComponent(lbl_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
            .addGroup(pnl_bdayageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_bdayageLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbl_birthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(txt_birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lbl_birthdate.getAccessibleContext().setAccessibleName("lbl_birthdate");
        txt_birthday.getAccessibleContext().setAccessibleName("txt_birthdate");
        lbl_age.getAccessibleContext().setAccessibleName("lbl_age");
        txt_age.getAccessibleContext().setAccessibleName("txt_age");

        jPanel5.add(pnl_bdayage);
        pnl_bdayage.getAccessibleContext().setAccessibleName("pnl_bdayage");

        pnl_username.setBackground(new java.awt.Color(48, 63, 85));
        pnl_username.setPreferredSize(new java.awt.Dimension(280, 50));

        lbl_username.setBackground(new java.awt.Color(255, 255, 102));
        lbl_username.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_username.setText("Username:");
        lbl_username.setPreferredSize(new java.awt.Dimension(280, 15));

        txt_username.setText("Keazer Love Dabu Forever");
        txt_username.setPreferredSize(new java.awt.Dimension(280, 25));

        javax.swing.GroupLayout pnl_usernameLayout = new javax.swing.GroupLayout(pnl_username);
        pnl_username.setLayout(pnl_usernameLayout);
        pnl_usernameLayout.setHorizontalGroup(
            pnl_usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(pnl_usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_usernameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pnl_usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnl_usernameLayout.setVerticalGroup(
            pnl_usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(pnl_usernameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_usernameLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbl_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lbl_username.getAccessibleContext().setAccessibleName("lbl_username");
        txt_username.getAccessibleContext().setAccessibleName("txt_username");

        jPanel5.add(pnl_username);
        pnl_username.getAccessibleContext().setAccessibleName("pnl_username");

        pnl_password.setBackground(new java.awt.Color(48, 63, 85));
        pnl_password.setPreferredSize(new java.awt.Dimension(280, 50));

        lbl_password.setBackground(new java.awt.Color(255, 255, 102));
        lbl_password.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_password.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_password.setText("Password:");
        lbl_password.setPreferredSize(new java.awt.Dimension(280, 15));

        txt_password.setText("Keazer kiniss si dabu");
        txt_password.setPreferredSize(new java.awt.Dimension(280, 25));

        javax.swing.GroupLayout pnl_passwordLayout = new javax.swing.GroupLayout(pnl_password);
        pnl_password.setLayout(pnl_passwordLayout);
        pnl_passwordLayout.setHorizontalGroup(
            pnl_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(pnl_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_passwordLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pnl_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnl_passwordLayout.setVerticalGroup(
            pnl_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(pnl_passwordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_passwordLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbl_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lbl_password.getAccessibleContext().setAccessibleName("lbl_password");
        txt_password.getAccessibleContext().setAccessibleName("txt_password");

        jPanel5.add(pnl_password);
        pnl_password.getAccessibleContext().setAccessibleName("pnl_password");

        pnl_confirmpassword.setBackground(new java.awt.Color(48, 63, 85));
        pnl_confirmpassword.setPreferredSize(new java.awt.Dimension(280, 50));

        lbl_confirmpassword.setBackground(new java.awt.Color(255, 255, 102));
        lbl_confirmpassword.setFont(new java.awt.Font("Lucida Fax", 1, 10)); // NOI18N
        lbl_confirmpassword.setForeground(new java.awt.Color(255, 255, 255));
        lbl_confirmpassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_confirmpassword.setText("Confirm Password:");
        lbl_confirmpassword.setPreferredSize(new java.awt.Dimension(280, 15));

        txt_confirmpassword.setText("Keazer kiniss si dabu");
        txt_confirmpassword.setPreferredSize(new java.awt.Dimension(280, 25));

        javax.swing.GroupLayout pnl_confirmpasswordLayout = new javax.swing.GroupLayout(pnl_confirmpassword);
        pnl_confirmpassword.setLayout(pnl_confirmpasswordLayout);
        pnl_confirmpasswordLayout.setHorizontalGroup(
            pnl_confirmpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
            .addGroup(pnl_confirmpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_confirmpasswordLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(pnl_confirmpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_confirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_confirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnl_confirmpasswordLayout.setVerticalGroup(
            pnl_confirmpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
            .addGroup(pnl_confirmpasswordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnl_confirmpasswordLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbl_confirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(txt_confirmpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        lbl_confirmpassword.getAccessibleContext().setAccessibleName("txt_confirmpassword");
        txt_confirmpassword.getAccessibleContext().setAccessibleName("txt_confirmpassword");

        jPanel5.add(pnl_confirmpassword);
        pnl_confirmpassword.getAccessibleContext().setAccessibleName("pnl_confirmpassword");

        pnl_buttonsignup.setBackground(new java.awt.Color(48, 63, 85));
        pnl_buttonsignup.setPreferredSize(new java.awt.Dimension(280, 50));

        btn_signup.setText("Sign Up");
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_buttonsignupLayout = new javax.swing.GroupLayout(pnl_buttonsignup);
        pnl_buttonsignup.setLayout(pnl_buttonsignupLayout);
        pnl_buttonsignupLayout.setHorizontalGroup(
            pnl_buttonsignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_buttonsignupLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(btn_signup, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        pnl_buttonsignupLayout.setVerticalGroup(
            pnl_buttonsignupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_buttonsignupLayout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(btn_signup))
        );

        btn_signup.getAccessibleContext().setAccessibleName("btn_signup");

        jPanel5.add(pnl_buttonsignup);
        pnl_buttonsignup.getAccessibleContext().setAccessibleName("pnl_buttonsignup");
        pnl_buttonsignup.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout pnl_signupLayout = new javax.swing.GroupLayout(pnl_signup);
        pnl_signup.setLayout(pnl_signupLayout);
        pnl_signupLayout.setHorizontalGroup(
            pnl_signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_signupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_signupLayout.setVerticalGroup(
            pnl_signupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_signupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Sign up", pnl_signup);

        lbl_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/logout.png"))); // NOI18N
        lbl_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lbl_exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lbl_exitMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnl_rightLayout = new javax.swing.GroupLayout(pnl_right);
        pnl_right.setLayout(pnl_rightLayout);
        pnl_rightLayout.setHorizontalGroup(
            pnl_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_rightLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(pnl_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_rightLayout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_rightLayout.createSequentialGroup()
                        .addComponent(lbl_exit)
                        .addContainerGap())))
        );
        pnl_rightLayout.setVerticalGroup(
            pnl_rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_rightLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        getContentPane().add(pnl_right, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
            auth.login(txt_loginusername.getText(), txt_loginpassword.getText());
            
            setVisible(false);
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
        if (!txt_password.getText().equals(txt_confirmpassword.getText())) {
            return;
        }
        auth.signup(
            txt_firstname.getText(),
            txt_lastname.getText(),
            LocalDate.parse(txt_birthday.getText(), DateTimeFormatter.ofPattern("MM-dd-yyyy")),
            Integer.parseInt(txt_age.getText()),
            txt_username.getText(),
            txt_password.getText()
        );
        JOptionPane.showMessageDialog(null, "Sign Up Successfully", "Information", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btn_signupActionPerformed

    private void lbl_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lbl_exitMouseClicked

    private void lbl_exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseEntered
        lbl_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lbl_exitMouseEntered

    private void lbl_exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_exitMouseExited
        lbl_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lbl_exitMouseExited

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(ValidationForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValidationForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValidationForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValidationForms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValidationForms().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_signup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_age;
    private javax.swing.JLabel lbl_birthdate;
    private javax.swing.JLabel lbl_confirmpassword;
    private javax.swing.JLabel lbl_exit;
    private javax.swing.JLabel lbl_firstname;
    private javax.swing.JLabel lbl_lastname;
    private javax.swing.JLabel lbl_loginpassword;
    private javax.swing.JLabel lbl_loginusername;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JPanel pnl_bdayage;
    private javax.swing.JPanel pnl_buttonlogin;
    private javax.swing.JPanel pnl_buttonsignup;
    private javax.swing.JPanel pnl_confirmpassword;
    private javax.swing.JPanel pnl_firstname;
    private javax.swing.JPanel pnl_lastname;
    private javax.swing.JPanel pnl_left;
    private javax.swing.JPanel pnl_login;
    private javax.swing.JPanel pnl_loginpassword;
    private javax.swing.JPanel pnl_loginusername;
    private javax.swing.JPanel pnl_password;
    private javax.swing.JPanel pnl_right;
    private javax.swing.JPanel pnl_signup;
    private javax.swing.JPanel pnl_username;
    private javax.swing.JTextField txt_age;
    private javax.swing.JTextField txt_birthday;
    private javax.swing.JTextField txt_confirmpassword;
    private javax.swing.JTextField txt_firstname;
    private javax.swing.JTextField txt_lastname;
    private javax.swing.JTextField txt_loginpassword;
    private javax.swing.JTextField txt_loginusername;
    private javax.swing.JTextField txt_password;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
