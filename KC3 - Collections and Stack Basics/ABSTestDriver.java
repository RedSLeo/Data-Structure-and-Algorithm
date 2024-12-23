
public class ABSTestDriver {
    public static void main(String[] args) {
        ArrayBoundedStack<String> stack = new ArrayBoundedStack<>(5);

        stack.push("Mango");
        stack.push("Watermelon");
        stack.push("Kiwi");

        System.out.println("Current Size: " + stack.size());

        // boolean swapped = stack.swapStart();
        // System.out.println("Successfully swapped " + swapped);

        System.out.println(stack.toString());

        String topElement = stack.poptop();
        System.out.println("Popped top element: " + topElement);

        System.out.println(stack.toString());

        // stack.popSome(2);
        // try{
        //     stack.poptop();
        // } catch (ArrayBoundedStack.StackUnderflowException e) {
        //     System.out.println(e.getMessage());
        // }

        stack.popSome(2);
        // swapped = stack.swapStart();
        // System.out.println("Swap successful: " + swapped);

        try {
            stack.popSome(2);
        } catch (StackUnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
}
