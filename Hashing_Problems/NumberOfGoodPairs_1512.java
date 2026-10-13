package LeetCodeEx.Hashing;

// https://leetcode.com/problems/number-of-good-pairs/description/
// Approach : use for two loops
// IDEA : find two equal values, count the pair, and make sure you don't count the same pair twice

// Time Complexity : O(n*2)     , Space Complexity : O(1)

public class NumberOfGoodPairs_1512 {
    public static void main(String[] args) {
        int[] nums ={1,1,1,1};

        System.out.println(goodPairs(nums));
    }
    static int goodPairs(int[] nums){

        int pair = 0;
        for (int i = 0; i <nums.length ; i++) {              // check ith element with all element
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i] == nums[j]){                     // if both elements are equal count +1
                    pair++;
                }
            }
        }
        return pair;
    }
}
