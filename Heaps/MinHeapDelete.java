import java.util.ArrayList;

public class MinHeapDelete {
    public static void main(String[] args) {
        int[] arr = {9,4,7,1,3,6,2};

        Heap h = new Heap(arr);

        System.out.println("Before Built Heap");
        h.printHeap();

        h.buildHeap();

        System.out.println("After Built Heap");
        h.printHeap();

    }
    static class Heap{
        ArrayList<Integer> heap = new ArrayList<>();

        // Constructor
        public Heap(int[]arr){
            // copy all elements into the ArrayList
            for(int num : arr){
                heap.add(num);
            }
        }

        // Build the Min Heap
        public void buildHeap(){
            // start from the last non-leaf node
            for (int i = (heap.size())/2; i >= 0 ; i--) {
                heapifyDown(i);
            }
        }

        // Heapify Down
        public void heapifyDown(int current){

            while(true){
                int left = 2 * current + 1;
                int right = 2 * current + 2;

                int smallest = current;

                // Check left child
                if(left < heap.size() && heap.get(left) < heap.get(smallest)){
                    smallest = left;
                }

                // check right child
                if(right < heap.size() && heap.get(right) < heap.get(smallest)){
                    smallest = right;
                }

                // Heap property satisfied
                if(smallest == current){
                    break;
                }

                // swap
                int temp = heap.get(current);
                heap.set(current , heap.get(smallest));
                heap.set(smallest , temp);

                current = smallest;
            }
        }
        // Print heap
        public void printHeap(){
            System.out.println(heap);
        }
    }
}

