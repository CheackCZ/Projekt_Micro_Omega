package UnitTesting_Package;

import first_Window_Package.FirstWindow_Buttons_JP;
import objects_Package.Competitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import userMatch_Window_Package.UserMatch_Window;

import java.io.File;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FirstWindow_Buttons_JPTest {

    FirstWindow_Buttons_JP firstWindowButtonsJp;

    /**
     * What happens before every test in class
     */
    @BeforeEach
    public void SetUp() {
        firstWindowButtonsJp = new FirstWindow_Buttons_JP(null, null, null, null);
    }

    /**
     * Testing if the absolute path is set correctly
     */
    @Test
    public void getPath() {
        File file = new File("Categories_ANSI.csv");
        firstWindowButtonsJp.setPath(file.getAbsolutePath());

        assertEquals("C:\\Users\\ondra\\Documents\\Zaverecny_Projekt\\Categories_ANSI.csv", firstWindowButtonsJp.getPath());
    }
}