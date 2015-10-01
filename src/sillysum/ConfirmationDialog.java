package sillysum;
import javax.swing.JOptionPane;


public class ConfirmationDialog {

	public static void main(String[] args) {
		int sum 	= 0;
		int count	= 0;
		int choice 	= JOptionPane.YES_OPTION, data;

		while (choice == JOptionPane.YES_OPTION) {	
			
			String command_string 	= JOptionPane.showInputDialog("Enter a number");
			data 					= Integer.parseInt(command_string);
			count++;
			if(count == 5){
				choice 				= JOptionPane.showConfirmDialog(null, "Proceed?");
				count				= 0;
			}
			sum+=data;
		}
		JOptionPane.showMessageDialog(null, "The Resulting Sum is "+ sum);

	}

}
