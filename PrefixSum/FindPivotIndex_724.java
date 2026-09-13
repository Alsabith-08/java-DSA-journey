package LeetCodeEx.PrefixSum;

/*
   https://leetcode.com/problems/find-pivot-index/description/

  Given an array of integers nums, calculate the pivot index of this array.

  The pivot index is the index where the sum of all the numbers strictly to the left
  of the index is equal to the sum of all the numbers strictly to the index's right.

  If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left.
  This also applies to the right edge of the array.

  Return the leftmost pivot index. If no such index exists, return -1.
*/

public class FindPivotIndex_724 {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};

        System.out.println(findPivot(nums));
    }
    static int findPivot(int[] nums){

        int rightSum = 0;
        for(int num : nums){           // first find the total sum
            rightSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i <nums.length ; i++) {

            // update the right sum
            rightSum -= nums[i];

            // check the both side sum
            if(leftSum == rightSum){
                return i;
            }

            // update the left sum
            leftSum += nums[i];
        }
        return -1;
    }
}
