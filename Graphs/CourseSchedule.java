package ChatGPT_Problems.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {

        int numCourses = 4;
           int[][] prerequisites ={
                   {1,0},
                   {2,0},
                   {3,1},
                   {3,2}
           };

           boolean result = canFinish(numCourses , prerequisites);

        System.out.println(result);
    }
    static boolean canFinish(int numCourses , int[][] prerequisites){

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses ; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        //Build Graph
        for(int[] prerequisite : prerequisites){

            int course = prerequisite[0];
            int preCourse = prerequisite[1];

            graph.get(preCourse).add(course);

            indegree[course]++;
        }

        //Queue
        Queue<Integer> queue = new LinkedList<>();

        for(int  i=0; i< numCourses ; i++){

            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int completedCourses = 0;

        //BFS
        while(!queue.isEmpty()){
            int current = queue.poll();

            completedCourses++;

            for (int nextCourses : graph.get(current)){
                indegree[nextCourses]--;

                if(indegree[nextCourses] == 0){
                    queue.offer(nextCourses);
                }
            }
        }
        return completedCourses == numCourses;
    }
}
