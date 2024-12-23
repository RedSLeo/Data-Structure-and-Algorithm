import support.LLNode;
import ch03.apps.LinkedListRecursive;

public class ContainsRecursive extends LinkedListRecursive {


   public boolean contains(int target, LLNode<Integer> list) {
      if (list == null) {
         return false;
      }
      
      if (list.getInfo() == target) {
         return true;
      }
      
      return contains(target, list.getLink());
   }
   
   public static void main(String[] args) {
      ContainsRecursive cr = new ContainsRecursive();
      
      LLNode<Integer> head = new LLNode<>(15);
      head.setLink(new LLNode<>(3));
      head.getLink().setLink(new LLNode<>(7));
      head.getLink().getLink().setLink(new LLNode<>(20));
      
      System.out.println("Contains 15: " + cr.contains(15, head));
      System.out.println("Contains 10: " + cr.contains(10, head));
      System.out.println("Contains 5: " + cr.contains(5, head));
   }



}