/*
 * The ArrayBoundedStack class represents a stack data structure by using a generic array.
 * It grants the ability for simple stack operations such as pushing 
 */
public class ArrayBoundedStack<T> {

    // Array that holds stack of elements of generic type T
    private T[] stackArray;

    // Index of the top element in the stack
    private int topIndex;

    /**
     * An initialized constructor with a specified sized stack.
     * topIndex is initialized to -1, starting the stack off as empty
     * 
     * @param size fixed size of the stack 
     */
    public ArrayBoundedStack(int size) {
        stackArray = (T[]) new Object[size]; // Creates a new array of generic T with the provided size
        topIndex = -1; // -1 means that the stack will start empty
    }

    /**
     * Swaps the first two elements of the stack
     * IF there are less than 2 elements within the stack, RETURN false 
     * 
     * @return true if successfully swapped, false if there are less than two elements.
     */
    public boolean swapStart(){
        if (size() < 2){
            return false; // Unable to swap if less than 2 elements
        }

        // Swap the first two elements
        T temp = stackArray[topIndex]; // Store the top element temporarily
        stackArray[topIndex] = stackArray[topIndex - 1]; // Transfer the second-to-top element to the top
        stackArray[topIndex - 1] = temp; // Put the top element in the second-to-top position

        return true; // Successfully swapped
    }


    /**
     * Pushes the new element onto the top of the stack
     * The method will print a message if the stack is full
     * 
     * @param element the element to be added to the stack
     */
    public void push(T element){
        if (topIndex == stackArray.length - 1) {
            System.out.println("Stack is currently full."); // Stack is full = unable to push
        } else {
            topIndex++; // Move topIndex to create space for the new element
            stackArray[topIndex] = element; // Add the element to the top of the stack
        }
    }

    /**
     * Removes the set number of elements from the top of the stack
     * A StackUnderflowException is thrown if there are less elements than the specified count
     * 
     * @param count
     * @throws StackUnderflowException if there are less than 'count' elements in the stack
     */
    public void popSome(int count) {
        if (count > size()) {
            throw new StackUnderflowException("Unable to pop " + count + " element due to low count.");
        }
        topIndex -= count;
    }

    /**
     * Removes and returns the top element of the stack
     * If the stack is empty a StackUnderflowException is thrown
     * 
     * @return the element at the top of the stack
     * @throws StackUnderflowException if the stack is empty
     */
    public T poptop(){
        if(topIndex == -1){
            throw new StackUnderflowException("Stack is currently empty and cannot pop the top element.");
        }

        T topElement = stackArray[topIndex]; // Get the top element
        topIndex--; // Decreases topIndex to remove the top element
        return topElement; // Return the removed top element
    }

    /**
     * Returns the current number of elements on the stack
     * 
     * @return the number of elements that's on the stack
     */
    public int size() {
        return topIndex + 1;
    }

    /**
     * Returns a string representation of the current stack
     * A message will be displayed if the stack is empty
     * 
     * @return a string representing the elements of the stack
     */
    public String toString() {
        if (topIndex == -1) {
            return "Stack is currently empty..."; // There are no elements in the stack
        }

    StringBuilder stackRepresentation = new StringBuilder();

    stackRepresentation.append("Contents of Stack: [");

    // Append(add) all elements in the stack up to the currrent topIndex 
    for (int i = 0; i <= topIndex; i++) {
        stackRepresentation.append(stackArray[i]);

        if (i < topIndex) {
            stackRepresentation.append(", "); // Add commas between elements
        }
    }

    stackRepresentation.append("]");
    return stackRepresentation.toString(); // Returns the final string

}
}
