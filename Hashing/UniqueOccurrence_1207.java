package LeetCodeEx.Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/unique-number-of-occurrences/description/
/*
   Given an array of integers arr, return true if the number of occurrences
   of each value in the array is unique or false otherwise.
 */
public class UniqueOccurrence_1207 {

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,3};

        System.out.println(uniqueOccurr(arr));
    }
    static boolean uniqueOccurr(int[] arr){

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num  : arr){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        // set
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
