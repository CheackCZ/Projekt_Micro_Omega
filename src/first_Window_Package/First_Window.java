package first_Window_Package;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import java.awt.Font;
import javax.swing.JTextField;

import file_Window_Package.File_Window;
import match_Window_Package.Match_Window;
import userMatch_Window_Package.UserMatch_Window;

import javax.swing.JSeparator;
import javax.swing.JLabel;

/**
 * Window showed at the beginning
 * write in the competition name and choose file with competitors
 * @author ondra
 */
public class First_Window extends JFrame {

    private JPanel contentPane;

    /** JTextfield to write the name of the competition in it */
    private JTextField txtCompetitionName;


    //First part windows
    /** Adding JPanel with the buttons */
    FirstWindow_Buttons_JP firstWindowButtonsJP;

    /** Adding JPanel with the file system */
    FirstWindow_File_JP fileSystemJP;

    /** Window showing the file inside JTable */
    File_Window fileWindow;


    /** Declaration of the match window */
    Match_Window matchWindow = new Match_Window();
    /**  Declaration of the window for user during the match */
    UserMatch_Window userMatchWindow = new UserMatch_Window(matchWindow);

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    First_Window frame = new First_Window();
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
    public First_Window() {

        //Declarations of JPanels/JFrames and Objects
        fileWindow = new File_Window();

        firstWindowButtonsJP = new FirstWindow_Buttons_JP(fileWindow, matchWindow, userMatchWindow, this);
        fileSystemJP = new FirstWindow_File_JP(firstWindowButtonsJP, this);


        setResizable(false); //Doesn't allow the user to resize the window
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 450, 215);
        contentPane = new JPanel();
        contentPane.setBackground(Color.darkGray);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        setLocationRelativeTo(null);  //Location of the first window exactly in the center of the monitor


        txtCompetitionName = new JTextField();
        txtCompetitionName.setText("Enter the competition name ");
        txtCompetitionName.setFont(new Font("Arial", Font.BOLD, 12));
        txtCompetitionName.setForeground(Color.LIGHT_GRAY);
        txtCompetitionName.setBounds(25, 35, 390, 30);
        txtCompetitionName.setBackground(Color.darkGray);
        txtCompetitionName.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        txtCompetitionName.setCaretColor(Color.WHITE);
        txtCompetitionName.addKeyListener(new KeyAdapter() {  //Method for recognizing if everything is filled, than you can continue
            @Override
            public void keyReleased(KeyEvent e) {
                competitionNameControl();
            }
        });
        txtCompetitionName.addFocusListener(new FocusListener() {  //Described in the bottom
            @Override
            public void focusGained(FocusEvent e) {
                competitionNameDefaultTextEmpty();
            }
            @Override
            public void focusLost(FocusEvent e) {
                competitionNameDefaultTextSetter();
            }

        });
        contentPane.add(txtCompetitionName);
        txtCompetitionName.setColumns(10);


        /** The line to know where to write the name of the competition */
        JSeparator lineNazev = new JSeparator();
        lineNazev.setForeground(new Color(255, 255, 255));
        lineNazev.setBounds(25, 65, 390, 1);
        contentPane.add(lineNazev);


        /** Just to avoid focus on the txtCompetitionName */
        JRadioButton rdbtnNewRadioButton = new JRadioButton("");
        rdbtnNewRadioButton.requestFocusInWindow();
        rdbtnNewRadioButton.setBounds(0, 0, 0, 0);
        contentPane.add(rdbtnNewRadioButton);


        /** JLabel for user to help him if he doesn't know what to do */
        JLabel lblHelp = new JLabel("Help?");
        lblHelp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblHelp.setToolTipText("Help window.");
        lblHelp.setFont(new Font("Arial", Font.PLAIN, 10));
        lblHelp.setBackground(Color.darkGray);
        lblHelp.setForeground(Color.gray);
        lblHelp.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        lblHelp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {  //Show u window with advice what to do when this JLabel is clicked
                JOptionPane.showMessageDialog(null, "You have to write in the name of the competition \nand "
                        + "upload the (CSV) file to continue", "HELP", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        lblHelp.setBounds(25, 145, 50, 15);
        contentPane.add(lblHelp);


        //Addressing the JPanels to the first JFrame

        fileSystemJP.setBounds(15, 80, 400, 60);
        contentPane.add(fileSystemJP);

        firstWindowButtonsJP.setBounds(245, 130, 180, 45);
        contentPane.add(firstWindowButtonsJP);

    }

    /**
     * @return competition name
     */
    public JTextField getTxtCompetitionName() {
        return txtCompetitionName;
    }
    /**
     * @param txtCompetitionName setting the competition name
     */
    public void setTxtCompetitionName(JTextField txtCompetitionName) {
        this.txtCompetitionName = txtCompetitionName;
    }


    /**
     * Method for recognizing if the name of the competition is long enough
     */
    public void competitionNameControl() {
        int length = txtCompetitionName.getText().length();
        if (length > 5 && !fileSystemJP.getTxtFileName().getText().equals("")) {
            if (txtCompetitionName.getText().matches("^[a-zìšèøžýáíéùA-ZÌŠÈØŽÝÁÍÉÙ0-9, ]{1,50}$")) {
                firstWindowButtonsJP.getBtnContinue().setEnabled(true);
            } else {
                firstWindowButtonsJP.getBtnContinue().setEnabled(false);
            }
        } else {
            firstWindowButtonsJP.getBtnContinue().setEnabled(false);
        }
    }


    /**
     * Method that recognizes if user wants to write in the name of the competition and it changes the default text to empty
     */
    public void competitionNameDefaultTextEmpty() {
        if(txtCompetitionName.getText().equals("Enter the competition name ")) {
            txtCompetitionName.setText("");
            txtCompetitionName.setForeground(Color.white);
        }
    }

    /**
     * Method that recognizes if user no longer wants to write in the name of the competition and sets it back to the default text
     */
    public void competitionNameDefaultTextSetter() {
        if(txtCompetitionName.getText().equals("")) {
            txtCompetitionName.setText("Enter the competition name ");
            txtCompetitionName.setForeground(Color.LIGHT_GRAY);
        }
    }


    /**
     * What happens when closing the window
     */
    @Override
    public void dispose() {
        fileWindow.dispose();
        fileWindow.popUpSearch.dispose();
        super.dispose();
    }

}