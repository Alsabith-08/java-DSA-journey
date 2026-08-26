
// https://leetcode.com/problems/product-of-array-except-self/description/

import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};

        int[] result = productExcept(nums);

        System.out.println("Input :" + Arrays.toString(nums));
        System.out.println("Output : "+ Arrays.toString(result));
    }
    static int[] productExcept(int[] nums){
        int n = nums.length;

        // answer[i] = leftProduct * rightProduct
        int[] answer  =new int[n];

        // store prefix products - contains product of everything before the current index
        int prefix = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = prefix;
            prefix = prefix * nums[i];
        }

        // Multiply by suffix products - contains product of everything after the current index
        int sufix = 1;
        for (int i = n-1; i >=0 ; i--) {
            answer[i] = answer[i] * sufix;
            sufix = sufix*nums[i];
        }

        return answer;
    }
}
