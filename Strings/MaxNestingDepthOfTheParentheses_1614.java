
// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
// Approach : use tow variables
// Time Complexity : O(n)   , Space Complexity : O(n)

public class MaxNestingDepthOfTheParentheses_1614 {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";

        System.out.println(maxDepth(s));
    }

    static int maxDepth(String s){
        int depth = 0;
        int maxDepth = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                depth++;
                maxDepth = Math.max(maxDepth , depth);
            }

            else if(ch == ')'){
                depth--;
            }
        }
        return maxDepth;
    }
}
