
// Find the shortest Path in Undirected Graph Using BFS
// Time Complexity = O(v + E)

import java.util.*;

public class BFS_ShortestPath {
    public static void main(String[] args) {
        int vertices = 6;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // add edges
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 0);
        addEdge(graph, 4, 1);

        int source = 0;
        int destination = 5;

        List<Integer> path = shortestPath(graph , source , destination );

        // print the shortest path
        if(path.isEmpty()){
            System.out.println("No Path exists");
        }else{
            System.out.println("Shortest path");
            for(int node : path){
                System.out.print(node + " ");
            }
        }

    }
     static void addEdge(ArrayList<ArrayList<Integer>> graph , int u , int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

     static List<Integer> shortestPath(ArrayList<ArrayList<Integer>> graph , int source  , int destination){

        // create a boolean array with graph size ,  initially all values are false
        boolean[] visited = new boolean[graph.size()];

        // create an integer array of parent with graph size , assign all values are -1
        int[] parent = new int[graph.size()];
        Arrays.fill(parent , -1);

        Queue<Integer> queue = new LinkedList<>();

        //start BFS
        visited[source] = true;
        queue.offer(source);

        while(!queue.isEmpty()){
            int current = queue.poll();

            // if the node and destination is same return
            if(current == destination){
                break;
            }

            // check the current node neighbours
            for (int neighbour : graph.get(current)){
                if(!visited[neighbour]){

                    // mark as visited
                    visited[neighbour] = true;
                    // put the current in the parent neighbours
                    // ex : parent[1] = 0
                    // this means 0 is parent of 1
                    parent[neighbour] = current;

                    queue.offer(neighbour);     // add it
                }
            }
        }

        //Destination cannot be Reached
        if(!visited[destination]){
            return new ArrayList<>();
        }

        // Reconstruct path
        List<Integer> path = new ArrayList<>();

        // from destination
        int current = destination;

        while(current != -1){

            // add to the path list
            path.add(current);

            // put the parent of the current till -1
            current = parent[current];
        }
        // currently destination -> source
        // reverse it , source -> destination
        Collections.reverse(path);

        return path;
    }
}
