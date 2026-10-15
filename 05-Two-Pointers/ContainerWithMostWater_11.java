
// https://leetcode.com/problems/container-with-most-water/description/
// Approach / Pattern : Two Pointers
// IDEA : use pointers ,maxWater variable
//        first and last index (basically)  , maxwater inintially 0
//        update maxwater with (maxwater or minimum of left/right * right-1)
//        move pointer based on which pointer has minimum value is left (+1) , is right(-1)

// Time Complexity : O(n)    , Space Complexity : O(1)

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxWater(nums));
    }
    static int maxWater(int[] nums){
        int left = 0;                            // use two pointers and one variable(maxwater)
        int right = nums.length -1;
        int maxwater = 0;

        while(left < right){                     // terminate condition
            maxwater = Math.max(maxwater , (right - left ) *Math.min(nums[left] , nums[right]));            // update maxwater -> pick maxValue from 
                                                                             //maxwater or calculate width(right -left) multiply(*) pick min value on left/right
            if(nums[left] < nums[right]){                 // move left +1 if left is minimum
                left++;                                   // otherwise , right -1 
            }else{
                right--;
            }
        }
        return maxwater;
    }
}
