package LeetCodeEx.Arrays;

import java.util.ArrayList;
import java.util.List;

public class GreatestNumberOfCandies_1431 {

    public static void main(String[] args) {

        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;

       List<Boolean> result = KidsWithCandies(candies , extraCandies);
        System.out.println(result);
    }

    static List<Boolean> KidsWithCandies(int[] candies , int extraCandies){

        // find the maximum no of candies
        int maxCandies = 0;

        for(int candy : candies){
            maxCandies = Math.max(maxCandies , candy);
        }

        // check each kids
        List<Boolean> result = new ArrayList<>();

        for (int candy : candies){
            if(candy + extraCandies >= maxCandies){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }
}
