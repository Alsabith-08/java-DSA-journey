// Detect Cycle In Undirected Graph Using DFS

import java.util.ArrayList;

public class DetectCycle {
    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(0);

        graph.get(1).add(2);
        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(1);
        graph.get(1).add(3);

        boolean[] visited = new boolean[v];
        boolean hasCycle = false;

        for (int i = 0; i < v ; i++) {
            if(!visited[i]){
                if(dfs(graph , i , -1 , visited)){
                    hasCycle = true;
                    break;
                }
            }
        }
        if(hasCycle){
            System.out.println("Cycle Found");
        }else{
            System.out.println("Cycle Not Found");
        }
    }
    static boolean dfs(ArrayList<ArrayList<Integer>> graph , int node , int parent  , boolean[] visited){
        visited[node] = true;

        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]) {
                if (dfs(graph, neighbour, node, visited))
                    return true;
            }
            else if(parent != neighbour){
                return true;
            }
        }
        return false;
    }
}
