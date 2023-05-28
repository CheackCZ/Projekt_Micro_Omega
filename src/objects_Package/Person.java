package objects_Package;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

/**
 * Class with peron details
 * @author ondra
 */
public class Person {

    protected String name;
    protected String lastName;
    protected Date dateOfbirth;
    protected String orientation;


    /**
     Constructor using (protected) fields
     * @param name of the Person
     * @param lastName of the Person
     * @param dateOfbirth of the Person
     * @param orientation of the Person
     */
    public Person(String name, String lastName, Date dateOfbirth, String orientation) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfbirth = dateOfbirth;
        this.orientation = orientation;
    }

    /**
     * Constructor not using any fields
     */
    public Person() {
    }


    //Getters and Setters
    /**
     * @return name of the person (String)
     */
    public String getName() {
        return name;
    }
    /**
     * @param name (String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return last name of the person (String)
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * @param lastName (String)
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return date of birth of the person (Date)
     */
    public Date getDateOfbirth() {
        return dateOfbirth;
    }
    /**
     * @param dateOfbirth (Date)
     */
    public void setDateOfbirth(Date dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    /**
     * @return sex
     */
    public String getOrientation() {
        return orientation;
    }
    /**
     * @param orientation of the person
     */
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    /**
     * Method getting the age of the person from the date of birth
     * @return the actual age
     */
    public int getAge() {
        LocalDate today = LocalDate.now();
        LocalDate endDate = LocalDate.of(this.getDateOfbirth().getYear() + 1900, this.getDateOfbirth().getMonth()+1, this.getDateOfbirth().getDate());

        Period period = Period.between(endDate, today);
        int age = period.getYears();

        return age;
    }}
