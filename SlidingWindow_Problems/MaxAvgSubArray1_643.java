package LeetCodeEx.SlidingWindow;

public class MaxAvgSubArray1_643 {
    public static void main(String[] args) {

        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        double answer = findMaxAverage(nums, k);
        System.out.println("Maximum Average : " + answer);

        double answer1 = findMaxAverage1(nums, k);
        System.out.println("Maximum Average1 : " + answer1);

    }

    // brute Force : Time O(n * k)
    public static double findMaxAverage(int[] nums , int k){
        double maxAverage = Double.NEGATIVE_INFINITY;

        // Strat of each subarray
        for (int i = 0; i <= nums.length - k ; i++) {
            int sum = 0;

            // calculate sum of k elements
            for (int j = i ; j < i+ k ; j++){
                sum += nums[j];
            }

            double average = (double) sum / k;

            // update maximum
            if(average > maxAverage){
                maxAverage = average;
            }
        }
        return maxAverage;
    }

    // efficient Solution :  O(n)
    public static double findMaxAverage1(int[] nums , int k){

        // Get sum for Starting window
        int sum= 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;

        // start sliding window
        int startIndex = 0;
        int endIndex = k;

        while(endIndex < nums.length){

            sum -= nums[startIndex];   //Remove previous element
            startIndex++;

            sum += nums[endIndex];    // Add next element
            endIndex++;

            maxSum = Math.max(maxSum , sum);  // update max sum
        }
        // Return the average
        return (double)maxSum /k;
    }
}
