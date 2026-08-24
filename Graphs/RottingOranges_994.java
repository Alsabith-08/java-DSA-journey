

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges_994 {
    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        int result = orangesRotting(grid);
        System.out.println( "Minimum minutes :  " +result);
    }

    static int orangesRotting(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        // find all rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <cols ; j++) {
                if(grid[i][j]== 2){
                    queue.offer(new int[]{i , j});
                }

                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int minutes = 0;
        // four direction
        int[][] directions = {
                {-1,0},
                {1,0},
                 {0, -1},
                {0,1}
        };

        // BFS
        while(!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];

                    if (newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols) {
                        continue;
                    }

                    // if fresh oranges
                    if (grid[newRow][newCol] == 1) {

                        // Make it rotten
                        grid[newRow][newCol] = 2;

                        // one less fresh orange
                        fresh--;

                        // Add newly rotten oranges to queue
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            // one complete level = one minute
            minutes ++;
        }

            // if fresh oranges remains , impossible
            if(fresh >0){
                return -1;
            }
        return minutes;
    }
}
