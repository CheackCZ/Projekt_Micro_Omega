package file_Window_Package;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;

/**
 * Window pop ups for user to write in text he wanna find inside the JTable
 * @author ondra
 */
public class PopUpSearch_Window extends JFrame {

    /** JPanel */
    private JPanel contentPane;

    /** JTextField with the word "Search for" for user to know where to write */
    public JTextField txtSearch;

    /** JTextField for user to write in what he wants find */
    public JTextField txtSearching;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PopUpSearch_Window frame = new PopUpSearch_Window();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public PopUpSearch_Window() {


        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 250, 80);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.darkGray);
        contentPane.setLayout(null);
        setResizable(false);
        setTitle("Find");


        txtSearch = new JTextField(" Search for");
        txtSearch.setEditable(false);
        txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
        txtSearch.setFont(new Font("Arial", Font.BOLD, 10));
        txtSearch.setBackground(Color.GRAY);
        txtSearch.setForeground(Color.WHITE);
        txtSearch.setBorder(BorderFactory.createLineBorder(Color.gray));
        txtSearch.setBounds(10, 10, 60, 20);
        contentPane.add(txtSearch);
        txtSearch.setColumns(10);


        txtSearching= new JTextField();
        txtSearching.setFont(new Font("Arial", Font.BOLD, 10));
        txtSearching.setEnabled(true);
        txtSearching.setEditable(true);
        txtSearching.setForeground(Color.black);
        txtSearching.setBackground(Color.white);
        txtSearching.setBorder(BorderFactory.createLineBorder(Color.gray));
        txtSearching.setBounds(75, 10, 150, 20);
        txtSearching.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 27) {  //'escape' to close the popUpSearch window
                    dispose();
                    txtSearching.setText("");
                    System.out.println("Vyhledávač v souboru zavřen!");
                }
            }
        });
        contentPane.add(txtSearching);
        txtSearching.setColumns(10);
    }}
