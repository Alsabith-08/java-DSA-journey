
//https://leetcode.com/problems/sort-colors/description/

// Approach : Three Pointers
// IDEA : low → position for the next 0
//        mid → current element to check
//        high → position for the next 2

//Time Complexity : O(n)    , Space Complexity :O(1)

import java.util.Arrays;

public class SortColors_75 {
    public static void main(String[] args) {
        int[] nums ={2,0,2,1,1,0};

        sortcolor(nums);

        System.out.println(Arrays.toString(nums));

    }
    static void sortcolor(int[] nums){
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid <= high){                                // condition
            if(nums[mid] == 0){                            // if mid is element is 0 -> swap low and mid and increment both
                int temp = nums[low];
                nums[low++]= nums[mid];
                nums[mid++] = temp;
            }else if(nums[mid] == 1){                     // if mid is 1 nothing to swap because already in crt space , so just increment mid
                mid++;
            }else{
                int temp = nums[mid];                    // otherwise , swap mid and high and decrement high only
                nums[mid] = nums[high];
                nums[high--] = temp;
            }
        }
    }
}
