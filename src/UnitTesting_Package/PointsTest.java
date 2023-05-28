package UnitTesting_Package;

import objects_Package.Category;
import objects_Package.Points;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import userMatch_Window_Package.UserMatch_Window;

import static org.junit.jupiter.api.Assertions.*;

public class PointsTest {
    Points points;
    UserMatch_Window userMatchWindow;

    /**
     * What happens before every test in class
     */
    @BeforeEach
    public void SetUp() {
        points = new Points(9, 0, 1);
        userMatchWindow = new UserMatch_Window(null);
    }


    /**
     * Testing the setFoulPoints() and setYellowCards() methods
     */
    @Test
    public void getPoints() {
        points.setFoulPoints(3);
        points.setFoulPoints(points.getFoulPoints()+1);
        points.setFoulPoints(points.getFoulPoints()+1);
        points.setFoulPoints(points.getFoulPoints()+1);

        points.setYellowCards(1, userMatchWindow);
        points.setYellowCards(points.getYellowCards()+1, userMatchWindow);

        assertEquals(5, points.getPoints());

    }
}