
// https://leetcode.com/problems/kth-largest-element-in-an-array/description/
// Approach : MinHeap 
// Time Complexity : O(N log K)    , Space Complexity : O(K)

import java.util.PriorityQueue;

public class KthLargestElement_215 {
    public static void main(String[] args) {
        
        int[] nums = {3,4,6,8,9,5, 10};
        int k = 2;

        System.out.println(Kthlarge(nums  , k));
    }
    static int Kthlarge(int[] nums , int k){

        PriorityQueue<Integer> heap = new PriorityQueue<>();      // create A minHeap
        
        for(int num : nums){                                      // Traverse the Array
            heap.offer(num);

            if(heap.size() > k){                                  // Keep only K elements
                heap.poll();
            }
        }
        return heap.peek();                                       // Return answer (Root is the Answer)
    }
}
