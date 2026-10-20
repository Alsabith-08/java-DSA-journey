public class recursion{
    public static void main(String[] args) {
        int n = 8;
        System.out.println(fibo(n));
    }
    private static int fibo(int n){
        if(n <= 1){
            return n;
        }
        return fibo(n-1) + fibo(n -2);
    }
}