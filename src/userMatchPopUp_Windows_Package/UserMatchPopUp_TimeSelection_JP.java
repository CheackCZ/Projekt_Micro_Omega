package userMatchPopUp_Windows_Package;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import userMatch_Window_Package.UserMatch_Window;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;

/**
 * JPanel with the time selection details
 * @author ondra
 */
public class UserMatchPopUp_TimeSelection_JP extends JPanel {

    /** JTextField to help user to select the time */
    private JTextField txtChooseTime;

    /** JList to choose time from */
    public JList listTimes;


    /** Array with the times to select from */
    public static String [] times = {"1:00", "1:30", "2:00", "3:00", "4:00", "5:00", "6:00", "7:00", "8:00", "9:00", "10:00"};

    /**
     * @param userMatchWindow to use the things inside
     */
    public UserMatchPopUp_TimeSelection_JP(UserMatch_Window userMatchWindow) {

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);


        txtChooseTime = new JTextField();
        txtChooseTime.setText("Choose Time:");
        txtChooseTime.setFont(new Font("Arial", Font.PLAIN, 12));
        txtChooseTime.setEditable(false);
        txtChooseTime.setBackground(Color.LIGHT_GRAY);
        txtChooseTime.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        txtChooseTime.setBounds(0, 0, 100, 25);
        add(txtChooseTime);
        txtChooseTime.setColumns(10);


        /** JScroolPane to scroll thru */
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 25, 216, 100);
        add(scrollPane);


        listTimes = new JList(times);
        scrollPane.setViewportView(listTimes);
        listTimes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listTimes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {  //Method enabling/disabling confirm button depends on whether
                //time is selected (even automatically)
                if (listTimes.getSelectedValue() != null) {
                    if (userMatchWindow.userMatchWindowButtons.popUpSelectTime.roundSelectionJP.listRounds.getSelectedValue() != null) {
                        userMatchWindow.userMatchWindowButtons.popUpSelectTime.btnConfirmSelection.setEnabled(true);
                    } else {
                        userMatchWindow.userMatchWindowButtons.popUpSelectTime.btnConfirmSelection.setEnabled(false);
                    }
                } else {
                    userMatchWindow.userMatchWindowButtons.popUpSelectTime.btnConfirmSelection.setEnabled(false);
                }
            }
        });
        listTimes.setFont(new Font("Arial", Font.PLAIN, 12));
        listTimes.setBorder(BorderFactory.createLineBorder(Color.gray));

    }}
