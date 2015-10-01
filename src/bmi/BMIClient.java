package bmi;

import javax.swing.UIManager;

public class BMIClient {

	// BMI is its own runnable client program
	public static void main(String[] args) {
		
	     // use look and feel for my system (Win32)
	      try {
	         UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	      } catch (Exception e) {}
	      
		BMI gui = new BMI();
		gui.toString();
	}

}
