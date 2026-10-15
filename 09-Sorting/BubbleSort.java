import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
       int[] arr = {1,2,3,4,5,6};

       bubbleSort(arr);
       System.out.println(Arrays.toString(arr));
    }
    static void bubbleSort(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
              int didSwap =0;   // in the first pass it didn't swap , the array is already sorted
            for (int j = i; j < arr.length -i-1 ; j++) {
                
                if(arr[j] > arr[j+1]){
                    // Swap
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    didSwap = 1;
                }
            }
            if(didSwap ==0) {
                break;
            }
        }
    }
}
