package ChatGPT_Problems.TopologicalSort;

import java.util.ArrayList;

public class CycleDetectionUsingDFS {
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <v ; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);
        graph.get(3).add(1);

        if(hasCycle(v , graph)){
            System.out.println("Cycle Detection");
        }else{
            System.out.println("No Cycle");
        }
    }

    static boolean dfs(int node , ArrayList<ArrayList<Integer>> graph , boolean[] visited , boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbour : graph.get(node)) {

            // neighbour is already in current DFS path
            if (recStack[neighbour]) {
                return true;
            }

            // Visit Unvisited Neighbour
            if(!visited[neighbour]){
                if(dfs(neighbour , graph , visited , recStack)){
                    return true;
                }
            }
        }
        // Remove node from current DFS path
        recStack[node] = false;
        return false;
    }
    static boolean hasCycle(int v , ArrayList<ArrayList<Integer>> graph){

        boolean[] visited = new boolean[v];
        boolean[] recStack = new boolean[v];

        for (int i = 0; i <v ; i++) {
            if(!visited[i]){
                if(dfs(1 , graph ,visited , recStack)){
                    return true;
                }
            }
        }
        return false;
    }
}
