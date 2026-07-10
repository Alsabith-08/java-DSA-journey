package ChatGPT_Problems;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        
     String s = "Madam";
     System.out.println(isPalindrome(s));

    }
    static boolean isPalindrome(String s){

        s = s.toLowerCase().replaceAll("[A-Za-z0-9]" , "");  // using Regex Expression for remove the unwanted values 
         // take two pointers
        int i =0;    
        int j =s.length() -1;

        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){  // use the charAt() method to check the first and last values are same if not same return false
                return false;
            }
            i++;  // increment starting pointer
            j--;  // decrement last pointer
        }
        return true;
    }
}
