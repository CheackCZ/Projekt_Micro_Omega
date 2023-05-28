package match_Window_Package;

import userMatchScreen_Window_Package.UpperPartUserMatch_JP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Font;
import javax.swing.JRadioButton;

/**
 * JPanel including the upper parts of the match window
 * @author ondra
 */
public class UpperPartMatch_JP extends JPanel {

    /** JTextField with the category */
    public JTextField txtCategory;
    /** JTextField with the number of the ring */
    public JTextField txtRingNumber;

    /** JRadioButton that shows if the red competitor did the spinning kick in the first round or not */
    public JRadioButton spinningKickRedFirst;
    /** JRadioButton that shows if the red competitor did the spinning kick in the second round not */
    public JRadioButton spinningKickRedSecond;

    /** JRadioButton that shows if the blue competitor did the spinning kick in the first round or not */
    public JRadioButton spinningKickBlueFirst;
    /** JRadioButton that shows if the blue competitor did the spinning kick in the second round or not */
    public JRadioButton spinningKickBlueSecond;

    /** Using to get the screen size and make the window compatible */
    Dimension dim;

    /**
     * Create the panel.
     */
    public UpperPartMatch_JP() {

        setBackground(Color.WHITE);
        setLayout(null);
        setSize(1536, 235);

        dim = Toolkit.getDefaultToolkit().getScreenSize();


        txtCategory = new JTextField();
        txtCategory.setEditable(false);
        txtCategory.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 60));
        txtCategory.setHorizontalAlignment(SwingConstants.CENTER);
        txtCategory.setForeground(Color.WHITE);
        txtCategory.setBackground(Color.BLACK);
        txtCategory.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        txtCategory.setBounds(0, 0, (int) dim.getWidth(), 135);
        add(txtCategory);


        txtRingNumber = new JTextField("RING");
        txtRingNumber.setBorder(new LineBorder(Color.GREEN));
        txtRingNumber.setEditable(false);
        txtRingNumber.setHorizontalAlignment(SwingConstants.CENTER);
        txtRingNumber.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 48));
        txtRingNumber.setForeground(Color.WHITE);
        txtRingNumber.setBackground(new Color(0, 128, 0));
        txtRingNumber.setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0)));
        txtRingNumber.setBounds(493, 135, 550, 100);
        add(txtRingNumber);


        //Buttons that shows if the spinning kick was done or not by the red competitor

        spinningKickRedFirst = new JRadioButton("");
        spinningKickRedFirst.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_unselected_icon.png")));
        spinningKickRedFirst.setForeground(Color.BLACK);
        spinningKickRedFirst.setBackground(Color.WHITE);
        spinningKickRedFirst.setHorizontalAlignment(SwingConstants.CENTER);
        spinningKickRedFirst.setVisible(false);
        spinningKickRedFirst.setBounds(1416, 155, 60, 60);
        add(spinningKickRedFirst);


        spinningKickRedSecond = new JRadioButton("");
        spinningKickRedSecond.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_unselected_icon.png")));
        spinningKickRedSecond.setForeground(Color.BLACK);
        spinningKickRedSecond.setBackground(Color.WHITE);
        spinningKickRedSecond.setHorizontalAlignment(SwingConstants.CENTER);
        spinningKickRedSecond.setVisible(false);
        spinningKickRedSecond.setBounds(1326, 155, 60, 60);
        add(spinningKickRedSecond);



        //Buttons that shows if the spinning kick was done or not by the red blue competitor


        spinningKickBlueFirst = new JRadioButton("");
        spinningKickBlueFirst.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_unselected_icon.png")));
        spinningKickBlueFirst.setForeground(Color.BLACK);
        spinningKickBlueFirst.setBackground(Color.WHITE);
        spinningKickBlueFirst.setHorizontalAlignment(SwingConstants.CENTER);
        spinningKickBlueFirst.setVisible(false);
        spinningKickBlueFirst.setBounds(60, 155, 60, 60);
        add(spinningKickBlueFirst);


        spinningKickBlueSecond = new JRadioButton("");
        spinningKickBlueSecond.setIcon(new ImageIcon(UpperPartUserMatch_JP.class.getResource("/povinnaOtocka_unselected_icon.png")));
        spinningKickBlueSecond.setForeground(Color.BLACK);
        spinningKickBlueSecond.setBackground(Color.WHITE);
        spinningKickBlueSecond.setHorizontalAlignment(SwingConstants.CENTER);
        spinningKickBlueSecond.setVisible(false);
        spinningKickBlueSecond.setBounds(150, 155, 60, 60);
        add(spinningKickBlueSecond);

    }}
