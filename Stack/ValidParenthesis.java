package ChatGPT_Problems.Stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String str = "(({[]}))";
        System.out.println(valid(str));
    }
    public static boolean valid(String s){
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()){
            // push the String value in stack by convert in characters using toCharArray()
            if(ch == '(' || ch == '{' || ch == '[' ){
                stack.push(ch);
            }
            // push it and pop it
            // what if?
            // if ex: one opening brackets are extra in stack there is no to pop it so return false
            // in stack there is one opening brackets are available , so stack is not an empty
            // then the closing brackets coming then check it
            if(ch == ')'){
                // if the brackets are opposite side then pop it
                // important : check the stack is empty before popping it
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }
            if(ch == '}'){
               if(stack.isEmpty() || stack.pop() != '{'){
                   return false;
               }
            }
            if(ch == ']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
            }
        }
        return true;
    }
}
