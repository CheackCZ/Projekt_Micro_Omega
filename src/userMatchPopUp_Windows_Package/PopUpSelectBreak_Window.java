package userMatchPopUp_Windows_Package;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import userMatch_Window_Package.UserMatch_Window;

import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;

/**
 * Pop up window to select the break time
 * @author ondra
 */
public class PopUpSelectBreak_Window extends JFrame {

    private JPanel contentPane;

    /** JTextField helping user to know what is he choosing */
    private JTextField txtChooseBreakTime;

    /** JButton to confirm the selection */
    private JButton btnConfirmSelection;

    /** JList to choose round from */
    public JList list;


    /** Array with the time to select from */
    public static String [] times = {"0:30", "1:00", "1:30", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00"};

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PopUpSelectBreak_Window frame = new PopUpSelectBreak_Window(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the Frame
     * @param userMatchWindow for all the things inside
     */
    public PopUpSelectBreak_Window(UserMatch_Window userMatchWindow) {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 250, 220);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        setLocationRelativeTo(null);
        setTitle("Break");
        setResizable(false);


        txtChooseBreakTime = new JTextField();
        txtChooseBreakTime.setEditable(false);
        txtChooseBreakTime.setBackground(Color.LIGHT_GRAY);
        txtChooseBreakTime.setText("Choose break time:");
        txtChooseBreakTime.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
        txtChooseBreakTime.setBounds(10, 10, 216, 25);
        txtChooseBreakTime.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        contentPane.add(txtChooseBreakTime);
        txtChooseBreakTime.setColumns(10);


        /**	JScroolPane to scroll thru  */
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 35, 216, 100);
        contentPane.add(scrollPane);


        list = new JList(times);
        list.setSelectedIndex(1);
        scrollPane.setViewportView(list);


        btnConfirmSelection = new JButton("Confirm");
        btnConfirmSelection.setBounds(75, 145, 85, 25);
        btnConfirmSelection.setToolTipText("Confirm Selection and move on to the break");
        btnConfirmSelection.setBackground(Color.white);
        btnConfirmSelection.setFocusable(false);
        btnConfirmSelection.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirmSelection.setBorder(BorderFactory.createLineBorder(Color.gray));
        btnConfirmSelection.setFont(new Font("Arial", Font.PLAIN, 12));
        btnConfirmSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmSelectionAction(userMatchWindow);
            }
        });
        contentPane.add(btnConfirmSelection);

    }

    /**
     * Method - what happens when user clicks on the confirm when choosing the break
     * @param userMatchWindow for all the things inside
     */
    public void confirmSelectionAction(UserMatch_Window userMatchWindow) {
        userMatchWindow.userMatchWindowButtons.btnNewRound.setEnabled(true);
        userMatchWindow.userMatchWindowButtons.btnSetBreak.setEnabled(false);

        //Setting the time
        userMatchWindow.match.setRound("Break");
        userMatchWindow.match.setTime(list.getSelectedValue().toString());


        userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.setText(userMatchWindow.match.getTime());
        userMatchWindow.userMatchScreen.roundAndTimeJp.txtMatchRound.setText(userMatchWindow.match.getRound());

        userMatchWindow.matchWindow.RoundAndTime.btnClock.setText(userMatchWindow.match.getTime());
        userMatchWindow.matchWindow.RoundAndTime.txtMatchRound.setText(userMatchWindow.match.getRound());

        userMatchWindow.matchWindow.RoundAndTime.txtMatchRound.setForeground(Color.gray);
        userMatchWindow.userMatchScreen.roundAndTimeJp.txtMatchRound.setForeground(Color.gray);


        userMatchWindow.match.settingMinutesAndSeconds(userMatchWindow);


        //Enabling/Disabling the buttons
        userMatchWindow.matchWindow.RoundAndTime.btnClock.setEnabled(true);
        userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.setEnabled(true);


        userMatchWindow.userMatchWindowSettingsButtons.btnRefresh.setEnabled(false);  //Disabling refresh button


        userMatchWindow.requestFocusInWindow(); //Without this function the space doesn't work

        dispose();
    }}
