package ChatGPT_Problems.Recursion;

import java.util.Scanner;

public class PrintNumberN_1_recursion {
    public static void main(String[] args) {
        // by default recursion
        // Get the input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n" );
        int n = sc.nextInt();
        //  int n = 5;
        printFunction(n);
    }
    static void printFunction( int n){
        // Base Condition
       if( n < 1){
           return;
       }
        System.out.println(n);
       printFunction(n-1);

    }
}
