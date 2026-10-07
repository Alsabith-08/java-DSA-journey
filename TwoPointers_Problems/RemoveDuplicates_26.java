package LeetCodeEx.TwoPointers;


// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
// Approach : Two pointers
// NOTE : don't use any extra space make in in-place Algorithm

// IDEA : both pointers are on 0 index (slow , fast)
//        if both values are not equal move slow +1 and replace slow value with fast value
//        otherwise , move fast +1

// Time Complexity : O(n)       , Space Complexity : O(1)

import java.util.Arrays;

public class RemoveDuplicates_26 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};           // return the unique elements count

        System.out.println(removeDup(nums));
    }
    static int removeDup(int[] nums){
        int slow = 0;                                // initially both pointers are same direction
        int fast = 0;

        while(fast != nums.length){                // terminated condition
            if(nums[slow] != nums[fast]){          // check is not duplicate (not a same value)  , otherWise -> move fast +1
                slow++;                            // move slow ++   , and replace slow with fast value
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;                           // return slow+1  because slow is index , so +1
    }
}
