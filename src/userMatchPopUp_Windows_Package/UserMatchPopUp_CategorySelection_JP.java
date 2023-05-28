package userMatchPopUp_Windows_Package;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import objects_Package.Category;
import userMatch_Window_Package.UserMatch_Window;

/**
 * JPanel with the category selection details
 * @author ondra
 */
public class UserMatchPopUp_CategorySelection_JP extends JPanel implements IFilter {

    /** JTextField for user to know that he has to select the weight category from JComboBox below */
    private JTextField txtChooseCategory;

    /** JCombobox to choose the weight category  */
    public JComboBox boxCategorySelection;

    /**
     * Create the Panel
     * @param userMatchWindow for all the things inside
     */
    public UserMatchPopUp_CategorySelection_JP(UserMatch_Window userMatchWindow) {

        setBackground(Color.WHITE);

        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));


        txtChooseCategory = new JTextField();
        txtChooseCategory.setBackground(Color.WHITE);
        txtChooseCategory.setHorizontalAlignment(SwingConstants.LEFT);
        txtChooseCategory.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
        txtChooseCategory.setEditable(false);
        txtChooseCategory.setText("Choose category:");
        txtChooseCategory.setBorder(BorderFactory.createLineBorder(Color.white));
        txtChooseCategory.setBounds(10, 5, 110, 25);
        add(txtChooseCategory);
        txtChooseCategory.setColumns(10);


        boxCategorySelection = new JComboBox();
        boxCategorySelection.setEditable(true);
        boxCategorySelection.setBackground(Color.white);
        boxCategorySelection.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boxCategorySelection.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
        boxCategorySelection.setToolTipText("Choose weight category!");
        boxCategorySelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //Still not working
                fillCategoryCompetitorsList(boxCategorySelection, userMatchWindow);
            }
        });
        boxCategorySelection.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {  //Controlling if the length of the written/selected category is correct
                controllOfTheCategory(boxCategorySelection, userMatchWindow, e);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                filterComboBox(((JTextField) boxCategorySelection.getEditor().getEditorComponent()).getText(), userMatchWindow.listCategory);
            }
        });
        boxCategorySelection.setBounds(10, 30, 431, 25);
        add(boxCategorySelection);

    }

    /**
     * Method that filters the showed categories to only those who match the given string
     * @param searchText filter word
     * @param list with the categories
     */
    public <Category> void filterComboBox(String searchText, ArrayList<Category> list) {
        if (!boxCategorySelection.isPopupVisible()) {  //Controlling if the pop up at the JComboBox is opened
            boxCategorySelection.showPopup();  //Otherwise it will show him
        }

        List<Category> filterArray= new ArrayList<>();

        //Getting the values of the JComboBox to the list I'm working within this method
        for (int i = 0; i < list.size(); i++) {
            Category c = list.get(i);
            if (c.toString().toLowerCase().contains(searchText.toLowerCase())) {
                filterArray.add(c);
            }
        }

        //Controlling if the size isn't null, than show everything
        if (filterArray.size() > 0) {
            DefaultComboBoxModel model = (DefaultComboBoxModel) boxCategorySelection.getModel();
            model.removeAllElements();
            for (Category c: filterArray) {
                model.addElement(c);
            }

            JTextField textfield = (JTextField) boxCategorySelection.getEditor().getEditorComponent();
            textfield.setText(searchText);
        }
    }


    /**
     * Method that controlling if the length of the written/selected category is correct
     * @param box with the categories
     * @param userMatchWindow to use the things inside
     * @param e keEvent
     */
    public void controllOfTheCategory(JComboBox box, UserMatch_Window userMatchWindow, KeyEvent e) {
        String text = ((JTextField) box.getEditor().getEditorComponent()).getText();
        for (int i = 0; i < userMatchWindow.listCategory.size(); i++) {
            if (text.toLowerCase().trim().equals(userMatchWindow.listCategory.get(i).toString().toLowerCase())) {
                e.consume();
            } else {
                userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.btnConfirmSelection.setEnabled(false);
            }
        }
    }


    /**
     * Method that filling the arraylit with competitors in given category
     * @param box with the categories
     * @param userMatchWindow to use the things inside
     */
    public void fillCategoryCompetitorsList(JComboBox box, UserMatch_Window userMatchWindow) {
        userMatchWindow.listCompetitorsFromSelectedCategory.clear();  //Clearing the box before adding something in

        String text = ((JTextField) box.getEditor().getEditorComponent()).getText();

        for (int j = 0; j < userMatchWindow.listCategory.size(); j++) {
            if (text.toLowerCase().trim().equals(userMatchWindow.listCategory.get(j).toString().toLowerCase())) {
                ((JTextField) box.getEditor().getEditorComponent()).setText(text.toUpperCase());
                Category c = (Category) box.getSelectedItem();
                userMatchWindow.category = (Category) box.getSelectedItem();
                for (int i = 0; i < userMatchWindow.listCompetitors.size(); i++) {
                    //Controlling if competitor is registered
                    //if not -> he will not compete -> not adding him to the ArrayList of competitors
                    //Also controlling if his weight is in the weight interval
                    //and if his age is in the age interval
                    if ((c.getWeightInterval().inInterval(userMatchWindow.listCompetitors.get(i).getWeight()))
                            && (userMatchWindow.listCompetitors.get(i).isRegistered())
                            && (c.getAgeInterval().inInterval(userMatchWindow.listCompetitors.get(i).getAge()))
                            && (c.getOrientation().matches(userMatchWindow.listCompetitors.get(i).getOrientation()))) {
                        userMatchWindow.listCompetitorsFromSelectedCategory.add(userMatchWindow.listCompetitors.get(i));
                    }
                }
            }
        }
        addCompetitorsToBoxes(userMatchWindow);
    }


    /**
     * Method that adds competitors to the boxes where to select them from
     * @param userMatchWindow to use the things inside
     */
    public void addCompetitorsToBoxes(UserMatch_Window userMatchWindow) {
        if (userMatchWindow.listCompetitorsFromSelectedCategory == null) {
        } else {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            DefaultComboBoxModel model2 = new DefaultComboBoxModel();

            model.addAll(userMatchWindow.listCompetitorsFromSelectedCategory);
            model2.addAll(userMatchWindow.listCompetitorsFromSelectedCategory);

            userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.redCompetitorSelection.boxCompetitorSelection.setModel(model);
            userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.blueCompetitorSelection.boxCompetitorSelection.setModel(model2);
        }
    }}
