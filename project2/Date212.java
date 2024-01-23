public class Date212 {
   static String date;
   private int month;
   private int day;
   private int year;
   
   //Constructor
   public Date212(String s) {
      date = s;
   }
 
   //Initialize private variables and deal with illegal dates
   public boolean main() {
      year = Integer.parseInt(date.substring(0,4));
      month = Integer.parseInt(date.substring(4,6));
      day = Integer.parseInt(date.substring(6));
      
      //When date is illegal:
      if(!check()) {
         System.out.println(date+" is an illegal date.");
         return false;
      }
      return true;
   }
   
   //Check date legality
   private boolean check() {
      if(month<=0 || month>=13) {
         return false;
      }
      if(month==2 && (day<=0 || day>=29)) {
         return false;
      }
      else if((month==4 || month==6 || month==9 || month==11) && (day<=0 || day>=31)) {
         return false;
      }    
      else if((month==1 || month==3 || month==5 || month==7 ||month==8 || month==10 || month==12) && (day<=0 || day>=32)) {
         return false;
      }
      return true;
   }
  
   //Display in mm/dd/yyyy format
   public String toString() {
      return month+"/"+day+"/"+year;
   }
  
   //Compare the two dates, returns true if the first is earlier
   public boolean compareTo(Date212 two) {
      if(year > two.year){
         return false;
      }
      if((year == two.year) && (month > two.month)) {
         return false;
      }
      if((year == two.year) && (month == two.month) && (day > two.day)) {
         return false;
      }
      return true;
   }
}
