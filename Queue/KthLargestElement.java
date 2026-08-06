import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr ={1,4,6,7,8,9};
        int k = 4;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : arr){
            queue.add(num);
        }

        for(int i = 1 ; i < k ; i++){
            queue.poll();
        }

        System.out.println(k + " Largest element " + queue.peek());
    }
}
