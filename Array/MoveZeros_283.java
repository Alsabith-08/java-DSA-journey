package LeetCodeEx.Arrays;

/* two pointers Approach :
     we use a variable called insertPos
     this position where the next non-Zero element should be placed
     initially, insertPos  = 0
     if we found non-zero num : add to insertPos and move to nextIndex(increment)
*/

import java.util.Arrays;

public class MoveZeros_283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,1,2};
        moveZeros(nums);

        System.out.println(Arrays.toString(nums));
    }
    static void moveZeros(int[] nums){

        int insertPos = 0;

        // move all non- Zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        // fill remaining positions with zero
        while(insertPos < nums.length){
            nums[insertPos] = 0;
            insertPos++;
        }
    }
}
