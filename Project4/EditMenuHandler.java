import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * Set the actions of the menu item "Search", have the user choose a local file, display the file contents to the gui
 */
public class EditMenuHandler implements ActionListener{

   Date212GUI frame;
   private String year;
   private int yr;
   
   /**
    * 
    * @param jf the GUI opened at the beginning of program execution
    */
   public EditMenuHandler (Date212GUI jf) {
      frame = jf;
   }
   
   /**
    * Set what the menu item does
    */
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      //"Search" will prompt the user to enter a year; all the dates with the specified year will be displayed to gui
      if (menuName.equals("Search")) {
          year = JOptionPane.showInputDialog(null, "Enter a year: ");
          yr = Integer.parseInt(year);
          findDates(yr);
      }
   } 
  
   /**
    * Retrieve the arrayList containing the Dates with the specified year and display them to the gui
    * 
    * @param y the year input by the user, all the Date212 objects should have this value for their year
    */
   public void findDates(int y) {
      ReadFile read = new ReadFile();
      //List will contain the Date212 objects that have the specified year
      ArrayList<Date212> list = read.returnyearArrayList(y);
      
      Container myContentPane = frame.getContentPane();
      
      JTextArea textArea = new JTextArea(15,15);
      textArea.setEditable(false);
      myContentPane.add(textArea);
      //"Label" of the column of gui
      textArea.append("Dates with "+y+" as the year: \n");
      
      //When there are no dates with the specified year
      if(list.size()==0) {
         textArea.append("No dates with year "+y);
      }
      //If there are dates that have the specified year, add them to the textArea to be displayed in gui
      else{
         for(Date212 i:list) {
            textArea.append(i+"\n");
         }
      }
           
      frame.setVisible(true);
   }
   

}
