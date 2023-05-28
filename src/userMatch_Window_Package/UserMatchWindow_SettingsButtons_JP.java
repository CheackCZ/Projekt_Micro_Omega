package userMatch_Window_Package;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import userMatchPopUp_Windows_Package.PopUpSelectRingNumber_Window;

/**
 * JPanel including settings buttons
 * @author ondra
 */
public class UserMatchWindow_SettingsButtons_JP extends JPanel {

    /** Button to set the ring number */
    public JButton btnSetRingNumber;
    /** Button to refresh all the fields (to be clear) */
    public JButton btnRefresh;

    /** Pop Up window to select the ring number opens on btnSetRingNumber button */
    public PopUpSelectRingNumber_Window popUpSelectRingNum;

    /**
     * Create the Panel
     * @param userMatchWindow for all the things inside
     */
    public UserMatchWindow_SettingsButtons_JP(UserMatch_Window userMatchWindow) {

        //Declarations of JPanels/JFrames and Objects
        popUpSelectRingNum = new PopUpSelectRingNumber_Window(userMatchWindow);

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));


        btnSetRingNumber= new JButton("Set Ring Number [F6]");
        btnSetRingNumber.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
        btnSetRingNumber.setBackground(Color.white);
        btnSetRingNumber.setFocusable(false);
        btnSetRingNumber.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSetRingNumber.setEnabled(true);
        btnSetRingNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  //What happens if you click the "Set ring number" Button
                btnSetRingNumberAction(userMatchWindow);
            }
        });
        btnSetRingNumber.setBounds(10, 10, 170, 60);
        add(btnSetRingNumber);


        btnRefresh = new JButton("Refresh [F7]");
        btnRefresh.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
        btnRefresh.setFocusable(false);
        btnRefresh.setEnabled(false);
        btnRefresh.setBackground(Color.WHITE);
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  //What happens if you click the "Refresh" Button
                btnRefreshAction(userMatchWindow);
            }
        });
        btnRefresh.setBounds(185, 10, 150, 60);
        add(btnRefresh);
    }

    /**
     * Method - what happens when JButton "btnSetRingNumber" is clicked -> opens the ring number selection
     * @param userMatchWindow for all the things inside
     */
    public void btnSetRingNumberAction(UserMatch_Window userMatchWindow) {
        popUpSelectRingNum.show();
    }

    /**
     * /Method - what happens when JButton "btnRefresh" is clicked -> refreshes all the details
     * @param userMatchWindow for all the things inside
     */
    public void btnRefreshAction(UserMatch_Window userMatchWindow) {
        //Clearing all the details (User match screen)
        userMatchWindow.userMatchScreen.upperPartJP.txtCategory.setText("");
        userMatchWindow.userMatchScreen.upperPartJP.txtRingNumber.setText("RING");

        userMatchWindow.userMatchScreen.blueCompetitorDataJP.txtClubBlue.setText("");
        userMatchWindow.userMatchScreen.blueCompetitorDataJP.txtNameBlue.setText("");
        userMatchWindow.userMatchScreen.blueCompetitorDataJP.txtLastNameBlue.setText("");

        userMatchWindow.userMatchScreen.redCompetitorDataJP.txtClubRed.setText("");
        userMatchWindow.userMatchScreen.redCompetitorDataJP.txtNameRed.setText("");
        userMatchWindow.userMatchScreen.redCompetitorDataJP.txtLastNameRed.setText("");


        //Setting the time to the start position
        userMatchWindow.match.setTime("0:00");
        userMatchWindow.match.setRound("");

        userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.setText(userMatchWindow.match.getTime());
        userMatchWindow.matchWindow.RoundAndTime.btnClock.setText(userMatchWindow.match.getTime());

        userMatchWindow.userMatchScreen.roundAndTimeJp.txtMatchRound.setText(userMatchWindow.match.getRound());
        userMatchWindow.matchWindow.RoundAndTime.txtMatchRound.setText(userMatchWindow.match.getRound());


        //Setting the properties to user match window
        userMatchWindow.matchWindow.UpperPart.txtCategory.setText("");
        userMatchWindow.matchWindow.UpperPart.txtRingNumber.setText("RING");

        userMatchWindow.matchWindow.BlueCompetitorData.txtClubBlue.setText("");
        userMatchWindow.matchWindow.BlueCompetitorData.txtNameBlue.setText("");
        userMatchWindow.matchWindow.BlueCompetitorData.txtLastNameBlue.setText("");

        userMatchWindow.matchWindow.RedCompetitorData.txtClubRed.setText("");
        userMatchWindow.matchWindow.RedCompetitorData.txtNameRed.setText("");
        userMatchWindow.matchWindow.RedCompetitorData.txtLastNameRed.setText("");


        //Refreshing the buttons
        userMatchWindow.userMatchWindowButtons.btnNewMatch.setEnabled(false);
        userMatchWindow.userMatchWindowButtons.btnEndMatch.setEnabled(false);
        userMatchWindow.userMatchWindowButtons.btnNewRound.setEnabled(false);
        userMatchWindow.userMatchWindowButtons.btnEndRound.setEnabled(false);
        userMatchWindow.userMatchWindowButtons.btnSetBreak.setEnabled(false);

        //Setting the text with points to zero
        userMatchWindow.userMatchScreen.pointJP.btnBluePoints.setText("0");
        userMatchWindow.userMatchScreen.pointJP.btnRedPoints.setText("0");

        btnRefresh.setEnabled(false);
        btnSetRingNumber.setEnabled(true);


        //Refreshing the pop up windows as well
        userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.userMatchPopUp_Category.boxCategorySelection.setSelectedItem(null);

        userMatchWindow.userMatchWindowButtons.popUpSelectTime.isEnabled = false;
    }}
