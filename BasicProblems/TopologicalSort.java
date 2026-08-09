/* Basic Problems
  1. Implement Topological Sort using DFS.                        - O(V + E)
  2. Implement Topological Sort using Kahn's Algorithm (BFS).     - O(V + E)
 */

// Topological Sort works only in DAG (Directed Acyclic Graphs)
// if graph contains cycle , topological order does not work

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {

        int vertices = 6;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i= 0; i< vertices ; i++){
            graph.add(new ArrayList<>());
        }
        // Add Edge
        addEdge(graph , 5 ,0);
        addEdge(graph , 5 ,2);
        addEdge(graph , 4 ,0);
        addEdge(graph , 4 ,1);
        addEdge(graph , 2 ,3);
        addEdge(graph , 3 ,1);

        topologicalSortUsingDFS(vertices , graph);
        topologicalSortUsingKahnAlgo(graph , vertices);

    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph , int u , int v){
        graph.get(u).add(v);
    }
    // -------------------------------------------- DFS ---------------------------------------------
    // IDEA
    // topological sort - DFS goes as deep as possible
    // node finishes put to stack
    // then , pop one by one to get the topological order
    static void topologicalSortUsingDFS(int vertices  , ArrayList<ArrayList<Integer>> graph){

        boolean[] visited = new boolean[vertices];

        Stack<Integer> stack = new Stack<>();

        for(int i= 0 ; i< vertices ; i++){

            if(!visited[i]){
                dfs(i , graph , visited , stack);
            }
        }
        System.out.println("\nTopological Sort");

        while(!stack.isEmpty()){
            System.out.print(stack.pop()  + " ");
        }
    }

    // DFS
    static void dfs(int node , ArrayList<ArrayList<Integer>> graph , boolean[] visited , Stack<Integer> stack){

        visited[node] = true;

        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour , graph , visited , stack);
            }
        }
        // add After Visiting all neighbour
        stack.push(node);
    }


    // ------------------------------------------------Kahn's Algorithm(BFS) -----------------------------------------------
  
    static void topologicalSortUsingKahnAlgo(ArrayList<ArrayList<Integer>> graph , int vertices){

        // Indegree Array
        int[] indegree = new int[vertices];

        // calculate Indegree  - O(V + E)
        for(int u= 0 ; u < vertices ; u++){

            for(int v : graph.get(u)){
                indegree[v]++;
            }
        }

        // kahn's Algorithm uses Queue
        Queue<Integer> queue = new LinkedList<>();

        // Add vertices of indegree 0
        for (int i = 0; i < vertices; i++) {
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        // create result that stores the final topological order : initially - result[]
        ArrayList<Integer> result = new ArrayList<>();

        // start BFS
        while(!queue.isEmpty()){

            // remove the first element and add to result
            int node = queue.poll();
            result.add(node);

            // visit neighbour of that node
            for(int neighbour : graph.get(node)){

                // decrease the indegree
                indegree[neighbour]--;

                // check indegree 0
                if(indegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }

        // cycle Detection
        if(result.size() != vertices){
            System.out.println("TopoLogical can't be possible");
            System.out.println("graph contains Cycle");
        }else{
            System.out.println("\nTopological sort");

            for(int node : result){
                System.out.print(node + " ");
            }
        }
    }
}
