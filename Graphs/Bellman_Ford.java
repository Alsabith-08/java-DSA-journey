import java.util.ArrayList;
import java.util.Arrays;

public class Bellman_Ford {
    public static void main(String[] args) {

        int vertices = 5;
        ArrayList<Edge> edges = new ArrayList<>();

        // source , destination , weight
        edges.add(new Edge(0,1,4));
        edges.add(new Edge(0,2,-5));
        edges.add(new Edge(1,2,2));
        edges.add(new Edge(1,3,6));
        edges.add(new Edge(2,3,3));
        edges.add(new Edge(3,4,2));

        int source = 0;

        BellmanFord(vertices , edges , source);

    }
    static class Edge{
        int source;
        int destination;
        int weight;

        Edge(int source , int destination , int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void BellmanFord(int vertices , ArrayList<Edge> edges , int source){
        int INF = Integer.MAX_VALUE;

        int[] dist = new int[vertices];
        Arrays.fill(dist , INF);

        dist[source] = 0;

        for (int i = 0; i < vertices -1; i++) {
            for(Edge edge : edges){

                int u = edge.source;
                int v = edge.destination;
                int weight = edge.weight;

                if(dist[u] != INF && dist[u] + weight < dist[v]){
                    dist[v] = dist[u] + weight;
                }
            }
        }
        for(Edge edge : edges){

            int u = edge.source;
            int v = edge.destination;
            int weight = edge.weight;

            if(dist[u] != INF && dist[u] + weight < dist[v]){
                System.out.println("Negative Weight Cycle detected ");
                return;
            }
        }
        System.out.println("Shortest Distances From Source " + source + " : ");
        for (int i = 0; i < vertices ; i++) {

            if(dist[i] == 0){
                System.out.println(source + " -> " + i + " =INF");
            }else{
                System.out.println(source + " -> " + i + " = " + dist[i]);
            }
        }
    }
}
