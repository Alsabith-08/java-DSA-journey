//https://leetcode.com/problems/increasing-triplet-subsequence/description/

import org.w3c.dom.ls.LSOutput;

public class IncreasingTripletSunSequence_334 {
    public static void main(String[] args) {


        int[] nums = {1,1,3,2,5,7};

        boolean result = increaseTriplet(nums);
        System.out.println(result);
    }
    static boolean increaseTriplet(int[] nums){

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int num : nums){

            // found a smaller first value
            if(num <= first){
                first = num;
            }

            // found a better second value
            else if(num <= second){
                second = num;
            }

            // num is greater than both first and second
            else{
                return true;
            }
        }
        return false;
    }
}
