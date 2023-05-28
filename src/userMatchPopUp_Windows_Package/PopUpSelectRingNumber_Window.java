package userMatchPopUp_Windows_Package;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import userMatch_Window_Package.UserMatch_Window;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

/**
 * Pop up window to select the ring number
 * @author ondra
 */
public class PopUpSelectRingNumber_Window extends JFrame {

    private JPanel contentPane;

    /** TextField for user to know that he has to select the ring number from JComboBox below */
    private JTextField txtChooseRingNum;

    /** JCombobox to choose the ring number */
    public JComboBox boxRingNums;
    /** Button to confirm the selected category and competitors */
    private JButton btnConfirmSelection;

    /** Array with the numbers to select from */
    public static String [] ringNums = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PopUpSelectRingNumber_Window frame = new PopUpSelectRingNumber_Window(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Crate the Frame
     * @param userMatchWindow to use the things inside
     */
    public PopUpSelectRingNumber_Window(UserMatch_Window userMatchWindow) {

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 225, 117);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.LIGHT_GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Ring num.");


        txtChooseRingNum = new JTextField();
        txtChooseRingNum.setForeground(Color.DARK_GRAY);
        txtChooseRingNum.setBackground(Color.LIGHT_GRAY);
        txtChooseRingNum.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        txtChooseRingNum.setHorizontalAlignment(SwingConstants.LEFT);
        txtChooseRingNum.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
        txtChooseRingNum.setEditable(false);
        txtChooseRingNum.setText("Choose ring number:");
        txtChooseRingNum.setBounds(10, 10, 120, 25);
        contentPane.add(txtChooseRingNum);


        boxRingNums = new JComboBox(ringNums);
        boxRingNums.setFont(new Font("Arial", Font.PLAIN, 12));
        boxRingNums.setBackground(Color.white);
        boxRingNums.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boxRingNums.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        boxRingNums.setToolTipText("Choose ring number!");
        boxRingNums.setBounds(133, 10, 67, 25);
        contentPane.add(boxRingNums);


        btnConfirmSelection = new JButton("Confirm");
        btnConfirmSelection.setToolTipText("Confirm Selection and move on to the match");
        btnConfirmSelection.setBackground(Color.white);
        btnConfirmSelection.setFocusable(false);
        btnConfirmSelection.setEnabled(true);
        btnConfirmSelection.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirmSelection.setBorder(BorderFactory.createLineBorder(Color.gray));
        btnConfirmSelection.setFont(new Font("Arial", Font.BOLD, 12));
        btnConfirmSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnConfirmSelectionAction(userMatchWindow);
            }
        });
        btnConfirmSelection.setBounds(65, 45, 85, 25);
        contentPane.add(btnConfirmSelection);

    }

    /**
     * Method - what happens when JButton "confirm" is clicked -> confirms the selected ring number
     * @param userMatchWindow for all the things inside
     */
    public void btnConfirmSelectionAction(UserMatch_Window userMatchWindow) {
        userMatchWindow.matchWindow.UpperPart.txtRingNumber.setText("RING " + boxRingNums.getSelectedItem());
        userMatchWindow.userMatchScreen.upperPartJP.txtRingNumber.setText("RING " + boxRingNums.getSelectedItem());

        userMatchWindow.userMatchWindowButtons.btnNewMatch.setEnabled(true);
        userMatchWindow.userMatchWindowSettingsButtons.btnSetRingNumber.setEnabled(false);

        userMatchWindow.userMatchWindowSettingsButtons.btnRefresh.setEnabled(true);

        dispose();
    }
}
