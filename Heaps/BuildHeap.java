package ChatGPT_Problems.Heap;

import java.util.ArrayList;

public class BuildHeap {
    public static void main(String[] args) {

        int[] arr = {4,40,6,8,9,12,6,7,50};
        Heap h = new Heap(arr);

        System.out.println("Before BuildHeap");
        h.printHeap();

        h.buildHeap();

        System.out.println("After BuildHeap");
        h.printHeap();

    }
    static class Heap{
        ArrayList<Integer> heap = new ArrayList<>();

        // constructor
        public Heap(int[] arr){
            for(int num : arr){
                heap.add(num);
            }
        }
        // build heap
        public void buildHeap(){
            for(int i = (heap.size() -1) ; i>=0 ; i--){
                heapifyDown(i);
            }
        }

        public void heapifyDown(int current) {

            while (true) {
                int left = 2 * current + 1;
                int right = 2 * current + 2;

                int smallest = current;

                // check left child
                if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
                    smallest = left;
                }

                // check right child
                if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
                    smallest = right;
                }

                if (smallest == current) {
                    break;
                }

                // Swap
                int temp = heap.get(current);
                heap.set(current, heap.get(smallest));
                heap.set(smallest, temp);

                current = smallest;
            }
        }
        public void printHeap(){
            System.out.println(heap);
        }

    }
}
