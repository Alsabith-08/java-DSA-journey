
/* You are given two integers n and s.
   Consider all prime numbers less than or equal to n. Select some of these primes such that:

  The sum of the selected primes is less than or equal to s.
  The number of selected primes is maximized.
  Each prime can be selected at most once.

  Return an integer array containing the selected primes in increasing order. If multiple optimal selections exist, return any of them.

  If no prime can be selected, return an empty array.

  A prime number is a natural number greater than 1 with only two factors, 1 and itself.

Note: Please do not copy the description during the contest to maintain the integrity of your submissions. */

// Approach : Greedy
// IDEA : find the prime number from n , the number of sum doesn't exceed of s

// Time Complexity : O(n*sqrt(n))           , Space Complexity : O(n)

import java.util.ArrayList;
import java.util.List;

public class PrimeSubsetSelection1 {
    public static void main(String[] args) {
        int n = 7;
        int s = 20;

        List<Integer> result = primesub(n ,s);
        System.out.println(result);
    }
    static List<Integer> primesub(int n ,int s){
        List<Integer> result = new ArrayList<>();

        int sum = 0;
        for (int num = 2; num <= n ; num++) {
            if(isprime(num)){
                if(sum +num >s){
                   break;
                }
                result.add(num);
                sum += num;
            }
        }
        return result;
    }
    static boolean isprime(int n){
        if(n < 2){
            return false;
        }

        for (int i=2 ; i*i<=n ;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
}
