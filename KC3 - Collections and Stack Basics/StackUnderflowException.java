/**
 * A custom exception that extends the RuntimeException class
 * Used to notify an error condition when an operaiton is attemped on an empty stack
 */
public class StackUnderflowException extends RuntimeException {
    /**
     * Constructor that creates a new StackUnderflowException with a custom error message
     * 
     * @param message provides a detailed explanation on the cause of the exception
     */
        public StackUnderflowException(String message) {
            super(message); // Call the superclass (RuntimeException) constructor with the error message
        }
    }