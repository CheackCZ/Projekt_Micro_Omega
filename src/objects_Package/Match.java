package objects_Package;

import userMatch_Window_Package.UserMatch_Window;

/**
 * Class for match details
 */
public class Match {

    private String time;
    private String round;

    /**
     * Constructor using fields
     * @param time of the match
     * @param round of the match
     */
    public Match(String time, String round) {
        this.time = time;
        this.round = round;
    }

    /**
     * Constructor without the fields
     */
    public Match() {
    }


    /**
     * @return time (String)
     */
    public String getTime() {
        return time;
    }
    /**
     * @param time (String)
     */
    public void setTime(String time) {
        this.time = time;
    }
    /**
     * @return round (String)
     */
    public String getRound() {
        return round;
    }
    /**
     * @param round (String)
     */
    public void setRound(String round) {
        this.round = round;
    }


    /**
     * Method to set the seconds and minutes inside the timer
     * @param userMatchWindow for all the things inside
     */
    public void settingMinutesAndSeconds(UserMatch_Window userMatchWindow) {
        String txtCas = userMatchWindow.match.getTime();
        String [] parts = txtCas.split(":");  //Seperating the string values with ":"

        int minutes = 0;
        int seconds = 0;

        if ((txtCas.length() == 4) || (txtCas.length() == 5)) {
            minutes = Integer.parseInt(parts[0]);
            seconds = Integer.parseInt(parts[1]);

            //Setting the time
            userMatchWindow.userMatchScreen.roundAndTimeJp.setMinute(minutes);
            userMatchWindow.userMatchScreen.roundAndTimeJp.setSecond(seconds);

            userMatchWindow.matchWindow.RoundAndTime.setMinute(minutes);
            userMatchWindow.matchWindow.RoundAndTime.setSecond(seconds);
        }
    }}
