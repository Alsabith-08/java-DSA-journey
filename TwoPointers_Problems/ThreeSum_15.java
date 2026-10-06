
// https://leetcode.com/problems/3sum/description/
// NOTE : no duplicates , three pointers sum is 0 , i!=k , j!= k, i!=j

// Approach / pattern : 3 pointers (i , j , k)
// IDEA : sort the array first ,  fix i pointer on first index , j = i+1 , k on last index
//        traverse and check i's previous is duplicate & j < K
//        calculate total of three pointers value then move pointers by condition

// Time Complexity : O(n2)       , Space Complexity :O(n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> result = sum3(nums);
        System.out.println(result);
    }
    static List<List<Integer>> sum3 (int[] nums){
        List<List<Integer>> res = new ArrayList<>();                // create an empty list of list
        Arrays.sort(nums);                                          // sort an array

        for (int i = 0; i < nums.length; i++) {                     // traverse and check i's previous is duplicate
            if(i> 0 && nums[i] == nums[i-1]){
                continue;
            }

            int j = i+1;                                           // j = i+1 , k = last index
            int k = nums.length -1;

            while(j < k){                                          // terminate condition
                int total = nums[i] + nums[j] + nums[k];           // sum of i , j , k

                if(total > 0){                                     // is greater than 0 move k -1
                    k--;
                }else if(total < 0){                               // is lesser than 0 move j +1
                    j++;
                }else{
                    res.add(Arrays.asList(nums[i] , nums[j] , nums[k]));      // if sum is 0 add to list and j +1
                    j++;

                    while(nums[j] == nums[j-1] && j < k){              // check j == j's previous & j < k and j +1
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
