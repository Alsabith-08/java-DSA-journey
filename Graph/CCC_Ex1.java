package ChatGPT_Problems.Graphs;

import java.util.ArrayList;

public class CCC_Ex1 {
    public static void main(String[] args) {
        int vertices = 10;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // add edges
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 4);
        addEdge(graph, 5, 4);

        addEdge(graph, 6, 7);
        addEdge(graph, 8, 9);

        boolean[] visited = new boolean[vertices];
        int components = 0;

        for (int i =0; i <vertices ; i++) {
           if(!visited[i]){
               dfs(graph , visited , i);
               components++;
           }
        }
        System.out.println("Total Components : " + components);
    }
    static void addEdge(ArrayList<ArrayList<Integer>> graph , int u , int v ){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph , boolean[] visited , int node){
        visited[node] = true;


        for (int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                dfs(graph, visited, neighbour);
            }
        }
    }
}