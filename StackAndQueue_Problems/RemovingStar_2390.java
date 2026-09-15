package LeetCodeEx.StackAndQueue;

// https://leetcode.com/problems/removing-stars-from-a-string/description/
// Approach : Stack(Last in First Out)
// Time Complexity : O(n)

/*              problem Description :
  You are given a string s, which contains stars *.

  In one operation, you can:

  Choose a star in s.
  Remove the closest non-star character to its left, as well as remove the star itself.
  Return the string after all stars have been removed.

  Note:
  The input will be generated such that the operation is always possible.
  It can be shown that the resulting string will always be unique.
  */
public class RemovingStar_2390 {
    public static void main(String[] args) {
        String s = "leet**cod*e";

        System.out.println(removeStars(s));
    }
    static String removeStars(String s){

        StringBuilder stack = new StringBuilder();
        for(char ch : s.toCharArray()){

            if(ch == '*'){
                stack.deleteCharAt(stack.length() - 1);
            }else{
                stack.append(ch);
            }
        }
        return stack.toString();
    }
}




