package ChatGPT_Problems.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Multi_Source_BFS {
    public static void main(String[] args) {

        int[][] grid = {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,0,1},
                {0,0,0,0}
        };

        int[][] distance = multiSourceBFS(grid);

        System.out.println("Output : ");
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[0].length ; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] multiSourceBFS(int[][] grid){

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] distance = new int[rows][cols];

        // -1 means not visited
        for (int i = 0; i <rows ; i++) {
            Arrays.fill(distance[i] , -1);
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j < cols; j++) {

                if(grid[i][j] == 1){
                    queue.offer(new int[]{i ,j});
                    distance[i][j] = 0;
                }
            }
        }

        int[][] directions = {
                {-1 , 0},
                {1,0},
                {0,-1},
                {0,1}
        };
        // BFS
        while(!queue.isEmpty()){
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] direction : directions){
                int newRow = row+ direction[0];
                int newCol = col+ direction[1];

                if(newRow < 0 || newCol < 0 || newCol >= cols || newRow >= rows){
                    continue;
                }

                // Already visited
                if(distance[newRow][newCol] != -1){
                    continue;
                }

                // set Distance
                distance[newRow][newCol] = distance[row][col] +1;

                //Add to Queue
                queue.offer(new int[]{newRow , newCol});
            }
        }
        return distance;
    }
}
