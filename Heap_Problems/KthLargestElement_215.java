package LeetCodeEx.Heap;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

import java.util.PriorityQueue;

public class KthLargestElement_215 {
    public static void main(String[] args) {
        int[] nums = {3,4,6,8,9,5, 10};
        int k = 2;

        System.out.println(Kthlarge(nums  , k));
    }
    static int Kthlarge(int[] nums , int k){

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num : nums){
            heap.offer(num);

            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
}
