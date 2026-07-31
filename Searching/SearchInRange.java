package DSA;

public class SearchInRange {
    public static void main(String[] args) {

        int[] nums = {2,4,6,9,5,45,3,67};
        int target = 4;

        System.out.println(linearSearch(nums, target , 1,3));
    }
    static int linearSearch(int[] arr, int target , int start , int end) {

        if (arr.length == 0) {
            return -1;
        }

        for (int i = start; i < end; i++) {
            int element = arr[i];
            if (element == target) {
                return i;
            }
        }
        return -1;
        }
}
