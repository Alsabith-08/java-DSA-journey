package LeetCodeEx.StackAndQueue;

// https://leetcode.com/problems/decode-string/description/

import java.util.Stack;

/*  Given an encoded string, return its decoded string.

   The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
   Note that k is guaranteed to be a positive integer.

   You may assume that the input string is always valid; there are no extra white spaces,
   square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain
   any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

   The test cases are generated so that the length of the output will never exceed 105.
   */
public class DecodeString_394 {
    public static void main(String[] args) {
         String s = "3[a]2[bc]";

        System.out.println(decodeString(s));
    }
    static String decodeString(String s){

        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

        StringBuilder currentString = new StringBuilder();
        int number = 0;

        for(char ch : s.toCharArray()){

            if(Character.isDigit(ch)){
                number = number * 10 +(ch -'0');
            }
            else if(ch =='['){
                countStack.push(number);
                stringStack.push(currentString.toString());

                number = 0;
                currentString.setLength(0);
            }
            else if(ch ==']'){

                int repeat = countStack.pop();
                String previousString = stringStack.pop();

                StringBuilder temp = new StringBuilder(previousString);

                for(int i=0; i<repeat ; i++){
                    temp.append(currentString);
                }
                currentString = temp;
            }
            else{
                currentString.append(ch);
            }
        }
        return currentString.toString();
    }
}
