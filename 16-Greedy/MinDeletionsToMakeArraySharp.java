
// Q1 - Minimum Deletions To Make Array Sharp
// Pattern - Greedy (Array Traversal)
// IDEA  - delete the minimum number if elements so that adjacent elements 
//         are different and the remaining array has even length

// Time Complexity : O(n)    ,  Space Complexity : O(1)



/* You may delete any number of elements from nums. 
   The remaining elements keep their original order.

   The resulting array a is sharp if the bitwise XOR of every pair of adjacent elements is
   non-zero. That is, a[i] XOR a[i + 1] != 0 for every index i such that 0 <= i < a.length - 1.
   An array with at most one element is sharp.

   Return the minimum number of deletions needed to make nums sharp.

   Bitwise XOR compares the corresponding bits of two integers. 
   A bit in the result is 1 if the corresponding bits differ, and 0 otherwise*/
   

public class MinDeletionsToMakeArraySharp{
    public static void main(String[] args) {
        int[] nums = {1,1,2,2,2,3};

        System.out.println(minDeletion(nums));
    }
    private static int minDeletion(int[] nums){
        int deletions = 0;                      // count variable
        int i = 0;                              // traverse/ check the element of the array

        while(i < nums.length - 1){             // traverse through n - 1 (because we check i+1)
            if(nums[i] == nums[i+1]){           // if i == i+1 then delete it (increase delete count +1) and i (index count)
                deletions++;
                i++;
            }else{                              // other wise , increase index count (+1)
                i++;
            }
        }                                      // return deletions count
        return deletions;
    }
}