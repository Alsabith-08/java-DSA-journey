import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_Traversal {
    public static void main(String[] args) {
        int vertices = 7;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(2).add(0);
        graph.get(2).add(5);
        graph.get(2).add(6);

        graph.get(3).add(1);

        graph.get(4).add(1);

        graph.get(5).add(2);

        graph.get(6).add(2);

        bfs(0, graph);

    }
     static void bfs(int start , ArrayList<ArrayList<Integer>> graph ){

        // create a visited array for the graph size
        boolean[] visited = new boolean[graph.size()];
         
        // create a queue- because FIFO
         Queue<Integer> queue = new LinkedList<>();

         // Visited starting node , it marks as visited
         visited[start] = true;

         // Add node in queue
         queue.offer(start);

         // running until queue has node
         while(!queue.isEmpty()){

             // remove the first element and print it
             int node = queue.poll();
             System.out.print(node + " ");

             // get neighbours
             for(int neighbour : graph.get(node)){

                 if(!visited[neighbour]){ // check visited if false mark visited
                     visited[neighbour] = true;
                     // Add to queue
                     queue.offer(neighbour);
                 }
             }
         }
     }
}
