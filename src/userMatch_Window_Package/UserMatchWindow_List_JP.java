package userMatch_Window_Package;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import objects_Package.Competitor;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * JPanel with the JList of the competitors
 * @author ondra
 */
public class UserMatchWindow_List_JP extends JPanel {

    /** JTextField that helps user to know where to see all/from selected category competitors */
    private JTextField txtCompetitors;

    /** txt with the word "Search for" for user to know where to write */
    private JTextField txtSearchFor;
    /** JTextField where user writes in the string he wants to find in between the competitors */
    private JTextField txtSearching;

    /** JList to show all the competitors */
    public JList list;

    /**
     * Create the Panel
     * @param userMatchWindow for all the things inside
     */
    public UserMatchWindow_List_JP(UserMatch_Window userMatchWindow) {

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.black));


        /** Using JScrollPane to scroll between all the competitors int the JList */
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 40, 330, 741);
        add(scrollPane);


        list = new JList();
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {  //On double-click
                    competitorsDetails();  //Pop up window showing the details of competitors
                }
            }
        });
        scrollPane.setViewportView(list);


        txtCompetitors = new JTextField("Competitors (All): ");
        txtCompetitors.setEditable(false);
        txtCompetitors.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)));
        txtCompetitors.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
        txtCompetitors.setBackground(new Color(240, 240, 240));
        txtCompetitors.setBounds(10, 5, 330, 30);
        add(txtCompetitors);
        txtCompetitors.setColumns(10);


        txtSearchFor = new JTextField();
        txtSearchFor.setBorder(BorderFactory.createLineBorder(Color.gray));
        txtSearchFor.setBackground(Color.LIGHT_GRAY);
        txtSearchFor.setFont(new Font("Arial", Font.PLAIN, 12));
        txtSearchFor.setText(" Search for:");
        txtSearchFor.setEditable(false);
        txtSearchFor.setBounds(10, 791, 75, 30);
        add(txtSearchFor);
        txtSearchFor.setColumns(10);


        txtSearching = new JTextField();
        txtSearching.setFont(new Font("Arial", Font.PLAIN, 12));
        txtSearching.setBorder(BorderFactory.createLineBorder(Color.gray));
        txtSearching.setBounds(95, 791, 245, 30);
        txtSearching.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                searchingInJList(userMatchWindow);
            }
        });
        add(txtSearching);
        txtSearching.setColumns(10);
    }

    /**
     * Method that shows the competitors details
     */
    public void competitorsDetails() {
        Competitor c = (Competitor) list.getSelectedValue();  //Creating a competitor where another competitor will be authorized

        //Formatting the date because I don't want it to show the time
        String formattedDate;
        if (c.getDateOfbirth() == null) {
            formattedDate = "";
        } else {
            formattedDate = c.getDateOfbirth().getDate() + "." + (c.getDateOfbirth().getMonth() + 1) + "." + (c.getDateOfbirth().getYear() + 1900);
        }

        String extract = "Competitor " +
                "\n Name:                          " + c.getName() + " " + c.getLastName() +
                "\n Date of Birth:              " + formattedDate +
                "\n Belt:                             " + c.getBelt() +
                "\n Nationality/Club:        " + c.getNationality() + "/" + c.getClub() +
                "\n Weight Category:       " + (int) c.getWeightCategory() + " Kg" +
                "\n Registered?:              " + c.isRegistered();

        //Pop up window showing details about selected competitor
        JOptionPane.showMessageDialog(null, extract, "Selected Competitor", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Method showing only competitors who equals to the given text by user
     * @param userMatchWindow for all the things inside
     */
    public void searchingInJList(UserMatch_Window userMatchWindow) {
        String filterText = txtSearching.getText();  //Given text want to find
        List<Competitor> filteredData = new ArrayList<>();  //List with the competitors equal to the given text

        for (int i = 0; i < userMatchWindow.listCompetitors.size(); i++) {
            Competitor c = userMatchWindow.listCompetitors.get(i);
            if (c.toString().toLowerCase().contains(filterText.toLowerCase())) {
                filteredData.add(c);
            }
        }

        //Setting the JList to new DefaultListModel with the competitors equaled to the given text
        DefaultListModel<Competitor> filteredModel = new DefaultListModel<>();
        filteredData.forEach(filteredModel::addElement);

        list.setModel(filteredModel);
        list.revalidate();
        list.repaint();
    }}
