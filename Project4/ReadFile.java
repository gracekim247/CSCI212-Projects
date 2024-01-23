import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Read and sort through file contents, storing each date into respective arrayList to be displayed on gui
 */
public class ReadFile {
   
   File file;
   protected static ArrayList<Date212> unsorted = new ArrayList<>();
   protected static ArrayList<Date212> sorted  = new ArrayList<>();
   protected static ArrayList<String> sorted2 = new ArrayList<>();
   protected static ArrayList<Date212> yearList  = new ArrayList<>();

   /**
    * Read through file content and add each date to an arraylist
    * 
    * @param f file chosen by user; contents will be read through and displayed on gui
    */
   public void readSource(File f) {
      String chosenFileName = f.getAbsolutePath(); 
      TextFileInput file = new TextFileInput(chosenFileName);
      
      String line = file.readLine();
      
      //Stores string values from the file so that Collections.sort() can be used later on
      sorted2 = new ArrayList<>();
      
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
      //Sort through the string arrayList
      Collections.sort(sorted2);
      //Sorted arraylist will contain Date212 objects in sorted order
      for(String i:sorted2) {
         Date212 date = new Date212(i);
         sorted.add(date);
      } 
   }
   
   /**
    * 
    * @return sorted arraylist
    */
   public ArrayList<Date212> returnSortedArrayList() {return sorted;}
   
   /**
    * 
    * @return unsorted arraylist
    */
   public ArrayList<Date212> returnUnsortedArrayList() {return unsorted;}
   
   /**
    * 
    * @param yr year input from user
    * @return arraylist containing only the Date212 objects with the specified year
    */
   public ArrayList<Date212> returnyearArrayList(int yr) {
      //Add Date212 object to yearList arraylist if its year matches with the specified year
      for(Date212 i: sorted) {
         if(i.year==yr) {
            yearList.add(i);
         }
      }
      return yearList;
   } 
   
}
