package objects_Package;

import javax.swing.JOptionPane;

import userMatch_Window_Package.UserMatch_Window;

/**
 * Class with all kinds of points as Statistics
 * @author ondra
 */
public class Points {

    public int points;
    public int foulPoints;

    public int yellowCards;


    /**
     * Contructor using all fields
     * @param points of the competitor
     * @param foulPoints of the competitor
     * @param yellowCards of the competitor
     */
    public Points(int points, int foulPoints, int yellowCards) {
        this.points = points;
        this.foulPoints = foulPoints;
        this.yellowCards = yellowCards;
    }


    //Setters and Getters
    /**
     * @return -ing the number of competitor points (int)
     */
    public int getPoints() {
        return points;
    }
    /**
     * @param points (int)
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return -ing the number of competitors foul points (int)
     */
    public int getFoulPoints() {
        return foulPoints;
    }
    /**
     * @param foulPoints (int)
     */
    public void setFoulPoints(int foulPoints) {
        if (foulPoints % 3 == 0) {  //If number of foul points divided by 3 equals zero, than the competitor losing one point
            this.points--;
        }
        this.foulPoints = foulPoints;
    }

    /**
     * @return number of yellow cards (int)
     */
    public int getYellowCards() {
        return yellowCards;
    }
    /**
     * Setting the number of yellow cards and also controlling number of them
     * @param yellowCards of the competitor
     * @param userMatchWindow for all the things inside
     */
    public void setYellowCards(int yellowCards, UserMatch_Window userMatchWindow) {
        this.yellowCards = yellowCards;
        this.setPoints(getPoints()-1);
        if (this.getYellowCards() == 3) {  //If number of yellow cards equals zero, than the competitor is disqualificated
            JOptionPane.showMessageDialog(null, "Competitor's third yellow card!\nTherefore he's disqualified!", "Disqualification", JOptionPane.WARNING_MESSAGE);
            disqualificationMethod(userMatchWindow);
            userMatchWindow.userMatchScreen.buttonAllowed = false;
        }
    }


    /**
     * When competitor is disqualificated -> end of the match -> opponent is the winner
     * @param userMatchWindow for all the things inside
     */
    public void disqualificationMethod(UserMatch_Window userMatchWindow) {
        //Sets buttons to enabled/disabled
        userMatchWindow.userMatchWindowButtons.btnNewRound.setEnabled(false);
        userMatchWindow.userMatchWindowButtons.btnEndMatch.setEnabled(true);
        userMatchWindow.userMatchWindowButtons.btnSetBreak.setEnabled(false);

        userMatchWindow.userMatchWindowButtons.btnEndRound.setEnabled(false);

        //Disabling the time button for user to not miss click the time
        userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.setEnabled(false);
        userMatchWindow.matchWindow.RoundAndTime.btnClock.setEnabled(false);

        //Stopping the timer when ending the round
        userMatchWindow.userMatchScreen.roundAndTimeJp.timer.stop();
        userMatchWindow.matchWindow.RoundAndTime.timer.stop();

        userMatchWindow.userMatchWindowSettingsButtons.btnRefresh.setEnabled(true);  //Enabling refresh button

    }}
