import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterPage implements ActionListener{

		JFrame frame = new JFrame();
		
		JButton returnButton = new JButton("Return");
		JButton registerButton = new JButton("Register");
		
		JTextField userIDField = new JTextField();
		JPasswordField userPasswordField = new JPasswordField();
		
		JLabel userIDLabel = new JLabel("Create userID: ");
		JLabel userPasswordLabel = new JLabel("Create password: ");
		JLabel messageLabel = new JLabel();
		
		RegisterPage() {
			
			userIDLabel.setBounds(20,50,175,25);
			userPasswordLabel.setBounds(20,100,175,25);
			
			messageLabel.setBounds(20,200,300,25);
			messageLabel.setFont(new Font(null,Font.ITALIC,12));
			
			userIDField.setBounds(20,75,200,25);
			userPasswordField.setBounds(20,125,200,25);
			
			returnButton.setBounds(125,250,100,25);
			returnButton.setFocusable(false);
			returnButton.addActionListener(this);
			
			registerButton.setBounds(225,250,100,25);
			registerButton.setFocusable(false);
			registerButton.addActionListener(this);
				
			frame.add(userIDLabel);
			frame.add(userPasswordLabel);
			frame.add(messageLabel);
			frame.add(userIDField);
			frame.add(userPasswordField);
			frame.add(returnButton);
			frame.add(registerButton);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(350,350);
			frame.setResizable(false);
			frame.setLayout(null);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==returnButton) {
				
				frame.dispose();
				
				UserLoginData userData = new UserLoginData();
				
				new StartPage(userData.getLoginInfo());		
			}
			if(e.getSource()==registerButton) {
				
				String username = userIDField.getText();
				String userPassword = String.valueOf(userPasswordField.getPassword());
				
				if(username.length()<5 || username.length()>12) {
					
					messageLabel.setForeground(Color.red);
					messageLabel.setText("UserID length should be 5-12 characters long");
				}
				else {
					
					if(userPassword.length()<5 || userPassword.length()>18) {
						messageLabel.setForeground(Color.red);
						messageLabel.setText("Password length should be 5-18 characters long");
					}
					else {
						
						frame.dispose();
						
						UserLoginData userData = new UserLoginData(username,userPassword);
						
						new StartPage(userData.getLoginInfo());
					}
				}			
			}
			
		}
	
}
