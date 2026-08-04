import java.util.Stack;

public class StackProblems {
    public static void main(String[] args) {
        // Create an Empty array of Size-5
        StackUsingArrays stack = new StackUsingArrays(5);

        // Push to array
        stack.push(12);
        stack.push(65);
        stack.push(76);
        stack.push(32);
        stack.push(98);

        // Display
        stack.display();

        // Pop Function
        System.out.println("\npopped element : "+stack.pop());
        stack.display();

        // Peek Function
        System.out.println("\nTop element : " +stack.peek());
        stack.display();


        // 1. Valid Parentheses
        String string = "(({{[[]]}}))";
        System.out.println(isValid(string));

        // Balanced Parentheses
        String string1 = "((a*b)+[a])";
        System.out.println(checkBalanced(string1));

        // Reverse A String
        String string2 = "Alsabith";
        System.out.println(reverseString(string2));

    }
    static class StackUsingArrays {
        int[] stack;
        int capacity;
        int top;

        public StackUsingArrays(int size){
            capacity = size;
            stack = new int[capacity];
            top = -1;
        }

        // check is Empty
        public boolean isEmpty(){
            return top == -1;
        }

        // Check is Full
        public boolean isFull(){
            return top == capacity -1;
        }

        // push
        public void push(int value){
            if (isFull()) {     // stack OverFlow the stack is full no more element can be push it
                System.out.println("Stack Overflow");
                return;
            }
            top ++;                     // increase the top position
            stack[top] = value;         // push the new Element
        }

        // pop
        public int pop(){
            if(isEmpty()){     // stack Underflow the stack is empty try to pop the item or element
                System.out.println("Stack UnderFlow");
                return -1;
            }
            int value = stack[top];     // save the top element in variable
            top--;                      // decrease the top position
            return value;               // return that variable
        }

        // Peek
        public int peek(){
            if(isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            return stack[top];
        }

        // Display
        public void display(){
            if(isEmpty()){
                System.out.println("Stack is Empty");
                return;
            }
            for (int i = top; i >=0 ; i--) {
                System.out.println(stack[i]);
            }
        }
    }

    // Valid Parentheses
    static boolean isValid(String s){
        Stack<Character> stack = new Stack();

        for(char ch : s.toCharArray()){
            if(ch =='(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if(ch ==')' && top != '('){
                    return false;
                }
                if(ch ==']' && top != '['){
                    return false;
                }
                if(ch =='}' && top != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    // Balanced Parentheses
    public static boolean checkBalanced(String s){

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch =='(' || ch == '[' || ch =='{'){
                stack.push(ch);
            }else if(ch ==')' || ch == ']' || ch == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();

                if(ch ==')' && top != '('){
                    return false;
                }
                if(ch ==']' && top != '['){
                    return false;
                }
                if(ch =='}' && top != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Reverse the String using Stack
    public static String reverseString(String s){
        Stack<Character> stack = new Stack<>();   // create an Empty Stack

        for(char ch : s.toCharArray()){          // separate the String into character
            stack.push(ch);                      // put all character into stack
        }
        StringBuilder result = new StringBuilder();   // create an empty string to store the reversed result

        while(!stack.isEmpty()) {
            result.append(stack.pop());          // remove the top character and add it to result
        }
        return result.toString();                // convert the StringBuilder into normal string
    }
}
