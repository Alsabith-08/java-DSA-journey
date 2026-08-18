
// check the graph contains a cycle or not Using Kahn's Algorithm

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionInKahn {
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

        System.out.println("This graph contains cycle : ");
        System.out.println(kahnCycle(graph , vertices));

    }

    static void addEdge(ArrayList<ArrayList<Integer>> graph , int u , int v){
        graph.get(u).add(v);
    }

    // kahn's Algorithm
    static boolean kahnCycle(ArrayList<ArrayList<Integer>> graph , int vertices){

        // Calculate indegree
        int[] indegree = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            for(int neighbour : graph.get(i)){
                indegree[neighbour]++;
            }
        }

        // Create Queue
        Queue<Integer> queue= new LinkedList<>();

        // check which edges have a 0 indegree , add it queue initilly
        for (int i = 0; i < vertices; i++) {
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        // processedNode variable initially 0
        int processed = 0;

        // check 
        while(!queue.isEmpty()){
            
            int node = queue.poll();
            processed++;
            
            for (int neighbour : graph.get(node)){
                indegree[neighbour]--;

                if(indegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }
        // check cycle
        if(processed != vertices){
            return true;
        }
        return false;
    }
}
