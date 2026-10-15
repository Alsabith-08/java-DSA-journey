package LeetCodeEx.Hashing;

//https://leetcode.com/problems/group-anagrams/description/
// Approach : Hashmap
// IDEA : Sort each word to get a common key and group anagrams using a HashMap.

// Time Complexity : O(n.k log K)   , Space Complexity : O(nk)    -> n - no.of.words     , K - word length

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {
    public static void main(String[] args) {
        String[] s = {"eat","tea","tan","ate","nat","bat"};

        System.out.println(group(s));
    }
    static List<List<String>> group(String[] s) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : s){                         // traverse each word
            char[] ch = word.toCharArray();           // convert into char array and sort
            Arrays.sort(ch);
            String key = new String(ch);             // use that word as a key

            if(!map.containsKey(key)){              // add word to the list of that key
                map.put(key , new ArrayList<>());
            }
            map.get(key).add(word);
        }
       return new ArrayList<>(map.values());      // return all grouped lists using map.values()
    }
}
