package match_Window_Package;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * JPanel including buttons with point of the competitors
 * @author ondra
 */
public class PointsMatch_JP extends JPanel {

    /** The double dot between the points of the competitors */
    private JTextField txtDoubleDot;

    /** JButton - button that adds points to the blue competitor	*/
    public JButton btnBluePoints;

    /** JButton - button that adds points to the red competitor	*/
    public JButton btnRedPoints;

    /** JLabel - triangle which changes the color depends on who is winning	*/
    public JLabel lblTriangle;

    /**
     * Create the panel.
     */
    public PointsMatch_JP() {

        setBackground(Color.WHITE);
        this.setSize(375, 150);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setLayout(null);


        txtDoubleDot = new JTextField(":");
        txtDoubleDot.setBackground(Color.WHITE);
        txtDoubleDot.setForeground(Color.BLACK);
        txtDoubleDot.setFont(new Font("Arial", Font.BOLD, 48));
        txtDoubleDot.setHorizontalAlignment(SwingConstants.CENTER);
        txtDoubleDot.setEditable(false);
        txtDoubleDot.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        txtDoubleDot.setBounds(212, 10, 20, 130);
        add(txtDoubleDot);


        btnBluePoints = new JButton("0");
        btnBluePoints.setFocusable(false);
        btnBluePoints.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnBluePoints.setFont(new Font("Dialog", Font.PLAIN, 80));
        btnBluePoints.setForeground(Color.BLUE);
        btnBluePoints.setBackground(Color.WHITE);
        btnBluePoints.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnBluePoints.setBounds(107, 20, 100, 110);
        add(btnBluePoints);


        btnRedPoints = new JButton("-0");
        btnRedPoints.setFocusable(false);
        btnRedPoints.setFont(new Font("Dialog", Font.PLAIN, 80));
        btnRedPoints.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRedPoints.setForeground(Color.RED);
        btnRedPoints.setBackground(Color.WHITE);
        btnRedPoints.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnRedPoints.setBounds(237, 20, 105, 110);
        add(btnRedPoints);


        lblTriangle = new JLabel("");
        lblTriangle.setIcon(new ImageIcon(PointsMatch_JP.class.getResource("/triangle.png")));
        lblTriangle.setBounds(1, 1, 125, 125);
        add(lblTriangle);

    }}
