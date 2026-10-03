package LeetCodeEx.Arrays;

public class MaximumSubArray_53 {
    public static void main(String[] args) {
        int[] nums = {1};

        System.out.println(maxSubArray(nums));
    }
    static int maxSubArray(int[] nums){
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Decide whether to add nums[i] to existing running sum
            // or start a new SubArray fresh from nums[i]
            currentSum = Math.max(nums[i] , currentSum+nums[i]);

            // update the global maximum subArray sum found so far
            maxSum = Math.max(maxSum , currentSum);
        }
        return maxSum;
    }
}
