
//Time Complexity : O(log n)
public class BinarySearch_iterative {
    public static void main(String[] args) {
        int[] arr = {2,5,7,8,12,15};
        int target = 12;

        System.out.println(binarySearch(arr , target));
    }
    static int binarySearch(int[] arr , int target){

        int start = 0;
        int end = arr.length -1;

        while(start < end){

            int mid  = start + (end -  start) / 2;

            if(arr[mid] == target) {
                return  mid;
            }else if(arr[mid] < target){
                start = mid +1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }
}


