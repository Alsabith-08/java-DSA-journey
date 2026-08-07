package BasicProblems;

import java.util.ArrayList;

public class Graph {
    public static void main(String[] args) {

        // Adjacent Matrix
        int vertices = 5;

        int[][] graph = new int[vertices][vertices];

        // Add Edges
        graph[0][1] = 1;
        graph[1][0] = 1;

        graph[1][2] = 1;
        graph[2][1] = 1;

        graph[1][3] = 1;
        graph[3][1] = 1;

        graph[2][4] = 1;
        graph[4][2] = 1;
        System.out.println("\nAdjacent Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        // Adjacent List
        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();

        // create an empty list
        for (int i = 0; i < vertices; i++) {
            graph1.add(new ArrayList<>());
        }

        // Add edges
        graph1.get(0).add(1);
        graph1.get(1).add(0);

        graph1.get(0).add(2);
        graph1.get(2).add(0);

        graph1.get(1).add(3);
        graph1.get(3).add(1);

        graph1.get(2).add(4);
        graph1.get(4).add(2);

        System.out.println("\nAdjacent List");
        print(graph1);

        
        // Add Edge
        addEdge edge = new addEdge();

        int v = 5;
        for (int i = 0; i < v; i++) {
            edge.graph.add(new ArrayList<>());
        }

        // Add Edges
        edge.addEdge(0, 3);
        edge.addEdge(0, 2);
        edge.addEdge(1, 3);
        edge.addEdge(2, 4);

        System.out.println("\nNew Edges List : ");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " -> ");

            for (int neighbour : edge.graph.get(i)) {
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }

        // Count the edges of Each Vertex
        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();

        // create an empty list
        for (int i = 0; i < vertices; i++) {
            graph2.add(new ArrayList<>());
        }

        // Add edges
        graph2.get(0).add(1);
        graph2.get(1).add(0);

        graph2.get(0).add(2);
        graph2.get(2).add(0);

        graph2.get(1).add(3);
        graph2.get(3).add(1);

        graph2.get(2).add(4);
        graph2.get(4).add(2);

        // Count the edge fo each Vertices
        System.out.println("\nCount the edges :");
        for (int i = 0; i < vertices ; i++) {
            System.out.println("Vertex : " + i + " -"+ graph2.get(i).size());
        }

    }
    static class addEdge {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        void addEdge(int u, int v) {

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
    // Print the Adjacent List
    static void print(ArrayList<ArrayList<Integer>> graph){
        for (int i = 0; i <graph.size() ; i++) {
            System.out.print(i + " ->");

            for(int neighbour : graph.get(i)){
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }
    }
}
