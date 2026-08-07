/*
   Basic Problems
   V -vertex    , E - edges
  1. Implement BFS using a Queue.                     - O(V+E)
  2. Implement DFS using Recursion.
  3. Implement DFS using a Stack.
  4. Count Connected Components using DFS.
  5. Detect a cycle in an Undirected Graph using DFS.

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS {
    public static void main(String[] args) {

        int v = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i= 0 ; i< v ; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);

        System.out.println("\nBFS");
        bfs(graph , 0);

        System.out.println("\nDFS");
        boolean[] visited = new boolean[v];
        dfs(graph , 0 , visited);
    }
//----------------------------------- BFS(Breadth First Search)--------------------------------------------
  
    static void bfs(ArrayList<ArrayList<Integer>> graph , int start){

      // create a empty array
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;               
        queue.offer(start);

        while(!queue.isEmpty()){

            int node = queue.poll();
            System.out.print(node + " ");
            for(int neighbour : graph.get(node)){

                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }

// ---------------------------------------DFS -(Depth First Search)--------------------------------------
  
    static void dfs(ArrayList<ArrayList<Integer>> graph , int node , boolean[] visited){

        visited[node] = true;

        System.out.print(node + " ");

        for (int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                dfs(graph , neighbour , visited);
            }
        }

    }
}
