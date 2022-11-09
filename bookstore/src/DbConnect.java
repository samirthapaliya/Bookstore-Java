import java.sql.*;

public class DbConnect {
	
	public Statement connection() {
        Connection con;
        Statement stmt = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","1234");
            stmt = con.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return stmt;
        
    }

}
