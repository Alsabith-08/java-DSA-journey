import java.util.Scanner;

/* Basic problems
   1. Print 1 to N
   2. Print N to 1
   3. Factorial of a number
   4. Sum of first N natural numbers
   5. Nth Fibonacci number
*/
public class Recursion {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       // print 1 to N
       System.out.print("Enter the value for N : ");
       int n = sc.nextInt();
       int i = 1;
       print(i , n);


       // print N to 1
       int m = 6;
       print_N_1(m);

       

       // Factorial
       int f = 4;
       System.out.println(factorial(f));

       

       // Sum of first N natural Numbers
       int N = 4;
       System.out.println(sumOfNatural(N));

       

        // Fibonacci Number
        System.out.print("Enter the number :");
        int num = sc.nextInt();
        System.out.println("Fibonacci of "+num+ "is :" +fibonacci(num));

    }

    // 1. print 1 to N
    static void print(int i , int n){

        // Base Condition
        if(i > n){
            return;
        }
        System.out.println(i);
        print(i+1 , n);
    }

    // 2. print N to 1
    static void print_N_1(int m){
        if(m < 1){
            return;
        }
        System.out.println(m);
        print_N_1(m-1 );
    }

    // 3. Factorial of Number
    static int factorial(int f){

        if(f == 1){
            return 1;
        }else{
           return f * factorial(f-1);
        }
    }

    // 4. Sum of first N natural Numbers
    static int sumOfNatural(int N){
        if(N == 0){
            return 0;
        }
        return N + sumOfNatural(N-1);
    }

    // Fibonacci Number
    static int fibonacci(int num){

        if(num == 0 || num == 1){
            return 1;
        }
        return fibonacci(num-1) + fibonacci(num -2);
    }
}
