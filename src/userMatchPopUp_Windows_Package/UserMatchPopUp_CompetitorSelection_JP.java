package userMatchPopUp_Windows_Package;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import objects_Package.Competitor;
import objects_Package.Points;
import objects_Package.Statistics;
import userMatch_Window_Package.UserMatch_Window;

/**
 * JPanel with the competitors selection details
 * @author ondra
 *
 */
public class UserMatchPopUp_CompetitorSelection_JP extends JPanel implements IFilter {

    /** JTextField for user to know that he has to select the competitor from JComboBox below */
    private JTextField txtChooseCompetitor;

    /** JComboBox to select competitor */
    public JComboBox boxCompetitorSelection;

    /**
     * Create the Panel
     * @param userMatchWindow for all the things inside
     */
    public UserMatchPopUp_CompetitorSelection_JP(UserMatch_Window userMatchWindow) {

        setBackground(Color.WHITE);
        setLayout(null);

        setBorder(BorderFactory.createLineBorder(Color.blue));


        txtChooseCompetitor = new JTextField();
        txtChooseCompetitor.setBackground(Color.WHITE);
        txtChooseCompetitor.setHorizontalAlignment(SwingConstants.LEFT);
        txtChooseCompetitor.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
        txtChooseCompetitor.setEditable(false);
        txtChooseCompetitor.setBorder(BorderFactory.createLineBorder(Color.white));
        txtChooseCompetitor.setBounds(10, 10, 155, 25);
        add(txtChooseCompetitor);
        txtChooseCompetitor.setColumns(10);


        boxCompetitorSelection = new JComboBox();
        ((JLabel) boxCompetitorSelection.getRenderer()).setHorizontalAlignment(JLabel.LEADING);  //Setting the text inside the pop up JComboBox to the left
        boxCompetitorSelection.setFont(new Font("Arial", Font.PLAIN, 12));
        boxCompetitorSelection.setEditable(true);
        boxCompetitorSelection.setBackground(Color.white);
        boxCompetitorSelection.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boxCompetitorSelection.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        boxCompetitorSelection.setToolTipText("Choose competitor!");
        boxCompetitorSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonEnabled(userMatchWindow);
            }
        });
        boxCompetitorSelection.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {  //Controlling if the length of the written/selected category is correct
                controllOfTheCategory(boxCompetitorSelection, userMatchWindow, e);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                filterComboBox(((JTextField) boxCompetitorSelection.getEditor().getEditorComponent()).getText(), userMatchWindow.listCompetitorsFromSelectedCategory);
                buttonEnabled(userMatchWindow);
            }
        });
        boxCompetitorSelection.setBounds(10, 35, 200, 20);
        add(boxCompetitorSelection);

    }

    //Getter
    /**
     * @return JtextField
     */
    public JTextField getTxtChooseCompetitor() {
        return txtChooseCompetitor;
    }

    /**
     * Method that filters the showed categories to only those who match the given string
     * @param searchText to filter the competitor by it
     * @param list with the competitors
     */
    public <Competitor> void filterComboBox(String searchText, ArrayList<Competitor> list) {
        if (!boxCompetitorSelection.isPopupVisible()) {  //Controlling if the pop up at the JComboBox is opened
            boxCompetitorSelection.showPopup();  //Otherwise it will show him
        }

        List<Competitor> filterArray= new ArrayList<>();

        //Getting the values of the JComboBox to the list I'm working within this method
        for (int i = 0; i < list.size(); i++) {
            Competitor c = list.get(i);
            if (c.toString().toLowerCase().contains(searchText.toLowerCase())) {
                filterArray.add(c);
            }
        }

        //Controlling if the size isn't null, than show everything
        if (filterArray.size() > 0) {
            DefaultComboBoxModel model = (DefaultComboBoxModel) boxCompetitorSelection.getModel();
            model.removeAllElements();
            for (Competitor c: filterArray) {
                model.addElement(c);
            }

            JTextField textfield = (JTextField) boxCompetitorSelection.getEditor().getEditorComponent();
            textfield.setText(searchText);
        }
    }

    /**
     * Method that controlling if the length of the written/selected category is correct
     * @param box wit the competitors
     * @param userMatchWindow to use the things inside
     * @param e keyEvent
     */
    public void controllOfTheCategory(JComboBox box, UserMatch_Window userMatchWindow, KeyEvent e) {
        String text = ((JTextField) box.getEditor().getEditorComponent()).getText();
        for (int i = 0; i < userMatchWindow.listCompetitorsFromSelectedCategory.size(); i++) {
            if (text.toLowerCase().trim().equals(userMatchWindow.listCompetitorsFromSelectedCategory.get(i).toString().toLowerCase())) {
                e.consume();
            }
        }
    }


    /**
     * Method that enables button to continue to the match when category and competitors are selected
     * @param userMatchWindow to use the things inside
     */
    public void buttonEnabled(UserMatch_Window userMatchWindow) {
        String blueBox = ((JTextField)userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.blueCompetitorSelection.boxCompetitorSelection.getEditor().getEditorComponent()).getText();
        String redBox = ((JTextField)userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.redCompetitorSelection.boxCompetitorSelection.getEditor().getEditorComponent()).getText();
        if ((!blueBox.isEmpty()) && (!redBox.isEmpty())) {
            controlForButtonEnabled(blueBox, redBox, userMatchWindow);
        } else {
            userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.btnConfirmSelection.setEnabled(false);
        }
    }


    /**
     * Method controlling if competitors are selected and if they are selected correctly
     * @param box text to filter the competitors by
     * @param box2 text to filter the competitors text by
     * @param userMatchWindow to use the things inside
     */
    public void controlForButtonEnabled(String box, String box2, UserMatch_Window userMatchWindow) {
        for (int i = 0; i < userMatchWindow.listCompetitorsFromSelectedCategory.size(); i++) {
            if (box.toLowerCase().trim().equals(userMatchWindow.listCompetitorsFromSelectedCategory.get(i).toString().toLowerCase())) {
                for (int j = 0; j < userMatchWindow.listCompetitorsFromSelectedCategory.size(); j++) {
                    if (box2.toLowerCase().trim().equals(userMatchWindow.listCompetitorsFromSelectedCategory.get(j).toString().toLowerCase())) {
                        userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.btnConfirmSelection.setEnabled(true);

                        userMatchWindow.blueCompetitor = (Competitor) userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.blueCompetitorSelection.boxCompetitorSelection.getSelectedItem();
                        userMatchWindow.redCompetitor = (Competitor) userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.redCompetitorSelection.boxCompetitorSelection.getSelectedItem();

                    }
                }
            } else if (box2.toLowerCase().trim().equals(userMatchWindow.listCompetitorsFromSelectedCategory.get(i).toString().toLowerCase())) {
                for (int j = 0; j < userMatchWindow.listCompetitorsFromSelectedCategory.size(); j++) {
                    if (box.toLowerCase().trim().equals(userMatchWindow.listCompetitorsFromSelectedCategory.get(j).toString().toLowerCase())) {
                        userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.btnConfirmSelection.setEnabled(true);

                        userMatchWindow.blueCompetitor = (Competitor) userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.blueCompetitorSelection.boxCompetitorSelection.getSelectedItem();
                        userMatchWindow.redCompetitor = (Competitor) userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.redCompetitorSelection.boxCompetitorSelection.getSelectedItem();
                    }
                }
            } else {
                userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.btnConfirmSelection.setEnabled(false);
            }
        }
        //Declarating these values in here cause I need them to be new for every match
        Points redPoints = new Points(0, 0, 0);
        Points bluePoints = new Points(0, 0, 0);

        Statistics redStats = new Statistics(redPoints, false);
        Statistics blueStats = new Statistics(bluePoints, false);

        userMatchWindow.redCompetitor.setStatistics(redStats);
        userMatchWindow.blueCompetitor.setStatistics(blueStats);
    }}
