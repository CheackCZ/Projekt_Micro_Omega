package userMatch_Window_Package;

import javax.swing.JPanel;

import objects_Package.Points;
import objects_Package.Statistics;
import userMatchPopUp_Windows_Package.PopUpSelectBreak_Window;
import userMatchPopUp_Windows_Package.PopUpSelectCompetitors_Window;
import userMatchPopUp_Windows_Package.PopUpSelectTime_Window;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JPanel with buttons for setting the match details
 * @author ondra
 */
public class UserMatchWindow_Buttons_JP extends JPanel {

    /** Button to create new match - Fn + F1 */
    public JButton btnNewMatch;
    /** Button to start new round - Fn + F2 */
    public JButton btnNewRound;
    /** Button to set the time of the break	*/
    public JButton btnSetBreak;
    /** Button to end the round */
    public JButton btnEndRound;
    /** Button to end the match */
    public JButton btnEndMatch;

    /** Pop up window to select category/competitors */
    public PopUpSelectCompetitors_Window popUpSelectCompetitors;
    /** Pop up window to select round/time */
    public PopUpSelectTime_Window popUpSelectTime;
    /** Pop up window to select break time */
    public PopUpSelectBreak_Window popUpSelectBreak;

    /** Value checking if overtime once already was */
    public boolean overtimeWas = false;

    /**
     * Create the panel
     * @param userMatchWindow for things in this class
     */
    public UserMatchWindow_Buttons_JP(UserMatch_Window userMatchWindow) {

        //Declarations of JPanels/JFrames and Objects
        popUpSelectCompetitors = new PopUpSelectCompetitors_Window(userMatchWindow);
        popUpSelectTime = new PopUpSelectTime_Window(userMatchWindow);
        popUpSelectBreak = new PopUpSelectBreak_Window(userMatchWindow);

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));


        btnNewMatch = new JButton("New Match [F1]");
        btnNewMatch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
        btnNewMatch.setBackground(Color.white);
        btnNewMatch.setFocusable(false);
        btnNewMatch.setEnabled(false);
        btnNewMatch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNewMatch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNewMatchAction(userMatchWindow);
            }
        });
        btnNewMatch.setBounds(10, 10, 150, 60);
        add(btnNewMatch);


        btnNewRound = new JButton("New Round [F2]");
        btnNewRound.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
        btnNewRound.setBackground(Color.white);
        btnNewRound.setFocusable(false);
        btnNewRound.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnNewRound.setEnabled(false);
        btnNewRound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnNewRoundAction(userMatchWindow);
            }
        });
        btnNewRound.setBounds(165, 10, 150, 60);
        add(btnNewRound);


        btnSetBreak = new JButton("Set Break [F3]");
        btnSetBreak.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
        btnSetBreak.setBackground(Color.white);
        btnSetBreak.setFocusable(false);
        btnSetBreak.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSetBreak.setEnabled(false);
        btnSetBreak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSetBreakAction();
            }
        });
        btnSetBreak.setBounds(320, 10, 150, 60);
        add(btnSetBreak);


        btnEndRound = new JButton("End Round [F4]");
        btnEndRound.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
        btnEndRound.setBackground(Color.white);
        btnEndRound.setFocusable(false);
        btnEndRound.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEndRound.setEnabled(false);
        btnEndRound.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEndRoundAction(userMatchWindow);
            }
        });
        btnEndRound.setBounds(475, 10, 150, 60);
        add(btnEndRound);


        btnEndMatch = new JButton("End Match [F5]");
        btnEndMatch.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
        btnEndMatch.setBackground(Color.white);
        btnEndMatch.setFocusable(false);
        btnEndMatch.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnEndMatch.setEnabled(false);
        btnEndMatch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  //What happens if you click the "End Match" Button
                btnEndMatchAction(userMatchWindow);
            }
        });
        btnEndMatch.setBounds(630, 10, 150, 60);
        add(btnEndMatch);

    }

    /**
     * Method - what happens when JButton "btnNewMatch" is clicked -> opens the category/competitor selection
     * @param userMatchWindow for all the things inside
     */
    public void btnNewMatchAction(UserMatch_Window userMatchWindow) {
        popUpSelectCompetitors.blueCompetitorSelection.boxCompetitorSelection.setSelectedItem(null);
        popUpSelectCompetitors.redCompetitorSelection.boxCompetitorSelection.setSelectedItem(null);

        popUpSelectTime.roundSelectionJP.automaticallySelectedIndex = 0;

        popUpSelectCompetitors.show();  //Opening the window to select the category and competitors

        //Setting the spinning kick to undone before every new Match
        userMatchWindow.userMatchScreen.upperPartJP.sKFRRed = false;
        userMatchWindow.userMatchScreen.upperPartJP.sKSRRed = false;

        userMatchWindow.userMatchScreen.upperPartJP.sKFRBlue = false;
        userMatchWindow.userMatchScreen.upperPartJP.sKSRBlue = false;

        //Setting the spinning kick icon to default
        userMatchWindow.userMatchScreen.upperPartJP.spinningKickBlueFirst.setIcon(new ImageIcon(UserMatchWindow_Buttons_JP.class.getResource("/povinnaOtocka_unselected_icon_small.png")));
        userMatchWindow.userMatchScreen.upperPartJP.spinningKickBlueSecond.setIcon(new ImageIcon(UserMatchWindow_Buttons_JP.class.getResource("/povinnaOtocka_unselected_icon_small.png")));

        userMatchWindow.userMatchScreen.upperPartJP.spinningKickRedFirst.setIcon(new ImageIcon(UserMatchWindow_Buttons_JP.class.getResource("/povinnaOtocka_unselected_icon_small.png")));
        userMatchWindow.userMatchScreen.upperPartJP.spinningKickRedSecond.setIcon(new ImageIcon(UserMatchWindow_Buttons_JP.class.getResource("/povinnaOtocka_unselected_icon_small.png")));

        userMatchWindow.matchWindow.UpperPart.spinningKickBlueFirst.setIcon(new ImageIcon(UserMatchWindow_Buttons_JP.class.getResource("/povinnaOtocka_unselected_icon.png")));
        userMatchWindow.matchWindow.UpperPart.spinningKickBlueSecond.setIcon(new ImageIcon(UserMatchWindow_Buttons_JP.class.getResource("/povinnaOtocka_unselected_icon.png")));

        userMatchWindow.matchWindow.UpperPart.spinningKickRedFirst.setIcon(new ImageIcon(UserMatchWindow_Buttons_JP.class.getResource("/povinnaOtocka_unselected_icon.png")));
        userMatchWindow.matchWindow.UpperPart.spinningKickRedSecond.setIcon(new ImageIcon(UserMatchWindow_Buttons_JP.class.getResource("/povinnaOtocka_unselected_icon.png")));

    }

    /**
     * Method - what happens when JButton "btnNewRound" is clicked -> opens the round/time selection
     * @param userMatchWindow for all the things inside
     */
    public void btnNewRoundAction(UserMatch_Window userMatchWindow) {
        popUpSelectTime.show();  //Opening the window to select the round and time
        popUpSelectTime.roundSelectionJP.listRounds.setSelectedIndex(popUpSelectTime.roundSelectionJP.automaticallySelectedIndex);

        userMatchWindow.redCompetitor.morePoints(userMatchWindow.blueCompetitor, userMatchWindow); //Using this to see the correct points in the beginning
    }

    /**
     * Method - what happens when JButton "btnSetBreak" is clicked -> break setting window pops up
     */
    public void btnSetBreakAction() {
        popUpSelectBreak.show();
    }

    /**
     * Method - what happens when JButton "btnEndRound" is clicked -> opens the window to end the round
     * @param userMatchWindow for all the things inside
     */
    public void btnEndRoundAction(UserMatch_Window userMatchWindow) {
        String [] optionsButtons = {"Yes","No"};
        int promptResult = JOptionPane.showOptionDialog(null, "Do you wanna end this round?", "Ending the Round", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionsButtons,optionsButtons[1]);

        if (promptResult == JOptionPane.YES_OPTION) {  //If wanna end the match -> this happens
            //Sets buttons that should be to enabled or opposite
            btnNewRound.setEnabled(false);
            btnEndMatch.setEnabled(true);
            btnSetBreak.setEnabled(true);

            btnEndRound.setEnabled(false);

            //Disabling the time button for user to not miss click the time
            userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.setEnabled(false);
            userMatchWindow.matchWindow.RoundAndTime.btnClock.setEnabled(false);

            //Stopping the timer when ending the round
            userMatchWindow.userMatchScreen.roundAndTimeJp.timer.stop();
            userMatchWindow.matchWindow.RoundAndTime.timer.stop();


            userMatchWindow.userMatchWindowSettingsButtons.btnRefresh.setEnabled(true);  //Enabling refresh button

            //Disabling the buttons to work
            userMatchWindow.userMatchScreen.buttonAllowed = false;
        }
    }

    /**
     * Method - what happens when JButton "btnEndMatch" is clicked -> opens the window to end the match
     * @param userMatchWindow for all the things inside
     */
    public void btnEndMatchAction(UserMatch_Window userMatchWindow) {
        String [] optionsButtons = {"Yes","No"};
        int promptResult = JOptionPane.showOptionDialog(null, "Do you wanna end this match?", "Ending the Match", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionsButtons,optionsButtons[1]);

        if(promptResult == JOptionPane.YES_OPTION) {  //Sets buttons that should be to enabled or opposite

            userMatchWindow.match.setTime("0:00");
            userMatchWindow.match.setRound("");

            //Setting the properties to user match screen
            userMatchWindow.userMatchScreen.blueCompetitorDataJP.txtClubBlue.setText("");
            userMatchWindow.userMatchScreen.blueCompetitorDataJP.txtNameBlue.setText("");
            userMatchWindow.userMatchScreen.blueCompetitorDataJP.txtLastNameBlue.setText("");

            userMatchWindow.userMatchScreen.redCompetitorDataJP.txtClubRed.setText("");
            userMatchWindow.userMatchScreen.redCompetitorDataJP.txtNameRed.setText("");
            userMatchWindow.userMatchScreen.redCompetitorDataJP.txtLastNameRed.setText("");


            userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.setText(userMatchWindow.match.getTime());
            userMatchWindow.userMatchScreen.roundAndTimeJp.txtMatchRound.setText(userMatchWindow.match.getRound());

            //Spinning kicks
            userMatchWindow.userMatchScreen.upperPartJP.spinningKickRedFirst.setVisible(false);
            userMatchWindow.userMatchScreen.upperPartJP.spinningKickRedSecond.setVisible(false);

            userMatchWindow.userMatchScreen.upperPartJP.spinningKickBlueFirst.setVisible(false);
            userMatchWindow.userMatchScreen.upperPartJP.spinningKickBlueSecond.setVisible(false);


            //Setting the properties to match window
            userMatchWindow.matchWindow.BlueCompetitorData.txtClubBlue.setText("");
            userMatchWindow.matchWindow.BlueCompetitorData.txtNameBlue.setText("");
            userMatchWindow.matchWindow.BlueCompetitorData.txtLastNameBlue.setText("");

            userMatchWindow.matchWindow.RedCompetitorData.txtClubRed.setText("");
            userMatchWindow.matchWindow.RedCompetitorData.txtNameRed.setText("");
            userMatchWindow.matchWindow.RedCompetitorData.txtLastNameRed.setText("");

            userMatchWindow.matchWindow.RoundAndTime.btnClock.setText(userMatchWindow.match.getTime());
            userMatchWindow.matchWindow.RoundAndTime.txtMatchRound.setText(userMatchWindow.match.getRound());

            //Spinning kicks
            userMatchWindow.matchWindow.UpperPart.spinningKickRedFirst.setVisible(false);
            userMatchWindow.matchWindow.UpperPart.spinningKickRedSecond.setVisible(false);

            userMatchWindow.matchWindow.UpperPart.spinningKickBlueFirst.setVisible(false);
            userMatchWindow.matchWindow.UpperPart.spinningKickBlueSecond.setVisible(false);

            //Setting points to zero between the matches
            userMatchWindow.redCompetitor.setStatistics(new Statistics(new Points(0,0,0), false));
            userMatchWindow.blueCompetitor.setStatistics(new Statistics(new Points(0,0,0), false));

            userMatchWindow.redCompetitor.morePoints(userMatchWindow.blueCompetitor, userMatchWindow);

            //Enabling buttons to continue
            btnNewMatch.setEnabled(true);
            btnEndMatch.setEnabled(false);
            btnNewRound.setEnabled(false);
            btnSetBreak.setEnabled(false);


            userMatchWindow.userMatchWindowButtons.popUpSelectTime.isEnabled = false;
        }
    }}
