
// https://leetcode.com/problems/first-unique-character-in-a-string/description/
// Approach : Counting Freqency
// IDEA : Count each character’s frequency, then return the index of the 
//        first character whose frequency is 1; if none exists, return -1.

// Time Complexity : O(n)     ,  Space Complexity :O(1)

public class FirstUniqueCharacter_387{
    public static void main(String[] args) {
        String s = "leetcodel";

        System.out.println(firstunique(s));
    }
    static int firstunique(String s){
        int[] freq= new int[26];                  // create a freq array of size 26

        for(int i = 0; i<s.length() ; i++){      // count the freqency of each character
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {    // check if the character frequency is 1 return it by checking from begin
            if(freq[s.charAt(i) -'a'] == 1){
                return i;
            }
        }
        return -1;                                // otherwise , return -1
    }
}
