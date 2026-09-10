package ChatGPT_Problems.Graphs;

import java.util.ArrayList;

public class DFS_Traversal {
    public static void main(String[] args) {
        int vertices = 4;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(2);

        graph.get(2).add(0);
        graph.get(2).add(1);
        graph.get(2).add(3);

        graph.get(3).add(2);

        boolean[] visited = new boolean[vertices];

        dfs(0 , graph , visited);
    }
    static void dfs(int node , ArrayList<ArrayList<Integer>> graph , boolean[] visited){

        visited[node] = true;
        System.out.print(node + " " );

        for(int neighbour : graph.get(node)){
            if (!visited[neighbour]) {
                dfs(neighbour , graph , visited);
            }
        }
    }
}
