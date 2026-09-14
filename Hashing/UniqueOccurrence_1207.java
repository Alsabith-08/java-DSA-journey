
/* https://leetcode.com/problems/unique-number-of-occurrences/description/
   Approach : hashMap + HashSet
             (Count Occurrence of Each Character) + (find frequency unique)
   Time Complexity : O(n)          
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueOccurrence_1207 {

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,3};

        System.out.println(uniqueOccurr(arr));
    }
    static boolean uniqueOccurr(int[] arr){

       // Count occurrences
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num  : arr){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        // check frequency are Unique
        Set<Integer> frequency = new HashSet<>();

        for(int num : map.values()){
            if(frequency.contains(num)){
                return false;
            }
            frequency.add(num);
        }
        return true;
    }
}
