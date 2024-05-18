
package cinematrix.Panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class moviepanel {

    public static void main(String args[]) {
        ImageIcon image = new ImageIcon("C:\\Users\\Guian Carlo\\Documents\\Programming\\OOP_Cinematrix_Migrate\\src\\moviepanel Icon\\170X190.png");
        ImageIcon heartIcon1 = new ImageIcon("C:\\Users\\Guian Carlo\\Documents\\Programming\\OOP_Cinematrix_Migrate\\src\\moviepanel Icon\\1.png");
        ImageIcon heartIcon2 = new ImageIcon("C:\\Users\\Guian Carlo\\Documents\\Programming\\OOP_Cinematrix_Migrate\\src\\moviepanel Icon\\2.png");
        ImageIcon bookmarkIcon1 = new ImageIcon("C:\\Users\\Guian Carlo\\Documents\\Programming\\OOP_Cinematrix_Migrate\\src\\moviepanel Icon\\3.png");
        ImageIcon bookmarkIcon2 = new ImageIcon("C:\\Users\\Guian Carlo\\Documents\\Programming\\OOP_Cinematrix_Migrate\\src\\moviepanel Icon\\4.png");

        // MOVIE LABEL
        JLabel lbl_movietitle = new JLabel();
        lbl_movietitle.setText("MOVIE TITLE:");
        lbl_movietitle.setVerticalAlignment(JLabel.TOP);
        lbl_movietitle.setHorizontalAlignment(JLabel.LEFT);
        lbl_movietitle.setFont(new Font("Cascadia Code", Font.PLAIN, 12));

        // RATING LABEL
        JLabel lbl_rating = new JLabel();
        lbl_rating.setText("RATING: ");
        lbl_rating.setVerticalAlignment(JLabel.BOTTOM);
        lbl_rating.setHorizontalAlignment(JLabel.LEFT);
        lbl_rating.setFont(new Font("Cascadia Code", Font.PLAIN, 12));

        // MOVIE PANEL ICON
        JLabel lbl_movieicon = new JLabel();
        lbl_movieicon.setIcon(image);

        // Create a layered pane to stack components
        JLayeredPane pnl_moviepanel = new JLayeredPane();
        pnl_moviepanel.setPreferredSize(new Dimension(170, 190));

        // Add movie icon and heart icon to layered pane
        pnl_moviepanel.add(lbl_movieicon, JLayeredPane.DEFAULT_LAYER);
        lbl_movieicon.setBounds(0, 0, 170, 163); // Set bounds for IconLabel

        JLabel heartLabel = createIconLabel(heartIcon1, heartIcon2, 100, 5);
        JLabel bookmarkLabel = createIconLabel(bookmarkIcon1, bookmarkIcon2, 90 + heartIcon1.getIconWidth() + 10, 5); // Position bookmark icon beside heart icon

        // Add heart and bookmark icon labels to layered pane
        pnl_moviepanel.add(heartLabel, JLayeredPane.PALETTE_LAYER);
        pnl_moviepanel.add(bookmarkLabel, JLayeredPane.PALETTE_LAYER);

        // MOVIE TITLE PANEL
        JPanel pnl_titlepanel = new JPanel();
        pnl_titlepanel.setBackground(Color.green);
        pnl_titlepanel.setLayout(new BorderLayout());
        pnl_titlepanel.setPreferredSize(new Dimension(170, 40)); // Set preferred size for titlePanel
        pnl_titlepanel.add(lbl_movietitle, BorderLayout.NORTH);
        pnl_titlepanel.add(lbl_rating, BorderLayout.SOUTH);
        


        //MainPanel
        JPanel pnl_mainpanel = new JPanel(new BorderLayout());
        pnl_mainpanel.setBackground(Color.red);
        pnl_mainpanel.setPreferredSize(new Dimension(170, 240));
        pnl_mainpanel.add(pnl_moviepanel, BorderLayout.CENTER);
        pnl_mainpanel.add(pnl_titlepanel, BorderLayout.SOUTH);

        
        //Jframe
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(170, 240);
        frame.setVisible(true);

        frame.setLayout(new BorderLayout()); // Set frame layout to BorderLayout

        frame.add(pnl_mainpanel, BorderLayout.CENTER);
    }

    
    
    
    
    
    private static JLabel createIconLabel(ImageIcon icon1, ImageIcon icon2, int x, int y) {
        JLabel iconLabel = new JLabel(icon1);
        iconLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (iconLabel.getIcon() == icon1) {
                    iconLabel.setIcon(icon2);
                } else {
                    iconLabel.setIcon(icon1);
                }
            }
        });
        iconLabel.setBounds(x, y, 30, 30); // Position icon label
        return iconLabel;
    }
}