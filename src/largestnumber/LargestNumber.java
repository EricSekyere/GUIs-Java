package largestnumber;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

/** Find the largest number in a series -- GUI version.<p>
 *
 * This is a follow-on program to <code>DemoLargestConsole</code>.  
 * It is an example of a <i>GUI application</i>
 * - a program that interacts with the user using a
 *   <i>graphical user interface</i> or GUI.  With a GUI
 * application, a mouse and keyboard are used to interact
 * with a graphical objects presented
 * in a window on the system's display.
 * <p>
 */
public class LargestNumber extends JFrame implements ActionListener
{
 
	private static final long serialVersionUID = 1L;

	private JTextArea inputArea;
	private JTextArea result;

   public LargestNumber(){
	   
      // ----------------------------------
      // construct and configure components
      // ----------------------------------

      inputArea = new JTextArea(5, 30);
      inputArea.setAlignmentX(Component.LEFT_ALIGNMENT);
      inputArea.setBackground(getBackground());
      inputArea.setBorder(new TitledBorder(new EtchedBorder(),
         "Enter numbers..."));

      result = new JTextArea("(result is here)", 1, 30);
      result.setEditable(false);
      result.setAlignmentX(Component.LEFT_ALIGNMENT);
      result.setBackground(getBackground());
      result.setForeground(new Color(204, 0, 0));
      result.setBorder(new TitledBorder(new EtchedBorder(),
         "Largest number is"));

      JButton findButton = new JButton("Find largest");
     
      // -------------
      // add listeners
      // -------------

      findButton.addActionListener(this);
      addWindowListener(new WindowCloser());

      // ------------------
      // arrange components
      // ------------------

      JPanel p1 = new JPanel();
      p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
      p1.add(inputArea);
      p1.add(Box.createRigidArea(new Dimension(0, 10)));
      p1.add(result);
      p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

      JPanel p2 = new JPanel();  // flow layout
      p2.add(findButton);
         
      JPanel contentPane = new JPanel(new BorderLayout());
      contentPane.add(p1, "Center");
      contentPane.add(p2, "South");
      contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

      setContentPane(contentPane);
   }

   // -------------------------------
   // implement ActionListener method
   // -------------------------------

   public void actionPerformed(ActionEvent ae)
   {
      String input 		= inputArea.getText();
      double largest 	= findLargest(input);
      result.setText	(String.valueOf(largest));
   }

   // -------------
   // other methods
   // -------------

   public static double findLargest(String sArg)
   {
      StringTokenizer st 	= new StringTokenizer(sArg, "[ \n\t\r.,;:!?(){}]",false);
      double result 		= Double.MIN_VALUE;
      while (st.hasMoreTokens())
      {
    	  try{
    	         double value = Double.parseDouble(st.nextToken());
    	         if (value > result)
    	            result = value;
    	  }
    	  catch (Exception ex){
    		  continue;
    	  }
      }
      return result;
   }

   // -----------
   // inner class
   // -----------

   // Note: WindowAdapter implements windowClosing

   private class WindowCloser extends WindowAdapter
   {
      public void windowClosing(WindowEvent event)
      {
         System.exit(0);
      }
   }
}