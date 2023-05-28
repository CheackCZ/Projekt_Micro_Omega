package match_Window_Package;

import javax.swing.JPanel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

/**
 * JPanel with blue competitor's foul points
 * @author ondra
 */
public class FaulPointsBlueCompetitor_JP extends JPanel {

    /** JButton that adds foul points to the blue competitor */
    public JButton btnFaulPoints;

    /** JButton that shows how many yellow cards blue competitor have */
    public JButton btnYellowCards;

    /**
     * Create the panel.
     */
    public FaulPointsBlueCompetitor_JP() {

        setBackground(Color.WHITE);
        setLayout(null);

        btnFaulPoints = new JButton("0");
        btnFaulPoints.setFocusable(false);
        btnFaulPoints.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnFaulPoints.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 72));
        btnFaulPoints.setForeground(Color.BLUE);
        btnFaulPoints.setBackground(Color.WHITE);
        btnFaulPoints.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnFaulPoints.setBounds(25, 10, 90, 90);
        add(btnFaulPoints);


        btnYellowCards = new JButton("0");
        btnYellowCards.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnYellowCards.setFocusable(false);
        btnYellowCards.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 88));
        btnYellowCards.setForeground(Color.BLUE);
        btnYellowCards.setBackground(Color.WHITE);
        btnYellowCards.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnYellowCards.setBounds(225, 5, 90, 90);
        add(btnYellowCards);

    }}
