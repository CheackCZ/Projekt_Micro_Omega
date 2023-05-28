package userMatchPopUp_Windows_Package;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import objects_Package.Competitor;
import userMatch_Window_Package.UserMatch_Window;

import javax.swing.JScrollPane;

/**
 * with the round selection details
 * @author ondra
 */
public class UserMatchPopUp_RoundSelection_JP extends JPanel {

    /** JTextField to help user to select the round */
    private JTextField txtChooseRound;

    /** JList to choose round from */
    public JList listRounds;


    /** Array with the rounds to select from */
    public static String [] rounds = {"1. Round", "2. Round", "Overtime", "Golden Point"};

    /** Variable showing if the automatic counting should count or not*/
    public boolean automaticSelectedIndexAvailable = false;
    /** Helps user with the selection (Automatic). Makes it easier for user. */
    public int automaticallySelectedIndex = 0;

    /** Controlling if two points should */
    public boolean minusPoints = false;

    /**
     * @param userMatchWindow to use the things inside
     */
    public UserMatchPopUp_RoundSelection_JP(UserMatch_Window userMatchWindow) {

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);


        txtChooseRound = new JTextField();
        txtChooseRound.setBackground(Color.LIGHT_GRAY);
        txtChooseRound.setFont(new Font("Arial", Font.PLAIN, 12));
        txtChooseRound.setText("Choose Round:");
        txtChooseRound.setEditable(false);
        txtChooseRound.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        txtChooseRound.setBounds(0, 0, 102, 25);
        add(txtChooseRound);
        txtChooseRound.setColumns(10);


        //JScroolPane to scroll thru
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 25, 216, 100);
        add(scrollPane);


        listRounds = new JList(rounds);
        listRounds.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listRounds.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {  //Method enabling/disabling confirm button depends on whether
                //round is selected (even automatically)
                if (listRounds.getSelectedValue() != null) {
                    if (userMatchWindow.userMatchWindowButtons.popUpSelectTime.timeSelectionJP.listTimes.getSelectedValue() != null) {
                        userMatchWindow.userMatchWindowButtons.popUpSelectTime.btnConfirmSelection.setEnabled(true);
                    } else {
                        userMatchWindow.userMatchWindowButtons.popUpSelectTime.btnConfirmSelection.setEnabled(false);
                    }
                    automaticChoosingOfTime(userMatchWindow);
                } else {
                    userMatchWindow.userMatchWindowButtons.popUpSelectTime.btnConfirmSelection.setEnabled(false);
                }
            }
        });
        scrollPane.setViewportView(listRounds);
        listRounds.setFont(new Font("Arial", Font.PLAIN, 12));
    }

    /**
     * Method that helps user selecting the times of the round
     * @param userMatchWindow to use the things inside
     */
    public void automaticChoosingOfTime(UserMatch_Window userMatchWindow) {
        String roundText = listRounds.getSelectedValue().toString().toLowerCase().trim();
        JList list = userMatchWindow.userMatchWindowButtons.popUpSelectTime.timeSelectionJP.listTimes;

        switch (roundText) {
            case "overtime":
                list.setSelectedIndex(0);
                minusPoints = false;
                break;
            case "golden point":
                list.setSelectedIndex(5);
                minusPoints = false;
                break;
            case "1. round":
                automaticChoosingOfTimeByCategory(userMatchWindow);
                minusPoints = true;
                break;
            case "2. round":
                automaticChoosingOfTimeByCategory(userMatchWindow);
                minusPoints = true;
                userMatchWindow.userMatchScreen.upperPartJP.sKFRRed = true;
                userMatchWindow.userMatchScreen.upperPartJP.sKFRBlue = true;
                break;
            default:
                automaticChoosingOfTimeByCategory(userMatchWindow);
                minusPoints = false;
                break;
        }
    }


    /**
     * Method that helps user selecting the times of the round depending on the age of the category selected
     * @param userMatchWindow to use the things inside
     */
    public void automaticChoosingOfTimeByCategory(UserMatch_Window userMatchWindow) {
        int ageInterval = (int) userMatchWindow.category.getAgeInterval().getUpperPart();
        JList list = userMatchWindow.userMatchWindowButtons.popUpSelectTime.timeSelectionJP.listTimes;

        switch (ageInterval) {
            case 10:
                list.setSelectedIndex(0);
                break;
            case 13:
                list.setSelectedIndex(1);
                break;
            case 15:
                list.setSelectedIndex(2);
                break;
            case 18:
                list.setSelectedIndex(2);
                break;
            case 39:
                list.setSelectedIndex(2);
                break;
            case 60:
                list.setSelectedIndex(1);
                break;
        }

    }


    /**
     * Method that sets competitors points to zero because in overtime they are starting a brand new match
     * @param userMatchWindow to use the things inside
     */
    public void pointsToZeroOT(UserMatch_Window userMatchWindow) {
        String text = listRounds.getSelectedValue().toString().toLowerCase().trim();

        if (text.equals("overtime") || text.equals("golden point")) {
            //Red Competitor's stats to zero
            Competitor red = userMatchWindow.redCompetitor;

            red.getStatistics().getPoints().setFoulPoints(0);
            red.getStatistics().getPoints().setYellowCards(0, userMatchWindow);
            red.getStatistics().getPoints().setPoints(0);

            //Blue Competitor's stats to zero
            Competitor blue = userMatchWindow.blueCompetitor;

            blue.getStatistics().getPoints().setFoulPoints(0);
            blue.getStatistics().getPoints().setYellowCards(0, userMatchWindow);
            blue.getStatistics().getPoints().setPoints(0);


            red.morePoints(blue, userMatchWindow);
        }
    }}
