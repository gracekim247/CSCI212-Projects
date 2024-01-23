
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;


/**
 * Set the actions of the menu items "Open" and "Quit", have the user choose a local file, display the file contents to the gui
 */
public class FileMenuHandler implements ActionListener  {
   
   Date212GUI jframe;
   File f;
   protected ArrayList<Date212> unsorted = new ArrayList<>();
   protected ArrayList<Date212> sorted = new ArrayList<>(); 
   
   /**
    * 
    * @param jf the GUI opened at the beginning of program execution
    */
   public FileMenuHandler (Date212GUI jf) {
      jframe = jf;
   }
   
   
   /**
    * Set what each of the menu items do
    */
   public void actionPerformed(ActionEvent event) {
      String menuName = event.getActionCommand();
      //"Open" menu item prompts the user to choose and open a local file
      if (menuName.equals("Open")) {
         openFile(); 
      }
      //"Quit" menu item terminates the program
      else if (menuName.equals("Quit")) {
         System.exit(0); 
      }
   } 
   
   
   /**
    * User chooses a file
    */
   private void openFile() {
      JFileChooser chooser = new JFileChooser();
      int status = chooser.showOpenDialog(null);
      addToGUI(chooser.getSelectedFile());
   }
   
   /**
    * Retrieves the sorted and unsorted arraylists from ReadFile class and displays the array lists to the gui
    * 
    * @param chosenFile the file the user chose
    */
   public void addToGUI(File chosenFile) {
      
      ReadFile read = new ReadFile();
      //Sort through the contents of the file
      read.readSource(chosenFile);
      //Return the arraylists created in the ReadFile class which will be later displayed on the gui
      sorted = read.returnSortedArrayList();
      unsorted = read.returnUnsortedArrayList();
      
      Container myContentPane = jframe.getContentPane();
      
      //Left side of GUI will contain unordered dates, right side will contain sorted dates
      JTextArea unorderedTextArea = new JTextArea(15,15);
      unorderedTextArea.setEditable(false);
      myContentPane.add(unorderedTextArea);
      JTextArea sortedTextArea = new JTextArea(15,15);
      sortedTextArea.setEditable(false);
      myContentPane.add(sortedTextArea);
      
      //"Labels" for each side of the GUI
      unorderedTextArea.append("Unordered dates: \n");
      sortedTextArea.append("Sorted dates: \n");
      
      //Add lists to respective side of the GUI 
      for(Date212 i:unsorted) {
         unorderedTextArea.append(i.toString()+"\n");
      }
      for(Date212 i:sorted) {
         sortedTextArea.append(i.toString()+"\n");
      }
      
      jframe.setVisible(true);
       
   }

}