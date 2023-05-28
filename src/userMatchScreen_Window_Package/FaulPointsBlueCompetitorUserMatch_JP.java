package userMatchScreen_Window_Package;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import userMatch_Window_Package.UserMatch_Window;

/**
 * JPanel with blue competitor's foul points
 * @author ondra
 */
public class FaulPointsBlueCompetitorUserMatch_JP extends JPanel implements IButtonsActions {

    /** JButton that adds foul points to the blue competitor */
    public JButton btnFaulPoints;

    /** JButton that shows how many yellow cards blue competitor have */
    public JButton btnYellowCards;

    /**
     * Create the Panel
     * @param userMatchWindow for all the things inside
     */
    public FaulPointsBlueCompetitorUserMatch_JP(UserMatch_Window userMatchWindow) {

        setBackground(Color.WHITE);
        setLayout(null);


        btnFaulPoints = new JButton("0");
        btnFaulPoints.setFocusable(false);
        btnFaulPoints.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnFaulPoints.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnFoulPointsAction(userMatchWindow);
            }
        });
        btnFaulPoints.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 45));
        btnFaulPoints.setForeground(Color.BLUE);
        btnFaulPoints.setBackground(Color.WHITE);
        btnFaulPoints.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnFaulPoints.setBounds(10, 20, 60, 60);
        add(btnFaulPoints);


        btnYellowCards = new JButton("0");
        btnYellowCards.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnYellowCards.setFocusable(false);
        btnYellowCards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnYellowCardAction(userMatchWindow);
            }
        });
        btnYellowCards.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 60));
        btnYellowCards.setForeground(Color.BLUE);
        btnYellowCards.setBackground(Color.WHITE);
        btnYellowCards.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnYellowCards.setBounds(145, 10, 70, 70);
        add(btnYellowCards);

    }

    /**
     * When clicking the blue foul points button it will at a foul point to the blue competitor + it will shows who is currently winning
     * @param userMatchWindow for all the things inside
     */
    public void btnFoulPointsAction(UserMatch_Window userMatchWindow) {
        if (userMatchWindow.userMatchScreen.buttonAllowed) {
            userMatchWindow.blueCompetitor.getStatistics().getPoints().setFoulPoints(userMatchWindow.blueCompetitor.getStatistics().getPoints().getFoulPoints()+1);

            userMatchWindow.redCompetitor.morePoints(userMatchWindow.blueCompetitor, userMatchWindow);
            System.out.println("Modrý plus trestný bod");
        }
    }


    /**
     * When clicking the blue yellow cards button it will at a yellow card to the blue competitor + it will shows who is currently winning
     * @param userMatchWindow for all the things inside
     */
    public void btnYellowCardAction(UserMatch_Window userMatchWindow) {
        if (userMatchWindow.userMatchScreen.buttonAllowed) {
            userMatchWindow.blueCompetitor.getStatistics().getPoints().setYellowCards(userMatchWindow.blueCompetitor.getStatistics().getPoints().getYellowCards()+1, userMatchWindow);

            userMatchWindow.redCompetitor.morePoints(userMatchWindow.blueCompetitor, userMatchWindow);
            System.out.println("Modrý plus žlutá karta");
        }
    }}
