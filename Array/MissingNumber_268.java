
// https://leetcode.com/problems/missing-number/description/

import java.util.Arrays;

public class MissingNumber_268 {
    public static void main(String[] args) {
        int[] nums = {2,3,0,1};

        System.out.println("Array :" + Arrays.toString(nums));

        int result = missingNum(nums);
        System.out.println("Missing Number :" + result);

        int result1 = missingNumber(nums);
        System.out.println("Missing Number :"+result1);
    }

    // XOR Rules - O(n)
    static int missingNum(int[] nums){
        // initialize xor
        int xor = nums.length;

        for (int i = 0; i <nums.length ; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor;
    }

    // using sort - O(n log n)
    static int missingNumber(int[] nums){
        Arrays.sort(nums);

        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }
}
