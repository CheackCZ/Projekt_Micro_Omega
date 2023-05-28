package userMatchPopUp_Windows_Package;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import userMatch_Window_Package.UserMatch_Window;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;

/**
 * Pop up window to select the round and time
 * @author ondra
 */
public class PopUpSelectTime_Window extends JFrame {

    private JPanel contentPane;

    /** JButton to confirm the selection */
    public JButton btnConfirmSelection;


    /** Adding JPanel with the round selection for this window  */
    public UserMatchPopUp_RoundSelection_JP roundSelectionJP;
    /** Adding JPanel with the time selection for this window  */
    public UserMatchPopUp_TimeSelection_JP timeSelectionJP;

    /** Variable to see if space can be used */
    public boolean isEnabled = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PopUpSelectTime_Window frame = new PopUpSelectTime_Window(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the Frame
     * @param userMatchWindow to use the things inside
     */
    public PopUpSelectTime_Window(UserMatch_Window userMatchWindow) {

        //Declarations of JPanels/JFrames and Objects
        roundSelectionJP = new UserMatchPopUp_RoundSelection_JP(userMatchWindow);
        timeSelectionJP = new UserMatchPopUp_TimeSelection_JP(userMatchWindow);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 250, 350);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);  //Location of the first window exactly in the center of the monitor

        setTitle("Selection");
        setResizable(false);


        btnConfirmSelection = new JButton("Confirm");
        btnConfirmSelection.setToolTipText("Confirm Selection and move on to the match");
        btnConfirmSelection.setBackground(Color.white);
        btnConfirmSelection.setFocusable(false);
        btnConfirmSelection.setEnabled(false);
        btnConfirmSelection.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirmSelection.setBorder(BorderFactory.createLineBorder(Color.gray));
        btnConfirmSelection.setFont(new Font("Arial", Font.PLAIN, 12));
        btnConfirmSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SettingTimeAndRound(userMatchWindow);
                //Allowing the buttons to work
                userMatchWindow.userMatchScreen.buttonAllowed = true;

                roundSelectionJP.pointsToZeroOT(userMatchWindow);

                minusPoints(userMatchWindow, roundSelectionJP);

                automaticSelectionOfIndex(userMatchWindow);
            }
        });
        btnConfirmSelection.setBounds(75, 275, 85, 25);
        contentPane.add(btnConfirmSelection);


        //Addressing the JPanels to the  JFrame

        roundSelectionJP.setBounds(10, 10, 216, 125);
        contentPane.add(roundSelectionJP);

        timeSelectionJP.setBounds(10, 140, 216, 125);
        contentPane.add(timeSelectionJP);

    }

    /**
     * Method that setting the time and round of the match
     * @param userMatchWindow to use the things inside
     */
    public void SettingTimeAndRound(UserMatch_Window userMatchWindow) {
        //Setting the text on the button with time
        userMatchWindow.match.setRound(userMatchWindow.userMatchWindowButtons.popUpSelectTime.roundSelectionJP.listRounds.getSelectedValue().toString());
        userMatchWindow.match.setTime(userMatchWindow.userMatchWindowButtons.popUpSelectTime.timeSelectionJP.listTimes.getSelectedValue().toString());


        userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.setText(userMatchWindow.match.getTime());
        userMatchWindow.userMatchScreen.roundAndTimeJp.txtMatchRound.setText(userMatchWindow.match.getRound());

        userMatchWindow.matchWindow.RoundAndTime.btnClock.setText(userMatchWindow.match.getTime());
        userMatchWindow.matchWindow.RoundAndTime.txtMatchRound.setText(userMatchWindow.match.getRound());

        userMatchWindow.match.settingMinutesAndSeconds(userMatchWindow);


        //Setting the color to black for user to know when "space" on keyboard will be working
        userMatchWindow.matchWindow.RoundAndTime.btnClock.setForeground(Color.black);
        userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.setForeground(Color.black);

        userMatchWindow.matchWindow.RoundAndTime.txtMatchRound.setForeground(Color.black);
        userMatchWindow.userMatchScreen.roundAndTimeJp.txtMatchRound.setForeground(Color.black);


        //Stopping the timer when new round is about to start
        userMatchWindow.userMatchScreen.roundAndTimeJp.timer.stop();
        userMatchWindow.matchWindow.RoundAndTime.timer.stop();


        userMatchWindow.userMatchWindowButtons.btnEndRound.setEnabled(true);
        userMatchWindow.userMatchWindowButtons.btnEndMatch.setEnabled(false);
        userMatchWindow.userMatchWindowButtons.btnNewRound.setEnabled(false);

        userMatchWindow.userMatchWindowSettingsButtons.btnRefresh.setEnabled(false);  //Disabling refresh button

        //Enabling the clock button so user can start/stop the time
        userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.setEnabled(true);
        userMatchWindow.matchWindow.RoundAndTime.btnClock.setEnabled(true);


        //Spinning Kick visibility
        spinningKickVisibility(userMatchWindow);

        isEnabled = true;

        this.dispose();
    }

    /**
     * Method that shows the spinning kick to be selected by type of the round
     * @param userMatchWindow to use the things inside
     */
    public void spinningKickVisibility(UserMatch_Window userMatchWindow) {
        switch (roundSelectionJP.listRounds.getSelectedIndex()) {
            case 0:  //1. Round
                userMatchWindow.userMatchScreen.upperPartJP.spinningKickBlueFirst.setVisible(true);
                userMatchWindow.matchWindow.UpperPart.spinningKickBlueFirst.setVisible(true);

                userMatchWindow.userMatchScreen.upperPartJP.spinningKickRedFirst.setVisible(true);
                userMatchWindow.matchWindow.UpperPart.spinningKickRedFirst.setVisible(true);

                userMatchWindow.userMatchScreen.upperPartJP.spinningKickBlueSecond.setVisible(false);
                userMatchWindow.matchWindow.UpperPart.spinningKickBlueSecond.setVisible(false);

                userMatchWindow.userMatchScreen.upperPartJP.spinningKickRedSecond.setVisible(false);
                userMatchWindow.matchWindow.UpperPart.spinningKickRedSecond.setVisible(false);
                break;
            case 1:  //2. Round
                userMatchWindow.userMatchScreen.upperPartJP.spinningKickBlueFirst.setVisible(true);
                userMatchWindow.matchWindow.UpperPart.spinningKickBlueFirst.setVisible(true);

                userMatchWindow.userMatchScreen.upperPartJP.spinningKickRedFirst.setVisible(true);
                userMatchWindow.matchWindow.UpperPart.spinningKickRedFirst.setVisible(true);


                userMatchWindow.userMatchScreen.upperPartJP.spinningKickBlueSecond.setVisible(true);
                userMatchWindow.matchWindow.UpperPart.spinningKickBlueSecond.setVisible(true);

                userMatchWindow.userMatchScreen.upperPartJP.spinningKickRedSecond.setVisible(true);
                userMatchWindow.matchWindow.UpperPart.spinningKickRedSecond.setVisible(true);
                break;
            default:  //Any other round
                userMatchWindow.userMatchScreen.upperPartJP.spinningKickBlueFirst.setVisible(false);
                userMatchWindow.matchWindow.UpperPart.spinningKickBlueFirst.setVisible(false);

                userMatchWindow.userMatchScreen.upperPartJP.spinningKickBlueSecond.setVisible(false);
                userMatchWindow.matchWindow.UpperPart.spinningKickBlueSecond.setVisible(false);


                userMatchWindow.userMatchScreen.upperPartJP.spinningKickRedSecond.setVisible(false);
                userMatchWindow.matchWindow.UpperPart.spinningKickRedSecond.setVisible(false);

                userMatchWindow.userMatchScreen.upperPartJP.spinningKickRedFirst.setVisible(false);
                userMatchWindow.matchWindow.UpperPart.spinningKickRedFirst.setVisible(false);
        }
    }

    /**
     * Method minus 2 points at both competitors in the beginning of the round
     * @param userMatchWindow for all the things inside
     * @param roundSelectionJP for the minus points value
     */
    public void minusPoints(UserMatch_Window userMatchWindow, UserMatchPopUp_RoundSelection_JP roundSelectionJP) {
        if (roundSelectionJP.minusPoints) {
            userMatchWindow.redCompetitor.getStatistics().getPoints().setPoints(userMatchWindow.redCompetitor.getStatistics().getPoints().getPoints() - 2);
            userMatchWindow.blueCompetitor.getStatistics().getPoints().setPoints(userMatchWindow.blueCompetitor.getStatistics().getPoints().getPoints() - 2);

            userMatchWindow.redCompetitor.morePoints(userMatchWindow.blueCompetitor, userMatchWindow);
        }
    }

    /**
     * Method automatically selecting the round and time that should be
     * @param userMatchWindow for all the things inside
     */
    public void automaticSelectionOfIndex(UserMatch_Window userMatchWindow) {
        userMatchWindow.userMatchWindowButtons.popUpSelectTime.roundSelectionJP.listRounds.setSelectedIndex(userMatchWindow.userMatchWindowButtons.popUpSelectTime.roundSelectionJP.automaticallySelectedIndex);
        if (userMatchWindow.userMatchWindowButtons.popUpSelectTime.roundSelectionJP.automaticallySelectedIndex == 2) {
            if (!userMatchWindow.userMatchWindowButtons.overtimeWas) {
                userMatchWindow.userMatchWindowButtons.overtimeWas = true;
                userMatchWindow.userMatchWindowButtons.popUpSelectTime.roundSelectionJP.automaticChoosingOfTime(userMatchWindow);
            } else if (userMatchWindow.userMatchWindowButtons.overtimeWas) {
                userMatchWindow.userMatchWindowButtons.popUpSelectTime.roundSelectionJP.automaticallySelectedIndex++;
                userMatchWindow.userMatchWindowButtons.popUpSelectTime.roundSelectionJP.automaticChoosingOfTime(userMatchWindow);
            }
        } else {
            userMatchWindow.userMatchWindowButtons.popUpSelectTime.roundSelectionJP.automaticallySelectedIndex++;
            userMatchWindow.userMatchWindowButtons.popUpSelectTime.roundSelectionJP.automaticChoosingOfTime(userMatchWindow);
            userMatchWindow.userMatchWindowButtons.overtimeWas = false;
        }
    }
}


