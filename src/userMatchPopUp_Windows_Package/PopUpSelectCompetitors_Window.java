package userMatchPopUp_Windows_Package;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import userMatch_Window_Package.UserMatch_Window;

import javax.swing.JButton;

/**
 * Pop up window with category/competitor selection
 * @author ondra
 */
public class PopUpSelectCompetitors_Window extends JFrame implements WindowFocusListener{

    private JPanel contentPane;

    /** Button to confirm the selected category and competitors */
    public JButton btnConfirmSelection;


    /** Adding JPanel with the category selection for this window  */
    public UserMatchPopUp_CategorySelection_JP userMatchPopUp_Category;

    /** Adding JPanel with the red competitor selection for this window  */
    public UserMatchPopUp_CompetitorSelection_JP redCompetitorSelection;
    /** Adding JPanel with the blue competitor selection for this window  */
    public UserMatchPopUp_CompetitorSelection_JP blueCompetitorSelection;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PopUpSelectCompetitors_Window frame = new PopUpSelectCompetitors_Window(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the Frame
     * @param userMatchWindow to use the thing inside
     */
    public PopUpSelectCompetitors_Window(UserMatch_Window userMatchWindow) {

        //Declarations of JPanels/JFrames and Objects
        userMatchPopUp_Category = new UserMatchPopUp_CategorySelection_JP(userMatchWindow);

        redCompetitorSelection = new UserMatchPopUp_CompetitorSelection_JP(userMatchWindow);
        blueCompetitorSelection = new UserMatchPopUp_CompetitorSelection_JP(userMatchWindow);


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 483, 242);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.LIGHT_GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);  //Location of the first window exactly in the center of the monitor
        setResizable(false);

        setTitle("Select category and choose competitors");

        addWindowFocusListener(this);


        btnConfirmSelection = new JButton("Confirm");
        btnConfirmSelection.setToolTipText("Confirm Selection and move on to the match");
        btnConfirmSelection.setBackground(Color.white);
        btnConfirmSelection.setFocusable(false);
        btnConfirmSelection.setEnabled(false);
        btnConfirmSelection.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirmSelection.setBorder(BorderFactory.createLineBorder(Color.gray));
        btnConfirmSelection.setFont(new Font("Arial", Font.BOLD, 12));
        btnConfirmSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnConfirmAction(userMatchWindow);
            }
        });
        btnConfirmSelection.setBounds(195, 170, 85, 25);
        contentPane.add(btnConfirmSelection);


        //Addressing the JPanels to the  JFrame

        userMatchPopUp_Category.setBounds(10, 10, 450, 70);
        contentPane.add(userMatchPopUp_Category);


        redCompetitorSelection.setBounds(10, 90, 220, 70);
        redCompetitorSelection.setBorder(BorderFactory.createLineBorder(Color.red));
        redCompetitorSelection.getTxtChooseCompetitor().setText("Choose competitor (red): ");
        contentPane.add(redCompetitorSelection);


        blueCompetitorSelection.setBounds(240, 90, 220, 70);
        blueCompetitorSelection.setBorder(BorderFactory.createLineBorder(Color.blue));
        blueCompetitorSelection.getTxtChooseCompetitor().setText("Choose competitor (blue): ");
        contentPane.add(blueCompetitorSelection);

    }

    /**
     * Method - what happens when "btnConfirm" is clicked
     * Setting the properties to user match screen and match window
     * @param userMatchWindow for all the things inside
     */
    public void btnConfirmAction(UserMatch_Window userMatchWindow) {
        if (userMatchWindow.blueCompetitor == userMatchWindow.redCompetitor) {
            JOptionPane.showMessageDialog(null, "You selected the same competitor! \n"
                    + "You have to select two differrent competitors.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            //Setting the properties to user match screen
            userMatchWindow.userMatchScreen.upperPartJP.txtCategory.setText("MATSOGI " + userMatchPopUp_Category.boxCategorySelection.getSelectedItem().toString());

            userMatchWindow.userMatchScreen.blueCompetitorDataJP.txtClubBlue.setText(userMatchWindow.blueCompetitor.getClub());
            userMatchWindow.userMatchScreen.blueCompetitorDataJP.txtNameBlue.setText(userMatchWindow.blueCompetitor.getName());
            userMatchWindow.userMatchScreen.blueCompetitorDataJP.txtLastNameBlue.setText(userMatchWindow.blueCompetitor.getLastName());

            userMatchWindow.userMatchScreen.redCompetitorDataJP.txtClubRed.setText(userMatchWindow.redCompetitor.getClub());
            userMatchWindow.userMatchScreen.redCompetitorDataJP.txtNameRed.setText(userMatchWindow.redCompetitor.getName());
            userMatchWindow.userMatchScreen.redCompetitorDataJP.txtLastNameRed.setText(userMatchWindow.redCompetitor.getLastName());


            //Setting the properties to user match window
            userMatchWindow.matchWindow.UpperPart.txtCategory.setText("MATSOGI " + userMatchPopUp_Category.boxCategorySelection.getSelectedItem().toString());

            userMatchWindow.matchWindow.BlueCompetitorData.txtClubBlue.setText(userMatchWindow.blueCompetitor.getClub());
            userMatchWindow.matchWindow.BlueCompetitorData.txtNameBlue.setText(userMatchWindow.blueCompetitor.getName());
            userMatchWindow.matchWindow.BlueCompetitorData.txtLastNameBlue.setText(userMatchWindow.blueCompetitor.getLastName());

            userMatchWindow.matchWindow.RedCompetitorData.txtClubRed.setText(userMatchWindow.redCompetitor.getClub());
            userMatchWindow.matchWindow.RedCompetitorData.txtNameRed.setText(userMatchWindow.redCompetitor.getName());
            userMatchWindow.matchWindow.RedCompetitorData.txtLastNameRed.setText(userMatchWindow.redCompetitor.getLastName());


            //Enabling buttons to continue
            userMatchWindow.userMatchWindowButtons.btnNewMatch.setEnabled(false);
            userMatchWindow.userMatchWindowButtons.btnEndMatch.setEnabled(true);
            userMatchWindow.userMatchWindowButtons.btnNewRound.setEnabled(true);

            userMatchWindow.requestFocusInWindow(); //Without this function the space doesn't work

            userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.dispose();
        }

    }


    @Override
    public void windowGainedFocus(WindowEvent e) {
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        toFront();
    }}
