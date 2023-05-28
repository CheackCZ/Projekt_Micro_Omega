package userMatch_Window_Package;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

/**
 * Class extending abstract method for kez board usage
 * @author ondra
 */
public class UserMatchWindow_KeyBoard extends UserMatchWindow_AbstractClass {

    /**
     * Abstract method from UserMatchWindow_keyMethods
     * Using this method inside the UserMatch_Window class for keyboard usage
     */
    public void keyMethods(KeyEvent e, UserMatch_Window userMatchWindow) {
        if (e.getKeyCode() == 112) {  //'fn + f1' to open the category/competitor selection
            if (userMatchWindow.userMatchWindowButtons.btnNewMatch.isEnabled()) {
                userMatchWindow.userMatchWindowButtons.btnNewMatchAction(userMatchWindow);
            }
        }

        if (e.getKeyCode() == 113) {  //'fn + f2' to open the round/time selection
            if (userMatchWindow.userMatchWindowButtons.btnNewRound.isEnabled()) {
                userMatchWindow.userMatchWindowButtons.btnNewRoundAction(userMatchWindow);
            }
        }

        if (e.getKeyCode() == 114) {  //'fn + f3' to open the time of the break
            if (userMatchWindow.userMatchWindowButtons.btnSetBreak.isEnabled()) {
                userMatchWindow.userMatchWindowButtons.btnSetBreakAction();
            }
        }

        if (e.getKeyCode() == 115) {  //'fn + f4' to end the round
            if (userMatchWindow.userMatchWindowButtons.btnEndRound.isEnabled()) {
                userMatchWindow.userMatchWindowButtons.btnEndRoundAction(userMatchWindow);
            }
        }

        if (e.getKeyCode() == 116) {   //'fn + f5' to end the match
            if (userMatchWindow.userMatchWindowButtons.btnEndMatch.isEnabled()) {
                userMatchWindow.userMatchWindowButtons.btnEndMatchAction(userMatchWindow);
            }
        }

        if (e.getKeyCode() == 117) {   //'fn + f6' to set the ring number
            if (userMatchWindow.userMatchWindowSettingsButtons.btnSetRingNumber.isEnabled()) {
                userMatchWindow.userMatchWindowSettingsButtons.btnSetRingNumberAction(userMatchWindow);
            }
        }

        if (e.getKeyCode() == 118) {   //'fn + f7' to refresh all details
            if (userMatchWindow.userMatchWindowSettingsButtons.btnRefresh.isEnabled()) {
                userMatchWindow.userMatchWindowSettingsButtons.btnRefreshAction(userMatchWindow);
            }
        }

        if (e.getKeyCode() == 32) {  //'Space' to start and stop the time
            if (userMatchWindow.userMatchWindowButtons.popUpSelectTime.isEnabled) {
                if (userMatchWindow.matchWindow.RoundAndTime.started == false) {
                    userMatchWindow.matchWindow.RoundAndTime.started = true;

                    userMatchWindow.userMatchScreen.roundAndTimeJp.timer.start();
                    userMatchWindow.matchWindow.RoundAndTime.timer.start();
                } else {
                    userMatchWindow.matchWindow.RoundAndTime.started = false;

                    userMatchWindow.userMatchScreen.roundAndTimeJp.timer.stop();
                    userMatchWindow.matchWindow.RoundAndTime.timer.stop();
                }
            }
        }

        //Using this for these things to be always focused on
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_SPACE) {
                    userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.doClick(); // Trigger the button action
                    return true; // Consume the event
                }

                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == 37) {  //'<-' to add points to the blue competitor
                    userMatchWindow.userMatchScreen.pointJP.btnBluePointsAction(userMatchWindow);
                    return true;
                }

                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == 39) {  //'->' to add points to the red competitor
                    userMatchWindow.userMatchScreen.pointJP.btnRedPointsAction(userMatchWindow);
                    return true;
                }

                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == 81) {  //'q' to add foul points to the blue competitor
                    userMatchWindow.userMatchScreen.faulPointsBlueJP.btnFoulPointsAction(userMatchWindow);
                    return true;
                }

                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == 80) {  //'p' to add foul points to the red competitor
                    userMatchWindow.userMatchScreen.faulPointsRedJP.btnFoulPointsAction(userMatchWindow);
                    return true;
                }

                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == 87) {  //'w' to add yellow card to the blue competitor
                    userMatchWindow.userMatchScreen.faulPointsBlueJP.btnYellowCards.doClick();
                    return true;
                }

                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == 79) {  //'w' to add yellow card to the red competitor
                    userMatchWindow.userMatchScreen.faulPointsRedJP.btnYellowCards.doClick();
                    return true;
                }

                return false;
            }
        });
        System.out.println(e.getKeyCode());
    }}
