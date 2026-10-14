package LeetCodeEx.Hashing;

// https://leetcode.com/problems/ransom-note/
// Approach : Frequency Counting
// IDEA :Count each character in magazine using a frequency array,
//       then check and decrement the frequency for every character in ransomNote
//       return false if any required character is unavailable.

// Time Complexity : O(n+m)      , Space Complexity :O(1)  - fixed array
public class RansomNote_383 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(canConstruct(ransomNote , magazine));
    }
    static boolean canConstruct(String ransomNote , String magazine){

        if(ransomNote.length() > magazine.length()){                 // first check length of magazine length that must be greater then ransomNote
            return false;
        }
        int[] freq = new int[26];                                   // create frequency Array of size 26(Alphabet characters)

        for (int i = 0; i < magazine.length(); i++) {              // count the frequency of magazine letters/characters
             char ch = magazine.charAt(i);
             freq[ch -'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {           // check that ransomNote character that must in freq array , if not return false
            char ch = ransomNote.charAt(i);

            if(freq[ch -'a'] == 0){
                return false;
            }
            freq[ch - 'a']--;                                   // if contains decrement the count of that character
        }
        return true;                                           // return true
    }
}
