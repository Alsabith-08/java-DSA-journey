

// Find the Distance of nearest cell Having 1's
// Approach : Multi-Source BFS(4 direction)
// TIme Complexity : O(rows * cols)   , Space Complexity O(rows * cols)

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

    // Find the nearest distance of Ones
    static int[][] nearestOne(int[][] grid){

        int rows = grid.length;                           // rows Length
        int cols = grid[0].length;                        // columns Length

        int[][] dist = new int[rows][cols];               // create a distance (empty)matrix of grid length

        Queue<int[]> queue = new LinkedList<>();          // create a empty Queue

        for (int i = 0; i <rows ; i++) {                  // initially add the cell which contains 1 on queue
            for (int j = 0; j <cols ; j++) {              // on the other hand , update the distance matrix  if gird is 1 change it 0 , if 0 change it to -1
                if(grid[i][j] == 1){
                    dist[i][j] = 0;
                    queue.add(new int[]{i ,j});
                }
                else{
                    dist[i][j]= -1;
                }
            }
        }

        int[][] directions = {                            // initialize 4 possible direction (up , down , left , right)
                {-1 , 0},   
                {1 , 0},
                {0,-1},
                {0,1}
        };

        // BFS
        while(!queue.isEmpty()){

            // take the first cell of the queue
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            
            for(int[] direction : directions){                     // check it neighbour
                int newRow = row + direction[0];                   // find the newRow and newCol
                int newCol = col + direction[1];

                // check boundaries -> row and column inside matrix , cell is unvisited
                if(newRow >=0 && newCol >= 0 && newRow < rows && newCol < cols && dist[newRow][newCol] == -1){
                    dist[newRow][newCol] = dist[row][col] +1;         // calculate distance nad add new cell to Queue

                    queue.offer(new int[]{newRow , newCol});
                    }
                }
            }
        return dist;
        }
    }

