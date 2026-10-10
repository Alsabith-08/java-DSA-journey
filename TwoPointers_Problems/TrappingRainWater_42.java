package LeetCodeEx.HARD;

// https://leetcode.com/problems/trapping-rain-water/description/
// Approach : Two Pointers
// IDEA : using prefix to find the LeftMax and RightMax
//       KEY -> totalWater i = min (leftMax [i] , rightMax[i] - height[i])

// Time Complexity : O(n)   , Space Complexity : O(n)
public class TrappingRainWater_42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(maxTotal(height));
    }
    static int maxTotal(int[] height){
        int n = height.length;                      // if height length ==0 return 0
        if(n == 0) return 0;

        int[] leftMax = new int[n];                // Create a empty array of size to Store LeftMax & rightMax height of each element
        int[] rightMax = new int[n];

        leftMax[0] = height[0];                    // initially store LeftMax[0] = first height
        rightMax[n-1] = height[n-1];               //                 rightMax[n-1] = last Height

        for (int i = 1; i < n; i++) {                                 // traverse two loop for store the leftMax and rightMax array
            leftMax[i] = Math.max(leftMax[i-1] , height[i]);
        }
        for (int i = n-2; i>=0 ; i--) {
            rightMax[i] = Math.max(rightMax[i+1] , height[i]);
        }

        int totalMax = 0;

        for (int i = 0; i <n ; i++) {                           // this formula is KEY
            // add with totalMax = minimum of current height of leftMax or rightMax subtract with current height
            totalMax  += (Math.min(leftMax[i] , rightMax[i]) - height[i]);
        }
        return totalMax;
    }
}
