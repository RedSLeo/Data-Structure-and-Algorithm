import ch02.stacks.LinkedStack;
import ch02.stacks.StackUnderflowException;
import support.LLNode;

public class MyExtendedLinkedStack<T> extends LinkedStack<T>{

      
   public String toString(){
      if (isEmpty()) {
         return "Stack is currently empty. . .";
      }
      
      StringBuilder stackRepresentation = new StringBuilder();
      
      stackRepresentation.append("Contents of the Stack: [");
      
      LLNode<T> currentNode = top;
      while (currentNode != null) {
         stackRepresentation.append(currentNode.getInfo());
         currentNode = currentNode.getLink();
         
         if (currentNode != null){
            stackRepresentation.append(", ");
         }
      }
      
      stackRepresentation.append("]");
      return stackRepresentation.toString();
   }
   
   public int size() {
      int count = 0;
      LLNode<T> currentNode = top;
      while (currentNode != null) {
         count++;
         currentNode = currentNode.getLink();
   }
   return count;
}

   public void popSome(int count){
      if (count > size()) {
         throw new StackUnderflowException("Unable to pop " + count + " element due to low count.");
      }
      
      for (int i = 0; i < count; i++) {
         pop();
      }
   }
   
   public boolean swapStart() {
      if (size() < 2){
         return false;
      }
      
      T firstElement = top.getInfo();
      T secondElement = top.getLink().getInfo();
      
      top.setInfo(secondElement);
      top.getLink().setInfo(firstElement);
      
      return true;
   }
   
   public T poptop() {
      if(isEmpty()){
         throw new StackUnderflowException("Stack is currently empty and cannot pop the top element");
      }
      
      T topElement = top();
      pop();
      return topElement;
   }
   
   public T inspector(int index){
      if (index < 1) {
         return null;
      }
      
      LLNode<T> currentNode = top;
      int currentIndex = 1;
      
      while (currentNode != null && currentIndex < index) {
         currentNode = currentNode.getLink();
         currentIndex++;
      }
      
      if (currentNode == null) {
         return null;
      }
      return currentNode.getInfo();
   }

}