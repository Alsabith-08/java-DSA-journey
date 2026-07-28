package DSA;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    // Queue - is FIFO data structure , First-in First-out

    // add    -  enqueue = offer()
    // remove -  dequeue = poll()

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();

        //System.out.println(queue.isEmpty());

        queue.offer("Alsabith");
        queue.offer("Berlin");
        queue.offer("Tokyo");
        queue.offer("Itachi");

//        System.out.println(queue.isEmpty());
//        System.out.println(queue.size());
//        System.out.println(queue.contains("Alsabith"));

        queue.poll();
        queue.poll();
        queue.poll();
       // queue.poll();
       // queue.element();

        System.out.println(queue);

    }

}
