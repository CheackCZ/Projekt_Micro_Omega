package userMatch_Window_Package;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;

/**
 * JPanel with key board short cuts for the red competitor
 * @author ondra
 */
public class UserMatchWindow_RedTextAdvice_JP extends JPanel {

    /** JTextField that helps user and navigates him how to use key short cuts in the user window before the match started */
    private JTextField txtAdviceRed;

    /** JTextPane with the advice for user to know what short-cut to use for red competitor */
    private JTextPane txtAdvicesRed;

    /**
     * Create the panel.
     */
    public UserMatchWindow_RedTextAdvice_JP() {

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);


        txtAdviceRed = new JTextField();
        txtAdviceRed.setEditable(false);
        txtAdviceRed.setForeground(Color.DARK_GRAY);
        txtAdviceRed.setText(" Red (short-cuts):");
        txtAdviceRed.setFont(new Font("Arial", Font.PLAIN, 14));
        txtAdviceRed.setBackground(Color.LIGHT_GRAY);
        txtAdviceRed.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        txtAdviceRed.setBounds(10, 10, 180, 25);
        add(txtAdviceRed);
        txtAdviceRed.setColumns(10);


        txtAdvicesRed = new JTextPane();
        txtAdvicesRed.setForeground(Color.GRAY);
        txtAdvicesRed.setBackground(Color.LIGHT_GRAY);
        txtAdvicesRed.setFont(new Font("Arial", Font.ITALIC, 15));
        txtAdvicesRed.setEditable(false);
        txtAdvicesRed.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        txtAdvicesRed.setText("  '->' - Adds Point to Red\n"
                + "  'p' - Adds Foul Point to \n  Red\n"
                + "  'o' - Adds Yellow Card to \n  Red\n");
        txtAdvicesRed.setBounds(10, 35, 190, 115);
        add(txtAdvicesRed);
    }}
