package file_Window_Package;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.RowFilter;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

/**
 * Window showing the file items in JTable
 * @author ondra
 */
public class File_Window extends JFrame implements KeyListener {

    /** JPanel */
    private JPanel contentPane;

    /** Table to show the CSV file items */
    public JTable table;

    /** Window with JTextField letting user to write in text he want search for inside the JTable */
    public PopUpSearch_Window popUpSearch;

    /** boolean controlling if window is opened/closed */
    boolean popUpSearchOpened = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    File_Window frame = new File_Window();
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
    public File_Window() {

        //Declarations of JPanels/JFrames and Objects
        popUpSearch = new PopUpSearch_Window();
        popUpSearch.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeactivated(WindowEvent e) {  //Using to show all the items in the JTable when something was searched
                popUpSearch.txtSearching.setText("");
                findingGivenText();
            }
        });

        setTitle("View CSV Folder");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 750, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        /** Showing the default buttons of the window */
        setDefaultLookAndFeelDecorated(true);

        /** Setting focusable to true, because key listener function needs it */
        setFocusable(true);
        /** Adding key listener to the JFrame */
        addKeyListener(this);


        /** JScrollPane to scroll between the columns in the CSV */
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBackground(new Color(56, 56, 56));
        scrollPane.getVerticalScrollBar().setBackground(new Color(56, 56, 56));
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.darkGray));


        table = new JTable();
        scrollPane.setViewportView(table);
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.setBackground(new Color(65, 65, 65));
        table.setForeground(Color.white);
        table.getTableHeader().setBackground(new Color(56, 56, 56));  //Changes the background color of the headers
        table.getTableHeader().setForeground(Color.white);  //Changes the foreground color of the headers
        table.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.darkGray));  //Setting the border of the headers

        table.setFillsViewportHeight(true);  //Makes the rest of the window colorful as well
        table.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        table.setAutoCreateRowSorter(true);  //Sorting the CSV file by the clicked header
        table.setDefaultEditor(Object.class, null);  //Making the cells non editable


        /**
         * Setting the layout to group, because the JTable works only on this layout
         */
        GroupLayout groupLayout = new GroupLayout(contentPane);
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );
        contentPane.setLayout(groupLayout);

    }

    //Methods used in the code

    /**
     * Key listener methods (implemented)
     */
    @Override
    public void keyTyped(KeyEvent e) {  //Not used
    }
    @Override
    public void keyReleased(KeyEvent e) {  //Not used
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == 119)) {  //Opens the search for word window
            openingSearchWindow();
        }
        if (e.getKeyCode() == 27) {  //'escape' to get out of either full screen with undecorated to true or full screen with undecorated to false
            closingSearchAndFileWindow();
        }
    }


    /**
     * Method finding the given word in the JTable
     */
    public void findingGivenText() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tableModel);
        table.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + popUpSearch.txtSearching.getText()));
    }


    /**
     * Method - what happens when opening the search window by clicking "fn + f8"
     */
    public void openingSearchWindow() {
        System.out.println("Vyhledávač otevřen!");

        popUpSearch.show();
        popUpSearch.txtSearching.requestFocusInWindow();  //When opened to be focused to the text field and can type without clicking on anything
        popUpSearchOpened = true;

        popUpSearch.txtSearching.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                findingGivenText();
            }
        });
    }


    /**
     * Method that what happens when closing the search window or the file window by clicking "ESC"
     */
    public void closingSearchAndFileWindow() {
        if (popUpSearchOpened) {
            popUpSearchOpened = false;
            popUpSearch.dispose();
        } else {
            this.dispose();
        }
    }



    /**
     * Implemented method - when closing the file window the popUpSearch window closes as well
     */
    @Override
    public void dispose() {
        popUpSearch.dispose();
        super.dispose();
    }
}
