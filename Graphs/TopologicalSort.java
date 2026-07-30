package ChatGPT_Problems.Graphs;

import java.util.ArrayList;
import java.util.Stack;


public class TopologicalSort {
    public static void main(String[] args) {
        int vertices = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0; i< vertices ; i++ ){
            graph.add(new ArrayList<>());
        }

        graph.get(5).add(2);
        graph.get(5).add(0);

        graph.get(4).add(0);
        graph.get(4).add(1);

        graph.get(2).add(3);

        graph.get(3).add(1);

        topologicsort(graph , vertices);

    }
    static class TS{
        static void dfs(int node , ArrayList<ArrayList<Integer>> graph , boolean[] visited , Stack<Integer> stack){

            visited[node] = true;

            for(int neighbour : graph.get(node)){

                if(!visited[neighbour]){
                    dfs(neighbour , graph , visited ,stack);
                }
            }
            stack.push(node);

        }
    }
    public static void topologicsort(ArrayList<ArrayList<Integer>> graph , int vertices){

        boolean[] visited =new boolean[vertices];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<vertices ; i++){

            if(!visited[i]){
                dfs(i , graph , visited , stack);
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop() + " ");
        }
    }
}
