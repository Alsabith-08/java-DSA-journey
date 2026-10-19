package Hashing;

// https://leetcode.com/problems/isomorphic-strings/description/
// Approach  : Use two HashMap
// IDEA : Use two HashMaps to ensure every character maps
//        consistently and uniquely in both directions.

// Time Complexity :O(n)  ,  Space Complexity : O(1)
import java.util.HashMap;

public class IsomorphicString_205 {
    public static void main(String[] args) {           // why 2 hashMap ?
        String s = "egg";                              // map1 - s to character in t
        String t = "uas";                              // map2 - t to character in s

        System.out.println(isomorphicStr(s , t));
    }
    private static boolean isomorphicStr(String s , String t){
        HashMap<Character , Character> map1 = new HashMap<>();    // create two hashMap
        HashMap<Character , Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {              // loop through strings
            char ch1 = s.charAt(i);                         // get the current characters
            char ch2 = t.charAt(i);

            if(map1.containsKey(ch1) && map1.get(ch1) != ch2){        // ch1 already in map1 and existing mapping character 
                return false;                                         // doesn't equal to current character
            }

            if(map2.containsKey(ch2) && map2.get(ch2) != ch1){        // reverse mapping
                return false;
            }
            map1.put(ch1 , ch2);                                     // otherwise, store the mapping and finnally return true
            map2.put(ch2 , ch1);
        }
        return true;
    }
}
