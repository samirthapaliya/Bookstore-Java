import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;


public class BookDetails {
	
	BookDetails(){	
		JFrame f = new JFrame();    
		JLabel lname , lpublishername, lpublishdate, lstock, lprice;
		JTextField tfname;
		JTextField tfpublishername;
		JTextField tfpublishdate;
		JTextField tfstock;
		JTextField tfprice;

		JButton btnAddBook, btnExit;
		
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("Add book");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel.setBounds(250, 5, 279, 86);
		f.getContentPane().add(lblNewLabel);
		
		lname = new JLabel("Book Name :");     
		f.add(lname);
		lname.setBounds(150, 80, 300, 60);
		
		tfname = new JTextField();
		f.add(tfname);
		tfname.setBounds(250, 90, 300, 30);
		
		lpublishername = new JLabel("Publisher Name :");     
		f.add(lpublishername);
		lpublishername.setBounds(150, 120, 300, 60);
		
		tfpublishername = new JTextField();
		f.add(tfpublishername);
		tfpublishername.setBounds(250, 130, 300, 30);
		
		lpublishdate = new JLabel("Publish Date :");     
		f.add(lpublishdate);
		lpublishdate.setBounds(150, 160, 320, 60);
		
		tfpublishdate = new JTextField();
		f.add(tfpublishdate);
		tfpublishdate.setBounds(250, 170, 300, 30);
		
		
		lstock = new JLabel("Stock :");     
		f.add(lstock);
		lstock.setBounds(150, 200, 300, 60);
		
		tfstock = new JTextField();
		f.add(tfstock);
		tfstock.setBounds(250, 210, 300, 30);
		
		lprice = new JLabel("Price :");     
		f.add(lprice);
		lprice.setBounds(150, 240, 320, 60);
		
		tfprice = new JTextField();
		f.add(tfprice);
		tfprice.setBounds(250, 250, 300, 30);
		
		
				
		btnAddBook = new JButton("Add Book");
		f.add(btnAddBook);
		btnAddBook.setBackground(new Color(34, 139, 34));
		btnAddBook.setForeground(new Color(255, 255, 255));
		btnAddBook.setFont(new Font("Tw Cen MT", Font.PLAIN, 40));
		btnAddBook.setBounds(150, 300, 400, 40);
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 0, 0));
		f.add(btnExit);
		btnExit.setBounds(150, 360, 400, 40);
		
//Exit Action
		
		btnExit.addActionListener(e->{
			new ViewBookDetails(null, false);
			f.dispose();
		});
		
		
		btnAddBook.addActionListener(e->{
			String name = tfname.getText();
			String publishername = tfpublishername.getText();
			String publishdate = tfpublishdate.getText();
			String stock = tfstock.getText();
			String price = tfprice.getText();
		
			DbConnect db = new DbConnect();
			
			try {
	            String insert_query = "insert into books(name, publisher_name, publish_date, price, stock) "
	            		+ "values('" + name+ "','" + publishername + "','" + publishdate + "'," + price + "," + stock + ")";
	            int result = db.connection().executeUpdate(insert_query);
	            if (result>0) {
	                JOptionPane.showMessageDialog(btnAddBook, "Data successfully saved");
	                new BookDetails();
	                f.dispose();
	            }
	        } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
			
			
		});
					
		
		
		
		
		
		
		
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(700,500);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
		
	}
	public static void main(String[] args) {
		BookDetails log = new BookDetails();				
	}
}

