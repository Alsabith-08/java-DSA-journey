package BasicProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*

  Implement BFS using a Queue.
  Implement DFS using Recursion.
  Implement DFS using a Stack.
  Detect a cycle in an Undirected Graph using DFS.

*/
public class BFS_DFS {
    public static void main(String[] args) {

        int v = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);

        System.out.println("\nBFS Using Queue ");
        bfs(graph, 0);

        System.out.println("\nDFS Using Recursion");
        boolean[] visited = new boolean[v];
        dfs(graph, 0, visited);

        System.out.println("\nDFS Using Stack : ");
        dfsUsingStack(graph, 0);
        System.out.println();

        int vertices = 5;
        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();

        for(int i= 0 ;i < vertices ; i++){
            graph.add(new ArrayList<>());
        }

        graph1.get(0).add(1);
        graph1.get(1).add(0);

        graph1.get(1).add(2);
        graph1.get(2).add(1);

        graph1.get(2).add(3);
        graph1.get(3).add(2);

        graph1.get(3).add(1);
        graph1.get(1).add(3);

        boolean[] visited1 = new boolean[vertices];
        boolean hasCycle = false;

        for (int i = 0; i < vertices ; i++) {
            if(!visited1[i]){
                if(dfscycle(graph , i ,-1 ,visited)){
                    hasCycle = true;
                    break;
                }
            }
        }
    }

// BFS(Breadth First Search) in Queue
    static void bfs(ArrayList<ArrayList<Integer>> graph , int start){

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

// DFS -(Depth First Search) in recursion
    static void dfs(ArrayList<ArrayList<Integer>> graph , int node , boolean[] visited){

        visited[node] = true;

        System.out.print(node + " ");

        for (int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                dfs(graph , neighbour , visited);
            }
        }
    }

// DFS using Stack
    static void dfsUsingStack(ArrayList<ArrayList<Integer>> graph , int start){

        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> stack  = new Stack<>();

        stack.push(start);

        while(!stack.isEmpty()){
               int node = stack.pop();

               if(!visited[node]){
                   visited[node] = true;
                   System.out.print(node + " ");
               }

            for (int i = graph.get(node).size() -1; i >= 0; i--) {

                int neighbour = graph.get(node).get(i);

                if(!visited[neighbour]){
                    stack.push(neighbour);
                }
            }
        }
    }

    static boolean dfscycle(ArrayList<ArrayList<Integer>> graph , int node , int parent , boolean[] visited){

        visited[node] = true;

        for (int neighbour : graph.get(node)){
            if(!visited[neighbour]){

                if(dfscycle(graph , neighbour , node , visited ))
                    return true;
            }
            else if(neighbour != parent)
                return true;
        }
        return false;
    }

}
