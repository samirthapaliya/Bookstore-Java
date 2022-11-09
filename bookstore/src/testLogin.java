import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class testLogin {
    
    @Test
    void test() {
        Login ltest = new Login();
        boolean actualOutput = ltest.userLogin("samir", "sam123456");
        assertEquals(true, actualOutput);
    }
}