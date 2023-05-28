package match_Window_Package;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * JPanel with red competitor's foul points
 * @author ondra
 */
public class FaulPointsRedCompetitor_JP extends JPanel {

    /** JButton that counts how many foul points red competitor has */
    public JButton btnFaulPoints;

    /** JButton that shows how many yellow cards red competitor has */
    public JButton btnYellowCards;

    /**
     * Create the panel.
     */
    public FaulPointsRedCompetitor_JP() {

        setBackground(Color.WHITE);
        setLayout(null);

        btnYellowCards = new JButton("0");
        btnYellowCards.setFocusable(false);
        btnYellowCards.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnYellowCards.setFont(new Font("Dialog", Font.PLAIN, 88));
        btnYellowCards.setForeground(Color.RED);
        btnYellowCards.setBackground(Color.WHITE);
        btnYellowCards.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnYellowCards.setBounds(35, 5, 90, 90);
        add(btnYellowCards);


        btnFaulPoints = new JButton("0");
        btnFaulPoints.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnFaulPoints.setFocusable(false);
        btnFaulPoints.setFont(new Font("Dialog", Font.PLAIN, 72));
        btnFaulPoints.setForeground(Color.RED);
        btnFaulPoints.setBackground(Color.WHITE);
        btnFaulPoints.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnFaulPoints.setBounds(225, 10, 90, 90);
        add(btnFaulPoints);

    }}
