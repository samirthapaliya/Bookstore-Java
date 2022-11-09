
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Statement;
import org.junit.jupiter.api.Test;

public class testDbConnect {
    
    @Test
    void test() {
        DbConnect db = new DbConnect();
        Statement actual_output = db.connection();
        
        assertEquals(null, actual_output);
        
    }
}