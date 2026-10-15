
import java.util.Arrays;

public class SearchIn2Darray {
    public static void main(String[] args) {
        int [][] arr = {
                {2,3,6},
                {23,7,94,67},
                {3,78,54,23},
                {78,98,54}
        };

        int target = 98;
        int[] ans = search(arr , target);
        System.out.println(Arrays.toString(ans));

    }
    static int[] search(int[][]arr , int target){

        for(int row = 0 ; row< arr.length ; row++){

            for(int col=0 ; col<arr[row].length ; col++ ){

                if (arr[row][col] == target) {
                    return new int[]{row,col};
                }
            }
        }
        return new int[] {-1,-1};
    }
}
