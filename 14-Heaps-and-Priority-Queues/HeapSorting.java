
// flow 
/* Normal Array
       |
   Build Max Heap
       |
   Swap Root <-> Last
       |
   Reduce Heap Size
       |
   Heapify Dowm
       |
   Repeat Until one element remains
       |
   Sorted Array
*/
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
                // left child
                int left = 2 * index + 1;
                // right child
                int right = 2 * index + 2;
                // compare left child
                if(left < size && arr[left] > arr[largest]){
                    largest = left;
                }
                // compare right child
                if(right < size && arr[right] > arr[largest]){
                    largest = right;
                }
                // heap Already correct
                // if the parent is still the largest
                // no swap is needed
                if(largest == index){
                    break;
                }
                // Normal swap
                int temp = arr[index];
                arr[index] = arr[largest];
                arr[largest] = temp;
                // continue Downward
                // Move to the child
                // continue fixing
                index = largest;
            }
        }
        // convert a normal array into Max Heap
        static void buildHeap(int[] arr){
            int n = arr.length;

            for(int i = n/2 - 1 ; i>=0 ; i--){
                heapifyDown(arr , n ,i);
            }
        }
        // Main sorting function 
        public static void heapSort(int[] arr){
            
            int n = arr.length;
            buildHeap(arr);
            //Each time, the root(largest element) 
            // moves to the end
            for(int i = n-1 ; i >=0 ; i--){
                // save root
                int temp = arr[0];
                // Move Last element to Root
                arr[0] = arr[i];
                // put largest at the end
                arr[i] = temp;
                // fix Remaining Heap
                heapifyDown(arr , i, 0);
            }
        }
    }
}
