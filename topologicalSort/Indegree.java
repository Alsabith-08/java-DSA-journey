
// Topological Sort Using Kahn's Algorithm indegree is important that means - number of incoming edges to a node

import java.util.ArrayList;
import java.util.List;

public class Indegree {
    public static void main(String[] args) {
        int vertices  = 4;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <vertices ; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);

        int[] indegree  = new int[vertices];

        // calculate indegree
        for (int i = 0; i < vertices; i++) {
            for(int neighbour : graph.get(i)){
                indegree[neighbour]++;
            }
        }
        for (int i = 0; i <vertices ; i++) {
            System.out.println("Vertex " + i + "-> "+indegree[i]);
        }
    }
}
