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
 * JPanel with red competitor's foul points
 * @author ondra
 */
public class FaulPointsRedCompetitorUserMatch_JP extends JPanel implements IButtonsActions {

    /** JButton that counts how many foul points red competitor has */
    public JButton btnFaulPoints;

    /** JButton that shows how many yellow cards red competitor has */
    public JButton btnYellowCards;

    /**
     * @param userMatchWindow for all the things inside
     */
    public FaulPointsRedCompetitorUserMatch_JP(UserMatch_Window userMatchWindow) {

        setBackground(Color.WHITE);


        btnYellowCards = new JButton("0");
        btnYellowCards.setFocusable(false);
        btnYellowCards.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnYellowCards.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnYellowCardAction(userMatchWindow);
            }
        });
        setLayout(null);
        btnYellowCards.setFont(new Font("Dialog", Font.PLAIN, 60));
        btnYellowCards.setForeground(Color.RED);
        btnYellowCards.setBackground(Color.WHITE);
        btnYellowCards.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnYellowCards.setBounds(10, 10, 70, 70);
        add(btnYellowCards);


        btnFaulPoints = new JButton("0");
        btnFaulPoints.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnFaulPoints.setFocusable(false);
        btnFaulPoints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnFoulPointsAction(userMatchWindow);
            }
        });
        btnFaulPoints.setFont(new Font("Dialog", Font.PLAIN, 45));
        btnFaulPoints.setForeground(Color.RED);
        btnFaulPoints.setBackground(Color.WHITE);
        btnFaulPoints.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        btnFaulPoints.setBounds(145, 20, 60, 60);
        add(btnFaulPoints);

    }

    /**
     * When clicking the red foul points button it will at a foul point to the red competitor + it will shows who is currently winning
     * @param userMatchWindow for all the things inside
     */
    public void btnFoulPointsAction(UserMatch_Window userMatchWindow) {
        if (userMatchWindow.userMatchScreen.buttonAllowed) {
            userMatchWindow.redCompetitor.getStatistics().getPoints().setFoulPoints(userMatchWindow.redCompetitor.getStatistics().getPoints().getFoulPoints()+1);

            userMatchWindow.redCompetitor.morePoints(userMatchWindow.blueCompetitor, userMatchWindow);
            System.out.println("Červený plus trestný bod");
        }
    }


    /**
     * When clicking the red yellow cards button it will at a yellow card to the red competitor + it will shows who is currently winning
     * @param userMatchWindow for all the things inside
     */
    public void btnYellowCardAction(UserMatch_Window userMatchWindow) {
        if (userMatchWindow.userMatchScreen.buttonAllowed) {
            userMatchWindow.redCompetitor.getStatistics().getPoints().setYellowCards(userMatchWindow.redCompetitor.getStatistics().getPoints().getYellowCards()+1, userMatchWindow);

            userMatchWindow.redCompetitor.morePoints(userMatchWindow.blueCompetitor, userMatchWindow);
            System.out.println("Červený plus žlutá karta");
        }
    }}
