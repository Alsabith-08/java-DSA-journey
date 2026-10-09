
// https://leetcode.com/problems/boats-to-save-people/description/
// Approach : Two Pointers
// IDEA : Sort the people weight,
//        two pointers i,j one from first index , last index
//        add both weights is less move i +1
//        otherwise move j -1 and increment boat count +1

// Time Complexity : O(n log n) , Space Complexity : O(log n)

import java.util.Arrays;

public class BoatsToSavePeople_881 {
    public static void main(String[] args) {
        int[] peoples = {3,2,2,1};
        int limit = 3;

        System.out.println(maxBoat(peoples , limit));

    }
    static int maxBoat(int[] peoples , int limit){
        int boats = 0;                                  // boat_Count = 0 initially
        Arrays.sort(peoples);                           // sort the array of peoples

        int i = 0;                                      // i = 0 , j = n-1
        int j = peoples.length-1;

        while(i <= j){
            if(peoples[i] + peoples[j] <= limit){      // add both value check is less than with limit
                i++;                                   // if less than move i pointer +1
            }
            j--;                                       // otherWise , move j pointer -1 and boat_count +1
            boats++;
        }
        return boats;                                 // return boats
    }
}
