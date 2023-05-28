package UnitTesting_Package;

import objects_Package.Category;
import objects_Package.Interval;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import userMatch_Window_Package.UserMatch_Window;

import static org.junit.jupiter.api.Assertions.*;

public class IntervalTest {

    Interval interval;

    /**
     * What happens before every test in class
     */
    @BeforeEach
    public void SetUp() {
        interval = new Interval(57, 63);
    }

    /**
     * Testing the inInterval() method by giving a random number
     */
    @Test
    public void inInterval() {
        assertTrue(interval.inInterval(60));
    }
}