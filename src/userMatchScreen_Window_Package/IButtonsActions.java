package userMatchScreen_Window_Package;

import userMatch_Window_Package.UserMatch_Window;

/**
 * Interface including two methods used in two different classes
 * @author ondra
 */
public interface IButtonsActions {

    /**
     * Method to add Foul Points to competitors
     * @param userMatchWindow for all the things inside
     */
    public void btnFoulPointsAction(UserMatch_Window userMatchWindow);

    /**
     * Method to add Yellow Cards to competitors
     * @param userMatchWindow for all the things inside
     */
    public void btnYellowCardAction(UserMatch_Window userMatchWindow);
}
