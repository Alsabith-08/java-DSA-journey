// Find the minimum Spanning tree using Kruskal Algorithm

import java.util.ArrayList;

public class KruskalAlgorithm {
    public static void main(String[] args) {
        int vertices = 4;
        ArrayList<Edge> graph = new ArrayList<>();

        graph.add(new Edge(0,1,10));
        graph.add(new Edge(0,2,6));
        graph.add(new Edge(0,3,5));
        graph.add(new Edge(1,3,15));
        graph.add(new Edge(2,3,14));

        kruskal(vertices , graph);

    }
    static class Edge{
        int source;
        int destination;
        int weight;

        Edge(int source , int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // tell me the root of x
    static int find(int[] parent , int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent , parent[x]);

        return parent[x];
    }

    // Union by Rank - joins the groups containing a and b
    static void union(int[] parent , int rank[] , int a  , int b){
        int rootA = find(parent , a);
        int rootB = find(parent , b);

        if(rootA == rootB){
            return;
        }

        if(rank[rootA] < rank[rootB]){
            parent[rootA] = rootB;

        }else if(rank[rootA] > rank[rootB]){
            parent[rootB] = rootA;
        }else{
            parent[rootA] = rootB;
            rank[rootA]++;
        }
    }
    static void kruskal(int vertices , ArrayList<Edge> graph){

        // 1. sort the graph by weight
        graph.sort((a,b) -> a.weight - b.weight);

        // 2. initially every vertex is its own parent
        int[] parent = new int[vertices];
        int[] rank = new int[vertices];

        for(int i = 0 ; i< vertices ; i++){
            parent[i] = i;
        }

        int totalWeight = 0;
        int edgesUsed = 0;

        System.out.println("Edges in Minimum Spanning Tree : ");

        // Process edges from smallest to largest
        for(Edge edge : graph){
            int rootSrc = find(parent , edge.source);
            int rootDest = find(parent ,edge.destination);

            // if root are different , adding this edge
            // it will NOT create a Cycle
            if(rootSrc != rootDest){

                System.out.println((char)('A' + edge.source) + " - " +
                                   (char)('A' +edge.destination) + " : " +
                                    edge.weight);
            }

            totalWeight += edge.weight;

            union(parent , rank , edge.source , edge.destination);
            edgesUsed++;

            // MST contains V-1 edges
            if(edgesUsed == vertices-1){
                break;
            }
        }
        System.out.println("Total MST weight = " +totalWeight);
    }
}
