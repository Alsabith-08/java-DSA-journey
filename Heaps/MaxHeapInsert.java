package ChatGPT_Problems.Heap;

import java.util.ArrayList;

public class MaxHeapInsert {
    public static void main(String[] args) {
       Heap heap = new Heap();

        heap.insert(20);
        heap.insert(15);
        heap.insert(25);
        heap.insert(80);
        heap.insert(60);
        heap.insert(10);
        heap.insert(6);

        heap.printHeap();
    }

    static class Heap{
        ArrayList<Integer> heap = new ArrayList<>();

        public void insert(int value){
            // add at last in array
            heap.add(value);

            // Find the index of inserted value
            int current = heap.size() -1;

            // current is less than 0 , suppose there is no parent of that value so nothing to do.
            while(current > 0){

                // Parent Formula = (i -1) /2
                int parent = (current -1) /2;

                // if current is greater than its parent then swap it
                if(heap.get(current) > heap.get(parent)){

                    // swap
                    int temp = heap.get(current);
                    heap.set(current , heap.get(parent));
                    heap.set(parent , temp);

                    // the current moved to up , so compare with its new parent
                    current = parent;
                }
                else{
                    break;
                }
            }
        }
        // Print heap
        public void printHeap(){
            System.out.println(heap);
        }
    }
}
