import ch02.stacks.StackUnderflowException;
public class LinkedStackDriver {

public static void main(String[] args) {
   
   MyExtendedLinkedStack<String> myStack = new MyExtendedLinkedStack<>();
   
   System.out.println("Current size of the stack: " + myStack.size());
   System.out.println(myStack.toString());
   
   myStack.push("Mango");
   myStack.push("Watermelon");
   myStack.push("Kiwi");
   myStack.push("Banana");
   myStack.push("Strawberry");
   myStack.push("Cookie");
   
   System.out.println(myStack.toString());
   System.out.println("Stack size: " + myStack.size());
   
   myStack.popSome(3);
   System.out.println("Content after popping 3 elements: " + myStack.toString());
   
   boolean swapped = myStack.swapStart();
   System.out.println("Swapped: " + swapped);
   System.out.println(myStack.toString());
   
   String topElement = myStack.poptop();
   System.out.println("Popped Element: " + topElement);
   System.out.println(myStack.toString());
   
   myStack.push("Potatos");
   System.out.println("\n" + myStack.toString());
   
   
   System.out.println("Selected element at index 2: " + myStack.inspector(2));
   System.out.println("Selected element at index 3: " + myStack.inspector(3));
   
   
   
   
}

}