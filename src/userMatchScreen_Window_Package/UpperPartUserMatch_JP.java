package userMatchScreen_Window_Package;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import userMatch_Window_Package.UserMatch_Window;

/**
 * JPanel including the upper parts of the match window
 * @author ondra
 */
public class UpperPartUserMatch_JP extends JPanel {

    /** JTextField with the category */
    public JTextField txtCategory;
    /** JTextField with the number of the ring */
    public JTextField txtRingNumber;

    /** JRadioButton that shows if the red competitor did the spinning kick in the first round not */
    public JRadioButton spinningKickRedFirst;
    /** JRadioButton that shows if the red competitor did the spinning kick in the second round not */
    public JRadioButton spinningKickRedSecond;

    /** JRadioButton that shows if the blue competitor did the spinning kick in the first round or not */
    public JRadioButton spinningKickBlueFirst;
    /** JRadioButton that shows if the blue competitor did the spinning kick in the second round or not */
    public JRadioButton spinningKickBlueSecond;

    //Using these to get the points for the spinning kick only once
    /** Spinning kick first round red */
    public boolean sKFRRed = false;
    /** Spinning kick second round red */
    public boolean sKSRRed = false;

    /** Spinning kick first round blue */
    public boolean sKFRBlue = false;
    /** Spinning kick second round blue */
    public boolean sKSRBlue = false;


    /** Using to get the screen size and make the window compatible */
    Dimension dim;

    /**
     * Create the Panel
     * @param userMatchWindow for all the things inside
     */
    public UpperPartUserMatch_JP(UserMatch_Window userMatchWindow) {

        setBackground(Color.WHITE);
        setLayout(null);
        setSize(720, 120);

        dim = Toolkit.getDefaultToolkit().getScreenSize();


        txtCategory = new JTextField("");
        txtCategory.setEditable(false);
        txtCategory.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 26));
        txtCategory.setHorizontalAlignment(SwingConstants.CENTER);
        txtCategory.setForeground(Color.WHITE);
        txtCategory.setBackground(Color.BLACK);
        txtCategory.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtCategory.setBounds(0, 0, 720, 70);
        add(txtCategory);


        txtRingNumber = new JTextField("RING ");
        txtRingNumber.setBorder(new LineBorder(Color.GREEN));
        txtRingNumber.setEditable(true);
        txtRingNumber.setFocusable(false);
        txtRingNumber.setHorizontalAlignment(SwingConstants.CENTER);
        txtRingNumber.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 30));
        txtRingNumber.setForeground(Color.WHITE);
        txtRingNumber.setBackground(new Color(0, 128, 0));
        txtRingNumber.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0)));
        txtRingNumber.setBounds(223, 70, 275, 50);
        add(txtRingNumber);



        //Buttons that shows if the spinning kick was done or not by the red competitor

        spinningKickRedFirst = new JRadioButton("");
        spinningKickRedFirst.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_unselected_icon_small.png")));
        spinningKickRedFirst.setForeground(Color.BLACK);
        spinningKickRedFirst.setBackground(Color.WHITE);
        spinningKickRedFirst.setHorizontalAlignment(SwingConstants.CENTER);
        spinningKickRedFirst.setVisible(false);
        spinningKickRedFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!sKFRRed) {
                    spinningKickRedCompleted(spinningKickRedFirst, userMatchWindow);
                    sKFRRed = true;
                }
                userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.requestFocusInWindow();
            }
        });
        spinningKickRedFirst.setBounds(665, 73, 45, 45);
        add(spinningKickRedFirst);


        spinningKickRedSecond = new JRadioButton("");
        spinningKickRedSecond.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_unselected_icon_small.png")));
        spinningKickRedSecond.setForeground(Color.BLACK);
        spinningKickRedSecond.setBackground(Color.WHITE);
        spinningKickRedSecond.setHorizontalAlignment(SwingConstants.CENTER);
        spinningKickRedSecond.setVisible(false);
        spinningKickRedSecond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!sKSRRed) {
                    spinningKickRedCompleted(spinningKickRedSecond, userMatchWindow);
                    sKSRRed = true;
                }
                userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.requestFocusInWindow();
            }
        });
        spinningKickRedSecond.setBounds(600, 73, 45, 45);
        add(spinningKickRedSecond);


        //Buttons that shows if the spinning kick was done or not by the blue competitor

        spinningKickBlueFirst = new JRadioButton("");
        spinningKickBlueFirst.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_unselected_icon_small.png")));
        spinningKickBlueFirst.setForeground(Color.BLACK);
        spinningKickBlueFirst.setBackground(Color.WHITE);
        spinningKickBlueFirst.setHorizontalAlignment(SwingConstants.CENTER);
        spinningKickBlueFirst.setVisible(false);
        spinningKickBlueFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!sKFRBlue) {
                    spinningKickBlueCompleted(spinningKickBlueFirst, userMatchWindow);
                    sKFRBlue = true;
                }
                userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.requestFocusInWindow();
            }
        });
        spinningKickBlueFirst.setBounds(10, 73, 45, 45);
        add(spinningKickBlueFirst);


        spinningKickBlueSecond = new JRadioButton("");
        spinningKickBlueSecond.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_unselected_icon_small.png")));
        spinningKickBlueSecond.setForeground(Color.BLACK);
        spinningKickBlueSecond.setBackground(Color.WHITE);
        spinningKickBlueSecond.setHorizontalAlignment(SwingConstants.CENTER);
        spinningKickBlueSecond.setVisible(false);
        spinningKickBlueSecond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!sKSRBlue) {
                    spinningKickBlueCompleted(spinningKickBlueSecond, userMatchWindow);
                    sKSRBlue = true;
                }
                userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.requestFocusInWindow();
            }
        });
        spinningKickBlueSecond.setBounds(75, 73, 45, 45);
        add(spinningKickBlueSecond);

    }

    /**
     * Completed spinning kick of blue competitor -> add 2 points to the competitor + changing the icon of it
     * @param radioBtn changing the icon of it
     * @param userMatchWindow for all the things inside
     */
    public void spinningKickBlueCompleted(JRadioButton radioBtn, UserMatch_Window userMatchWindow) {
        if (userMatchWindow.userMatchScreen.buttonAllowed) {
            radioBtn.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_selected_icon-blue_small.png")));

            if (userMatchWindow.matchWindow.UpperPart.spinningKickBlueFirst.isVisible()) {
                userMatchWindow.matchWindow.UpperPart.spinningKickBlueFirst.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_selected_icon-blue.png")));
            }
            if (userMatchWindow.matchWindow.UpperPart.spinningKickBlueSecond.isVisible()) {
                userMatchWindow.matchWindow.UpperPart.spinningKickBlueSecond.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_selected_icon-blue.png")));
            }

            userMatchWindow.blueCompetitor.getStatistics().getPoints().setPoints(userMatchWindow.blueCompetitor.getStatistics().getPoints().getPoints() + 2);
            userMatchWindow.redCompetitor.morePoints(userMatchWindow.blueCompetitor, userMatchWindow);
        }
    }


    /**
     * Completed spinning kick of the red competitor -> add 2 points to the competitor + changing the icon of it
     * @param radioBtn changing the icon of it
     * @param userMatchWindow for all the things inside
     */
    public void spinningKickRedCompleted(JRadioButton radioBtn, UserMatch_Window userMatchWindow) {
        if (userMatchWindow.userMatchScreen.buttonAllowed) {
            radioBtn.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_selected_icon-red_small.png")));

            if (userMatchWindow.matchWindow.UpperPart.spinningKickRedFirst.isVisible()) {
                userMatchWindow.matchWindow.UpperPart.spinningKickRedFirst.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_selected_icon-red.png")));
            }
            if (userMatchWindow.matchWindow.UpperPart.spinningKickRedSecond.isVisible()) {
                userMatchWindow.matchWindow.UpperPart.spinningKickRedSecond.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_selected_icon-red.png")));
            }

            userMatchWindow.redCompetitor.getStatistics().getPoints().setPoints(userMatchWindow.redCompetitor.getStatistics().getPoints().getPoints() + 2);
            userMatchWindow.redCompetitor.morePoints(userMatchWindow.blueCompetitor, userMatchWindow);
        }
    }}
