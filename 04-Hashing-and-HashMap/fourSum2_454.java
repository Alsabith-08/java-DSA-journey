package LeetCodeEx.Hashing;

// https://leetcode.com/problems/4sum-ii/description/
// Pattern : HashMap + Complement
// IDEA : Store the frequencies of all pair sums from the first two arrays, 
//        then count matching opposite sums from the remaining two arrays.

// Time Complexity ; O(n*2)    , Space Complexity : O(n*2)

import java.util.*;


public class fourSum2_454 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        System.out.println(fourSum(nums1 , nums2 , nums3 , nums4));
    }
    static int fourSum(int[] nums1 , int[] nums2 , int[] nums3, int[] nums4){
        HashMap<Integer , Integer > map = new HashMap<>();                       // create a hashMap

        for (int i = 0; i < nums1.length; i++) {                                // traverse first two array and add sum on map with its frequency
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];

                map.put(sum , map.getOrDefault(sum, 0) +1);
            }
        }

        int count = 0;

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {                       // traverse remaining two array and find the sum of complement of becomes 0
                int sum = nums3[i] + nums4[j];
                int target = -sum;

                count += map.getOrDefault(target, 0);                      // increase the count when there are becomes 0
            }
        }
       return count;
    } 
}
