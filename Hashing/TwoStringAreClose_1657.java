package LeetCodeEx.Hashing;

// https://leetcode.com/problems/determine-if-two-strings-are-close/description/

/*
Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
             For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
             For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)

You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */

import java.util.Arrays;
public class TwoStringAreClose_1657 {
    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "bcd";

        System.out.println(findClose(word1 , word2));
    }

    static boolean findClose(String word1 , String word2){

        if(word1.length() != word2.length()){
            return false;
        }

        int fw1[]  = new int[26];
        int fw2[]  = new int[26];

        // Count character
        for(int i= 0; i< word1.length() ; i++){
            fw1[word1.charAt(i)-'a']++;
            fw2[word2.charAt(i)-'a']++;
        }
        // check whether both strings contain same character

        for(int i=0 ; i < 26; i++){
            if (fw1[i] != 0 && fw2[i] == 0 ||
                    fw1[i] == 0 && fw2[i] != 0){
                return false;
            }
        }
        Arrays.sort(fw1);
        Arrays.sort(fw2);
        return Arrays.equals(fw1 , fw2);
    }
}
