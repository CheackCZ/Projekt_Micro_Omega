package userMatch_Window_Package;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * JPanel with key board short cuts for the blue competitor
 * @author ondra
 */
public class UserMatchWindow_BlueTextAdvice_JP extends JPanel {

    /** JTextField that helps user and navigates him how to use key short cuts in the user window before the match started */
    private JTextField txtAdviceBlue;

    /** JTextPane with the advice for user to know what short-cut to use for red competitor */
    private JTextPane txtAdvicesBlue;

    /**
     * Create the panel.
     */
    public UserMatchWindow_BlueTextAdvice_JP() {

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);


        txtAdviceBlue = new JTextField();
        txtAdviceBlue.setEditable(false);
        txtAdviceBlue.setForeground(Color.DARK_GRAY);
        txtAdviceBlue.setText(" Blue (short-cuts):");
        txtAdviceBlue.setFont(new Font("Arial", Font.PLAIN, 14));
        txtAdviceBlue.setBackground(Color.LIGHT_GRAY);
        txtAdviceBlue.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        txtAdviceBlue.setBounds(10, 10, 180, 25);
        add(txtAdviceBlue);
        txtAdviceBlue.setColumns(10);


        txtAdvicesBlue = new JTextPane();
        txtAdvicesBlue.setForeground(Color.GRAY);
        txtAdvicesBlue.setBackground(Color.LIGHT_GRAY);
        txtAdvicesBlue.setFont(new Font("Arial", Font.ITALIC, 15));
        txtAdvicesBlue.setEditable(false);
        txtAdvicesBlue.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        txtAdvicesBlue.setText("  '<-' - Adds Point to Blue\n"
                + "  'q' - Adds Foul Point to \n  Blue\n"
                + "  'w' - Adds Yellow Card to\n  Blue\n");
        txtAdvicesBlue.setBounds(10, 35, 190, 115);
        add(txtAdvicesBlue);

    }}
