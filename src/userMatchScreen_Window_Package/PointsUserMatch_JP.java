package userMatchScreen_Window_Package;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import userMatch_Window_Package.UserMatch_Window;

/**
 * JPanel including buttons with point of the competitors
 * @author ondra
 */
public class PointsUserMatch_JP extends JPanel {

    /** The double dot between the points of the competitors */
    private JTextField txtDoubleDot;

    /** JButton - button that adds points to the blue competitor	*/
    public JButton btnBluePoints;
    /** JButton - button that adds points to the red competitor	*/
    public JButton btnRedPoints;

    /** JLabel - triangle which changes the color depends on who is winning	 */
    public JLabel lblTriangle;

    /**
     * Create the Panel
     * @param userMatchWindow for all the things inside
     */
    public PointsUserMatch_JP(UserMatch_Window userMatchWindow) {

        setBackground(Color.WHITE);
        setSize(215, 85);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(null);


        txtDoubleDot = new JTextField(":");
        txtDoubleDot.setBackground(Color.WHITE);
        txtDoubleDot.setForeground(Color.BLACK);
        txtDoubleDot.setFont(new Font("Arial", Font.BOLD, 48));
        txtDoubleDot.setHorizontalAlignment(SwingConstants.CENTER);
        txtDoubleDot.setEditable(false);
        txtDoubleDot.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        txtDoubleDot.setBounds(125, 10, 20, 65);
        add(txtDoubleDot);


        btnBluePoints = new JButton("0");
        btnBluePoints.setFocusable(false);
        btnBluePoints.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBluePoints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBluePointsAction(userMatchWindow);
            }
        });
        btnBluePoints.setFont(new Font("Dialog", Font.PLAIN, 48));
        btnBluePoints.setForeground(Color.BLUE);
        btnBluePoints.setBackground(Color.WHITE);
        btnBluePoints.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnBluePoints.setBounds(65, 10, 55, 65);
        add(btnBluePoints);


        btnRedPoints = new JButton("0");
        btnRedPoints.setFocusable(false);
        btnRedPoints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRedPointsAction(userMatchWindow);
            }
        });
        btnRedPoints.setFont(new Font("Dialog", Font.PLAIN, 48));
        btnRedPoints.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRedPoints.setForeground(Color.RED);
        btnRedPoints.setBackground(Color.WHITE);
        btnRedPoints.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnRedPoints.setBounds(150, 10, 55, 65);
        add(btnRedPoints);


        lblTriangle = new JLabel("");
        lblTriangle.setIcon(new ImageIcon(PointsUserMatch_JP.class.getResource("/triangle_small.png")));
        lblTriangle.setBounds(1, 1, 70, 70);
        add(lblTriangle);
    }

    /**
     * When clicking the red points button it will at a point to the red competitor + it will shows who is currently winning
     * @param userMatchWindow for all the things inside
     */
    public void btnRedPointsAction(UserMatch_Window userMatchWindow) {
        if (userMatchWindow.userMatchScreen.buttonAllowed) {
            userMatchWindow.redCompetitor.getStatistics().getPoints().setPoints(userMatchWindow.redCompetitor.getStatistics().getPoints().getPoints()+1);;
            userMatchWindow.redCompetitor.morePoints(userMatchWindow.blueCompetitor, userMatchWindow);
        }
    }

    /**
     * When clicking the blue points button it will at a point to the blue competitor + it will shows who is currently winning
     * @param userMatchWindow for all the things inside
     */
    public void btnBluePointsAction(UserMatch_Window userMatchWindow) {
        if (userMatchWindow.userMatchScreen.buttonAllowed) {
            userMatchWindow.blueCompetitor.getStatistics().getPoints().setPoints(userMatchWindow.blueCompetitor.getStatistics().getPoints().getPoints()+1);;
            userMatchWindow.redCompetitor.morePoints(userMatchWindow.blueCompetitor, userMatchWindow);
        }
    }}
