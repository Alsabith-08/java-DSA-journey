package ChatGPT_Problems.Heap;

import java.util.ArrayList;
import java.util.Arrays;


public class HeapSorting {
    public static void main(String[] args) {

        int[] arr = {10, 30,20,50,40};
        HeapSort.heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }
    static class HeapSort{

        static  void heapifyDown(int[] arr , int size , int index){

            while(true) {
                int largest = index;
                int left = 2 * index + 1;
                int right = 2 * index + 2;

                if(left < size && arr[left] > arr[largest]){
                    largest = left;
                }

                if(right < size && arr[right] > arr[largest]){
                    largest = right;
                }

                if(largest == index){
                    break;
                }

                int temp = arr[index];
                arr[index] = arr[largest];
                arr[largest] = temp;

                index = largest;
            }
        }

        static void buildHeap(int[] arr){
            int n = arr.length;

            for(int i = n/2 - 1 ; i>=0 ; i--){
                heapifyDown(arr , n ,i);
            }
        }

        public static void heapSort(int[] arr){
            int n = arr.length;
            buildHeap(arr);

            for(int i = n-1 ; i >=0 ; i--){
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapifyDown(arr , i, 0);
            }
        }
    }
}
