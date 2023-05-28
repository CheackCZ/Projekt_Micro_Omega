package userMatch_Window_Package;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

/**
 * JPanel with text advices for user to know how to use keyboard short cuts
 * @author ondra
 */
public class UserMatchWindow_TextAdvice_JP extends JPanel {

    /** JTextPane with the advice for user to know what short-cut to use */
    private JTextField txtAdviceBeforeMatch;

    /** JTextField that helps user and navigates him how to use key short cuts in the user window before the match started */
    private JTextPane txtAdvicesBM;

    /**
     * Create the panel.
     */
    public UserMatchWindow_TextAdvice_JP() {

        setBackground(new Color(240, 240, 240));
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.black));


        txtAdvicesBM = new JTextPane();
        txtAdvicesBM.setForeground(Color.GRAY);
        txtAdvicesBM.setBackground(new Color(240, 240, 240));
        txtAdvicesBM.setFont(new Font("Arial", Font.ITALIC, 15));
        txtAdvicesBM.setText("  (Fn) + F1 -> Category/Competitors Selection window; "
                + "(Fn) + F2 -> Round/Time Selection window; "
                + "(Fn) + F3 -> Break Selection window; (Fn) + F4 -> End Round \n  window; "
                + "(Fn) + F5 -> End Match window; (Fn) + F6 -> Set the Ring Number; "
                + "(Fn) + F7 -> Refreshes all the details; ");
        txtAdvicesBM.setEditable(false);
        txtAdvicesBM.setBounds(20, 45, 1145, 50);
        add(txtAdvicesBM);


        txtAdviceBeforeMatch = new JTextField();
        txtAdviceBeforeMatch.setForeground(Color.DARK_GRAY);
        txtAdviceBeforeMatch.setBackground(new Color(240, 240, 240));
        txtAdviceBeforeMatch.setFont(new Font("Arial", Font.PLAIN, 14));
        txtAdviceBeforeMatch.setText("Before Match (short-cuts):");
        txtAdviceBeforeMatch.setEditable(false);
        txtAdviceBeforeMatch.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)));
        txtAdviceBeforeMatch.setBounds(24, 15, 550, 30);
        add(txtAdviceBeforeMatch);
        txtAdviceBeforeMatch.setColumns(10);

    }
}
