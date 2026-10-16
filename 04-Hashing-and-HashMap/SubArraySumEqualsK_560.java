
// https://leetcode.com/problems/subarray-sum-equals-k/description/
// Approach : prefix Sum + hashMap
// IDEA :Use Prefix Sum + HashMap to count previous prefix sums equal to currentSum - k,
//       finding all continuous subarrays whose sum equals k.

// Time Complexity : O(n)          , Space Complexity : O(n)
import java.util.HashMap;

public class SubArraySumEqualsK_560 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k= 3;

        System.out.println(maxSubArray(nums , k));
    }
    static int  maxSubArray(int[] nums , int k){
        HashMap<Integer , Integer> map = new HashMap<>();

        map.put(0 , 1);                           // initially add this key value in map

        int sum = 0;                              // sum - calculate the num of subarray
        int count = 0;                            // count - used to how many subarray sum equal to k 

        for(int num: nums){                       // traverse and sum one by one
            sum += num;

            int required = sum -k;                // find the required number equal to sum

            count += map.getOrDefault(required , 0);      // count it if its equal to sum

            map.put(sum  , map.getOrDefault(sum , 0)+1);     // add it to map
        }
        return count;
    }
}
