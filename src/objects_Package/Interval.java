package objects_Package;


/**
 * Class with interval values
 * @author ondra
 */
public class Interval {

    private double downerPart;
    private double upperPart;


    /**
     * Constructor using fields
     * @param downerPart of the interval
     * @param upperPart of the interval
     */
    public Interval(double downerPart, double upperPart) {
        this.downerPart = downerPart;
        this.upperPart = upperPart;
    }


    //Getters and Setters
    /**
     * @return downer part of interval (double)
     */
    public double getDownerPart() {
        return downerPart;
    }
    /**
     * @param downerPart of the interval
     */
    public void setDownerPart(double downerPart) {
        this.downerPart = downerPart;
    }

    /**
     * @return upper part of interval (double)
     */
    public double getUpperPart() {
        return upperPart;
    }
    /**
     * @param upperPart of the interval
     */
    public void setUpperPart(double upperPart) {
        this.upperPart = upperPart;
    }


    /**
     * Method recognizing if value is in the interval
     * @param value checked if laying in interval
     * @return if value is inside the interval (boolean)
     */
    public boolean inInterval(double value) {
        if ((value <= upperPart) && (value >= downerPart)) {
            return true;
        }
        return false;
    }}
