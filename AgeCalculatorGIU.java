
/**
*Author: David P
 *Purpose: This Age Calculator calculates the user's age from the user's date of birth with
  the current year.
*/

//Event listen for the button
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// API classes
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//The date class API
import java.util.Date;  


public class AgeCalculatorGui {
//	JFrame name
   static JFrame frame = new JFrame("David GUI");

   public static void main(String args[]) {
       JPanel ageCalculatorPanel = new JPanel();
       ageCalculatorPanel.setLayout(null);
       
       final JLabel titleLabel = new JLabel("Age Calculator");
       titleLabel.setBounds(150, 15, 200, 30);
       
       
       //Change the front size of the title
       titleLabel.setFont (titleLabel.getFont ().deriveFont (25.0f));
       
       //Birth Year Message     
       JLabel dOBLabel = new JLabel("Enter the birth year: ");
       dOBLabel.setBounds(200, 100, 250, 30);
       
       final JTextField yearOfBirth = new JTextField(10);
       yearOfBirth.setBounds(400, 100, 100, 30);
       
       //Setting up the button
       JButton btn = new JButton();
       btn.setText("Calculate");
       btn.setBounds(200, 150, 250, 20);
       
       //RGB for the button
       Color btnColor = new Color(204, 235, 255);
       btn.setBackground(btnColor);
     
       //The output for the age
       JLabel sum = new JLabel("You are: ");
       sum.setBounds(200, 200, 300, 30);
       
       //Temporary Disable the result field.
       final JTextField calculateAge = new JTextField(10);
       calculateAge.setBounds(300, 200, 100, 30);
       calculateAge.setEditable(!true);
       
       //Test
       Date d=new Date();  
       /*See the bar on top of getYear method, it because it is deprecated, hopefully it will still work.
       That deprecated method adds 1900 to the year because it is just old
       */
       int year = d.getYear();
       int deprecatedMethod = 1900;// That 1900 is old and because java is like C. 
       int currentYear = year + deprecatedMethod ;
       //End Test
       

       //Even listener when the button is clicked
       btn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent aE) {
        	   
        	   //Default integers if the user doesn't type anything | Variables
               int cYear = 0;
               int yOfBirth = 0;
        
        	 try {
              
               String y = yearOfBirth.getText();
              if (y.trim().length() != 0) {
            	   yOfBirth = Integer.parseInt(y);
              }//End if
              
              //Control flow if the user Enters invalid data
              //If the field is blank
             if(cYear == yOfBirth) {
            	System.out.println();
            	 JOptionPane.showMessageDialog(calculateAge, "Field cannot be blank, Please Enter a valid year!" + "\n" + " e.g 2000","ERROR",JOptionPane.ERROR_MESSAGE);
            	 System.exit(0); 
             }
             //If the user enters a negative number
             else if(yOfBirth <= 0) {
             	System.out.println();
           	 JOptionPane.showMessageDialog(calculateAge, "Please Enter a valid year","ERROR",JOptionPane.ERROR_MESSAGE);
           	 
             }
             
             //If the year of birth is greater than the current year
             else if(yOfBirth > currentYear ) {
             	System.out.println();
           	 JOptionPane.showMessageDialog(calculateAge, "Man! You are not even born yet!","ERROR",JOptionPane.ERROR_MESSAGE);
           	 System.exit(0);// The program will close because this looks suspicious :-)
            }//End if
        	 
           //The code to run if everything is okay
            calculateAge.setText(( currentYear - yOfBirth) + " years old");
        	 }
             catch(NumberFormatException e){
            	 JOptionPane.showMessageDialog(calculateAge, "Sorry! You can only enter numbers","ERROR",JOptionPane.ERROR_MESSAGE);
             }
           }
         });
       
       //Panels that display contents in the frame
       ageCalculatorPanel.add(dOBLabel);
       ageCalculatorPanel.add(titleLabel);
       ageCalculatorPanel.add(yearOfBirth);
       ageCalculatorPanel.add(btn);
       ageCalculatorPanel.add(calculateAge);
       ageCalculatorPanel.add(sum);
       frame.add(ageCalculatorPanel);
       
       //Width and Height of the frame
       frame.setSize(700, 300);
       frame.setLocationRelativeTo(null);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //Make the frame visible
       frame.setVisible(!false);
   
   }//End main
   

}//End Gui class
