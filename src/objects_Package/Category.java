package objects_Package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import userMatch_Window_Package.UserMatch_Window;

/**
 * Class with cateory details
 * @author ondra
 */
public class Category implements IParsing {

    private String name;

    private Interval weightInterval;
    private Interval ageInterval;

    private String orientation;


    /**
     * Constructor using fields
     * @param name of the category
     * @param downerPartAge of the category
     * @param upperPartAge of the category
     * @param downerPartWeight of the category
     * @param upperPartWeight of the category
     * @param orientation of the category
     */
    public Category(String name, double downerPartAge, double upperPartAge, double downerPartWeight, double upperPartWeight, String orientation) {
        this.name = name;
        this.weightInterval = new Interval(downerPartWeight, upperPartWeight);
        this.ageInterval = new Interval(downerPartAge, upperPartAge);
        this.orientation = orientation;
    }

    /**
     * Constructor without fields
     */
    public Category() {
    }


    //Getters and Setters
    /**
     * @return -ing the name of the category
     */
    public String getName() {
        return name;
    }
    /**
     * @param name of the category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return interval of weights
     */
    public Interval getWeightInterval() {
        return weightInterval;
    }
    /**
     * @param weightInterval of the category
     */
    public void setWeightInterval(Interval weightInterval) {
        this.weightInterval = weightInterval;
    }

    /**
     * @return interval of ages
     */
    public Interval getAgeInterval() {
        return ageInterval;
    }
    /**
     * @param ageInterval of the category
     */
    public void setAgeInterval(Interval ageInterval) {
        this.ageInterval = ageInterval;
    }

    /**
     * @return the orientation of the category (String)
     */
    public String getOrientation() {
        return orientation;
    }

    /**
     * Using custom toString because of the way I want it to look like on the screen
     */
    @Override
    public String toString() {
        String text = "matsogi " + name;
        return name.toUpperCase();
    }


    /**
     * Method that uploads the categories to the array
     * @param list with the categories
     */
    public void uploadCategoriesToArray(ArrayList<Category> list) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(Category.class.getResourceAsStream("/Categories_ANSI.csv")));  //Folder with categories

            String line = "";
            String [] kolonky = null;

            int num = 0;
            int i = 0;

            while ((line = br.readLine()) != null) {
                if (num == 0) {
                } else {
                    kolonky = line.split(",");  //Separating the CSV values using comma

                    //Adding the categories from the file to ArrayList
                    list.add(new Category(kolonky[0], parsingToDouble(kolonky[1]), parsingToDouble(kolonky[2]),
                            parsingToDouble(kolonky[3]), parsingToDouble(kolonky[4]), kolonky[5]));

                }
                num++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This prints the competitors added to the array list from CSV - for control
     * @param list with the categories
     * @return String with the competitors
     */
    public String printingTheCategoriesFromTheArray(ArrayList<Category> list) {
        String str = "\n ==> Printing categories from the csv file: \n\n";
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i) + "\n";
        }
        return str;
    }

    /**
     * Method adding competitors to array because JList using array
     * @param list with the categories
     * @param userMatchWindow to get values from it
     */
    public void addCategoriesToComboBox(ArrayList<Category> list, UserMatch_Window userMatchWindow) {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addAll(list);
        userMatchWindow.userMatchWindowButtons.popUpSelectCompetitors.userMatchPopUp_Category.boxCategorySelection.setModel(model);
    }


    /**
     * Method that checks if value can be parsed to double
     * @param value from the CSV file which being checked
     * @return double
     */
    public double parsingToDouble(String value) {
        double tmp = 0;
        if (value.isEmpty()) {   //Checking if the value of the double in CSV isn't empty
            return tmp;
        } else {
            tmp = Double.parseDouble(value);  //Parsing
        }
        return tmp;
    }}
