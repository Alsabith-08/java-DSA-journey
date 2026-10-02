package LeetCodeEx.Strings;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// Approach  : HashSet + Two Pointers
// Time Complexity : O(n) , Space Complexity : O(K) -> character
import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacters_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(LongSubString(s));
    }
    static int LongSubString(String s){
        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength , right - left +1);
        }
        return maxLength;
    }
}
