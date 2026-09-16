// https://leetcode.com/problems/number-of-recent-calls/description/
// Apporach : Queue(First in First Out)
// Time Complexity : O(n)

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls_933 {
    public static void main(String[] args) {

        RecentCounter counter = new RecentCounter();

        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }
     static class RecentCounter{
         Queue<Integer> queue;

         public RecentCounter(){
             queue = new LinkedList<>();
         }

         public int ping(int t){
             // add the new call
             queue.offer(t);

             // Remove calls outside [t  -3000]
             while(queue.peek() < t -3000){
                 queue.poll();
             }
             // return number of recent calls
             return queue.size();
         }
     }
}
