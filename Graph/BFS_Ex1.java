package ChatGPT_Problems.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Ex1 {
        public static void main(String[] args) {

            int vertices = 4;
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                graph.add(new ArrayList<>());
            }
            // add edges
            addEdge(graph, 0, 1);
            addEdge(graph, 0, 2);
            addEdge(graph, 1, 3);
            addEdge(graph, 2, 3);

            System.out.println("BFS");
            bfs(graph , 0);

        }
        static void addEdge(ArrayList<ArrayList<Integer>> graph , int u , int v) {
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        static void bfs(ArrayList<ArrayList<Integer>> graph , int start){
            boolean[] visited = new boolean[graph.size()];

            visited[start] = true;
            Queue<Integer> queue = new LinkedList<>();

            queue.offer(start);

            while(!queue.isEmpty()){
                int node = queue.poll();
                System.out.print(node + " ");

                for (int neighbour : graph.get(node)){
                    if(!visited[neighbour]){
                        visited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }
        }
}
