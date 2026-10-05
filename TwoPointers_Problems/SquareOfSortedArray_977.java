package LeetCodeEx.TwoPointers;

// https://leetcode.com/problems/squares-of-a-sorted-array/description/
// Approach : Two Pointers
// IDEA : traverse n-1 to 0 , convert values to abs then compare left > right ,square left value  add to result otherwise square
//                            right put it to result

// Time Complexity : O(n)     , Space Complexity O(n)
import java.util.Arrays;

public class SquareOfSortedArray_977 {
    public static void main(String[] args) {
        int[] nums = {-4,-1,2,3,10};

        System.out.println(Arrays.toString(square(nums)));
    }
    static int[] square(int[] nums){
        int left = 0;                                      // initially : left = 0 , right = n-1
         int right = nums.length -1;
         int[] result = new int[nums.length];              // create a empty array of size n

        for (int i = nums.length-1; i >=0 ; i--) {                  // traverse from n-1 to 0 (reverse) -> it gives a sorted
            if(Math.abs(nums[left]) > Math.abs(nums[right])){       // convert both value as absolute  ,compare because negative values
                result[i] = nums[left] * nums[left];                // left > right then , square the left value and put into ith index
                left++;                                             // then move left by +1
            }else{
                result[i] = nums[right] * nums[right];            //otherWise square the right value and put into ith index then move right by -1
                right--;
            }
        }
        return result;
    }
}
