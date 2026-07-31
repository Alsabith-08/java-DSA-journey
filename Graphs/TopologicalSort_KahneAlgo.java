package ChatGPT_Problems.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort_KahneAlgo {
    public static void main(String[] args) {
        int vertices  = 4;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // create an empty adjacent list
        for (int i = 0; i < vertices ; i++) {
            graph.add(new ArrayList<>());
        }
        // add it
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);

        System.out.println(topologicalSort(vertices , graph));
    }
    public static List<Integer> topologicalSort(int vertices ,
                                                ArrayList<ArrayList<Integer>> graph) {

        // create an indegree array
        int[] indegree = new int[vertices];

        // calculate the indegree for each node
        for (int i = 0; i < vertices; i++) {
            for (int neighbour : graph.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // Add All nodes with degree
        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        // create a topo list
        List<Integer> topo = new ArrayList<>();

        while(!queue.isEmpty()){

            // add the element in to topo
            int node  = queue .poll();
            topo.add(node);

            // remove the incoming edge from that node
            for(int neighbour : graph.get(node)){
                indegree[neighbour] --;

                // if indegree 0 push in to queue
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        return topo;
    }
}
