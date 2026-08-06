/*  Basic Problems of Heap
   1. Build a Max Heap from an array.
   2. Insert an element into a Max Heap.
   3. Delete the root from a Max Heap.
   4. Implement Heap Sort.
   5. Find the Kth Largest Element.
    */

public class Heap {
    public static void main(String[] args) {
        
        int[] arr= {10,20,15,30,40};

        System.out.println("Before buildHeap");
        for(int x : arr){
            System.out.print( x + " ");
        }
        buildHeap(arr);

        // Print the heap after buildHeap
        System.out.println("\nAfter buildHeap");
        for(int x: arr){
            System.out.print( x+ " ");
        }
    }

    // Build MaxHeap
    static void buildHeap(int[] arr){
        int n = arr.length;

        // Find the last non-leaf Node formula : n / 2 -1
        for(int i = n / 2 -1 ; i>= 0 ; i--){
            heapify(arr , n , i);
        }
    }

    static void heapify(int[] arr ,int n , int i){

        int largest = i;

        int left = 2 * i + 1;      // Left Formula : 2* i +1
        int right = 2 * i + 2;   // right Formula : 2* i +2

        // Check left is less than arraySize and left is greater than the largest , put into largest
        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }

        // Check right is less than arraySize and left is greater than largest , put into largest
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }

        // check the maxHeap property - child is larger than the current node
        if(largest != i){

            // Swap them
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr , n , largest);
        }
    }
}
