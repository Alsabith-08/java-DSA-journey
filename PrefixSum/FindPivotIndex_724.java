
/*
   https://leetcode.com/problems/find-pivot-index/description/
   Apporach: Prefix Sum
   TimeComplexity : O(n)
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
