// https://leetcode.com/problems/longest-consecutive-sequence/description/
// Approach : HashSet
// IDEA : Use a HashSet to count consecutive numbers only when the current number
//        has no predecessor (num - 1), keeping the time complexity O(n) on average.

// Time Complexity : O()     , Space Complexity : O()
import java.util.HashSet;

public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {
        int[] nums = {100, 4 , 200 , 1,3,2};

        System.out.println(longsequence(nums));
    }
    static int longsequence(int[] nums){
    
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){                        // put all value in set , it automatically removes the duplicates
            set.add(num);
        }

        int longest = 0;                            // it will return the longest sequence

        for(int num : set){                     
            if(!set.contains(num-1)){               // check the num-1 in set contains if contains that return true but our condition says !(Sysmbol)  true becomes false
                int length = 1;

                while(set.contains(num + length)){           // count the sequence of values until it fails
                    length++;
                }
                longest = Math.max(longest , length);    // update the longest
            }
        }
        return longest;
    }
    
}
