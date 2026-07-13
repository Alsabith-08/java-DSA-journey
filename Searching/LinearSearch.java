
//Time Complexity : O(n)
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,8};
        int target = 8;

        System.out.println(linearSearch(arr , target));
    }
    static int linearSearch(int[] arr , int target){
        // Traverse the whole array if i == target return i  , then -1
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

}
