import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class testSort {
    @Test
    void test() {
        MergeSort ms = new MergeSort();
        Object[][] test = {{1,"x"}, {2,"z"}, {3,"y"}};
        ms.sort(test, 0, test.length-1, 1, "Ascending");
        
        Object[][] expected = {{1, "x"}, {3, "y"}, {2, "z"}};
        assertEquals(expected[1][0], test[1][0]);
    }
}
