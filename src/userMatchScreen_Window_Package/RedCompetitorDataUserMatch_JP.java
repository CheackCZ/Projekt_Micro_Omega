package userMatchScreen_Window_Package;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * JPanel with red competitor's details
 * @author ondra
 */
public class RedCompetitorDataUserMatch_JP extends JPanel {

    /** JTextField - show the club/Team of the red competitor */
    public JTextField txtClubRed;
    /** JTextField - show the name of the red competitor */
    public JTextField txtNameRed;
    /** JTextField - show the last name of the red competitor */
    public JTextField txtLastNameRed;

    /**
     * Create the panel.
     */
    public RedCompetitorDataUserMatch_JP() {

        setLayout(null);


        txtClubRed = new JTextField("");
        txtClubRed.setEditable(false);
        txtClubRed.setHorizontalAlignment(SwingConstants.RIGHT);
        txtClubRed.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
        txtClubRed.setBackground(Color.WHITE);
        txtClubRed.setForeground(Color.BLACK);
        txtClubRed.setBorder(BorderFactory.createLineBorder((Color.WHITE)));
        txtClubRed.setBounds(0, 0, 160, 40);
        add(txtClubRed);


        txtNameRed = new JTextField("");
        txtNameRed.setEditable(false);
        txtNameRed.setBackground(Color.WHITE);
        txtNameRed.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNameRed.setForeground(Color.BLACK);
        txtNameRed.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
        txtNameRed.setBorder(BorderFactory.createLineBorder((Color.WHITE)));
        txtNameRed.setBounds(0, 40, 160, 30);
        add(txtNameRed);


        txtLastNameRed = new JTextField("");
        txtLastNameRed.setEditable(false);
        txtLastNameRed.setBackground(Color.WHITE);
        txtLastNameRed.setHorizontalAlignment(SwingConstants.RIGHT);
        txtLastNameRed.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
        txtLastNameRed.setBorder(BorderFactory.createLineBorder((Color.WHITE)));
        txtLastNameRed.setForeground(Color.BLACK);
        txtLastNameRed.setBounds(0, 70, 160, 35);
        add(txtLastNameRed);

    }}
