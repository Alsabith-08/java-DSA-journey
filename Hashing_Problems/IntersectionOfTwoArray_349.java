
// https://leetcode.com/problems/intersection-of-two-arrays/description/
// Approach : HashSet
// IDEA : add all element of nums1 on set then create a list 
//        check nums2 elements is present in set and not in list
//        if these condition satisfy add to list and return

// Time Complexity : O()      , Space Complexity : O()

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoArray_349 {
    public static void main(String[] args) {
         int[] nums1 = {1,2,2,1};
         int[] nums2 = {2,2};

         int[] ans = interofArray(nums1 , nums2);

        System.out.println(Arrays.toString(ans));
    }
    static int[] interofArray(int[] nums1 , int[] nums2){
        HashSet<Integer> set = new HashSet<>();                          // create a set

        List<Integer> result = new ArrayList<>();                        // create a list

        for(int num : nums1){                                            // add nums1 element on set
            set.add(num);
        }
 
        for(int num : nums2){                                           // traverse all elements of nums2
            if(set.contains(num) && !result.contains(num)){             // check that element present on set and not in list then add to list
                result.add(num);
            }
        }
        int[] ans = new int[result.size()];                             // convert that list to array

        for (int i = 0; i <result.size() ; i++) {
            ans[i] = result.get(i);
        }
        return ans;                                                     // return it
    }
}
