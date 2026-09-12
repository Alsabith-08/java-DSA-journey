package LeetCodeEx.SlidingWindow;

public class longSubArrayOfOnes_1493 {
    public static void main(String[] args) {
        int[] nums= {1,1,0,1,1,1};

        System.out.println(maxLength(nums));
    }
    static int maxLength(int[] nums){

        int left = 0;
        int zeros = 0;
        int maxLength = 0;

        for (int right = 0; right <nums.length ; right++) {

            if(nums[right] == 0){
                zeros++;
            }

            while(zeros > 1){
                if(nums[left] == 0){
                    zeros--;
                }
                left++;
            }
            maxLength = Math.max(maxLength , (right -left));
        }
        return maxLength;
    }
}
