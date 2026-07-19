package ChatGPT_Problems.Queue;


import java.util.Queue;

public class CustomQueue {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.enqueue(12);
        queue.enqueue(32);
        queue.enqueue(65);
        queue.enqueue(98);
        queue.enqueue(76);


        queue.display();
        System.out.println("\n" +queue.dequeue());
        System.out.println("\nFront " + queue.front());
        System.out.println("\nRear " +queue.rear());

        queue.display();

    }
    static class Queue{
        int[] queue;
        int front;
        int rear;
        int size;

        public Queue(int size){
            this.size = size;
            front = 0;
            rear = -1;
            queue = new int[size];
        }

        public boolean isEmpty(){
            return front > rear;
        }

        public boolean isFull(){
            return rear == size -1;
        }

        public void enqueue(int value){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            rear++;
            queue[rear] = value;
        }

        public int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return queue[front++];
        }

        public int front(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return queue[front];
        }

        public int rear(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return queue[rear];
        }

        public void display(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return;
            }
            for (int i = front; i <= rear ; i++) {
                System.out.println(queue[i] + " ");
            }
            System.out.println();
        }
    }
}
