/*  Basic Problems in BinarySearch
  1. Implement Binary Search (Iterative).
  2. Implement Binary Search (Recursive).
  3. Find the first occurrence of a target in a sorted array.
  4. Find the last occurrence of a target in a sorted array.
  5. Count the number of occurrences of a target in a sorted array.
  */
public class BinarySearchBasicProblems {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1,5,7,8,9,13,13};

        // print the iterative Method
        System.out.println("Using Iterative :"+iterative(arr, 9));

        // print the recursion method
        System.out.println("Using Recursion : "+recursion(arr ,9 , 0 , arr.length));

        // print the first occurrence
        System.out.println("First Occurrence Of A Target :"+firstOccurrence(arr , 1));

        // print the lastOccurrence
        System.out.println("Last Occurrence Of A target :"+lastOccurrence(arr , 1));

        // print countOccurrence
        System.out.println("Count Occurrence of A Target : "+ countOccurrence(arr , 1) );
    }

    // 1. Binary Search Using Iterative
    public static int iterative(int[] arr , int target){
        // initial position
        int start = 0;
        int end = arr.length -1;

        while(start <= end){
            int mid = start + (end-start) / 2;

            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }

    // 2. BinarySearch Using Recursion
    static int recursion(int[] arr , int target , int start , int end ){

        // Base Condition
        if(start > end){
            return -1;
        }

        // Find the mid
        int mid = start + (end -start) /2;

        if(arr[mid] == target) {
            return mid;
        }

        if(arr[mid] < target){
            return recursion(arr , target , mid+1 , end);
        }

        return recursion(arr , target , start , mid -1);
    }

    // 3. find the first occurrence of a target
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

    // 4. find the last Occurrence of a target
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

    // 5. Count the no.of Occurrence of a target
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
