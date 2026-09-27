package LeetCodeEx.Graph;

// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutes_1466 {
    public static void main(String[] args) {

        int n = 6;

        int[][] connections = {
                {0, 1},
                {1, 3},
                {2, 3},
                {4, 0},
                {4, 5}
        };

        System.out.println(minRoute(n, connections));
    }
    static class Edge{
        int to;                     // Destination City
        int cost;                   // 1 = need reversal , 0 = is correct

        Edge(int to , int cost){
            this.to = to;
            this.cost = cost;
        }
    }
    static int answer;
    static int minRoute(int n , int[][] connections){

        List<List<Edge>> graph = new ArrayList<>();         // create an Adjacent List

        for(int i = 0; i< n ;i++){                          // create an empty list for each city
            graph.add(new ArrayList<>());
        }

       // Store every road in BOTH direction
        for(int[] road : connections){
            int from = road[0];
            int to = road[1];

            graph.get(from).add(new Edge(to,1));             // original road : from -> to this road need reversal, so cost =1
            graph.get(to).add(new Edge(from , 0));           // opposite direction :to -> from already correct  , so cost = 0;
        }

        boolean[] visited = new boolean[n];                       // create visited Array
        answer = 0;                                               // initially
        dfs(0 , graph , visited);                          // current : starting node 

        return answer;
    }

    // dfs
    static void dfs(int current , List<List<Edge>> graph, boolean[] visited){
        visited[current] = true;

        for(Edge edge : graph.get(current)){                          // check neighbours are visited
            if(visited[edge.to]){
                continue;
            }
            // Add 1 if this road need reversal
            answer += edge.cost;

            dfs(edge.to , graph , visited);
        }
    }
}
