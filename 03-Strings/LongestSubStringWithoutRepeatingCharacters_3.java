
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

        for (int right = 0; right < s.length(); right++) {            // while -> remove the character until the character disappears
            while(set.contains(s.charAt(right))){                     // the set contains the character
                set.remove(s.charAt(left));                           // remove the left character and increment by 1
                left++;
            }
            set.add(s.charAt(right));                                 // add that character
            maxLength = Math.max(maxLength , right - left +1);        // calculate the maxLength -> FORMULA : right - left +1
        }
        return maxLength;
    }
}
