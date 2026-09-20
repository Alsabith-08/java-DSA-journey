package ChatGPT_Problems.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1_s {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,0},
                {0,1,0},
                {1,0,0},
        };

        int[][] result = nearestOne(grid);

        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] nearestOne(int[][] grid){

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dist = new int[rows][cols];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
                if(grid[i][j] == 1){
                    dist[i][j] = 0;
                    queue.add(new int[]{i ,j});
                }
                else{
                    dist[i][j]= -1;
                }
            }
        }

        int[][] directions = {
                {-1 , 0},
                {1 , 0},
                {0,-1},
                {0,1}
        };

        while(!queue.isEmpty()){

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for(int[] direction : directions){
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if(newRow >=0 && newCol >= 0 && newRow < rows && newCol < cols && dist[newRow][newCol] == -1){
                    dist[newRow][newCol] = dist[row][col] +1;

                    queue.offer(new int[]{newRow , newCol});
                    }
                }
            }
        return dist;
        }
    }

