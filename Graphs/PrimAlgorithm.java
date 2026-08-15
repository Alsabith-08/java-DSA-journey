// Minimum Spanning Tree

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimAlgorithm {
    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<Edge>[] graph  =new ArrayList[vertices];

        for (int i = 0; i <vertices ; i++) {
            graph[i] = new ArrayList<>();
        }

        addEdge(graph,0,1,2);
        addEdge(graph,0,2,3);
        addEdge(graph,0,3,6);

        addEdge(graph,1,3,8);
        addEdge(graph,1,4,5);

        addEdge(graph,2,3,7);
        addEdge(graph,2,5,4);

        addEdge(graph,3,5,10);
        addEdge(graph,3,4,9);

        addEdge(graph,4,5,1);


        primMST(graph, vertices);

    }

    static class Edge{
        int destination;
        int weight;

        Edge(int destination , int weight){
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Pair{
        int vertex;
        int weight;

        Pair(int vertex , int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    static void addEdge(ArrayList<Edge>[] graph , int source , int destination , int weight){
        graph[source].add(new Edge(destination , weight));
        graph[destination].add(new Edge(source , weight));
    }

    static void primMST(ArrayList<Edge>[] graph , int vertices){
        boolean[] visited = new boolean[vertices];

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);

        pq.offer(new Pair(0,0));

        int totalWeight = 0;

        System.out.println("Edges in MST : ");

        while(!pq.isEmpty()){
            Pair current = pq.poll();

            int vertex = current.vertex;
            int weight = current.weight;

            if(visited[vertex]){
                continue;
            }

            visited[vertex] = true;

            totalWeight = totalWeight + weight;

            if(weight!= 0){
                System.out.println("Vertex " + vertex + " Added with edges weight " + weight);
            }

            // explore All Neighbours Vertex
            for(Edge edge : graph[vertex]){
                if(!visited[edge.destination]){
                    pq.offer(new Pair(edge.destination , edge.weight));
                }
            }
        }
        System.out.println("Total MST Weight = "+ totalWeight);
    }

}
