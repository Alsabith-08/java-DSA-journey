public class Floor {
    public static void main(String[] args) {
        int[] arr= {-23,-22,-12,0,0,12,23,34,45,56,78,89,99,100};
        int target = 33;

        int ans = binarySearch(arr, target);
        System.out.println(ans);
    }
    // Floor - Greatest element is <= target
    static int binarySearch(int[]arr , int target){

        int start =0;
        int end = arr.length -1;  // total elements= 13 , end= 12

        while(start <=end){    //0 <= 12
            //this total will  extend  the int out of range
            //int mid = start +end/2;

            int mid = start +(end -start) /2;  // mid = 0 + (12-0) / 2 = 6

            if(target < arr[mid]){                      // 23 < 34
                end = mid-1;                          //  end = 6-1 , end = 5
            }else if(target > arr[mid]){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return end;
    }

}
