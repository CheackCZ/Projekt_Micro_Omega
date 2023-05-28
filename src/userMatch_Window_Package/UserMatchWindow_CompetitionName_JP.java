package userMatch_Window_Package;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * JPanel with name of the competition
 * @author ondra
 */
public class UserMatchWindow_CompetitionName_JP extends JPanel {

    /** JTextField for the competition name to be seen at the top of the user screen */
    public JTextField txtCompetitonName;

    /**
     * Create the panel.
     */
    public UserMatchWindow_CompetitionName_JP() {

        setBackground(SystemColor.infoText);
        setLayout(null);

        txtCompetitonName = new JTextField();
        txtCompetitonName.setEditable(false);
        txtCompetitonName.setForeground(Color.gray);
        txtCompetitonName.setFont(new Font("Arial", Font.PLAIN, 24));
        txtCompetitonName.setHorizontalAlignment(SwingConstants.CENTER);
        txtCompetitonName.setBackground(SystemColor.infoText);
        txtCompetitonName.setBorder(null);
        txtCompetitonName.setText("");
        txtCompetitonName.setBounds(5, 7, 1175, 32);
        add(txtCompetitonName);
        txtCompetitonName.setColumns(10);
    }}
