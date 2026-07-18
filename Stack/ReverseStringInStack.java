package ChatGPT_Problems.Stack;

import java.util.Stack;

public class ReverseStringInStack {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        String str = "Alsabith Berlin";

        // push all characters in stack
        for(char ch : str.toCharArray()){
            stack.push(ch);
        }
        // then pop it and print it
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
