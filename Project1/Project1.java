import java.util.StringTokenizer;
import java.util.*;

public class Project1 {
  
   public static void main(String[] args) {
      TextFileInput file = new TextFileInput("P1input.txt");
      String line = file.readLine();
      
      //Dynamic structure to store the input values because number of dates in each input file is unknown
      Vector<String> vec = new Vector<String>();
      
      //Store the tokens from the input file as elements of the vector
      while(line != null) {   
         StringTokenizer myTokens = new StringTokenizer(line,",");
         
            //Add the token to the vector until there are no more tokens after it
            while (myTokens.hasMoreTokens()) {
               String token = myTokens.nextToken();
               vec.add(token);
            }
         line = file.readLine();
      }
      
      Date212[] unordered = new Date212[vec.size()];
      Date212[] sorted = new Date212[vec.size()];
      int count = 0;
     
      //Make each string element of the vector into Date212 objects and put the Date212 objects into arrays
      for(int r = 0; r<unordered.length; r++) {
         Date212 dates = new Date212(vec.get(r));
         
         //If date is legal, date gets added to arrays
         if(dates.main()) {
            unordered[count] = dates;
            sorted[count] = dates;
            count++;
         }
      }
      
      //Sort array with selection sort
      for(int x = 0; x<count-1; x++) {         
         int index = x;
         for(int y = x+1; y<count; y++) {
            if(sorted[y].compareTo(sorted[index])){
               index = y;
            }
         }
         Date212 temp = sorted[index];
         sorted[index]= sorted[x];
         sorted[x] = temp;
      }
    
      //Initialize GUI and print the two arrays to GUI
      DateGUI.makeAndDisplayGUI(unordered, sorted, count);
   }

}
