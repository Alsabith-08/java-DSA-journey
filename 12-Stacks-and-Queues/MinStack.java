import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        minStack ms = new minStack();

        ms.push(4);
        ms.push(2);
        ms.push(3);
        ms.push(5);

        System.out.println(ms.getMin());
        ms.pop();

        System.out.println(ms.getMin());
        ms.pop();

        System.out.println(ms.getMin());
    }
    static class minStack{
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minstack = new Stack<>();

        // push
        public void push(int x){
            stack.push(x);

            if(minstack.isEmpty()){
                minstack.push(x);
            }else{
                minstack.push(Math.min(x , minstack.peek()));
            }
        }

        // pop
        public int pop(){
            if(stack.isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            minstack.pop();
            return stack.pop();
        }

        // top
        public int top(){

            if(stack.isEmpty()){
                return -1;
            }
            return stack.peek();
        }

        // Get Minimum
        public int getMin(){
            if(minstack.isEmpty()){
                return -1;
            }
            return minstack.peek();
        }
    }
}
