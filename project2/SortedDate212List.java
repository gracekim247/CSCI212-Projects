
public class SortedDate212List extends Date212List {

   //no-argument constructor
   public SortedDate212List() {
      super();
   }
   
   //to add node to proper position
   public void add(Date212 d) {
      Date212Node newNode = new Date212Node(d);
      //while traversing through the list, pointer points to the each node
      Date212Node pointer = first;
      //real points to the node where the new node should be added after
      Date212Node real = first;
      
      //skip traversing through the list if the new node is bigger than the last node 
      if(last.data.compareTo(d)) {
         last.next = newNode;
         last = newNode;
      }
      else {
         //traverse through list
         while(pointer.next!=null) {
            //if d is bigger than pointer data:
            if(!d.compareTo(pointer.data)) {
               real = pointer;
            }
            pointer = pointer.next;
         }
         //new node is added after the node real points to
         newNode.next = real.next;
         real.next = newNode;
      }
      length++;
   }  
}
