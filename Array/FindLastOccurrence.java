package ChatGPT_Problems;

public class FindLastOccurrence {
    public static void main(String[] args) {
     int[] arr = {1,2,3,4,4,4,4,6,7,8};
     int element = 4;

        System.out.println(findLast(arr , element));
     }
    static int findLast(int [] arr , int element){

        int start = 0;
        int end = arr.length -1;
        int last =-1;

        while(start <= end){

            int  mid = start + (end - start) /2;

            if(arr[mid] == element){
                last = mid;
                start = mid +1;
            }else if(arr[mid] < element){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return last;
    }
}
