package UnitTesting_Package;

import objects_Package.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import userMatch_Window_Package.UserMatch_Window;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    Category c;
    UserMatch_Window userMatchWindow;

    @BeforeEach
    public void SetUp() {
        c = new Category();
        userMatchWindow = new UserMatch_Window(null);
    }

    /**
     * Testing if the given method printing the categories as it should
     */
    @Test
    public void printingTheCategoriesFromTheArray() {
        String text = "\n ==> Printing categories from the csv file: \n" +
                "\n" +
                "MLADŠÍ ŽÁCI (- 10 LET) - 25 KG\n" +
                "MLADŠÍ ŽÁCI (- 10 LET) - 30 KG\n" +
                "MLADŠÍ ŽÁCI (- 10 LET) - 35 KG\n" +
                "MLADŠÍ ŽÁCI (- 10 LET) - 40 KG\n" +
                "MLADŠÍ ŽÁCI (- 10 LET) + 40 KG\n" +
                "MLADŠÍ ŽÁKYNÌ (- 10 LET) - 25 KG\n" +
                "MLADŠÍ ŽÁKYNÌ (- 10 LET) - 30 KG\n" +
                "MLADŠÍ ŽÁKYNÌ (- 10 LET) - 35 KG\n" +
                "MLADŠÍ ŽÁKYNÌ (- 10 LET) - 40 KG\n" +
                "MLADŠÍ ŽÁKYNÌ (- 10 LET) + 40 KG\n" +
                "STARŠÍ ŽÁCI (11 - 13 LET) - 35 KG\n" +
                "STARŠÍ ŽÁCI (11 - 13 LET) - 40 KG\n" +
                "STARŠÍ ŽÁCI (11 - 13 LET) - 45 KG\n" +
                "STARŠÍ ŽÁCI (11 - 13 LET) - 50 KG\n" +
                "STARŠÍ ŽÁCI (11 - 13 LET) - 55 KG\n" +
                "STARŠÍ ŽÁCI (11 - 13 LET) - 60 KG\n" +
                "STARŠÍ ŽÁCI (11 - 13 LET) + 60 KG\n" +
                "STARŠÍ ŽÁKYNÌ (11 - 13 LET) - 30 KG\n" +
                "STARŠÍ ŽÁKYNÌ (11 - 13 LET) - 35 KG\n" +
                "STARŠÍ ŽÁKYNÌ (11 - 13 LET) - 40 KG\n" +
                "STARŠÍ ŽÁKYNÌ (11 - 13 LET) - 45 KG\n" +
                "STARŠÍ ŽÁKYNÌ (11 - 13 LET) - 50 KG\n" +
                "STARŠÍ ŽÁKYNÌ (11 - 13 LET) - 55 KG\n" +
                "STARŠÍ ŽÁKYNÌ (11 - 13 LET) + 55 KG\n" +
                "MLADŠÍ JUNIOØI (14 - 15 LET) - 45 KG\n" +
                "MLADŠÍ JUNIOØI (14 - 15 LET) - 50 KG\n" +
                "MLADŠÍ JUNIOØI (14 - 15 LET) - 55 KG\n" +
                "MLADŠÍ JUNIOØI (14 - 15 LET) - 60 KG\n" +
                "MLADŠÍ JUNIOØI (14 - 15 LET) - 65 KG\n" +
                "MLADŠÍ JUNIOØI (14 - 15 LET) - 70 KG\n" +
                "MLADŠÍ JUNIOØI (14 - 15 LET) + 70 KG\n" +
                "MLADŠÍ JUNIORKY (14 - 15 LET) - 40 KG\n" +
                "MLADŠÍ JUNIORKY (14 - 15 LET) - 45 KG\n" +
                "MLADŠÍ JUNIORKY (14 - 15 LET) - 50 KG\n" +
                "MLADŠÍ JUNIORKY (14 - 15 LET) - 55 KG\n" +
                "MLADŠÍ JUNIORKY (14 - 15 LET) - 60 KG\n" +
                "MLADŠÍ JUNIORKY (14 - 15 LET) - 65 KG\n" +
                "MLADŠÍ JUNIORKY (14 - 15 LET) + 65 KG\n" +
                "STARŠÍ JUNIOØI (16 - 18 LET) - 45 KG\n" +
                "STARŠÍ JUNIOØI (16 - 18 LET) - 51 KG\n" +
                "STARŠÍ JUNIOØI (16 - 18 LET) - 57 KG\n" +
                "STARŠÍ JUNIOØI (16 - 18 LET) - 63 KG\n" +
                "STARŠÍ JUNIOØI (16 - 18 LET) - 69 KG\n" +
                "STARŠÍ JUNIOØI (16 - 18 LET) - 75 KG\n" +
                "STARŠÍ JUNIOØI (16 - 18 LET) + 75 KG\n" +
                "STARŠÍ JUNIORKY (16 - 18 LET) - 40 KG\n" +
                "STARŠÍ JUNIORKY (16 - 18 LET) - 46 KG\n" +
                "STARŠÍ JUNIORKY (16 - 18 LET) - 52 KG\n" +
                "STARŠÍ JUNIORKY (16 - 18 LET) - 58 KG\n" +
                "STARŠÍ JUNIORKY (16 - 18 LET) - 64 KG\n" +
                "STARŠÍ JUNIORKY (16 - 18 LET) - 70 KG\n" +
                "STARŠÍ JUNIORKY (16 - 18 LET) + 70 KG\n" +
                "SENIOØI (19 - 39 LET) - 52 KG\n" +
                "SENIOØI (19 - 39 LET) - 58 KG\n" +
                "SENIOØI (19 - 39 LET) - 64 KG\n" +
                "SENIOØI (19 - 39 LET) - 71 KG\n" +
                "SENIOØI (19 - 39 LET) - 78 KG\n" +
                "SENIOØI (19 - 39 LET) - 85 KG\n" +
                "SENIOØI (19 - 39 LET) - 92 KG\n" +
                "SENIOØI (19 - 39 LET) + 92 KG\n" +
                "SENIORKY (19 - 39 LET) - 47 KG\n" +
                "SENIORKY (19 - 39 LET) - 52 KG\n" +
                "SENIORKY (19 - 39 LET) - 57 KG\n" +
                "SENIORKY (19 - 39 LET) - 62 KG\n" +
                "SENIORKY (19 - 39 LET) - 67 KG\n" +
                "SENIORKY (19 - 39 LET) - 72 KG\n" +
                "SENIORKY (19 - 39 LET) - 77 KG\n" +
                "SENIORKY (19 - 39 LET) + 77 KG\n" +
                "VETERÁNI (40 + LET) - 64 KG\n" +
                "VETERÁNI (40 + LET) - 73 KG\n" +
                "VETERÁNI (40 + LET) - 80 KG\n" +
                "VETERÁNI (40 + LET) - 90 KG\n" +
                "VETERÁNI (40 + LET) + 90 KG\n" +
                "VETERÁNKY (40 + LET) - 54 KG\n" +
                "VETERÁNKY (40 + LET) - 61 KG\n" +
                "VETERÁNKY (40 + LET) - 68 KG\n" +
                "VETERÁNKY (40 + LET) - 75 KG\n" +
                "VETERÁNKY (40 + LET) + 75 KG\n";

        c.uploadCategoriesToArray(userMatchWindow.listCategory);
        assertEquals(text, c.printingTheCategoriesFromTheArray(userMatchWindow.listCategory), "Je podle oèekávání!");
    }

    /**
     * Testing if the given method parsing the String to double correctly
     */
    @Test
    public void parsingToDouble() {
        assertEquals(11.0, c.parsingToDouble("11"));
        assertEquals(0.0, c.parsingToDouble(""));
    }
}