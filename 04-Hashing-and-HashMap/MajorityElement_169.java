
// https://leetcode.com/problems/majority-element/description/
// Approach : Boyer–Moore Voting Algorithm
// IDEA : increase the count for the same candidate, decrease it for a different element,
//        and choose a new candidate when the count reaches zero.

// Time Complexity : O(n)     , Space Complexity :O(1)

public class MajorityElement_169 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,2,2};

        System.out.println(majorityElement(nums));
    }
    static int majorityElement(int[] nums){          // initially
        int candidate = -1;                          // use two variables : candidate = -1    , votes/count = 0
        int votes = 0;

        for(int num : nums){                         // traverse the array
            if(votes == 0){                          // check the votes is 0 then assign the current element to candidate
                candidate = num;
            }

            if(candidate == num){                   // if next element are equal to candidate increase vote +1
                votes++;
            }else{                                  // otherWise , decrement vote -1
                votes--;
            }
        }
        return candidate;                         // return the candidate   (this must be the majority element of nums/array)
    }
}
