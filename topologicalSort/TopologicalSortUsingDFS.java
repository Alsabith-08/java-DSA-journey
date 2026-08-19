package ChatGPT_Problems.TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSortUsingDFS {
    public static void main(String[] args) {
        int v = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        // add edges
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(4);

        topologicalSort(graph, v);
    }

    static void dfs(int node , ArrayList<ArrayList<Integer>> graph , boolean[] visited , Stack<Integer> stack){
        visited[node] = true;

        for (int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour , graph , visited , stack);
            }
        }
        stack.push(node);

    }
    static void topologicalSort(ArrayList<ArrayList<Integer>> graph , int v){
        boolean[] visited = new boolean[v];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < v; i++) {
            if(!visited[i]){
                dfs(i , graph  , visited , stack);
            }
        }

        System.out.println("Topological Sort");
        for (int i = 0; i <v ; i++) {
            System.out.print(stack.pop() + " ");
        }
    }

}