// https://leetcode.com/problems/max-number-of-k-sum-pairs/description/

import java.util.Arrays;

public class MaxNumberOfK_SumPairs_1679 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int k = 5;

        System.out.println("Total Pairs :"+sumPair(nums ,k));
    }
    static int sumPair(int[] nums , int k ){
        // 1. sort an array
        Arrays.sort(nums);

        //2. we use two pointers
        int left = 0;
        int right = nums.length -1;

        int pairs= 0;

        //3.continue until pointers meet
        while(left < right){

            int sum = nums[left] + nums[right];

            // pair found
            if(sum == k){
              pairs++;
              left++;
              right--;
            }
            // sum is too short
            else if(sum < k){
                left++;
            }
            // sum is too large
            else{
                right--;
            }
        }
        return pairs;
    }
}
