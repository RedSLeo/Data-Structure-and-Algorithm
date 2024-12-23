import support.LLNode;
import ch04.queues.LinkedQueue;
import ch04.queues.QueueUnderflowException;

public class MELQDriver {
   
   public static void main(String[] args){
      MyExtendedLinkedQueue<String> q = new MyExtendedLinkedQueue<>();
      
      System.out.println("Queue is currently empty: " + q.toString());
      
       q.enqueue("Ye");
       q.enqueue("Bear");
       q.enqueue("Goat");
       q.enqueue("Kobe");
       q.enqueue("Fish");
       
       System.out.println("After enqueues: " + q.toString());
       
       q.remove(2);
       System.out.println("Removed 2 elements: " + q.toString());
       
       System.out.println("swapStart: " + q.swapStart());
       System.out.println("swapStart: " + q.toString());
       
       System.out.println("swapEnds: " + q.swapEnds());
       System.out.println("swapEnds: " + q.toString());
      
   }
}