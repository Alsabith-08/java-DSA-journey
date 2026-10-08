package LeetCodeEx.TwoPointers;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
// Approach : Two Pointers
// IDEA : pointer - k (initially 2) , start from 2nd index , for each traverse check the current element to k-2
//        if not equal replace the current index to k, then move k+1

// Time Complexity : O(n)      , Space Complexity  : O(1)
public class RemoveDuplicate2_80 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};

        System.out.println(removeDupli(nums));
    }
    static int removeDupli(int[] nums){
        int k = 2;                                           // initially pointer points to 2 index ,because we check if element occur
                                                             // more than 2 times we make exact 2 , remaining occurrence should be removed
        for (int i = 2; i < nums.length; i++) {              //traverse from index 2
            if(nums[i] != nums[k-2]){                        // check if current index != current index -2
                nums[k]= nums[i];                            // put the current element to current index -2 , then move k
                k++;
            }
        }
        return k;                                         // return k , because after removing duplicate print the length of an array
    }
}
