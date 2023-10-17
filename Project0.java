// To access the JOptionPane methods
import javax.swing.*;

public class Project0 {

   public static void main(String[] args) {
      
      // A while loop surrounds the majority of the program to repeat the process of asking the user for a string and counting the number 
      // of occurrences of e's and E's in the string. Because the condition in the while loop is set to true, the code infinitely repeats 
      // until the user states otherwise (by entering "stop").
      while(true) {
         String userString = JOptionPane.showInputDialog(null, "Please enter a sentence.");
         
         int lowerECount = 0;
         int upperECount = 0;
         
         // The for loop initializes and increments the index variable which is passed as a parameter to the charAt method to access each 
         // character of the string. The index continues to access each character as it increments and as the for loop progresses until the 
         // index value reaches the value of the string length.
         for(int index = 0; index<userString.length(); index++) {
            // The charAt method accesses the character in the specified index of the string. This is followed by  =='e' or =='E' to check 
            // if the accessed character is an e or E. == is used instead of the equals() method because char is a primitive data type 
            // and only objects can use the equals() method. If the conditions following the if statements are met (the character at the index 
            // is either e or E), the variables that keep count of the e's and E's is incremented by 1.
            if(userString.charAt(index)=='e') 
               lowerECount++;
            if(userString.charAt(index)=='E') 
               upperECount++;
         }
         
         // In the case that the user wants to terminate the program, the user enters "stop". If the string equals "stop" regardless of the 
         // cases of the letters, the program exits out of the infinite while loop, thus, terminating the program.
         if(userString.equalsIgnoreCase("STOP")) {
            System.exit(0);
         }
      
         JOptionPane.showMessageDialog(null, "Number of lowercase e's: "+lowerECount+"\n"+"Number of uppercase e's: "+upperECount);
         
      }
   }
   
}
