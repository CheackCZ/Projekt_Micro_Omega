package match_Window_Package;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

/**
 * Window of the match
 * Showing all the details about competitors
 * @author ondra
 */
public class Match_Window extends JFrame implements KeyListener {

    private JPanel contentPane;

    /** The upper part of the second screen - name of the category, ring number, and spinning kicks buttons */
    public UpperPartMatch_JP UpperPart;

    /** The red competitor name, last name and name of the club */
    public RedCompetitorDataMatch_JP RedCompetitorData;

    /** The blue competitor name, last name and name of the club */
    public BlueCompetitorDataMatch_JP BlueCompetitorData;

    /** The blue competitor foul points and yellow cards he has */
    public FaulPointsBlueCompetitor_JP FaulPointsBlue;

    /** The blue competitor foul points and yellow cards he has */
    public FaulPointsRedCompetitor_JP FaulPointsRed;

    /** The points of competitors */
    public PointsMatch_JP Points;

    /** The timer and the number of round */
    public RoundAndTime_JP RoundAndTime;

    /** Using to get the screen size and make the window compatible */
    Dimension dim;
    /** Timer using for the countdown */
    Timer timer;

    /** controlling if the window is full screen and undecorated to false */
    boolean fullscreen = false;

    /** controlling if the window is full screen and undecorated to true */
    boolean decoratedFullScreen = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Match_Window frame = new Match_Window();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    /**
     * Create the frame.
     */
    public Match_Window() {

        //Declarations of JPanels/JFrames and Objects
        UpperPart = new UpperPartMatch_JP();
        RedCompetitorData = new RedCompetitorDataMatch_JP();
        BlueCompetitorData = new BlueCompetitorDataMatch_JP();
        FaulPointsBlue = new FaulPointsBlueCompetitor_JP();
        FaulPointsRed = new FaulPointsRedCompetitor_JP();
        Points = new PointsMatch_JP();
        RoundAndTime = new RoundAndTime_JP();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setForeground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);
        setBounds(0, 0, 960, 640);

        setLocationRelativeTo(null);  //Setting location to null to have the JFrame exactly in the middle
        setFocusable(true);  //Setting focusable to true, because key listener function needs it
        addKeyListener(this);  //Adding key listener to the JFrame


        //When closing the window make sure user really wants to exit the application
        addWindowListener( new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {

                String [] optionsButtons = {"Yes","No"};
                int promptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?","Exit",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,optionsButtons,optionsButtons[1]);

                if(promptResult == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });


        UpperPart.setBounds(0, 0, 1536, 235);
        contentPane.add(UpperPart);


        RedCompetitorData.setBounds(996, 250, 490, 155);
        contentPane.add(RedCompetitorData);


        BlueCompetitorData.setBounds(60, 250, 490, 155);
        contentPane.add(BlueCompetitorData);


        FaulPointsBlue.setBounds(60, 465, 350, 110);
        contentPane.add(FaulPointsBlue);


        FaulPointsRed.setBounds(1126, 465, 350, 110);
        contentPane.add(FaulPointsRed);


        Points.setBounds(570, 715, 375, 150);
        contentPane.add(Points);


        RoundAndTime.setBounds(582, 295, 370, 300);
        contentPane.add(RoundAndTime);

    }

    /**
     * Using key listener to make it full screen or default size
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'f') {  //'f' to make the window full screen and undecorated to false
            decoratedFullScreen = true;
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            System.out.println("Obrazovka zvětšena na fullscreen!");
        }
        if (e.getKeyCode() == 122) {  //'fn + f11' to make the window full screen and undecorated to true
            if (!fullscreen) {
                dispose();
                fullscreen = true;
                this.setExtendedState(JFrame.MAXIMIZED_BOTH);
                this.setUndecorated(true);
                this.setVisible(true);
                System.out.println("Obrazovka zvětšena na plný fullscreen!");
            }
        }
        if (e.getKeyCode() == 27) {  //'escape' to get out of either full screen with undecorated to true or full screen with undecorated to false
            if (fullscreen) {
                dispose();
                this.setExtendedState(JFrame.NORMAL);
                this.setUndecorated(false);
                this.setVisible(true);
                System.out.println("Obrazovka zmenšena z plného fullscreenu!");
                fullscreen = false;
            }
            if (decoratedFullScreen) {  //Using to not always close and open the window again
                this.setExtendedState(JFrame.NORMAL);
                System.out.println("Obrazovka zmenšena z fullscreenu!");
                decoratedFullScreen = false;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }}
