import Sorting.Testing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import Sorting.Algorithms.*;

public class Main {
    public static void main(String[] args) {
        
        try {
            System.setOut(new PrintStream(new File("Sorting\\Testing\\result.txt")));

            final boolean isSelectionSortPass = SortTest.test(new Selection());

            System.out.println("Selection Test : " + (isSelectionSortPass? "Passed": "Failed"));
    
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            System.out.close();
        }
    }
}
