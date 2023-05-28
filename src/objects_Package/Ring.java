package objects_Package;

/**
 * Class with ring details
 * @author ondra
 */
public class Ring {

    private int number;


    /**
     * Constructor without fields
     */
    public Ring() {
    }


    /**
     * Constructor using fields
     * @param number of the Rind
     */
    public Ring(int number) {
        this.number = number;
    }


    //Getters and Seters
    /**
     * @return bumber of the ring (int)
     */
    public int getNumber() {
        return number;
    }
    /**
     * @param number (int)
     */
    public void setNumber(int number) {
        this.number = number;
    }}
