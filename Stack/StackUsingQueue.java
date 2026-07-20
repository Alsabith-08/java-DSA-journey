import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(21);
        stack.push(3);
        stack.push(1);
        stack.push(2);

        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.Empty());
    }
    static public class MyStack{
        private Queue<Integer> queue;

        public MyStack(){
            queue = new LinkedList<>();
        }

        public void push(int x){
            queue.add(x);
            for(int i= 1; i< queue.size() ; i++){
                queue.add(queue.remove());
            }
        }
        public int pop(){
            return queue.remove();
        }

        public int top(){
            return queue.peek();
        }

        public boolean Empty(){
            return queue.isEmpty();
        }
    }
}
