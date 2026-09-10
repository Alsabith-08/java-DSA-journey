package ChatGPT_Problems.Graphs;

import java.util.ArrayList;

public class AdjacentList {
    public static void main(String[] args) {
        // List
        int vertices = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(2);

        graph.get(2).add(0);
        graph.get(2).add(1);
        graph.get(2).add(3);

        graph.get(3).add(2);

        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " - ");

            for(int neighbour : graph.get(i)){
                System.out.print(neighbour + " ");
            }
            System.out.println();
        }




    }
}
