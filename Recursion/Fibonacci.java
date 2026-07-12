public class Fibonacci {
    public static void main(String[] args) {

        System.out.println(fibo(9));
    }
    static int fibo(int n){
        //Base Condition
        if(n == 1 || n ==2){
            return 1;
        }
        //Recursion
        return fibo(n -1) + fibo(n -2);
    }
}
