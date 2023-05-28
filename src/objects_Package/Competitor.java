package objects_Package;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

import userMatch_Window_Package.UserMatch_Window;

/**
 * Class with competitor's details
 * @author ondra
 */
public class Competitor extends Person implements IParsing {

    private String belt;

    private String nationality;
    private String club;

    private double weightCategory;
    private double weight;

    private boolean registered;

    private Statistics statistics;

    UserMatch_Window userMatchWindow;


    /**
     * Constructor using fields and extended fields
     * @param name of the competitor
     * @param lastName of the competitor
     * @param dateOfbirth of the competitor
     * @param belt of the competitor
     * @param nationality of the competitor
     * @param club of the competitor
     * @param weightCategory of the competitor
     * @param weight of the competitor
     * @param registered competitor?
     * @param orientation of the competitor
     */
    public Competitor(String name, String lastName, Date dateOfbirth, String orientation, String belt, String nationality, String club,
                      double weightCategory, double weight, boolean registered) {
        super(name, lastName, dateOfbirth, orientation);
        this.belt = belt;
        this.nationality = nationality;
        this.club = club;
        this.weightCategory = weightCategory;
        this.weight = weight;
        this.registered = registered;
    }

    /**
     * Constructor not using any fields
     */
    public Competitor() {
    }

    /**
     * Constructor using only field
     * @param userMatchWindow for all the things inside
     */
    public Competitor(UserMatch_Window userMatchWindow) {
        this.userMatchWindow = userMatchWindow;
    }


    //Getters and Setters
    /**
     * @return belt (String)
     */
    public String getBelt() {
        return belt;
    }

    /**
     * @return nationality (String)
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @return club (String)
     */
    public String getClub() {
        return club;
    }

    /**
     * @return weight category (double)
     */
    public double getWeightCategory() {
        return weightCategory;
    }
    /**
     * @param weightCategory (double)
     */
    public void setWeightCategory(double weightCategory) {
        this.weightCategory = weightCategory;
    }

    /**
     * @return weight of competitor (double)
     */
    public double getWeight() {
        return weight;
    }
    /**
     * @param weight of the competitor (double)
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Checking if competitor is registered
     * @return boolean
     */
    public boolean isRegistered() {
        return registered;
    }

    /**
     * @return statistics of the competitor
     */
    public Statistics getStatistics() {
        return statistics;
    }
    /**
     * @param statistics of the competitor
     */
    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    /**
     * Using toString() method because I need to print the competitors for check
     * @return String
     */
    @Override
    public String toString() {
        return name + " " + lastName + "; " + belt + "; " + nationality + "/" + club + "; " + weightCategory;
    }


    /**
     * Method that uploads competitors from CSV and add them to the array list
     * @param path of the file (String)
     * @param userMatchWindow for all the things inside
     */
    public void uploadCompetitorsToList(String path, UserMatch_Window userMatchWindow) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            String line = "";
            String [] kolonky = null;

            int num = 0;

            while ((line = br.readLine()) != null) {
                if (num == 0) {  //Using the num to check the first line of the CSv and don't upload it to the arrayList

                } else {
                    kolonky = line.split(",");  //Separating the CSV values using comma

                    double weightCategory = parsingToDouble(kolonky[7]);  //Parsing the String value to double
                    double weight = parsingToDouble(kolonky[8]);  //Parsing the String value to double

                    Competitor c = new Competitor(kolonky[0], kolonky[1], formatToDate(kolonky[2]), kolonky[3], kolonky[4], kolonky[5],
                            kolonky[6], weightCategory, weight, Boolean.parseBoolean(kolonky[9]));

                    //Adding competitors to ArrayList
                    userMatchWindow.listCompetitors.add(c);
                }
                num++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        addCompetitorsToJList(userMatchWindow);
    }

    /**
     * This prints the competitors added to the array list from CSV
     * @param userMatchWindow for all the things inside
     * @return competitors (String)
     */
    public String printingTheCompetitorsFromTheList(UserMatch_Window userMatchWindow) {
        String str = "\n ==> Printing competitors from the csv file: \n\n";
        for (int i = 0; i < userMatchWindow.listCompetitors.size(); i++) {
            str += userMatchWindow.listCompetitors.get(i) + "\n";
        }
        return str;
    }

    /**
     * Method adding competitors to array because JList uses array
     * @param userMatchWindow for all the things inside
     */
    public void addCompetitorsToJList(UserMatch_Window userMatchWindow)  {
        for (int i = 0; i < userMatchWindow.listCompetitors.size(); i++) {
            userMatchWindow.listModel.addElement(userMatchWindow.listCompetitors.get(i));
        }
        userMatchWindow.userMatchWindowList.list.setModel(userMatchWindow.listModel);
    }


    /**
     * Method formatting String to Date format
     * @param value of the date (String)
     * @return date (Date)
     */
    public Date formatToDate(String value) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  //Formatting the string with date to given date format
        Date date = new Date();

        if (value.isEmpty()) {  //Checking if the value of the date in CSV isn't empty
            date = null;
        } else {
            try {
                date = formatter.parse(value);  //Formatting
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
     * Method that checks if value can be parsed to double
     * @param value of the String converting to double
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
    }

    /**
     * Method comparing competitors points
     * @param blue competitor
     * @param userMatchWindow for all the things inside
     */
    public void morePoints(Competitor blue, UserMatch_Window userMatchWindow) {
        if (this.getStatistics().getPoints().points > blue.getStatistics().getPoints().points) {
            colorChanges("/triangle_red.png", "/triangle_red_small.png", Color.red, userMatchWindow);
        }
        if (this.getStatistics().getPoints().points < blue.getStatistics().getPoints().points) {
            colorChanges("/triangle_blue.png", "/triangle_blue_small.png", Color.blue, userMatchWindow);
        }
        if (this.getStatistics().getPoints().points == blue.getStatistics().getPoints().points) {
            colorChanges("/triangle.png", "/triangle_small.png", new Color(0, 128, 0), userMatchWindow);
        }
        //Setting points text
        userMatchWindow.userMatchScreen.pointJP.btnBluePoints.setText(userMatchWindow.blueCompetitor.getStatistics().getPoints().getPoints() + "");
        userMatchWindow.userMatchScreen.pointJP.btnRedPoints.setText(userMatchWindow.redCompetitor.getStatistics().getPoints().getPoints() + "");

        userMatchWindow.matchWindow.Points.btnBluePoints.setText(userMatchWindow.blueCompetitor.getStatistics().getPoints().getPoints() + "");
        userMatchWindow.matchWindow.Points.btnRedPoints.setText(userMatchWindow.redCompetitor.getStatistics().getPoints().getPoints() + "");

        //Setting foul points text
        userMatchWindow.userMatchScreen.faulPointsBlueJP.btnFaulPoints.setText(userMatchWindow.blueCompetitor.getStatistics().getPoints().getFoulPoints() + "");
        userMatchWindow.userMatchScreen.faulPointsRedJP.btnFaulPoints.setText(userMatchWindow.redCompetitor.getStatistics().getPoints().getFoulPoints() + "");

        userMatchWindow.matchWindow.FaulPointsBlue.btnFaulPoints.setText(userMatchWindow.blueCompetitor.getStatistics().getPoints().getFoulPoints() + "");
        userMatchWindow.matchWindow.FaulPointsRed.btnFaulPoints.setText(userMatchWindow.redCompetitor.getStatistics().getPoints().getFoulPoints() + "");

        //Setting yellow cards text
        userMatchWindow.userMatchScreen.faulPointsBlueJP.btnYellowCards.setText(userMatchWindow.blueCompetitor.getStatistics().getPoints().getYellowCards() + "");
        userMatchWindow.userMatchScreen.faulPointsRedJP.btnYellowCards.setText(userMatchWindow.redCompetitor.getStatistics().getPoints().getYellowCards() + "");

        userMatchWindow.matchWindow.FaulPointsBlue.btnYellowCards.setText(userMatchWindow.blueCompetitor.getStatistics().getPoints().getYellowCards() + "");
        userMatchWindow.matchWindow.FaulPointsRed.btnYellowCards.setText(userMatchWindow.redCompetitor.getStatistics().getPoints().getYellowCards() + "");
    }

    /**
     * Changing the colors of everything
     * @param photoBig setting the color of the lblTriangle in Match_Window
     * @param photoSmall setting the color of the lblTriangle in UserMatchScreen
     * @param color (Color)
     * @param userMatchWindow for all the things inside
     */
    public void colorChanges(String photoBig, String photoSmall, Color color, UserMatch_Window userMatchWindow) {
        //Setting the triangle color at the bottom of the points
        userMatchWindow.matchWindow.Points.lblTriangle.setIcon(new ImageIcon(Competitor.class.getResource(photoBig)));
        userMatchWindow.userMatchScreen.pointJP.lblTriangle.setIcon(new ImageIcon(Competitor.class.getResource(photoSmall)));

        //Setting the ring background color
        userMatchWindow.matchWindow.UpperPart.txtRingNumber.setBackground(color);
        userMatchWindow.matchWindow.UpperPart.txtRingNumber.setBorder(new LineBorder(color));

        userMatchWindow.userMatchScreen.upperPartJP.txtRingNumber.setBackground(color);
        userMatchWindow.userMatchScreen.upperPartJP.txtRingNumber.setBorder(new LineBorder(color));

        //Setting the color of the table over the user match screen window
        if (color == Color.blue) {
            userMatchWindow.boxUserMatchWindow.setBorder(BorderFactory.createLineBorder(color, 4, true));
        } else if (color == Color.red) {
            userMatchWindow.boxUserMatchWindow.setBorder(BorderFactory.createLineBorder(color, 4, true));
        } else {
            userMatchWindow.boxUserMatchWindow.setBorder(BorderFactory.createLineBorder(Color.black, 4, true));
        }

    }}
