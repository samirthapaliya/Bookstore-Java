
    import javax.swing.*;
	import java.sql.*;


	public class UpdateBook{
		
		UpdateBook(int id, String bname, String pname, String pdate, int stock, int price){
			JFrame f = new JFrame();
			JLabel lbname, lpname, lpdate, lprice, lstock;
            JTextField tfbname, tfpname, tfpdate, tfprice, tfstock;
                                    
            lbname = new JLabel("Book Name");
            f.add(lbname);
            lbname.setBounds(250, 140, 300, 50);
            
            tfbname = new JTextField();
            f.add(tfbname);
            tfbname.setBounds(380, 150, 300, 30);
            
            lpname = new JLabel("Publisher Name");
            f.add(lpname);
            lpname.setBounds(250, 180, 300, 50);    
            
            tfpname = new JTextField();
            f.add(tfpname);
            tfpname.setBounds(380, 190, 300, 30);
            
            lpdate = new JLabel("Publish Date");
            f.add(lpdate);
            lpdate.setBounds(250, 230, 300, 50);    
            
            tfpdate = new JTextField();
            f.add(tfpdate);
            tfpdate.setBounds(380, 240, 300, 30);
            
            lstock = new JLabel("Stock");
            f.add(lstock);
            lstock.setBounds(250, 270, 300, 50);    
            
            tfstock = new JTextField();
            f.add(tfstock);
            tfstock.setBounds(380, 280, 300, 30);
            
            lprice = new JLabel("Price");
            f.add(lprice);
            lprice.setBounds(250, 310, 300, 50);    
            
            tfprice = new JTextField();
            f.add(tfprice);
            tfprice.setBounds(380, 320, 300, 30);

            JButton btnChange = new JButton("Make Change");
            f.add(btnChange);
            btnChange.setBounds(450, 360, 150, 50);

            JButton btnCancel = new JButton("Cancel");
            f.add(btnCancel);
            btnCancel.setBounds(450, 420, 150, 50);
            
            tfbname.setText(bname+"");
            tfpname.setText(pname+"" );
            tfpdate.setText(pdate+"" );
            tfprice.setText(price+"");
            tfstock.setText(stock+"");
            
            DbConnect db = new DbConnect();
            
         // update action
            btnChange.addActionListener(e3->{
                String book_name = tfbname.getText();
                String pub_name = tfpname.getText();
                String pub_date = tfpdate.getText();
                String book_price = tfprice.getText();
                String book_stock = tfstock.getText();
                
                String uquery = "update books set name='"+book_name+"', publisher_name='"+pub_name+"', publish_date='"+ pub_date + "', price="+book_price+", stock=" + book_stock +"  where id="+id;
                
                try {
                    int result = db.connection().executeUpdate(uquery);
                    if(result > 0) {
                        JOptionPane.showMessageDialog(btnChange, "Book Updated");
                        new ViewBookDetails(null, false);
                        f.dispose();
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            });
            
            //Exit Action
            btnCancel.addActionListener(e2->{
                new ViewBookDetails(null, false);
                f.dispose();
            });
						
			
			
			
			
			
			
			
			f.setLayout(null);
			f.setVisible(true);
			f.setSize(1000,1000);
			f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
			
		}
		

}




