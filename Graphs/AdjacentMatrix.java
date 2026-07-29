public class AdjacentMatrix {
    public static void main(String[] args) {
        // graphs representation in matrix
        // 0 - means not connected
        // 1 - means connected
        // row , column - vertices
        int [][] graph = {
                {0,1,1,0},
                {1,0,1,0},
                {1,1,0,1},
                {0,0,1,0}
        };

        System.out.println(graph[2][1]);  // 1
        System.out.println(graph[3][1]);  // 0
    }
}
