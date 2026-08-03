package ChatGPT_Problems.Arrays;

public class CountTheOccurrenceOfTarget {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,5,6,7,8,9};
        System.out.println(countOccurrence(arr  , 1));
    }
    static int firstOccurrence(int[] arr , int target){
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(arr[mid] == target){
                ans = mid;
                end = mid -1; // Search left
            }else if(arr[mid] < target){
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        return ans;
    }

    static int lastOccurrence(int[] arr , int target){
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while(start <=end){
            int mid = start + (end -start) /2;

            if(arr[mid] == target){
                ans = mid;
                start = mid +1;
            }else if(arr[mid] < target){
                start = mid +1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }

    static int countOccurrence(int[] arr , int target){
        // Formula : last - first +1
        int start = 0;
        int end = arr.length -1;

        int first = firstOccurrence(arr , target);

        if(first == -1){
            return 0;
        }
        int last = lastOccurrence(arr , target);

        return last - first + 1;
    }
}
