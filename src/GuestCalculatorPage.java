import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class GuestCalculatorPage implements ActionListener{

	//------------------- Constant numbers -------------------
	
	final int TOP_MARGIN = 70;
	final int LEFT_MARGIN_LONG = 150;
	final int LEFT_MARGIN_MEDIUM = 15;
	final int LEFT_MARGIN_SHORT = 10;
	final int RIGHT_MARGIN = 310;
	
	final int WIDTH_LONG = 200;
	final int WIDTH_MEDIUM = 150;
	final int WIDTH_SHORT = 30;
	final int HEIGHT_LONG = 35;
	final int HEIGHT_MEDIUM = 25;
	final int HEIGHT_SHORT = 20;
	
	//------------------- Numbers -------------------
	
	int calories = 0;
	int protein = 0;
	int fat = 0;
	int carbohydrates = 0;
	
	JFrame frame = new JFrame();
	
	//------------------- Upper Part -------------------
	
	JLabel welcomeLabel = new JLabel("Hello Friend");
	JLabel ageLabel = new JLabel("Write your age");
	JLabel heightLabel = new JLabel("Write your height:");
	JLabel cmLabel = new JLabel("cm");
	JLabel weightLabel = new JLabel("Write your weight:");
	JLabel kgLabel = new JLabel("kg");
	JLabel activityLabel = new JLabel("Select your daily activity level:");
	JLabel goalLabel = new JLabel("Select goal, you want to achieve:");
	JLabel genderLabel = new JLabel("Select your gender:");
	
	JTextField cmField = new JTextField("170");
	JTextField kgField = new JTextField("75");	
	JTextField ageField = new JTextField("18");
	
	String[] activity = {"Minimal physical activity","Small physical activity", "Average physical activity", "Large physical activity"};
	String[] goal = {"Lose weight", "Keep weight", "Gain weight"};
	String[] gender = {"Male","Female"};
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox activityComboBox = new JComboBox(activity);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox goalComboBox = new JComboBox(goal);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JComboBox genderComboBox = new JComboBox(gender);
	
	JButton calculateButton = new JButton("Calculate BMR");
	JButton resetButton = new JButton("Reset");
	
	//------------------- Bottom Part -------------------
	
	JLabel resultLabel = new JLabel("Your results:");
	JLabel caloriesLabel = new JLabel("Calories count to consume:");
	JLabel kcalLabel = new JLabel(calories+" kcal");
	JLabel macroLabel = new JLabel("Macronutrients count to consume:");
	JLabel proteinLabel = new JLabel("Protein: "+protein+" g");
	JLabel fatLabel = new JLabel("Fat: "+fat+" g");
	JLabel carbohydratesLabel = new JLabel("Carbohydrates: "+carbohydrates+" g");
	
	JButton returnButton = new JButton("Return");
	
	GuestCalculatorPage(){
		
		//------------------- Upper Part -------------------
		
		// Welcome Text field part of the code
		welcomeLabel.setBounds(LEFT_MARGIN_LONG,0,WIDTH_LONG,HEIGHT_LONG);
		welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		welcomeLabel.setFont(new Font(null,Font.ROMAN_BASELINE,HEIGHT_MEDIUM));
		
		// Age field part of the code
		ageLabel.setBounds(LEFT_MARGIN_SHORT,TOP_MARGIN,WIDTH_MEDIUM,HEIGHT_SHORT);
		ageLabel.setHorizontalAlignment(JLabel.LEFT);
		ageLabel.setFont(new Font("Calibri",Font.BOLD,16));
		
		ageField.setBounds(LEFT_MARGIN_LONG,TOP_MARGIN,WIDTH_SHORT,HEIGHT_MEDIUM);
		
		// Height field part of the code
		heightLabel.setBounds(LEFT_MARGIN_SHORT,TOP_MARGIN+30,WIDTH_MEDIUM,HEIGHT_SHORT);
		heightLabel.setHorizontalAlignment(JLabel.LEFT);
		heightLabel.setFont(new Font("Calibri",Font.BOLD,16));
		
		cmField.setBounds(LEFT_MARGIN_LONG,TOP_MARGIN+25,WIDTH_SHORT,HEIGHT_SHORT);
		
		cmLabel.setBounds(LEFT_MARGIN_LONG+30,TOP_MARGIN+30,WIDTH_SHORT,HEIGHT_SHORT);
		cmLabel.setHorizontalAlignment(JLabel.LEFT);
		cmLabel.setFont(new Font("Calibri",Font.BOLD,14));
		
		// Weight field part of the code
		weightLabel.setBounds(LEFT_MARGIN_SHORT,TOP_MARGIN+60,WIDTH_MEDIUM,HEIGHT_SHORT);
		weightLabel.setHorizontalAlignment(JLabel.LEFT);
		weightLabel.setFont(new Font("Calibri",Font.BOLD,16));
		
		kgField.setBounds(LEFT_MARGIN_LONG,TOP_MARGIN+55,30,20);
		
		kgLabel.setBounds(LEFT_MARGIN_LONG+30,TOP_MARGIN+60,WIDTH_SHORT,HEIGHT_SHORT);
		kgLabel.setHorizontalAlignment(JLabel.LEFT);
		kgLabel.setFont(new Font("Calibri",Font.BOLD,14));
		
		// Activity field part of the code
		activityLabel.setBounds(LEFT_MARGIN_SHORT,TOP_MARGIN+90,WIDTH_LONG+50,HEIGHT_SHORT);
		activityLabel.setHorizontalAlignment(JLabel.LEFT);
		activityLabel.setFont(new Font("Calibri",Font.BOLD,16));
		
		activityComboBox.setBounds(LEFT_MARGIN_SHORT,TOP_MARGIN+110,WIDTH_LONG,HEIGHT_MEDIUM);
		
		// Goal field part of the code
		goalLabel.setBounds(LEFT_MARGIN_SHORT,TOP_MARGIN+140,WIDTH_LONG+50,HEIGHT_SHORT);
		goalLabel.setHorizontalAlignment(JLabel.LEFT);
		goalLabel.setFont(new Font("Calibri",Font.BOLD,16));
		
		goalComboBox.setBounds(LEFT_MARGIN_SHORT,TOP_MARGIN+160,WIDTH_LONG,HEIGHT_MEDIUM);
		
		//Gender field part of the code
		genderLabel.setBounds(LEFT_MARGIN_SHORT,TOP_MARGIN+190,WIDTH_LONG,HEIGHT_SHORT);
		genderLabel.setHorizontalAlignment(JLabel.LEFT);
		genderLabel.setFont(new Font("Calibri",Font.BOLD,16));
		
		genderComboBox.setBounds(LEFT_MARGIN_SHORT,TOP_MARGIN+210,WIDTH_LONG,HEIGHT_MEDIUM);
		
		// Buttons part	
		calculateButton.setBounds(RIGHT_MARGIN,TOP_MARGIN+50,WIDTH_MEDIUM,HEIGHT_MEDIUM);
		calculateButton.addActionListener(this);
		resetButton.setBounds(RIGHT_MARGIN,TOP_MARGIN+75,WIDTH_MEDIUM,HEIGHT_MEDIUM);
		resetButton.addActionListener(this);
		
		//------------------- Bottom Part -------------------
		
		// Result Text field part of the code
		resultLabel.setBounds(LEFT_MARGIN_LONG,TOP_MARGIN+250,WIDTH_LONG,HEIGHT_LONG);
		resultLabel.setHorizontalAlignment(JLabel.CENTER);
		resultLabel.setFont(new Font(null,Font.ROMAN_BASELINE,25));
		
		// Calories count field part of the code
		caloriesLabel.setBounds(LEFT_MARGIN_SHORT,TOP_MARGIN+290,WIDTH_LONG+50,HEIGHT_MEDIUM);
		caloriesLabel.setHorizontalAlignment(JLabel.LEFT);
		caloriesLabel.setFont(new Font("Calibri",Font.BOLD,18));
		
		kcalLabel.setBounds(LEFT_MARGIN_MEDIUM,TOP_MARGIN+310,WIDTH_LONG,HEIGHT_LONG);
		kcalLabel.setHorizontalAlignment(JLabel.LEFT);
		kcalLabel.setFont(new Font("Calibri",Font.BOLD,22));
		
		// Macronutrients count field part of the code
		macroLabel.setBounds(LEFT_MARGIN_SHORT,TOP_MARGIN+340,WIDTH_LONG+80,HEIGHT_MEDIUM);
		macroLabel.setHorizontalAlignment(JLabel.LEFT);
		macroLabel.setFont(new Font("Calibri",Font.BOLD,18));
		
		proteinLabel.setBounds(LEFT_MARGIN_MEDIUM,TOP_MARGIN+370,WIDTH_LONG,20);
		proteinLabel.setHorizontalAlignment(JLabel.LEFT);
		proteinLabel.setFont(new Font("Calibri",Font.BOLD,16));
		
		fatLabel.setBounds(LEFT_MARGIN_MEDIUM,TOP_MARGIN+390,WIDTH_LONG,20);
		fatLabel.setHorizontalAlignment(JLabel.LEFT);
		fatLabel.setFont(new Font("Calibri",Font.BOLD,16));
		
		carbohydratesLabel.setBounds(LEFT_MARGIN_MEDIUM,TOP_MARGIN+410,WIDTH_LONG,20);
		carbohydratesLabel.setHorizontalAlignment(JLabel.LEFT);
		carbohydratesLabel.setFont(new Font("Calibri",Font.BOLD,16));
		
		//Button part
		returnButton.setBounds(RIGHT_MARGIN,TOP_MARGIN+420,WIDTH_MEDIUM,HEIGHT_MEDIUM);
		returnButton.addActionListener(this);
		
		//------------------- Upper Part -------------------
		
		frame.add(welcomeLabel);
		
		frame.add(heightLabel);
		frame.add(cmLabel);
		frame.add(cmField);
		
		frame.add(weightLabel);
		frame.add(kgLabel);
		frame.add(kgField);
		
		frame.add(activityLabel);
		frame.add(activityComboBox);
		
		frame.add(goalLabel);
		frame.add(goalComboBox);
		
		frame.add(genderLabel);
		frame.add(genderComboBox);
		
		frame.add(calculateButton);
		frame.add(resetButton);
		
		//------------------- Bottom Part -------------------
		
		frame.add(resultLabel);
		
		frame.add(caloriesLabel);
		frame.add(kcalLabel);
		
		frame.add(macroLabel);
		frame.add(proteinLabel);
		frame.add(fatLabel);
		frame.add(carbohydratesLabel);
		
		frame.add(returnButton);
		
		//------------------- Frame part -------------------
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,600);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==calculateButton) {
					
			Calculations result = new Calculations(
					cmField.getText(),
					kgField.getText(),
					ageField.getText(),
					genderComboBox.getSelectedIndex(),
					activityComboBox.getSelectedIndex(),
					goalComboBox.getSelectedIndex());
			
			calories = result.FinalCaloriesResult();
			protein = result.FinalProteinResult();
			fat = result.FinalFatResult();
			carbohydrates = result.FinalCarbohydratesResult();
			
			kcalLabel.setText(calories+" kcal");
			proteinLabel.setText("Protein: "+protein+" g");
			fatLabel.setText("Fat: "+fat+" g");
			carbohydratesLabel.setText("Carbohydrates: "+carbohydrates+" g");
		}
		
		if(e.getSource()==resetButton){
			
			ageField.setText("18");
			cmField.setText("170");
			kgField.setText("75");
			activityComboBox.setSelectedIndex(0);
			goalComboBox.setSelectedIndex(0);
			genderComboBox.setSelectedIndex(0);
		}
		
		if(e.getSource()==returnButton) {
			
			frame.dispose();		
			UserLoginData userData = new UserLoginData();			
			new StartPage(userData.getLoginInfo());
		}
		
	}
}
