package LeetCodeEx.TwoPointers;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
// NOTE : Sorted and 1-indexing based array
// IDEA : Two Pointers : one is starting index another one is last index
//                       and both value , if lesser than target move left(++) ,if greater than target move right(--)

// Time Complexity : O(n) , Space Complexity : O(1)

import java.util.Arrays;

public class TwoSum2_167 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum2(nums , target)));
    }

    static int[] twoSum2(int[] nums , int target){

        int left = 0;
        int right = nums.length -1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[left] + nums[right] == target ){
                return new int[]{left+1 , right+1};
            }else if (nums[left] + nums[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return new int[]{};
    }
}
