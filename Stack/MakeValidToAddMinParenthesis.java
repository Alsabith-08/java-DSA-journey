package ChatGPT_Problems.Stack;

import java.util.Stack;

public class MakeValidToAddMinParenthesis {
    public static void main(String[] args) {
        String str = "(()((";

        System.out.println(valid(str));
    }
    public static int valid(String string){

        Stack<Character> stack = new Stack<>();

        // push all characters in stack
        for(char ch : string.toCharArray() ){

            // check there is opposite bracket in top of the stack then pop it
            if(ch == ')'){
                // important check stack is empty before popping
               if(!stack.isEmpty() && stack.peek() == '('){
                   stack.pop();
               }// else push it to stack
               else{
                   stack.push(ch);
               }
            }
            // else push it to stack
            else{
                stack.push(ch);
            }
        }
        // return the stack size (after push and pop)
        // there is the minimum to add in stack to make it valid parenthesis
        // stack doesn't have the length property instead use the size to know the length of the stack
        return stack.size();
    }
}
