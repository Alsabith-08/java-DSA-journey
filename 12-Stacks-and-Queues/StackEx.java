import java.util.Stack;

// stack is the LIFO data structure and linear

public class StackEx {
    public static void main(String[] args) {

        // In-built Stack class in java
        Stack <Integer> stack = new Stack<>();

        // Methods :
        // push - to insert at the top of the stack
        // pop - to remove the top of the element of the stack
        // peek - to print top of the element of the stack
        // isEmpty - check stack is empty or not
        // isFull - check stack is full or not
        stack.push(12);
        stack.push(3);
        stack.push(4);
        stack.push(6);

        stack.pop();  // 6 will be removed because it is the top value
        System.out.println(stack.peek());  // print the top element of the stack



    }
}
