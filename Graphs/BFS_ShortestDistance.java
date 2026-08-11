
// FInd the shortest Distance from O to all other nodes Using BFS 
// Time complexity - O(v + E)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_ShortestDistance {
    public static void main(String[] args) {
        int vertices = 6;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add Edges
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 5);
        addEdge(graph, 4, 5);

        shortestDistance(graph, 0);

    }

    private static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static void shortestDistance(ArrayList<ArrayList<Integer>> graph , int source){

        // create a distance empty array with graph.size
        int[] distance = new int[graph.size()];
        // fill with -1
        Arrays.fill(distance , -1);

        // create a queue
        Queue<Integer> queue = new LinkedList<>();

        // start from source , distance of source(0) node is 0 then put into queue
        distance[source] = 0;
        queue.offer(source);

        while(!queue.isEmpty()){

            // pop the element which the first of queue
            int current = queue.poll();

            // visited the neighbour of that node
            for (int neighbour : graph.get(current)){

                if(distance[neighbour] == -1){                   // if not visited
                    distance[neighbour] = distance[current] +1;  // and add the current node distance and +1
                    queue.offer(neighbour);                      // then put into queue
                }
            }
        }

        // print the distance
        for (int i = 0; i < graph.size() ; i++) {
            System.out.println("Distance from " + source + " to " + i + " = " + distance[i]);
        }
    }
}

