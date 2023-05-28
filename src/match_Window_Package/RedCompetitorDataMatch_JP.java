package match_Window_Package;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

/**
 * JPanel with red competitor's details
 * @author ondra
 */
public class RedCompetitorDataMatch_JP extends JPanel {

    /** JTextField - show the club/Team of the red competitor */
    public JTextField txtClubRed;

    /** JTextField - show the first name of the red competitor */
    public JTextField txtNameRed;

    /** JTextField - show the last name of the red competitor */
    public JTextField txtLastNameRed;

    /**
     * Create the panel.
     */
    public RedCompetitorDataMatch_JP() {

        setForeground(Color.BLACK);
        setSize(490, 155);
        setBackground(Color.WHITE);
        setLayout(null);


        txtClubRed = new JTextField();
        txtClubRed.setEditable(false);
        txtClubRed.setHorizontalAlignment(SwingConstants.RIGHT);
        txtClubRed.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 42));
        txtClubRed.setBackground(Color.WHITE);
        txtClubRed.setForeground(Color.BLACK);
        txtClubRed.setBorder(BorderFactory.createLineBorder((Color.WHITE)));
        txtClubRed.setBounds(0, 0, 480, 65);
        add(txtClubRed);


        txtNameRed = new JTextField("");
        txtNameRed.setEditable(false);
        txtNameRed.setBackground(Color.WHITE);
        txtNameRed.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNameRed.setForeground(Color.BLACK);
        txtNameRed.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 30));
        txtNameRed.setBorder(BorderFactory.createLineBorder((Color.WHITE)));
        txtNameRed.setBounds(0, 60, 480, 50);
        add(txtNameRed);


        txtLastNameRed = new JTextField("");
        txtLastNameRed.setEditable(false);
        txtLastNameRed.setBackground(Color.WHITE);
        txtLastNameRed.setHorizontalAlignment(SwingConstants.RIGHT);
        txtLastNameRed.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 40));
        txtLastNameRed.setBorder(BorderFactory.createLineBorder((Color.WHITE)));
        txtLastNameRed.setForeground(Color.BLACK);
        txtLastNameRed.setBounds(0, 105, 480, 50);
        add(txtLastNameRed);
    }}
