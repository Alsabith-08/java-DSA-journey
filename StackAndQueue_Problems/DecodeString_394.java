
// https://leetcode.com/problems/decode-string/description/
// Apporach        : stack + StringBuilder
// Time Complexity : O(n)

import java.util.Stack;

public class DecodeString_394 {
    public static void main(String[] args) {
         String s = "3[a]2[bc]";

        System.out.println(decodeString(s));
    }
    static String decodeString(String s){

       // Create a two Stack , one for number and another one for characters
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();

       // use a stringBuilder to store a string while processing
       // and initialize a number to store the current number
        StringBuilder currentString = new StringBuilder();
        int number = 0;

        for(char ch : s.toCharArray()){

           // is character is number add to number variable
            if(Character.isDigit(ch)){
                number = number * 10 +(ch -'0');
            }
               // if open bracket, push the currnent value of number in number Stack
               // and push the StringBuilder value in characterStack
            else if(ch =='['){
                countStack.push(number);
                stringStack.push(currentString.toString());

               // then reset the number and StringBuilder values
                number = 0;
                currentString.setLength(0);
            }
               // if close brackets, this is the important thing
               // pop the top element of numberStack and pop the top element of characterStack element
            else if(ch ==']'){

                int repeat = countStack.pop();
                String previousString = stringStack.pop();

               // create a temp string
                StringBuilder temp = new StringBuilder(previousString);

               // store the character based on the number in that temp string
                for(int i=0; i<repeat ; i++){
                    temp.append(currentString);
                }
               // assign to currentString
                currentString = temp;
            }
               // otherWise add the character in StringBuilder
            else{
                currentString.append(ch);
            }
        }
       // return the currentString in String
        return currentString.toString();
    }
}
