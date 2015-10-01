package bmi;
/**
 * A GUI to compute a person's body mass index (BMI).
 */

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.Format;

import javax.swing.*;

public class BMI {
	
	//--------------------------------------------------------//
	//----------creating fields for components----------------//
	//--------------------------------------------------------//
	
	private JFrame 			frame; // the frame
	private JTextField 		heightfield; //the height input
	private JTextField 		weightfield;// the weight input
	private JLabel 			bmiLabel;//label for the BMI result field
	private JButton 		computeButton;
	private DecimalFormat 	format = new DecimalFormat();
	

	public BMI() {
		
		format.setMaximumFractionDigits		(3);
		// set up components
		heightfield = new JTextField		(20);
		heightfield.setPreferredSize		(new Dimension(70,50));
		heightfield.setBorder				(javax.swing.BorderFactory.createEmptyBorder());
		heightfield.setBackground			(Color.white);
		
		weightfield = new JTextField		(20);
		weightfield.setBorder				(javax.swing.BorderFactory.createEmptyBorder());
		weightfield.setBackground			(Color.WHITE);
		
		bmiLabel = new JLabel				("                    Type your height and weight");
		bmiLabel.setFont					(new Font("Cambria", Font.BOLD,20));
		
		computeButton = new JButton			("Compute BMI");

		// A grid layout for our components
		JPanel north = new JPanel			(new GridLayout(2, 2,10,10));
		
		JLabel height = new JLabel			("Height (m): ");
		height.setFont						(new Font("Cambria", Font.BOLD,20));
		
		north.add							(height);
		north.add							(heightfield);
		
		JLabel weight = new JLabel			("Weight (Kg): ");
		weight.setFont						(new Font("Cambria", Font.BOLD,20));
		
		north.add							(weight);
		north.add							(weightfield);
		
		
		//-----------------------------------------------------------//
		//-----Adding the action listener to the compute button------//
		//-----------------------------------------------------------//
		
		computeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				// read height/weight info from text fields
				
				String heightText 	= heightfield.getText();
				String weightText 	= weightfield.getText();
				double height,weight;
				try {
					height 			= Double.parseDouble(heightText);
					weight 			= Double.parseDouble(weightText);
					
					//compute BMI and display it on screen
					double bmi 		= weight / (height * height) * 703;
					
					bmiLabel.setText("BMI:       " + format.format(bmi)+" Kg/m"+"\u00b2");
				} 
				catch (Exception e2) {
					String message;
					if 		(weightText.isEmpty()){		message ="Weight Field Cannot Be Empty";}
					else if	(heightText.isEmpty()){		message ="Height Field Cannot Be Empty";}
					if		(weightText.isEmpty()
									&&
							 heightText.isEmpty()){		message ="Height and Weight Field Cannot Be Empty";}
					else						  {		message ="Please Enter a Valid Value";}
					JOptionPane.showMessageDialog(null, message);
				}
				
			}
		});
		
		//-----------------------------------------------------------//
		//----------creating Frame and Setting preferences-----------//
		//-----------------------------------------------------------//
		
		
		frame = new JFrame				("BMI Calculator");
		frame.setBackground				(Color.lightGray);
		frame.setDefaultCloseOperation	(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize			(new Dimension(500,400));
		frame.setLayout					(new BorderLayout());
		frame.add						(north, BorderLayout.NORTH);
		frame.add						(bmiLabel, BorderLayout.CENTER);
		frame.add						(computeButton, BorderLayout.SOUTH);
		frame.setLocationRelativeTo		(null);;
		frame.pack						();
		frame.setVisible				(true);
	}
	
}