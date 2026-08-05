
/*   Basic Problems
   1. Implement Queue using an array.
   2. Enqueue an element.
   3. Dequeue an element.
   4. Display an Queue
   5. Implement Circular Queue.
   6. Check if Queue is Full or Empty
*/

public class Queue {
    public static void main(String[] args) {

        // 1. Linear Queue using Arrays
        queueUsingArray queue = new queueUsingArray(5);

        queue.enqueue(12);
        queue.enqueue(23);
        queue.enqueue(16);
        queue.enqueue(18);
        queue.enqueue(13);

        queue.display();

        System.out.println("\nDequeue Element : "+queue.dequeue());
        System.out.println("Dequeue Element : "+queue.dequeue());

        queue.display();


        // 2. Circular Queue
        circularQueue queue1 = new circularQueue(5);

        queue1.enqueue(12);
        queue1.enqueue(23);
        queue1.enqueue(16);
        queue1.enqueue(18);
        queue1.enqueue(13);

        queue1.display();

        System.out.println("\nDequeue Element : "+queue1.dequeue());
        System.out.println("Dequeue Element : "+queue1.dequeue());

        queue1.enqueue(34);
        queue1.enqueue(100);

        queue1.display();
    }

    // LINEAR QUEUE
    static class queueUsingArray{
        // Variables
        int[] arr;
        int front, rear , size;

        // Constructor
        public queueUsingArray(int size){
            this.size = size;
            arr = new int[size];
            front = 0;
            rear = -1;
        }

        // Enqueue - O(1)
        public void enqueue(int value){
            if(rear == size -1){
                System.out.println("Queue is Full");
                return;
            }
            rear++;
            arr[rear] = value;
        }

        // Dequeue - O(1)
        public int dequeue(){
            if(front > rear){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front++];
        }

        // Display - O(n)
        public void display(){
            if(front > rear){
                System.out.println("Queue is Empty");
                return;
            }
            for(int i= front ; i<= rear ; i++){
                System.out.println(arr[i] +" ");
            }
            System.out.println();
        }
    }


    // CIRCULAR QUEUE
    static class circularQueue {
        int[] arr;
        int front, rear, size;

        public circularQueue(int size) {
            this.size = size;
            arr = new int[size];
            front = -1;                     // in circular queue front and rear is -1
            rear = -1;
        }

        // Circular Queue -isFull
        public boolean isFull(){           // rear == front means queue is full
            return (rear+1)%size == front;
        }

        // Circular Queue - isEmpty
        public boolean isEmpty(){         // if front is -1 the queue is Empty
            return front == -1;
        }

        // Enqueue -- O(1)
        public void enqueue(int value) {

            if(isFull()){                                 // Check if full
                System.out.println("Queue is Full");
                return;
            }

            if(front == -1){                               // move front forward
                front = 0;
            }

            rear = (rear+1) % size;                       // find the rear position through formula
            arr[rear] = value;                            // insert it
        }

        // Dequeue - O(1)
        public int dequeue(){

            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }

            int value = arr[front];

            if(front == rear){                             // is this the last element , there is only one element
                front = rear = -1;                         // after removing queue is empty
            }else{
                front = (front +1)% size;                  // Move front forward
            }
            return value;
        }

        // display - why doesn't use normal for loop like in linear Queue
        // in linear queue is front to rear but in circular queue doesn't effecient 
        public void display(){
            if(front == -1){
                System.out.println("Queue is Empty");
                return;
            }
           int i = front;                                  // start from front

            while(true){
                System.out.println(arr[i] + " ");          // print one by one

                if(i == rear){                            // stop if reach the rear
                    break;
                }
                i = (i+1) % size;                         // keep moving with (index+1) % size
            }
            System.out.println();
        }
    }
}
