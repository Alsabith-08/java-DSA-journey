package ChatGPT_Problems.graph_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraShortestDistance {
    public static void main(String[] args) {

        int n = 4;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // 0 - 4 -> 1
        graph.get(0).add(new Edge( 1 , 4));
        // 0 - 1 -> 2
        graph.get(0).add(new Edge( 2 , 1));
        // 1 - 2 -> 3
        graph.get(1).add(new Edge( 3 , 2));
        // 2 - 3 -> 3
        graph.get(2).add(new Edge( 3 , 3));

        int source  =0;

        int[] result = dijkstra(graph , source);

        System.out.println("Shortest distances From " + source + " : ");

        for(int i =0 ; i<n ; i++){
            System.out.println(source + " -> " + i + " = " + result[i]);
        }

    }
    static class Edge{
        int node;
        int weight;

        public Edge(int node , int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    static class Pair{
        int node;
        int distance;

        public Pair(int node , int distance){
            this.node = node;
            this.distance = distance;
        }

    }

    static int[] dijkstra(ArrayList<ArrayList<Edge>> graph , int source){

        int  n = graph.size();

        //Distance Array
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[source] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);

        // Add Source
        pq.offer(new Pair(source , 0));

        while(!pq.isEmpty()){

            Pair current = pq.poll();

            int node = current.node;
            int distance = current.distance;

            if(distance > dist[node]){
                continue;
            }

            // visit all neighbour
            for(Edge edge : graph.get(node)){

                int newNode = edge.node;
                int weight = edge.weight;

                int newDistance = distance + weight;

                if(newDistance < dist[newNode]){

                    dist[newNode] = newDistance;

                    pq.offer(new Pair(newNode , newDistance));
                }
            }
        }
        return dist;
    }
}
