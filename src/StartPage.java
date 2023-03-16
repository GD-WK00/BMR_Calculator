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

public class StartPage implements ActionListener{

	JFrame frame = new JFrame();
	
	JButton loginButton = new JButton("Login");
	JButton registerButton = new JButton("Register");
	JButton continueWithoutLoginIn = new JButton("Continue without login in");
	
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	
	JLabel userIDLabel = new JLabel("userID: ");
	JLabel userPasswordLabel = new JLabel("password: ");
	JLabel messageLabel = new JLabel();
	
	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	StartPage(HashMap<String,String> loginInfoOriginal){
		
		logininfo = loginInfoOriginal;
		
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		
		messageLabel.setBounds(125,300,250,35);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		
		userIDField.setBounds(125,100,200,25);
		userPasswordField.setBounds(125,150,200,25);
		
		loginButton.setBounds(125,200,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		registerButton.setBounds(225,200,100,25);
		registerButton.setFocusable(false);
		registerButton.addActionListener(this);
		
		continueWithoutLoginIn.setBounds(125,250,200,25);
		continueWithoutLoginIn.setFocusable(false);
		continueWithoutLoginIn.addActionListener(this);
		
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(userPasswordField);
		frame.add(loginButton);
		frame.add(registerButton);
		frame.add(continueWithoutLoginIn);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,420);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==registerButton) {
			
			frame.dispose();
			
			new RegisterPage();
		}
		
		if(e.getSource()==loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					
					messageLabel.setForeground(Color.black);
					messageLabel.setText("");
					
					frame.dispose();
					
					new UserCalculatorPage(userID);
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password");
				}
				
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found");
			}
		}
		
		if(e.getSource()==continueWithoutLoginIn) {
			
			messageLabel.setForeground(Color.black);
			messageLabel.setText("");
			
			frame.dispose();			
			new GuestCalculatorPage();
		}
	}
	
}
