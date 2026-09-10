package ChatGPT_Problems.Graphs;

public class AdjacentMatrix {
    public static void main(String[] args) {
        // graphs representation in matrix
        int [][] graph = {
                {0,1,1,0},
                {1,0,1,0},
                {1,1,0,1},
                {0,0,1,0}
        };

        System.out.println(graph[2][1]);
        System.out.println(graph[3][1]);
    }
}
