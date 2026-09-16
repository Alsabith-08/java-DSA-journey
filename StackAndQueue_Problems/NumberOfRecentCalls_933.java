package LeetCodeEx.StackAndQueue;

// https://leetcode.com/problems/number-of-recent-calls/description/

/* You have a RecentCounter class which counts the number of recent requests within a certain time frame.

   Implement the RecentCounter class:

   RecentCounter() Initializes the counter with zero recent requests.
   int ping(int t) Adds a new request at time t, where t represents some time in milliseconds,
   and returns the number of requests that have happened in the inclusive range [t - 3000, t], that is, the new request plus every earlier request that is no more than 3000 milliseconds older.
   It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
   */

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
