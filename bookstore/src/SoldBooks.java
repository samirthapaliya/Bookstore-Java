
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

public class SoldBooks {
    
    SoldBooks() {
        JFrame f = new JFrame();
        
        String column[] = {"Id", "Book Name", "Publisher Name", "Sold Date", "Quantity"};
        
        DbConnect db = new DbConnect();
                
        String query = "Select s.id, b.name, b.publisher_name, s.sold_date, s.quantity from sold s, books b where b.id=s.book_id";
        ArrayList<Sold> arrSold = new ArrayList<Sold>();
        
        try {
            ResultSet rs = db.connection().executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String book_name = rs.getString("name");
                String pub_name = rs.getString("publisher_name");
                String sold_date = rs.getString("sold_date");
                int quantity = rs.getInt("quantity");
                
                Sold sd = new Sold(id, book_name, pub_name, sold_date, quantity);
                arrSold.add(sd);
                
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Object data[][] = new Object[arrSold.size()][column.length];
        
        for (int i=0; i<arrSold.size(); i++) {
            data[i][0] = arrSold.get(i).id;
            data[i][1] = arrSold.get(i).book_name;
            data[i][2] = arrSold.get(i).publisher_name;
            data[i][3] = arrSold.get(i).sold_date;
            data[i][4] = arrSold.get(i).quantity;
            
        }
        
        JButton btnBack = new JButton("Back");
        f.getContentPane().add(btnBack);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnBack.setForeground(new Color(255, 255, 255));
        btnBack.setBackground(new Color(255, 0, 0));
        btnBack.setBounds(80, 40, 150, 40);
        
        
        JTable jtEmp = new JTable(data, column);
        JScrollPane sp = new JScrollPane(jtEmp);
        f.add(sp);
        sp.setBounds(200, 100, 800, 400);
        
        btnBack.addActionListener(e-> {
        	btnBack.setForeground(new Color(255, 255, 255));
   		 	btnBack.setBackground(new Color(255, 0, 0));
            new ViewBookDetails(null, false);
            
            f.dispose();
        });
       
        
        f.setLayout(null);
        f.setVisible(true); 
        f.setSize(1280, 800);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}