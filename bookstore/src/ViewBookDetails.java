
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.TableModel;


import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class ViewBookDetails {
	public static void main(String[] args) {
		ViewBookDetails vbd = new ViewBookDetails(null, false);
	}
	
		ViewBookDetails(Object[][]filtered, boolean changed){
		JFrame f = new JFrame("View Books");
		f.getContentPane().setBackground(new Color(255, 228, 196));
		
		String column[] = {"Id", "Name","Publisher Name","Publish Date", "Price", "Stock"};
		
		
		Object [][] data;
		
		DbConnect db = new DbConnect();
		
		if(changed) {
            data = filtered;
            
            
        } else {
        	
        	
    		String query = "Select * from books";
    		ArrayList<Book> arrbook = new ArrayList<Book>();
    		
    		try {
                ResultSet rs = db.connection().executeQuery(query);
                while(rs.next()) {
                    int book_id = rs.getInt("id");
                    String book_name = rs.getString("name");
                    String pub_name = rs.getString("publisher_name");
                    String pub_date = rs.getString("publish_date");
                    int price = rs.getInt("price");
                    int stock = rs.getInt("stock");
                    
                    Book bk = new Book(book_id, book_name, pub_name, pub_date, price, stock);
                    arrbook.add(bk);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            data = new Object[arrbook.size()][column.length];
            
            for (int i=0; i<data.length; i++) {
                data[i][0] = arrbook.get(i).book_id;
                data[i][1] = arrbook.get(i).book_name;
                data[i][2] = arrbook.get(i).publisher_name;
                data[i][3] = arrbook.get(i).publish_date;
                data[i][4] = arrbook.get(i).price;
                data[i][5] = arrbook.get(i).stock;
            }
    		
    		
            
        }
		

		JTable jtEmp = new JTable(data, column);
		JScrollPane sp = new JScrollPane(jtEmp);
		f.add(sp);
		sp.setBounds(418, 97, 614, 414);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buttons", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(32, 20, 370, 274);
		f.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAllBooks = new JButton("All Books");
		btnAllBooks.setFont(new Font("Arial", Font.BOLD, 20));
		btnAllBooks.setBounds(21, 31, 159, 51);
		panel.add(btnAllBooks);
		
		JButton btnAvailableBooks = new JButton("Available Books");
		btnAvailableBooks.setFont(new Font("Arial", Font.BOLD, 16));
		btnAvailableBooks.setBounds(21, 108, 159, 51);
		panel.add(btnAvailableBooks);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.setFont(new Font("Arial", Font.BOLD, 20));
		btnAddBook.setBounds(199, 31, 150, 51);
		panel.add(btnAddBook);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Arial", Font.BOLD, 20));
		btnUpdate.setBounds(21, 190, 159, 51);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Arial", Font.BOLD, 20));
		btnDelete.setBounds(199, 107, 150, 51);
		panel.add(btnDelete);
		
		JButton btnSoldBooks = new JButton("Sold Book");
		btnSoldBooks.setBounds(199, 190, 150, 51);
		panel.add(btnSoldBooks);
		btnSoldBooks.setFont(new Font("Arial", Font.BOLD, 20));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Sell Book", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(32, 319, 376, 279);
		f.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnSellBooks = new JButton("Sell Book");
		btnSellBooks.setBounds(115, 10, 156, 44);
		panel_2.add(btnSellBooks);
		btnSellBooks.setFont(new Font("Arial", Font.BOLD, 20));
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(418, 20, 614, 67);
		f.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lsearchBy = new JLabel("Search By");
		lsearchBy.setFont(new Font("Tahoma", Font.BOLD, 16));
		lsearchBy.setBounds(10, 20, 85, 37);
		panel_1.add(lsearchBy);
		
		JComboBox jsSearchBy = new JComboBox();
		jsSearchBy.setModel(new DefaultComboBoxModel(new String[] {"Book Name", "Publisher", "Publish Date"}));
		jsSearchBy.setFont(new Font("Tahoma", Font.BOLD, 14));
		jsSearchBy.setBounds(105, 20, 167, 32);
		panel_1.add(jsSearchBy);
		
		JTextField tfsearchVal = new JTextField();
		tfsearchVal.setFont(new Font("Tahoma", Font.BOLD, 15));
		tfsearchVal.setBounds(282, 20, 167, 30);
		panel_1.add(tfsearchVal);
		tfsearchVal.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(459, 20, 134, 32);
		panel_1.add(btnSearch);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setBounds(418, 531, 614, 67);
		f.getContentPane().add(panel_1_1);
		
		JLabel lsortby = new JLabel("Sort By");
		lsortby.setFont(new Font("Tahoma", Font.BOLD, 16));
		lsortby.setBounds(10, 17, 85, 37);
		panel_1_1.add(lsortby);
		
		JComboBox jcSortby = new JComboBox();
		jcSortby.setModel(new DefaultComboBoxModel(new String[] {"Book Name", "Publisher", "Publish Date"}));
		jcSortby.setFont(new Font("Tahoma", Font.BOLD, 16));
		jcSortby.setBounds(78, 19, 167, 32);
		panel_1_1.add(jcSortby);
		
		JLabel lorder = new JLabel("Order");
		lorder.setFont(new Font("Tahoma", Font.BOLD, 16));
		lorder.setBounds(263, 17, 69, 37);
		panel_1_1.add(lorder);
		
		JComboBox jcSort = new JComboBox();
		jcSort.setModel(new DefaultComboBoxModel(new String[] {"Ascending", "Descending"}));
		jcSort.setFont(new Font("Tahoma", Font.BOLD, 14));
		jcSort.setBounds(323, 19, 167, 32);
		panel_1_1.add(jcSort);
		
		JButton btnSort = new JButton("Sort");
		btnSort.setBounds(495, 17, 109, 32);
		panel_1_1.add(btnSort);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogout.setBackground(new Color(255, 0, 0));
		btnLogout.setBounds(895, 0, 137, 21);
		f.getContentPane().add(btnLogout);

		
		
		
//AddBooks
		
		btnAddBook.addActionListener(e -> {
			new BookDetails();
			f.dispose();
		});
		

		
//Update
		
		btnUpdate.addActionListener(e -> {
            int row = jtEmp.getSelectedRow();
            if(row>=0) { 
            	TableModel model = jtEmp.getModel();
	              int id = (int) model.getValueAt(row, 0);
	              String bname = (String) model.getValueAt(row, 1);
	              String pname = (String) model.getValueAt(row, 2);
	              String pdate = (String) model.getValueAt(row, 3);
	              int price = (int) model.getValueAt(row, 4);
	              int stock = (int) model.getValueAt(row, 5);
	              new UpdateBook(id, bname, pname, pdate, stock, price);
	              f.dispose();
	              

                }else {
                    JOptionPane.showMessageDialog(sp, "Select Row for Update");
                }
            
        });
		
			    
		
		
//Delete		
		btnDelete.addActionListener(e->{
			int row =jtEmp.getSelectedRow();
	    	
	        if(row>=0) {
	        	
	    	   TableModel model = jtEmp.getModel();
	    	      int book_id = (int) model.getValueAt(row, 0);
	    	      String dquery = "delete from books where id="+book_id;
	    	  
	    
		      try {
			   int result = db.connection().executeUpdate(dquery);
			        if(result>0) {
           	             JOptionPane.showMessageDialog(sp, "Book data Deleted");
           	             new ViewBookDetails(null, false);
           	             f.dispose();
                    }
   				
		      } catch (SQLException e1) {			
			  e1.printStackTrace();
		    }
	             
	        }else {
	    	JOptionPane.showMessageDialog(sp, "Select Row");
	    }
	    	      
	    		    
		});
	
		
		
		
//Search		
		
		btnSearch.addActionListener(e-> {
            String search_by = jsSearchBy.getSelectedItem().toString();
            int index = 1;
            switch(search_by) {
            case "Book Name":
                index = 1;
                break;
            case "Publisher Name":
                index = 2;
                break;
            case "Publish Date":
                index = 3;
                break;
            }
            String search_value = tfsearchVal.getText();
            
            if (search_value.length()==0) {
                JOptionPane.showMessageDialog(sp, "Please enter the search value");
            } else {
            	String book_query = "Select * from books";
                ArrayList<Book> book_arr = new ArrayList<Book>();
                try {
                    ResultSet rs = db.connection().executeQuery(book_query);
                    while(rs.next()) {
                        int book_id = rs.getInt("id");
                        String book_name = rs.getString("name");
                        String pub_name = rs.getString("publisher_name");
                        String pub_date = rs.getString("publish_date");
                        int price = rs.getInt("price");
                        int stock = rs.getInt("stock");
                        
                        Book bk = new Book(book_id, book_name, pub_name, pub_date, price, stock);
                        book_arr.add(bk);
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                
                Object book_data[][] = new Object[book_arr.size()][column.length];
                
                for (int i=0; i<book_data.length; i++) {
                	book_data[i][0] = book_arr.get(i).book_id;
                	book_data[i][1] = book_arr.get(i).book_name;
                	book_data[i][2] = book_arr.get(i).publisher_name;
                	book_data[i][3] = book_arr.get(i).publish_date;
                	book_data[i][4] = book_arr.get(i).price;
                	book_data[i][5] = book_arr.get(i).stock;
                }
                
                ArrayList<Object[]> searched = new ArrayList<Object[]>();
                
                Search ls_obj = new Search();
                ls_obj.searchString(book_data, searched, index, search_value);
                
                Object[][] searched_list = new Object[searched.size()][column.length];
                for(int i=0; i<searched.size(); i++) {
                    searched_list[i] = searched.get(i);
                }
                if (searched_list.length<=0) {
                    JOptionPane.showMessageDialog(sp, "No data found");
                } else {
            
                    new ViewBookDetails(searched_list, true);
                    f.dispose();
                    
                }
                
            }
            
        });
		
		
//All Books
		
		btnAllBooks.addActionListener(e->{
			new ViewBookDetails(null, false);
			f.dispose();
		});
		
//Logout
		
		btnLogout.addActionListener(e->{
			new Login();
			f.dispose();
		});
		
		
//Sort
		
		btnSort.addActionListener(e -> {
            String order_by = jcSortby.getSelectedItem().toString();
            int index=1;
            
            if (order_by.equals("Book Name")) {
                index = 1;
            } else if(order_by.equals("Publisher Name")) {
                index = 2;
            } else if (order_by.equals("Publish Date")) {
                index = 3;
            }
            String order = jcSort.getSelectedItem().toString();
            MergeSort ms = new MergeSort();
            int n = data.length;
            ms.sort(data, 0, n-1, index, order);
            new ViewBookDetails(data, true);
            f.dispose();
        });
		
		
//SellAction
		
		btnSellBooks.addActionListener(e -> {
            int row = jtEmp.getSelectedRow();
            if(row>=0) {          
                JLabel lquantity, ldate;
                JTextField tfquantity, tfdate;

        		panel_2.setBorder(new TitledBorder(null, "Sell Book", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        		panel_2.setBounds(32, 319, 376, 279);
        		f.getContentPane().add(panel_2);
        		panel_2.setLayout(null);
                
                lquantity = new JLabel("Quantity");
        		lquantity.setFont(new Font("Tahoma", Font.BOLD, 20));
        		lquantity.setBounds(10, 78, 99, 33);
        		panel_2.add(lquantity);
        		
        		ldate = new JLabel("Date");
        		ldate.setFont(new Font("Tahoma", Font.BOLD, 20));
        		ldate.setBounds(20, 121, 99, 33);
        		panel_2.add(ldate);
        		
        		 tfquantity = new JTextField();
        		tfquantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
        		tfquantity.setBounds(113, 82, 229, 30);
        		panel_2.add(tfquantity);
        		tfquantity.setColumns(10);
        		
        		tfdate = new JTextField();
        		tfdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
        		tfdate.setColumns(10);
        		tfdate.setBounds(113, 125, 229, 30);
        		panel_2.add(tfdate);
        		
        		JButton btnSubmit = new JButton("Submit");
        		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 16));
        		btnSubmit.setBounds(20, 175, 322, 33);
        		panel_2.add(btnSubmit);
        		
        		JButton btnCancel = new JButton("Cancel");
        		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
        		btnCancel.setBounds(20, 219, 322, 33);
        		panel_2.add(btnCancel);
                
                TableModel model = jtEmp.getModel();
                int book_id = (int) model.getValueAt(row, 0);
                int stock = (int) model.getValueAt(row, 5);
                
                btnSubmit.addActionListener(e1 -> {
                    String qty = tfquantity.getText();
                    String date = tfdate.getText();
                    
                    if(qty.length()==0 || date.length()==0) {
                        JOptionPane.showMessageDialog(sp, "All fields are required");
                    } else if(Integer.parseInt(qty)>stock) {
                        JOptionPane.showMessageDialog(sp, "Quantity not available");
        
                    } else {
                        int update_stock = stock - Integer.parseInt(qty);
                        
                        String sold_query = "insert into sold(quantity, sold_date, book_id) values("+qty+",'"+date+"',"+book_id+")";                
                        String update_query = "update books set stock="+update_stock+" where id="+book_id;
                        
                        try {
                            int res_insert = db.connection().executeUpdate(sold_query);
                            int res_upd = db.connection().executeUpdate(update_query);
                            if(res_insert>0) {
                                JOptionPane.showMessageDialog(sp, "Book Sold");
                                new ViewBookDetails(null, false);
                                f.dispose();
                            }
                        } catch (SQLException e2) {
                            // TODO Auto-generated catch block
                            e2.printStackTrace();
                        }
                        
                    }
                                    
                    
                    
                });
        
            }else {
                JOptionPane.showMessageDialog(sp, "Select a row to sell");
            }
            
            
        });
		

		
//Available Books Action
		
		btnAvailableBooks.addActionListener(e-> {
            String query = "select * from books where stock>0";
            ArrayList<Book> book_arr = new ArrayList<Book>();
            try {
                ResultSet rs = db.connection().executeQuery(query);
                while(rs.next()) {
                    int book_id = rs.getInt("id");
                    String book_name = rs.getString("name");
                    String pub_name = rs.getString("publisher_name");
                    String pub_date = rs.getString("publish_date");
                    int price = rs.getInt("price");
                    int stock = rs.getInt("stock");
                    
                    Book bk = new Book(book_id, book_name, pub_name, pub_date, price, stock);
                    book_arr.add(bk);
                }
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            
            Object available_books[][] = new Object[book_arr.size()][column.length];
            
            for (int i=0; i<available_books.length; i++) {
                available_books[i][0] = book_arr.get(i).book_id;
                available_books[i][1] = book_arr.get(i).book_name;
                available_books[i][2] = book_arr.get(i).publisher_name;
                available_books[i][3] = book_arr.get(i).publish_date;
                available_books[i][4] = book_arr.get(i).price;
                available_books[i][5] = book_arr.get(i).stock;
            }
            new ViewBookDetails(available_books, true);
            f.dispose();
        });
		
		
//Sold Books Action
		
		btnSoldBooks.addActionListener(e-> {
            new SoldBooks();
            f.dispose();
        });
		
		
		
		
		
		
		
		
		
		
		
		f.setSize(1100,700);
		f.setLayout(null);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}

}
