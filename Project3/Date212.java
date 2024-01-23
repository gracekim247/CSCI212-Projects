
/**
 * Create the Date212 object from a string and checks its validity
 */
public class Date212 {
   
   static String date;
   private int month;
   private int day;
   private int year;
   
   /**
    * Constructor - create Date212 object from a string
    * 
    * @param s the date in yyyymmdd form from the selected file
    * @throws IllegalDate212Exception if the check method of the date returns false
    */
   public Date212(String s) throws IllegalDate212Exception {
         date = s;
         //if the date is legal, class variables are instantiated and the Date212 object is created
         if (check(s)) {
            year = Integer.parseInt(date.substring(0,4));
            month = Integer.parseInt(date.substring(4,6));
            day = Integer.parseInt(date.substring(6));
         }
         //if date is illegal, throw the exception and print the illegal date to the console
         else {
            throw new IllegalDate212Exception(Integer.parseInt(date.substring(4,6))+
                  "/"+Integer.parseInt(date.substring(6))+
                  "/"+Integer.parseInt(date.substring(0,4))+
                  " is an illegal date.");
         }
   }
 
   
   /**
    * Return true when the date is legal; false otherwise
    * 
    * @param str the date from file in yyyymmdd form
    * @return true if the month value is between 1 and 12 and the day value is between 1 and 28, 30, or 31
    */
   public static boolean check(String str) {
      int month2 = Integer.parseInt(str.substring(4,6));
      int day2 = Integer.parseInt(str.substring(6));
      
      if(month2<=0 || month2>=13) {
         return false;
      }
      if(month2==2 && (day2<=0 || day2>=29)) {
         return false;
      }
      else if((month2==4 || month2==6 || month2==9 || month2==11) && (day2<=0 || day2>=31)) {
         return false;
      }    
      else if((month2==1 || month2==3 || month2==5 || month2==7 ||month2==8 || month2==10 || month2==12) && (day2<=0 || day2>=32)) {
         return false;
      }
      return true;
      
   }
  
  
   /**
    * Display in mm/dd/yyyy format
    * 
    */
   public String toString() {
      return month+"/"+day+"/"+year;
   }
  
}
