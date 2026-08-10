package ChatGPT_Problems.Stack;

import java.util.Stack;

public class BalancedParentheses {
    public static void main(String[] args) {
        String string = "((a*b)+[a])";

        System.out.println(checkBalanced(string));
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
}
