
// https://leetcode.com/problems/climbing-stairs/description/
// Pattern: 1D Dynamic Programming
// Approach: Bottom-up DP using previously calculated answers.
// IDEA: dp[i] = dp[i-1] + dp[i-2] because we can reach step i from step i-1 or i-2.

// Time complexity: O(n)    ,Space complexity: O(n)

public class ClimbingStairs_70 {
    public static void main(String[] args) {
        int n = 8;

        System.out.println(ways(n));
    }
    private static int ways(int n){
        if(n <= 2){
            return n;
        }
        /*int[] dp = new int[n+1];     // dp array

        dp[1] = 1;
        dp[2] = 2; */

        int prev1 = 2;              // space Optimazation use two variables
        int prev2 = 1;

        for (int i = 3; i <= n; i++) {

            // dp[i] = dp[i-1] + dp[i-2];
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        // return dp[n];
        return prev1;
    }
    
}
