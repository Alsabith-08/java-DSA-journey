
// https://leetcode.com/problems/smallest-number-in-infinite-set/description/    (Medium)
// Approach : minHeap + HashSet
// Time Complexity : O(log k)   , Space Complexity :O(k)

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallNumInfiniteSet_2336 {
    public static void main(String[] args) {
        
      SmallestInfiniteSet obj = new SmallestInfiniteSet();

        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());

        obj.addBack(1);

        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());

        obj.addBack(2);
        obj.addBack(2);  // duplicate - ignored

        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());
        System.out.println(obj.popSmallest());

    }
    static class SmallestInfiniteSet{

        private PriorityQueue<Integer> minHeap;             // quickly find the smallest restored number
        private HashSet<Integer> set;                       // prevent duplicates
        private int next;

        public SmallestInfiniteSet(){
            minHeap = new PriorityQueue<>();
            set = new HashSet<>();
            next = 1;
        }
        public int popSmallest(){

            // if a restored number is smaller than next,
            // it should be returned first
            if(!minHeap.isEmpty() && minHeap.peek() < next){
                int smallest = minHeap.poll();

                // remove it from the set
                set.remove(smallest);
                return smallest;
            }// otherwise , return the next untouched number
            return next++;
        }

        public void addBack(int num){

            // only previously removed numbers can be added back
            // set check prevents duplicates
            if(num < next && !set.contains(num)){
                minHeap.offer(num);
                set.add(num);
            }
        }
    }
}
