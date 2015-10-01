package largestnumber;

import java.awt.Dimension;

import javax.swing.UIManager;

public class LargestNumberClient {

	public static void main(String[] args)
	   {
	      // use look and feel for my system (Win32)
	      try {
	    	  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	      } catch (Exception e) {}

	      LargestNumber frame = new LargestNumber();
	      frame.setTitle("Largest Number Finder");
	      frame.setLocationRelativeTo(null);
	      frame.setPreferredSize(new Dimension(500,500));
	      frame.pack();
	      frame.setVisible(true);
	   }
}
