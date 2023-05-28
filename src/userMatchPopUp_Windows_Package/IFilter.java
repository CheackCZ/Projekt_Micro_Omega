package userMatchPopUp_Windows_Package;

import java.util.ArrayList;

/**
 * Interface including method filtering JComboBox
 * @author ondra
 */
public interface IFilter {

    /**
     * Method filtering ArrayList of given data type
     * @param <T> Category/Competition
     * @param searchText -> filter word
     * @param list -> ArrayList
     */
    public <T> void filterComboBox(String searchText, ArrayList<T> list);
}
