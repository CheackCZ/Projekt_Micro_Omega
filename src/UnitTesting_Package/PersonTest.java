package UnitTesting_Package;

import objects_Package.Category;
import objects_Package.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import userMatch_Window_Package.UserMatch_Window;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    Person person;

    /**
     * What happens before every test in class
     */
    @BeforeEach
    public void SetUp() {
        person = new Person();
    }

    /**
     * Testing the getAge() method if it calculates the persons age correctly
     */
    @Test
    public void getAge() {
        String dateString = "23-06-2005";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date;

        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        person.setDateOfbirth(date);

        assertEquals(17, person.getAge());
    }
}