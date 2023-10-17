import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.*;

public class DateGUI {
 
   public static void makeAndDisplayGUI(Date212[] unord, Date212[] sort, int size) {
      //Create and set up the window
      JFrame myGUI = new JFrame();
      myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myGUI.setSize(350,350);
      myGUI.setLocation(500,300);
      myGUI.setTitle("Project 1");
      
      //Set GUI layout to grid format
      myGUI.setLayout(new GridLayout(1,2));
      
      Container myContentPane = myGUI.getContentPane();
      
      //Create text area where the unordered list of dates will be displayed
      JTextArea unorderdTextArea = new JTextArea(15,15);
      unorderdTextArea.setEditable(false);
      myContentPane.add(unorderdTextArea);
      
      //Create text area where the sorted list of dates will be displayed
      JTextArea sortedTextArea = new JTextArea(15,15);
      sortedTextArea.setEditable(false);
      myContentPane.add(sortedTextArea);
      
      //"labels" for each side of the GUI
      unorderdTextArea.append("Unordered dates: \n");
      sortedTextArea.append("Sorted dates: \n");
      
      //Add arrays to respective side of the GUI
      for (int i = 0; i<size; i++) {
         unorderdTextArea.append(unord[i].toString()+"\n");
         sortedTextArea.append(sort[i].toString()+"\n");
         
      }
      //Display the window
      myGUI.pack();
      myGUI.setVisible(true);
   }
}
