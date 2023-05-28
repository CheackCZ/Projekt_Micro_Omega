package userMatch_Window_Package;

import java.awt.event.KeyEvent;

/**
 * Abstract class with one method
 * @author ondra
 */
public abstract class UserMatchWindow_AbstractClass {

    /**
     * Abstract method -> filling the method in UserMatchWindow_KeyBoard class
     * @param e for the event I'm using it in
     * @param userMatchWindow with all the stuff I need
     */
    public abstract void keyMethods(KeyEvent e, UserMatch_Window userMatchWindow);
}
