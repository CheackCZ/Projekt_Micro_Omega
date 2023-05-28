package UnitTesting_Package;

import objects_Package.Competitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import userMatch_Window_Package.UserMatch_Window;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class CompetitorTest {

    Competitor c;
    UserMatch_Window userMatchWindow;

    /**
     * What happens before every test in class
     */
    @BeforeEach
    public void SetUp() {
        c = new Competitor("Ondra", "Faltin", new Date(23-06-2005), "Male", "1. Dan", "CZE", "SONKAL", 63.0, 62.5, true);
        userMatchWindow = new UserMatch_Window(null);
    }

    /**
     * Testing the output of toString() method
     */
    @Test
    public void testToString() {
        String text = "Ondra Faltin; 1. Dan; CZE/SONKAL; 63.0";
        assertEquals(text, c.toString());
    }

    /**
     * Testing if the given method formatting the date in a right way
     */
    @Test
    public void formatToDate() {
        String text = "23-06-2005";

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  //Formatting the string with date to given date format
        Date d = null;
        try {
            d = formatter.parse(text);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        assertEquals(d, c.formatToDate(text));
    }
}