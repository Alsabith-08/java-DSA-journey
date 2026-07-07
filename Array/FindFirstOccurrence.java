package ChatGPT_Problems;

public class FindFirstOccurrence {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,4,4,6,7,8};
        int element = 4;

        System.out.println(findFirst(arr , element));
    }
    static int findFirst(int[] arr , int element){

        int low = 0;
        int high =arr.length -1;
        int first  = -1;

        while(low <= high){

            int mid = low + (high -low) /2 ;

            if(arr[mid]  == element){
                first = mid;
                high = mid-1;
            }else if(arr[mid] < element){
               low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return first;
    }
}
