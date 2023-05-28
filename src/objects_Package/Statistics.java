package objects_Package;

/**
 * Class with the competitor's stats
 * @author ondra
 */
public class Statistics {

    public Points points;

    public boolean spinningKick;


    /**
     * Constructor using fields
     * @param points (Points)
     * @param spinningKick (boolean)
     */
    public Statistics(Points points, boolean spinningKick) {
        this.points = points;
        this.spinningKick = spinningKick;
    }


    //Getters and Setters
    /**
     * @return Points (Points)
     */
    public Points getPoints() {
        return points;
    }
    /**
     * @param points (Points)
     */
    public void setPoints(Points points) {
        this.points = points;
    }}
