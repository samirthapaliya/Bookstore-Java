import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

public class LoginFrame {
	public static void main(String[] args) {
		Login log = new Login();        //Constructor 
				
	}
}

class Login{
	
	Login(){	
		JFrame f = new JFrame();    
		JLabel luser , lpsw;
		JTextField tfuser;
		JPasswordField pfpsw;
		JButton btnLogin, btnRegister;
		
		f.getContentPane().setBackground(Color.LIGHT_GRAY);
		f.setBounds(100, 100, 725, 689);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel.setBounds(208, 51, 279, 86);
		f.getContentPane().add(lblNewLabel);
		
		luser = new JLabel("Username");
		luser.setFont(new Font("Tahoma", Font.PLAIN, 25));
		luser.setBounds(105, 188, 150, 59);
		f.getContentPane().add(luser);
		
		lpsw = new JLabel("Password");
		lpsw.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lpsw.setBounds(105, 304, 150, 59);
		f.getContentPane().add(lpsw);
		
		tfuser = new JTextField();
		tfuser.setFont(new Font("Tahoma", Font.PLAIN, 26));
		tfuser.setBackground(new Color(230, 230, 250));
		tfuser.setBounds(328, 188, 300, 43);
		f.getContentPane().add(tfuser);
		tfuser.setColumns(10);
		
		 btnLogin = new JButton("Login");

		 btnLogin.setBackground(new Color(34, 139, 34));
		 btnLogin.setForeground(new Color(255, 255, 255));
		 btnLogin.setFont(new Font("Tw Cen MT", Font.PLAIN, 40));
		 btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		 
		 btnLogin.setBounds(104, 425, 524, 44);
		f.getContentPane().add( btnLogin);
		
		 btnRegister = new JButton("Register");
		 btnRegister.setFont(new Font("Tahoma", Font.BOLD, 25));
		 btnRegister.setForeground(new Color(255, 255, 255));
		 btnRegister.setBackground(new Color(255, 0, 0));
		 btnRegister.setBounds(104, 494, 524, 44);
		 f.getContentPane().add( btnRegister);
		
		 pfpsw = new JPasswordField();
		 pfpsw.setBackground(new Color(230, 230, 250));
		 
		 pfpsw.setFont(new Font("Tahoma", Font.BOLD, 26));
		 pfpsw.setBounds(328, 304, 300, 43);
		 f.getContentPane().add(pfpsw);
		
		//Register Action

		btnRegister.addActionListener(e->{
			new Register();
			f.dispose();
		});
		
				
		btnLogin.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e) {
				String username = tfuser.getText();
				String psw = pfpsw.getText();
				
				
				boolean res= userLogin(username,psw);
				
				if(res) {
					new ViewBookDetails(null, false);
            		f.dispose();
            		
				}else {
					JOptionPane.showMessageDialog(f, "Username/Password invalid");
				}
					
				
			}			
		});
				
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(700,700);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				
	}
	
	public boolean userLogin(String user, String psw) {
		DbConnect db = new DbConnect();
        String query = "Select * from user";
        ArrayList<User> user_arr = new ArrayList<User>();
        try {
            ResultSet rs = db.connection().executeQuery(query);
            while(rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                
                User us = new User(username, password);
                user_arr.add(us);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Object user_data[][] = new Object[user_arr.size()][2];
        
        for (int i=0; i<user_data.length; i++) {
        	user_data[i][0] = user_arr.get(i).username;
        	user_data[i][1] = user_arr.get(i).password;
        }

    for(Object row[]: user_data) {
          if (user.equals(row[0]) && psw.equals(row[1])) {
            return true;
          }
      }
                        
        return false;
		
	}
	
	
	
	
}
