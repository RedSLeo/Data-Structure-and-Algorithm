import ch04.queues.CircularLinkedQueue;
import support.LLNode;
import ch04.queues.QueueUnderflowException;

public class CircularQueueDriver {

   public static void main(String[] args) {
      CircularLinkedQueue<String> clq = new CircularLinkedQueue<>();
      
      System.out.println("Queue is empty right now" + clq.toString() + ", the size is " + clq.size());
      
      clq.enqueue("Bobby");
      System.out.println("\nAfter adding(enqueue) and element--> " + clq.toString());
      System.out.println(clq.isEmpty());
      System.out.println(clq.size());
      System.out.println("Dequeued element: " + clq.dequeue());
      System.out.println("Queue is empty right now" + clq.toString());
      
      clq.enqueue("Charles");
      clq.enqueue("Xavier");
      System.out.println("\nAfter adding(enqueue) elements--> " + clq.toString());
      System.out.println(clq.isEmpty());
      System.out.println(clq.size());
      System.out.println("Dequeued element: " + clq.dequeue());
      System.out.println("After removing(Dequeued) element: " + clq.toString());
      System.out.println("Dequeued element: " + clq.dequeue());
      System.out.println("Queue is empty right now" + clq.toString());
      
      clq.enqueue("Elizabeth");
      clq.enqueue("Charlie");
      clq.enqueue("Sebastion");
      System.out.println("\nAfter adding(enqueue) elements--> " + clq.toString());
      System.out.println(clq.isEmpty());
      System.out.println(clq.size());
      System.out.println("Dequeued element: " + clq.dequeue());
      System.out.println("After removing(Dequeued) element: " + clq.toString());
      System.out.println("Dequeued element: " + clq.dequeue());
      System.out.println("After removing(Dequeued) element: " + clq.toString());
      System.out.println("Dequeued element: " + clq.dequeue());
      System.out.println("Queue is empty right now" + clq.toString());
      
   }
}