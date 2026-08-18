package ChatGPT_Problems.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
*  calculate the INDEGREE
*  put INDEGREE 0 into QUEUE
*  remove from QUEUE
*  Decrease neighbour INDEGREE.
*  INDEGREE 0 -> QUEUE
* */

public class TopologicalSort_KahneAlgo {
    public static void main(String[] args) {
        int vertices = 6;

        ArrayList<ArrayList<Integer>>  graph = new ArrayList<>();

        for(int i= 0; i< vertices ; i++){
            graph.add(new ArrayList<>());
        }

        // Add Edge
        addEdge(graph ,5 , 0 );
        addEdge(graph ,5 , 2);
        addEdge(graph ,4 , 0);
        addEdge(graph ,4 , 1);
        addEdge(graph ,2 , 3);
        addEdge(graph ,3 , 1);

        topologicalSortUsingKahnAlgo(graph , vertices);
    }

    // Add Function
    // this function add  u -> v
    static void addEdge(ArrayList<ArrayList<Integer>> graph , int u , int v) {
        graph.get(u).add(v);
    }

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