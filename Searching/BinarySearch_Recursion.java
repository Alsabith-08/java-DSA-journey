//Time Complexity : O(log n)

public class BinarySearch_Recursion {
    public static void main(String[] args) {
        int[] arr = {2,5,7,8,12,15};
        int target = 12;

        System.out.println(binarySearch(arr , target, 0,arr.length));
    }
    static int binarySearch(int[] arr , int target , int start , int end) {

        // Base Condition
        if(start > end){
            return -1;
        }
        // Find mid
        int mid  = start + (end - start) / 2;

        if(arr[mid]  == target){
            return mid;
        }

        if(arr[mid] > target){
            return binarySearch(arr , target , start , mid -1);
        }

        return binarySearch(arr , target , mid +1 , end);
    }

}
