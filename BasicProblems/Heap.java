/*  Basic Problems of Heap

   1. Build a Max Heap from an array.     -O(n)           (12 - 67)
   2. Insert an element into a Max Heap.  -O(log n)       (140- 159)
   3. Delete the root from a Max Heap.    -O(log n)       (172 - 183)
   4. Display the Heap                    -O(n)           (163 - 168)
   5. Implement Heap Sort.                -O(n log n)     (91 - 105)
   6. Find the Kth Largest Element.       -O(n + k log n) (187 -204)

     */

public class Heap {
    public static void main(String[] args) { //----------------------------Main --------------------------------------------------
        
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

  //-------------------------------------------------  Build MaxHeap------------------------------------------------
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
   //--------------------------------------- ignore this part for buildHeap code -----------------------------------------
   //Call the class
        MaxHeapOperations heap = new MaxHeapOperations();

        heap.insert(12);
        heap.insert(32);
        heap.insert(54);
        heap.insert(23);
        heap.insert(65);

        System.out.println("\nMax Heap Operations : ");
        System.out.println("\nAfter Insert ");
        heap.display();

        // Call the KthLargest function
        heap.KthLargest(heap.heap, 3);

        System.out.println("\nAfter Delete ");
        heap.deleteRoot();
        heap.display();
    }
//-----------------------------------------------------------HeapSort------------------------------------------

    static void heapSort(int[] arr){
        int n = arr.length;

        for(int i= n/2 -1 ; i>= 0 ; i--){
            heapify(arr ,n, i);
        }

        for(int i = n-1 ; i>=0 ; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr , i , 0);
        }
    }

//------------------------------------------ MaxHeap Operations : insert , deleteRoot , heapSort , find the Kth Largest Element ------------------------------------------------------------

    static class MaxHeapOperations{
        int[] heap = new int[20];
        int size = 0;


// Satisfied The MaxHeap Property

        public void heapify1(int i){
            int largest = i;
            int left = 2 *i +1;
            int right = 2 * i +2;

            if(left < size && heap[left] > heap[largest]){
                largest = left;
            }
            if(right < size && heap[right] > heap[largest]){
                largest = right;
            }

            if(largest != i){

                int temp = heap[i];
                heap[i] = heap[largest];
                heap[largest] = temp;

                heapify1(largest);
            }
        }

//---------------------------------------------------- Insert Function--------------------------------------------

        public void insert(int value){
            heap[size] = value;
            int current = size;

            while(current > 0){

                int parent = (current -1)/2;

                if(heap[current] > heap[parent]){
                    int temp = heap[current];
                    heap[current] = heap[parent];
                    heap[parent] = temp;

                    current = parent;
                }else{
                    break;
                }
            }
            size++;
        }

//-------------------------------------------------------- Display ------------------------------------------------

        public void display(){
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }

//-----------------------------------------------------DeleteRoot Node---------------------------------------------------

        public void deleteRoot(){
            // check is empty
            if(size == 0){
                return;
            }

            // swap the lastNode to RootNode
            heap[0] = heap[size -1];
            size--;                       // Decrease the Size

            heapify1(0);               // then rebuild to satisfy the MaxHeap Property
        }

//------------------------------------------------- Find The Kth Largest Element------------------------------------------

        public void KthLargest(int[] arr , int k ){

            // create an empty the queue                        // Collections.reverseOrder() - decreasing the order
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            // add the elements in queue of reverse order (decreasing order)
            for(int num : arr){
                 maxHeap.add(num);
            }

            // remove the element from the queue till the kth Element
            for (int i = 1; i < k ; i++) {
                maxHeap.poll();
            }

            // then print the root element
            System.out.println(k + " largest element : " + maxHeap.peek());
        }
    }
}
