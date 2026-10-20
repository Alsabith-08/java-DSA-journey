public class spaceOptimize{
    public static void main(String[] args) {
        int n = 8;

        System.out.println(fibo(n));
    }
    private static int fibo(int n){
        int prev2 = 0;
        int prev1 = 1;

       for (int i = 2; i <= n; i++) {
        int cur = prev1 + prev2;
        prev2 = prev1;
        prev1 = cur;
       }
       return prev1;
    }
}