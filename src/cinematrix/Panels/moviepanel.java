package cinematrix.Panels;

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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import org.json.JSONException;
import org.json.JSONObject;

public class moviepanel extends JPanel {

    private String movieTile;
    private String ratings;
    private ImageIcon resizedIcon;

    public moviepanel(JSONObject movie) throws MalformedURLException, IOException {
        
        try {
            movieTile = movie.getString("title");
        } catch (JSONException e) {
            movieTile = movie.getString("original_name");
        }
        
        ratings = "ratings: " + movie.getDouble("vote_average");
        String posterPathURL = "https://image.tmdb.org/t/p/w500" + movie.getString("poster_path");

        URL posterUrl = new URL(posterPathURL);
        BufferedImage originalImage = ImageIO.read(posterUrl);
        int desiredWidth = 170;
        int desiredHeight = 200;
        Image resizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
        resizedIcon = new ImageIcon(resizedImage);

        ImageIcon heartIcon1 = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + "\\moviepanel Icon\\1.png");
        ImageIcon heartIcon2 = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + "\\moviepanel Icon\\2.png");
        ImageIcon bookmarkIcon1 = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + "\\moviepanel Icon\\3.png");
        ImageIcon bookmarkIcon2 = new ImageIcon(System.getProperty("user.dir") + File.separator + "src" + "\\moviepanel Icon\\4.png");

        // MOVIE LABEL
        JLabel lbl_movietitle = new JLabel();
        lbl_movietitle.setText(movieTile);
        lbl_movietitle.setVerticalAlignment(JLabel.TOP);
        lbl_movietitle.setHorizontalAlignment(JLabel.LEFT);
        lbl_movietitle.setFont(new Font("Cascadia Code", Font.PLAIN, 12));
        lbl_movietitle.setForeground(new Color(0xE5E7EB));

        // RATING LABEL
        JLabel lbl_rating = new JLabel();
        lbl_rating.setText(ratings);
        lbl_rating.setVerticalAlignment(JLabel.BOTTOM);
        lbl_rating.setHorizontalAlignment(JLabel.LEFT);
        lbl_rating.setFont(new Font("Cascadia Code", Font.PLAIN, 12));
        lbl_rating.setForeground(new Color(0xE5E7EB));

        // MOVIE PANEL ICON
        JLabel lbl_movieicon = new JLabel();
        lbl_movieicon.setIcon(resizedIcon);

        // Create a layered pane to stack components
        JLayeredPane pnl_moviepanel = new JLayeredPane();
        pnl_moviepanel.setPreferredSize(new Dimension(170, 240));

        // Add movie icon and heart icon to layered pane
        pnl_moviepanel.add(lbl_movieicon, JLayeredPane.DEFAULT_LAYER);
        lbl_movieicon.setBounds(0, 0, 170, 190); // Set bounds for IconLabel

        JLabel heartLabel = createIconLabel(heartIcon1, heartIcon2, 115, 0);
        JLabel bookmarkLabel = createIconLabel(bookmarkIcon1, bookmarkIcon2, 90 + heartIcon1.getIconWidth() + 10, 0); // Position bookmark icon beside heart icon

        // Add heart and bookmark icon labels to layered pane
        pnl_moviepanel.add(heartLabel, JLayeredPane.PALETTE_LAYER);
        pnl_moviepanel.add(bookmarkLabel, JLayeredPane.PALETTE_LAYER);

        // MOVIE TITLE PANEL
        JPanel pnl_titlepanel = new JPanel();
        pnl_titlepanel.setBackground(new Color(0x374151, false));
        pnl_titlepanel.setLayout(new BorderLayout());
        pnl_titlepanel.setPreferredSize(new Dimension(170, 40)); // Set preferred size for titlePanel
        pnl_titlepanel.add(lbl_movietitle, BorderLayout.NORTH);
        pnl_titlepanel.add(lbl_rating, BorderLayout.SOUTH);

        //MainPanel
        JPanel pnl_mainpanel = new JPanel(new BorderLayout());
        pnl_mainpanel.setBackground(new Color(0x374151, false));
        pnl_mainpanel.setPreferredSize(new Dimension(170, 230));
        pnl_mainpanel.add(pnl_moviepanel, BorderLayout.CENTER);
        pnl_mainpanel.add(pnl_titlepanel, BorderLayout.SOUTH);

        // Add main panel to this panel
        add(pnl_mainpanel);
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

    public static void main(String args[]) {
        try {
            JSONObject movie = new JSONObject(); // Example JSON object
            moviepanel moviePanel = new moviepanel(movie);

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(170, 240);
            frame.setVisible(true);

            frame.setLayout(new BorderLayout()); // Set frame layout to BorderLayout

            frame.add(moviePanel, BorderLayout.CENTER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
