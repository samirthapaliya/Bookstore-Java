
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.util.ArrayList;


public class Registration {
	public static void main(String[] args) {
		Register log = new Register(); 
	}
}

class Register{
	
	Register(){	
		JFrame f = new JFrame();    
		JLabel lusername, lpassword, lconfirmpassword;
		JTextField tfusername;
		JPasswordField tfpassword;
		JPasswordField tfconfirmpassword;
		
		JButton btnSubmit, btnExit;
		
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		f.getContentPane().setForeground(new Color(230, 230, 250));
		f.setBounds(100, 100, 747, 693);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel.setBounds(260, 50, 175, 60);
		f.getContentPane().add(lblNewLabel);
		
		 lusername = new JLabel("Username");
		 lusername.setFont(new Font("Tahoma", Font.PLAIN, 25));
		 lusername.setBounds(60, 148, 151, 60);
		f.getContentPane().add( lusername);
		
		 tfusername = new JTextField();
		 tfusername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		 tfusername.setBackground(new Color(255, 255, 240));
		 tfusername.setBounds(294, 148, 305, 43);
		f.getContentPane().add( tfusername);
		 tfusername.setColumns(10);
		
		 lpassword = new JLabel("Password");
		 lpassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		 lpassword.setBounds(60, 259, 151, 60);
		f.getContentPane().add( lpassword);
		
		lconfirmpassword = new JLabel("Confirm Password");
		lconfirmpassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lconfirmpassword.setBounds(60, 365, 200, 60);
		f.getContentPane().add(lconfirmpassword);
		


		
		tfpassword = new JPasswordField();
		tfpassword.setBackground(new Color(255, 255, 224));
		tfpassword.setBounds(294, 377, 305, 50);
		f.getContentPane().add(tfpassword);
		
		tfconfirmpassword = new JPasswordField();
		tfconfirmpassword.setBackground(new Color(255, 255, 224));
		tfconfirmpassword.setBounds(294, 271, 305, 50);
		f.getContentPane().add(tfconfirmpassword);
		
		
		
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(106, 90, 205));
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Tw Cen MT", Font.PLAIN, 40));
		btnSubmit.setBounds(60, 467, 539, 43);
		f.getContentPane().add(btnSubmit);
		
		btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 0, 0));
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		btnExit.setBounds(60, 532, 539, 43);
		f.getContentPane().add(btnExit);	
		
		
		
//Exit Action
		
		btnExit.addActionListener(e->{
			new Login();
			f.dispose();
		});
		
		
		btnSubmit.addActionListener(e->{
			
			
			DbConnect db = new DbConnect();
            
	        String username = tfusername.getText();
	        String password1 = tfpassword.getText();
	        String password2 = tfconfirmpassword.getText();
	        
	        String query = "Select * from user";
	        ArrayList<User> user_arr = new ArrayList<User>();
	        try {
	            ResultSet rs = db.connection().executeQuery(query);
	            while(rs.next()) {
	                String uname = rs.getString("username");
	                String password = rs.getString("password");
	                
	                User us = new User(uname, password);
	                user_arr.add(us);
	            }
	        } catch (SQLException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
	        
	        Object data[][] = new Object[user_arr.size()][2];
	        
	        for (int i=0; i<data.length; i++) {
	            data[i][0] = user_arr.get(i).username;
	            data[i][1] = user_arr.get(i).password;
	        }
	        
	        ArrayList<String> username_list = new ArrayList<String>();
	        for (Object[] row: data) {
	        
                username_list.add((String)row[0]);
            }
	        
            boolean username_exists = false;
            for(int i=0; i<username_list.size(); i++) {
	            if(username.equals(username_list.get(i))) {
	            	username_exists = true;
	                break;
	            }
	        }
	        
	        if (username.length() == 0 || password1.length() == 0) {
	        	JOptionPane.showMessageDialog(btnSubmit, "All fields are required");
	        } else if(username.length()<=2) {
	            JOptionPane.showMessageDialog(btnSubmit, "Username should be atleast contain 3 letters");
	        } else if(username_exists) {
	        	JOptionPane.showMessageDialog(btnSubmit, "Username already exists");
	        } else if (password1.length()<=7) {
	            JOptionPane.showMessageDialog(btnSubmit, "Password must be 8 characters long");
	        } else if (!password1.equals(password2)) {
	            JOptionPane.showMessageDialog(btnSubmit, "Password does not match");
	        } else {
	        	try {
                    String insert_query = "insert into user(username, password) values('" + username + "','" + password1 + "')";                        
                    
                    int result;
                    result = db.connection().executeUpdate(insert_query);
                    if (result > 0) {
                        JOptionPane.showMessageDialog(btnSubmit, "Data successfully saved");
                        new Login();
                        f.dispose();
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
      }
			
			
						
		});
					
		
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(700,700);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);		
		
	}
}

