package match_Window_Package;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * JPanel with blue competitor's details
 * @author ondra
 */
public class BlueCompetitorDataMatch_JP extends JPanel {

    /** JTextField - show the club/Team of the blue competitor */
    public JTextField txtClubBlue;
    /** JTextField - show the first name of the blue competitor */
    public JTextField txtNameBlue;
    /** JTextField - show the last name of the blue competitor */
    public JTextField txtLastNameBlue;

    /**
     * Create the panel.
     */
    public BlueCompetitorDataMatch_JP() {

        setBackground(Color.WHITE);
        setLayout(null);
        setSize(490, 155);


        txtClubBlue = new JTextField();
        txtClubBlue.setForeground(Color.BLACK);
        txtClubBlue.setEditable(false);
        txtClubBlue.setHorizontalAlignment(SwingConstants.LEFT);
        txtClubBlue.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 42));
        txtClubBlue.setBackground(Color.WHITE);
        txtClubBlue.setBorder(BorderFactory.createLineBorder((Color.WHITE)));
        txtClubBlue.setBounds(10, 0, 480, 65);
        add( txtClubBlue);
        txtClubBlue.setColumns(10);


        txtNameBlue = new JTextField();
        txtNameBlue.setForeground(Color.BLACK);
        txtNameBlue.setEditable(false);
        txtNameBlue.setBackground(Color.WHITE);
        txtNameBlue.setHorizontalAlignment(SwingConstants.LEFT);
        txtNameBlue.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 30));
        txtNameBlue.setBorder(BorderFactory.createLineBorder((Color.WHITE)));
        txtNameBlue.setBounds(10, 60, 480, 50);
        add( txtNameBlue);
        txtNameBlue.setColumns(10);


        txtLastNameBlue = new JTextField();
        txtLastNameBlue.setForeground(Color.BLACK);
        txtLastNameBlue.setEditable(false);
        txtLastNameBlue.setBackground(Color.WHITE);
        txtLastNameBlue.setHorizontalAlignment(SwingConstants.LEFT);
        txtLastNameBlue.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 40));
        txtLastNameBlue.setBorder(BorderFactory.createLineBorder((Color.WHITE)));
        txtLastNameBlue.setBounds(10, 105, 480, 50);
        add(txtLastNameBlue);
        txtLastNameBlue.setColumns(10);

    }}
