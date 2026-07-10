package ChatGPT_Problems;

import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
      String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));

    }
    static boolean isPalindrome(String s){

        s.toLowerCase().replaceAll("[A-Za-z0-9]" , "");
        int i =0;
        int j =s.length() -1;

        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
