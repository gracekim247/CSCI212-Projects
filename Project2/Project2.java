import java.util.StringTokenizer;
import java.util.*;

public class Project2 {
  
   public static void main(String[] args) {
      TextFileInput file = new TextFileInput("P1input.txt");
      String line = file.readLine();
      
      //To store the input values 
      UnsortedDate212List unsorted = new UnsortedDate212List();
      SortedDate212List sorted = new SortedDate212List();
      
      //Store the tokens from the input file as nodes of the lists
      while(line != null) {   
         StringTokenizer myTokens = new StringTokenizer(line,",");
         
            //Repeat until there are no more tokens after it
            while (myTokens.hasMoreTokens()) {
               String token = myTokens.nextToken();
               //Token to Date212 object
               Date212 dateNode = new Date212(token);
               //Add to both lists
               if (dateNode.main()) {
                  unsorted.add(dateNode);
                  sorted.add(dateNode);
               }
            }
         line = file.readLine();
      }
            
      //Initialize GUI and print the two arrays to GUI
      DateGUI.makeAndDisplayGUI(unsorted, sorted);
   }

}
