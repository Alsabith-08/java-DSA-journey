package LeetCodeEx.TwoPointers;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
// Approach : Two Pointers
// IDEA :  check fast pointer not equal to val , put the fast element into slow element and move slow +1
//         otherwise move fast , return slow (after removing remaining elements)

// Time Complexity :O(n)    , Space Complexity: O(1)

public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        System.out.println(removeEle(nums , val));
    }
    static int removeEle(int[] nums , int val){
        int slow = 0;                                    // initially both pointers are same direction
        int fast = 0;

        while(fast < nums.length){                       // move slow when the fast is not value and before moving,
                                                          // put the fast value to slow value
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }                                          // otherwise , move fast +1
            fast++;
        }
        return slow;                                  // return slow , because after removing that element  how many element are there
    }
}
