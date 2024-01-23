
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


/**
 * Set the actions of the menu items "Open" and "Quit", read through the file contents, and sort through and displays the dates
 */
public class FileMenuHandler implements ActionListener  {
   
   Date212GUI jframe;
   
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
      if (menuName.equals("Open")) {
         openFile(); 
      }
      else if (menuName.equals("Quit")) {
          System.exit(0); 
      }
   } 
   
   
   /**
    * user chooses a file
    */
   private void openFile() {
      JFileChooser chooser = new JFileChooser();
      int status = chooser.showOpenDialog(null);
      readSource(chooser.getSelectedFile());
   }
   
   
   /**
    * contents of the file are read through, sorted, and displayed
    * 
    * @param chosenFile the file the user chose
    */
   private void readSource(File chosenFile) {
      String chosenFileName = chosenFile.getAbsolutePath();
      TextFileInput file = new TextFileInput(chosenFileName);
      
      String line = file.readLine();
      
      //Where values from the file will be stored. sorted2 is of string type so Collections.sort() can be used later on
      ArrayList<Date212> unsorted = new ArrayList<>();
      ArrayList<String> sorted2 = new ArrayList<>();
      
      //Store the tokens from the file into the ArrayLists
      while(line != null) {   
         StringTokenizer myTokens = new StringTokenizer(line,",");
            //Repeat until there are no more tokens after it
            while (myTokens.hasMoreTokens()) {
               String token = myTokens.nextToken();
               //To deal with illegal dates
               try{
                  Date212 d = new Date212(token);
                  unsorted.add(d);  
                  sorted2.add(token);
               }
               //If illegal date is found, prints the error message to the console
               catch (IllegalDate212Exception err){
                  System.out.println(err);
               }
            }
         line = file.readLine();
      }
      
      //Create an Arraylist, sort the dates, store them into ArrayList
      ArrayList<Date212> sorted = new ArrayList<>();
      Collections.sort(sorted2);
      for(String i:sorted2) {
         Date212 date = new Date212(i);
         sorted.add(date);
      }
   
      
      Container myContentPane = jframe.getContentPane();
      
      //left side of GUI will contain unordered dates, right side will contain sorted dates
      JTextArea unorderedTextArea = new JTextArea(15,15);
      unorderedTextArea.setEditable(false);
      myContentPane.add(unorderedTextArea);
      JTextArea sortedTextArea = new JTextArea(15,15);
      sortedTextArea.setEditable(false);
      myContentPane.add(sortedTextArea);
      
      //"labels" for each side of the GUI
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