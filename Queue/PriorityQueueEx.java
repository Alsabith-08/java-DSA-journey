package DSA;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {
    // PriorityQueue - is FIFO data structure , First-In First-Out
    //               - highest priority first before the lowest priority

    public static void main(String[] args) {
        //Queue is the interface so use the linked list instead of Queue on the right side
        Queue<Double> queue = new PriorityQueue<>(Collections.reverseOrder());

        Queue<String> queue1 = new PriorityQueue<>();

        queue.offer(3.0);
        queue.offer(2.5);
        queue.offer(1.5);
        queue.offer(4.0);
        queue.offer(3.5);

        queue1.offer("A");
        queue1.offer("B");
        queue1.offer("C");
        queue1.offer("D");
        queue1.offer("E");

        //OUTPUT :
        // Linkedlist - the output is on the sequence
        // PriorityQueue  - the output on the Ascending Order
        // in parameter ( Collections.reverseOrder() ) - the output on the Descending order


        while(!queue1.isEmpty()){
            System.out.println(queue1.poll());
        }

        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }


    }
}
