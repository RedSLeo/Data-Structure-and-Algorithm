import support.LLNode;
import ch04.queues.LinkedQueue;
import ch04.queues.QueueUnderflowException;

public class MyExtendedLinkedQueue<T> extends LinkedQueue<T> {

   public String toString(){
      StringBuilder result = new StringBuilder("Front [");
      
      LLNode<T> current = front;
      while (current != null) {
         result.append(current.getInfo());
         if (current.getLink() != null) {
            result.append(", ");
         }
         current = current.getLink();
      }
      result.append("] Rear");
      return result.toString();
   }
   
   public void remove(int count){
      if (count > numElements) {
         throw new QueueUnderflowException(" Not enough elements to be removed at the moment ");
      }
      for (int i = 0; i < count; i++) {
         front = front.getLink();
         numElements--;
         if (front == null) {
            rear = null;
            break;
         }
      }
   }
   
   boolean swapStart(){
      if (numElements < 2) {
         return false;
      }
      LLNode<T> second = front.getLink();
      front.setLink(second.getLink());
      second.setLink(front);
      front = second;
      if (numElements == 2) {
         rear = second.getLink();
      }
      return true;
   }
   
   boolean swapEnds(){
      if (numElements < 2) {
         return false;
      }
      LLNode<T> previous = null;
      LLNode<T> current = front;
      while (current.getLink() != null) {
         previous = current;
         current = current.getLink();
      }
      if (previous == null){
         return false;
      }
      current.setLink(front.getLink());
      front.setLink(null);
      previous.setLink(front);
      front = current;
      rear = previous.getLink();
      return true;
   }

}