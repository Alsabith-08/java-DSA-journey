package LeetCodeEx.TwoPointers;

// https://leetcode.com/problems/valid-palindrome-ii/
// NOTE : delete at most one element
// Approach / Pattern : Two Pointers
// IDEA : left pointer is on first index and right pointer is on last index
//        if equal move both pointers, otherwise there are two possibility one left+1 or right-1
//        preform any one to get an equal element

// Time Complexity : O(n)   , Space Complexity : O(1)
public class ValidPalindrome2_680 {
    public static void main(String[] args) {
        String s = "abca";

        System.out.println(valid(s));
    }
    static boolean valid(String s){
        int left = 0;                                     // initially left = 0 , right = n-1
        int right = s.length() - 1;

        while(left < right){                             // terminate condition
            if(s.charAt(left) == s.charAt(right)){       // check both element is equal move both pointers is left++ , is right--
                left++;
                right--;
            }else{                                      // otherWise, use a helper function that checks possibility left+1 or right-1
                return isPalindrome(s , left+1 , right) || isPalindrome(s , left , right-1);
            }
        }
        return true;
    }
    static boolean isPalindrome(String s , int left , int right){
        while(left < right){                               // terminate condition
            if(s.charAt(left++) != s.charAt(right--)){     // is not equal not return false;
              return false;
            }
        }
        return true;
    }
}
