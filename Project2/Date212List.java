
public abstract class Date212List {
   Date212Node empty = new Date212Node(new Date212(""));
   protected Date212Node first;
   protected Date212Node last;
   protected int length;
   
   //no-argument constructor
   public Date212List(){
      super();
      first = empty;
      last = empty;
      length = 0;
   }
   
   public void append(Date212 d) {
      Date212Node n = new Date212Node(d);
      last.next = n;
      last = n;
      length++;
   }
}
