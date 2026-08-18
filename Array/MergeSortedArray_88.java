
import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArray_88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        // use two pointer
        int i = m-1;       // nums 1 last valid position
        int j = n-1;       // nums 2 last valid position
        int k = m+n -1;    // total array length of nums1 array

        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        // if second array still has elements
        while( j >=0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
