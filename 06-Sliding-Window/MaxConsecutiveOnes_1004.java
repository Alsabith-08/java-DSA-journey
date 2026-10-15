
// Leetcode - 1004
// https://leetcode.com/problems/max-consecutive-ones-iii/description/
// solved using Slidng Window - O(n)

public class MaxConsecutiveOnes_1004 {
    public static void main(String[] args) {

        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k  = 2;

        System.out.println(longestOnes(nums, k));
    }
    static int longestOnes(int[] nums , int k){

        int left = 0;
        int zeros = 0;
        int maxLength = 0;

        // if current element is 0 , increase the zero count
        for(int right = 0 ; right < nums.length; right++){
            if(nums[right] == 0){
                zeros++;
            }

            // Too many Zeros -> move left
            while(zeros > k){
                if(nums[left] == 0){
                    zeros--;
                }
                left++;
            }
            // calculate the current length
            int length = right - left +1;

            // update the maximum current length
            maxLength = Math.max(length , maxLength);
        }
        return maxLength;
    }
}
