package ChatGPT_Problems.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        String str = "Hello";

        reverseString stack = new reverseString(str.length());

        // push all characters
        for (int i = 0; i < str.length() ; i++) {
            stack.push(str.charAt(i));
        }

        System.out.println("Reversed String");

        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
class reverseString{
    private char[] stack;
    private int capacity;
    private int top;

    public reverseString(int size){
        capacity = size;
        top = -1;
        stack = new char[capacity];
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void push(char ch){
        if(top == capacity -1){
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stack[top] = ch;
    }
    public char pop(){
        if(isEmpty()){
            return '\0';
        }
        return stack[top--];
    }
}
