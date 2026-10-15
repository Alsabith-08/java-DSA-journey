
// https://leetcode.com/problems/removing-stars-from-a-string/description/
// Approach : Stack(Last in First Out)
// Time Complexity : O(n)

public class RemovingStar_2390 {
    public static void main(String[] args) {
        String s = "leet**cod*e";

        System.out.println(removeStars(s));
    }
    static String removeStars(String s){

      // use StringBuilder because it is mutable and the answer keeps changing while processing the String
      // StringBuilder acts as a stack 
        StringBuilder stack = new StringBuilder();
      
        for(char ch : s.toCharArray()){

          // if character is *(Star) is found remove the previous element , otherwise add to Stack
            if(ch == '*'){
                stack.deleteCharAt(stack.length() - 1);
            }else{
                stack.append(ch);
            }
        }
      // return the final string
        return stack.toString();
    }
}




