package userMatchScreen_Window_Package;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import userMatch_Window_Package.UserMatch_Window;

/**
 * JPanel with the match screen for user to see it as well
 * @author ondra
 */
public class UserMatch_Screen_JP extends JPanel {

    /** Adding JPanel with the data of the blue competitor for this window */
    public BlueCompetitorDataUserMatch_JP blueCompetitorDataJP;
    /** Adding JPanel with the data of the red competitor for this window */
    public RedCompetitorDataUserMatch_JP redCompetitorDataJP;

    /** Adding JPanel with the upper part of the screen for this window */
    public UpperPartUserMatch_JP upperPartJP;

    /** Adding JPanel with the fouls of the blue competitor for this window */
    public FaulPointsBlueCompetitorUserMatch_JP faulPointsBlueJP;
    /** Adding JPanel with the fouls of the red competitor for this window */
    public FaulPointsRedCompetitorUserMatch_JP faulPointsRedJP;

    /** Adding JPanel with the round and time for this window */
    public RoundAndTimeUserMatch_JP roundAndTimeJp;

    /** Adding JPanel with the points for this window */
    public PointsUserMatch_JP pointJP;

    /** Enabling/Disabling buttons function */
    public boolean buttonAllowed;

    /**
     * Create the Panel
     * @param userMatchWindow for all the things inside
     */
    public UserMatch_Screen_JP(UserMatch_Window userMatchWindow) {

        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.black));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(null);


        //Declarations of JPanels/JFrames and Objects
        blueCompetitorDataJP = new BlueCompetitorDataUserMatch_JP();
        redCompetitorDataJP = new RedCompetitorDataUserMatch_JP();

        upperPartJP = new UpperPartUserMatch_JP(userMatchWindow);

        faulPointsBlueJP = new FaulPointsBlueCompetitorUserMatch_JP(userMatchWindow);
        faulPointsRedJP = new FaulPointsRedCompetitorUserMatch_JP(userMatchWindow);

        roundAndTimeJp = new RoundAndTimeUserMatch_JP(userMatchWindow);
        pointJP = new PointsUserMatch_JP(userMatchWindow);
        pointJP.lblTriangle.setLocation(1, 1);


        //Addressing the JPanels to the  JFrame

        blueCompetitorDataJP.setBounds(20, 125, 160, 105);
        add(blueCompetitorDataJP);

        redCompetitorDataJP.setBounds(540, 125, 160, 105);
        add(redCompetitorDataJP);

        upperPartJP.setBounds(1, 1, 718, 120);
        add(upperPartJP);

        faulPointsBlueJP.setBounds(20, 230, 225, 100);
        add(faulPointsBlueJP);

        faulPointsRedJP.setBounds(475, 230, 225, 100);
        add(faulPointsRedJP);

        roundAndTimeJp.setBounds(263, 210, 195, 115);
        roundAndTimeJp.btnClock.requestFocusInWindow();
        add(roundAndTimeJp);

        pointJP.setBounds(250, 355, 215, 85);
        add(pointJP);

    }}
