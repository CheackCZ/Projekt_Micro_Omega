package first_Window_Package;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import file_Window_Package.File_Window;
import match_Window_Package.Match_Window;
import match_Window_Package.Match_Window;
import userMatch_Window_Package.UserMatch_Window;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * JPanel with buttons
 * @author ondra
 */
public class FirstWindow_Buttons_JP extends JPanel {

    /** Button to continue to next page, but it appears clickable only when everything is done */
    private JButton btnContinue;

    /** Button to view the selected file, but it appears clickable only when file is selected */
    private JButton btnViewFile;

    /** String with the path of selected file */
    private String path;

    //First part window
    /** Window showing the file */
    private File_Window fileWindow;

    //Second part windows
    /** Described at parameters of the constructor */
    private Match_Window matchWindow;
    /** Described at parameters of the constructor */
    private UserMatch_Window userMatchWindow;

    /**
     * @param fileWindow - window showing the fil
     * @param matchWindow - window with match details
     * @param userMatchWindow - window for user to control the match
     * @param firstWindow - window at the beginning
     */
    public FirstWindow_Buttons_JP(File_Window fileWindow, Match_Window matchWindow, UserMatch_Window userMatchWindow, First_Window firstWindow) {

        //Declarations of JPanels and Objects
        this.fileWindow = fileWindow;

        this.matchWindow = matchWindow;
        this.userMatchWindow = userMatchWindow;


        setBackground(Color.DARK_GRAY);
        setLayout(null);


        btnContinue = new JButton("Continue");
        btnContinue.setToolTipText("Continue to workspace and the match");
        btnContinue.setBackground(Color.white);
        btnContinue.setEnabled(false);
        btnContinue.setFocusable(false);
        btnContinue.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnContinue.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnContinueAction(firstWindow);
            }
        });
        btnContinue.setFont(new Font("Arial", Font.BOLD, 12));
        btnContinue.setBounds(95, 10, 75, 25);
        add(btnContinue);


        btnViewFile = new JButton("View File");
        btnViewFile.setToolTipText("View what's in inside the folder");
        btnViewFile.setBackground(Color.white);
        btnViewFile.setEnabled(false);
        btnViewFile.setFocusable(false);
        btnViewFile.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnViewFile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        btnViewFile.setFont(new Font("Arial", Font.BOLD, 12));
        btnViewFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFileToView();
            }
        });
        btnViewFile.setBounds(10, 10, 75, 25);
        add(btnViewFile);

    }

    /**
     * Method - what happens when "btnContinue" is clicked
     * @param firstWindow closing the window
     */
    public void btnContinueAction(First_Window firstWindow) {
        firstWindow.dispose();  //Closing the first window

        userMatchWindow.show();  //Opening the window for user during the match
        matchWindow.show();  //Opening the match window


        userMatchWindow.userMatchWindowText.txtCompetitonName.setText(firstWindow.getTxtCompetitionName().getText());  //Setting the competition name

        userMatchWindow.competitorHelper.uploadCompetitorsToList(getPath(), userMatchWindow);  //Uploading the competitors from the CSV to arrayList
        userMatchWindow.category.uploadCategoriesToArray(userMatchWindow.listCategory);  //Uploading the categories from the CSV to array
        userMatchWindow.category.addCategoriesToComboBox(userMatchWindow.listCategory, userMatchWindow);  //Adding the categories to the JComboBox

        userMatchWindow.matchWindow.RoundAndTime.btnClock.setText("0:00"); //Setting the time to "0:00" in the beginning
        userMatchWindow.userMatchScreen.roundAndTimeJp.btnClock.setText("0:00"); //Setting the time to "0:00" in the beginning

        System.out.println(userMatchWindow.competitorHelper.printingTheCompetitorsFromTheList(userMatchWindow));  //Printing the uploaded competitors
        System.out.println(userMatchWindow.category.printingTheCategoriesFromTheArray(userMatchWindow.listCategory));  //Printing the uploaded categories

    }

    /**
     * Method that opens the CSV file for user to see what is inside
     */
    public void openFileToView() {
        System.out.println("Selected folder: " + path);  //Printing the absolute path of the file
        File file = new File(path);

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String firstLine = br.readLine().trim();
            String [] columns = firstLine.split(",");  //Splitting into columns

            DefaultTableModel model = new DefaultTableModel();  //Using as a template for the Table columns
            model.setColumnIdentifiers(columns);

            Object [] tableLines = br.lines().toArray();

            for (int i = 0; i < tableLines.length; i++) {

                String line = tableLines[i].toString().trim();
                if (line != null && (line.trim().equals(",,,,,,,,,,,,,,,,,,,,,,,"))) {  //Checking if there is a value on the line
                    break;
                }
                String [] dataRow = line.split(",");
                model.addRow(dataRow);  //Adding row with value to the TableModel
            }

            fileWindow.table.setModel(model);  //Setting the values to the fileWindow
            fileWindow.show();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    //Getters and Setters
    /**
     * @return btnContinue
     */
    public JButton getBtnContinue() {
        return btnContinue;
    }

    /**
     * @return btnViewFile
     */
    public JButton getBtnViewFile() {
        return btnViewFile;
    }

    /**
     * @return -ing the path of the file
     */
    public String getPath() {
        return path;
    }
    /**
     * @param path setting the file path
     */
    public void setPath(String path) {
        this.path = path;
    }}
