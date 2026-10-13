package LeetCodeEx.Hashing;

// https://leetcode.com/problems/intersection-of-two-arrays/description/
// Approach : HashSet
// IDEA :

// Time Complexity : O()      , Space Complexity : O()

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArray_349 {
    public static void main(String[] args) {
         int[] nums1 = {1,2,2,1};
         int[] nums2 = {2,2};

         int[] ans = interofArray(nums1 , nums2);

        System.out.println(Arrays.toString(ans));
    }
    static int[] interofArray(int[] nums1 , int[] nums2){
        HashSet<Integer> set = new HashSet<>();

        List<Integer> result = new ArrayList<>();

        for(int num : nums1){
            set.add(num);
        }

        for(int num : nums2){
            if(set.contains(num) && !result.contains(num)){
                result.add(num);
            }
        }
        int[] ans = new int[result.size()];

        for (int i = 0; i <result.size() ; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
