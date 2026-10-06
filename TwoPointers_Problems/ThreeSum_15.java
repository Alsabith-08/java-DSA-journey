package LeetCodeEx.TwoPointers;


// 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> result = sum3(nums);
        System.out.println(result);
    }
    static List<List<Integer>> sum3 (int[] nums){
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i> 0 && nums[i] == nums[i-1]){
                continue;
            }

            int j = i+1;
            int k = nums.length -1;

            while(j < k){
                int total = nums[i] + nums[j] + nums[k];

                if(total > 0){
                    k--;
                }else if(total < 0){
                    j++;
                }else{
                    res.add(Arrays.asList(nums[i] , nums[j] , nums[k]));
                    j++;

                    while(nums[j] == nums[j-1] && j < k){
                        j++;
                    }
                }
            }
        }
        return res;
    }
}
