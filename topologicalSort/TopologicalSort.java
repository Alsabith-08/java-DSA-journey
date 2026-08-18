
// Topological Sort using DFS

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static void main(String[] args) {
        int vertices = 6;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0 ; i<vertices ; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(5).add(2);
        graph.get(5).add(0);
        graph.get(4).add(0);
        graph.get(4).add(1);
        graph.get(2).add(3);
        graph.get(3).add(1);

        topological(vertices , graph);

    }
    public static void topological(int vertices , ArrayList<ArrayList<Integer>> graph){

        boolean[] visited = new boolean[vertices];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {

            if(!visited[i]){
                dfs(i , visited , graph , stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
    public static void dfs(int node , boolean[] visited ,
                           ArrayList<ArrayList<Integer>> graph ,
                           Stack<Integer> stack){

        visited[node] = true;

        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour , visited , graph , stack);
            }
        }
        stack.push(node);
    }
}
