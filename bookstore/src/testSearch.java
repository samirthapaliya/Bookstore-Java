import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
public class testSearch {
    
    @Test
    void test() {
        Search ls = new Search();
        Object[][] test = {{1,"xrt"}, {2,"Pqdr"}, {3,"Xyz"}};
        ArrayList<Object[]> searched = new ArrayList<Object[]>();
        ls.searchString(test, searched, 1, "xrt");
        ArrayList<Object[]> expected = new ArrayList<Object[]>();
        Object[]arr = {1,"Abc"};
        expected.add(arr);
        
        assertEquals(expected.get(0)[0], searched.get(0)[0]);
        
    }
    
}