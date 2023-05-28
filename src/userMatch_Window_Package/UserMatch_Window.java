package userMatch_Window_Package;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import match_Window_Package.Match_Window;
import match_Window_Package.Match_Window;
import objects_Package.Category;
import objects_Package.Competitor;
import objects_Package.Match;
import objects_Package.Ring;
import userMatchScreen_Window_Package.UserMatch_Screen_JP;
import javax.swing.Box;
import javax.swing.DefaultListModel;

/**
 * Window with everything user needs durng the match
 * @author ondra
 */
public class UserMatch_Window extends JFrame implements KeyListener {

    private JPanel contentPane;

    /** Box around the match screen */
    public Box boxMatchScreen;
    /** Box around the whole user match screen to see who's winning */
    public Box boxUserMatchWindow;

    //Competitors
    /**	Filling with the competitors to see them inside the JList */
    public DefaultListModel listModel;
    /** ArrayList with all competitors */
    public ArrayList<Competitor> listCompetitors;
    /** ArrayList with competitors from selected category*/
    public ArrayList<Competitor> listCompetitorsFromSelectedCategory;

    /**	Using for methods */
    public Competitor competitorHelper = new Competitor();

    /** Red competitor declaration */
    public Competitor redCompetitor;
    /** Blue competitor declaration */
    public Competitor blueCompetitor;


    //Category
    /** Category class declaration  */
    public Category category = new Category();
    /** ArrayList with all the categories from file */
    public ArrayList<Category> listCategory = new ArrayList<>();


    //Objects I'm using and I need them inside
    /** Ring class declaration */
    public Ring ring = new Ring();
    /** Match class declaration */
    public Match match = new Match();


    //2. screen (JPanels)
    /** Adding JPanel with the buttons for this window */
    public UserMatchWindow_Buttons_JP userMatchWindowButtons;
    /** Adding JPanel with the settings buttons for this window */
    public UserMatchWindow_SettingsButtons_JP userMatchWindowSettingsButtons;

    /** Adding JPanel with the list of the competitors for this window */
    public UserMatchWindow_List_JP userMatchWindowList;

    /** Adding JPanel with the JTextField for the name of the competition */
    public UserMatchWindow_CompetitionName_JP userMatchWindowText;

    /** Adding JPanel with the advice for user to help him with short-cuts */
    public UserMatchWindow_TextAdvice_JP userMatchWindowAdvice;
    /** Adding JPanel with the advice for user to help him with red competitor's short-cuts */
    public UserMatchWindow_RedTextAdvice_JP userMatchWindowRedAdvice;
    /** Adding JPanel with the advice for user to help him with blue competitor's short-cuts */
    public UserMatchWindow_BlueTextAdvice_JP userMatchWindowBlueAdvice;

    /** Class with abstract method for the keyboard */
    public UserMatchWindow_KeyBoard userMatchWindowKeys;

    /** Adding JPanel with the match screen for this window */
    public UserMatch_Screen_JP userMatchScreen;

    /** JPanel with the match screen */
    public Match_Window matchWindow;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserMatch_Window frame = new UserMatch_Window(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the Frame
     * @param matchWindow to control it from here
     */
    public UserMatch_Window(Match_Window matchWindow) {

        //Declarations of JPanels/JFrames and Objects
        userMatchWindowButtons = new UserMatchWindow_Buttons_JP(this);
        userMatchWindowSettingsButtons = new UserMatchWindow_SettingsButtons_JP(this);

        userMatchWindowList = new UserMatchWindow_List_JP(this);
        userMatchWindowText = new UserMatchWindow_CompetitionName_JP();
        userMatchWindowAdvice =  new UserMatchWindow_TextAdvice_JP();
        userMatchWindowRedAdvice = new UserMatchWindow_RedTextAdvice_JP();
        userMatchWindowBlueAdvice = new UserMatchWindow_BlueTextAdvice_JP();

        userMatchWindowKeys = new UserMatchWindow_KeyBoard();

        userMatchScreen = new UserMatch_Screen_JP(this);

        this.matchWindow = matchWindow;


        listCompetitors = new ArrayList<>();
        listCompetitorsFromSelectedCategory = new ArrayList<>();
        listModel = new DefaultListModel<>();

        redCompetitor = new Competitor();
        blueCompetitor = new Competitor();

        listCategory = new ArrayList<>();


        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.LIGHT_GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        setTitle("User match screen");
        setResizable(false);

        setFocusable(true);  //Setting focusable to true, because key listener function needs it
        addKeyListener(this);  //Using keyListener to use keyboard during the match


        //When closing the window make sure user really wants to exit the application
        addWindowListener((WindowListener) new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                String [] optionsButtons = {"Yes","No"};
                int promptResult = JOptionPane.showOptionDialog(null,"Are you sure you want to exit?",
                        "Exit",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,optionsButtons,optionsButtons[1]);

                if(promptResult == JOptionPane.YES_OPTION) {
                    System.exit(0);  //Exits the system
                }
            }
        });


        boxMatchScreen = Box.createHorizontalBox();
        boxMatchScreen.setBorder(new LineBorder(Color.black, 4, true));
        boxMatchScreen.setBounds(565, 185, 730, 450);
        contentPane.add(boxMatchScreen);

        boxUserMatchWindow = Box.createHorizontalBox();
        boxUserMatchWindow.setBorder(new LineBorder(Color.black, 4, true));
        boxUserMatchWindow.setBounds(350, 42, 1186, 694);
        contentPane.add(boxUserMatchWindow);

        //Addressing the JPanels to the  JFrame

        userMatchWindowList.setBounds(0, 0, 350, 841);
        contentPane.add(userMatchWindowList);

        userMatchWindowButtons.setBounds(375, 70, 790, 80);
        contentPane.add(userMatchWindowButtons);

        userMatchWindowSettingsButtons.setBounds(1165, 70, 345, 80);
        contentPane.add(userMatchWindowSettingsButtons);

        userMatchWindowText.setBounds(349, 0, 1187, 42);
        contentPane.add(userMatchWindowText);

        userMatchWindowAdvice.setBounds(349, 736, 1187, 105);
        contentPane.add(userMatchWindowAdvice);

        userMatchWindowRedAdvice.setBounds(1300, 250, 200, 150);
        contentPane.add(userMatchWindowRedAdvice);

        userMatchWindowBlueAdvice.setBounds(359, 250, 200, 150);
        contentPane.add(userMatchWindowBlueAdvice);

        userMatchScreen.setBounds(570, 190, 720, 440);
        userMatchScreen.setBorder(BorderFactory.createLineBorder(Color.black));
        contentPane.add(userMatchScreen);

    }

    @Override
    public void keyTyped(KeyEvent e) {  //Not used
    }

    /** Methods for having control over the program from keyboard */
    @Override
    public void keyPressed(KeyEvent e) {
        userMatchWindowKeys.keyMethods(e, this);
    }
    @Override
    public void keyReleased(KeyEvent e) {  //Not used
    }}
