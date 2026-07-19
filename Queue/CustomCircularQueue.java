public class CustomCircularQueue {
    public static void main(String[] args) {
        circularQueue queue = new circularQueue(5);

        queue.enqueue(12);
        queue.enqueue(32);
        queue.enqueue(65);
        queue.enqueue(87);
        queue.enqueue(21);

        System.out.println("Queue");
        queue.display();

        System.out.println("Removed " + queue.dequeue());
        System.out.println("Removed " + queue.dequeue());

        System.out.println("Queue");
        queue.display();

        queue.enqueue(54);
        queue.enqueue(67);

        System.out.println("Queue after adding 54 and 67");
        queue.display();

        System.out.println(queue.front());
        System.out.println(queue.rear());

    }
    static class circularQueue{
        int[] queue;
        int front;
        int rear;
        int size;

        public circularQueue(int size){
            this.size = size;
            front = -1;
            rear = -1;
            queue = new int[size];
        }
        public boolean isEmpty(){
            return front == -1;
        }

        public boolean isFull(){
            return  (rear+1) % size == front;
        }

        public void enqueue(int value){
            if(isFull()){
                System.out.println("Queue is Full");
                return;
            }
            if(isEmpty()){
                front = 0;
                rear = 0;
            }else{
                rear = (rear+1) % size;
            }
            queue[rear] = value;
        }

        public int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int value = queue[front];

            if(front == rear){
                front = -1;
                rear = -1;
            }else{
                front = (front +1) % size;
            }
            return value;
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
            int i = front;
            while(true){
                System.out.println(queue[i] + " ");

                if(i == rear){
                    break;
                }
                i = (i+1) % size;
            }
            System.out.println();
        }
    }
}




















