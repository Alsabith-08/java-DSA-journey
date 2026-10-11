package LeetCodeEx.TwoPointers;

/* Problem : The Fibonacci sequence starts with 0 and 1,
             and each subsequent number is the sum of the previous two numbers.
             Its first few terms are 0, 1, 1, 2, 3, 5, 8, 13, ....

            Return true if n can be expressed as the sum of three consecutive
            terms in the Fibonacci sequence, and false otherwise.
Note: Please do not copy the description during the contest to maintain the integrity of your submissions. */

// Approach : Using Three Pointers
// IDEA : sum all pointers compare to n
//        if equals return true , otherwise swap next = b+c , a = b , b = c , c = next
//        if the sum is greater than n

// Time Complexity : O(n)    , Space Complexity : O(1)
import java.util.Scanner;

public class ThreeFibonacciSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(sum(n));
    }
    static boolean sum (int n){
        int a = 0;
        int b = 1;
        int c = 1;

        while(true){
            int sum = a+b+c;

            if(sum == n){
                return true;
            }
            if(sum > n){
                return false;
            }
            int next = b+c;
            a = b;
            b = c;
            c = next;
        }
    }
}
