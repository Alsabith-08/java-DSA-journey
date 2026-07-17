package ChatGPT_Problems.Stack;

public class CustomStack {
    public static void main(String[] args) {
        customstack stack = new customstack(5);
        stack.push(12);
        stack.push(43);
        stack.push(2);
        stack.push(1);


        stack.display();
        System.out.println("\n Top " + stack.peek());

        System.out.println(" \nRemoved Element " + stack.pop());
        stack.display();

    }
    static class customstack {

        int[] stack;
        int top;
        int capacity;

        public customstack(int size) {
            capacity = size;
            stack = new int[capacity];
            top = -1;
        }

        // check stack is empty
        public boolean isEmpty() {
            return top == -1;
        }
        public boolean isFull() {
            return top == capacity - 1;
        }

        public void push(int value) {
            if (isFull()) {
                System.out.println("Stack Overflow");
                return;
            }
            top++;
            stack[top] = value;

            System.out.println(value + " Pushed");
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack UnderFlow");
                return -1;
            }
            int value = stack[top];
            top--;
            return value;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Stack Empty");
                return -1;
            }

            return stack[top];
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Stack Empty");
                return;
            }

            for (int i = top; i >= 0; i--) {
                System.out.println(stack[i]);
            }
        }
    }

}
