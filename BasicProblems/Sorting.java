/*
  Basic Sorting Problems
  
  1. Bubble Sort
  2. Selection Sort
  3.Insertion Sort
  4. Sort an array in ascending order
  5. Sort an array in descending order
  
*/
import java.util.Arrays;

public class SortingBasicProblems {
    public static void main(String[] args) {

        int[] arr = {1,4,6,8,9,2,1};

        // call the BubbleSort Method
        bubbleSort(arr);
        System.out.println("Bubble Sort :"+Arrays.toString(arr));


        // call the selectionSort Method
        selectionSort(arr);
        System.out.println("Selection Sort :"+Arrays.toString(arr));

        // call the insertionSort Method
        insertionSort(arr);
        System.out.println("Insertion Sort :"+Arrays.toString(arr));

        // call the ascending Method
        ascending(arr);
        System.out.println("Ascending Order :"+Arrays.toString(arr));

        // call the descending Method
        descending(arr);
        System.out.println("Descending Order : "+Arrays.toString(arr));
    }

    // 1. Bubble Sort - time Complexity : O(n^2)
    static void bubbleSort(int[] arr){

        for (int i = 0; i <arr.length; i++) {
            // if the array is already sorted nothing to traverse the whole element
            int didSwap = 0;
            for (int j = 0; j < arr.length-i-1; j++) {

                if(arr[j] > arr[j+1]){

                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // for the first pass is no elements to swap then break it
                    didSwap =1;
                }
            }
            if(didSwap == 0){
                break;
            }
        }
    }

    // 2. Selection Sort - time Complexity - O(n^2)
    static void selectionSort(int[] arr){

        for (int i = 0; i <arr.length ; i++) {

            int min = i;

            for (int j = i+1; j < arr.length; j++) {
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    // 3. insertion Sort - time Complexity - O(n^2)
    static void insertionSort(int[] arr){
        for (int i = 0; i < arr.length -1; i++) {

            for (int j = i+1; j > 0 ; j--) {

                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else{
                    break;
                }
            }
        }
    }
    // 4. Sort the array in ascending order - Time Complexity - O(n^2)
    static void ascending(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {

            for (int j = i+1; j < arr.length; j++) {

                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    // Sort the Array in descending Order - Time Complexity - O(n^2)
    static void descending(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {

            for (int j = i+1; j < arr.length; j++) {

                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
