
// Find the Shortest Path in Binary Matrix 
// Start to destination : (0 , 0) -> (n-1)(n-1)  , n -> grid.length
// Time Complexity : n x n -> O(n²) 

import java.util.LinkedList;
import java.util.Queue;
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0,1},
                {0,0,1,0},
                {1,0,0,0},
                {1,1,1,0}
        };
        System.out.println(shortestPath(grid));
    }
    static int shortestPath(int[][] grid){
        int n= grid.length;

        // check the start and destination is 0
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }

        // all 8 direction -> diagonal 4 , up , down , left , right
        int[][] directions = {
                {-1 , -1},  {-1 , 0}, {-1 , 1},
                {0 , -1},             {0 , 1},
                {1 , -1},  {1 , 0},   { 1,1 }
        };

        // create a Queue in array
        Queue<int[]> queue = new LinkedList<>();

        // add to queue
        // initially row , col , distance -> row=0 , col=0 , distance=1
        queue.offer(new int[]{0 , 0 , 1});

        // mark visited the start
        grid[0][0] = 1;

        //traverse - BFS
        while(!queue.isEmpty()){

            int[] current  = queue.poll();

            // the current is {0,0,1}
            // actually , row = 0 , col = 0 , distance = 1
            int row = current[0];                   // current[0] means = the 0 is the index of current contain in queue
            int col = current[1];
            int distance = current[2];

            // check destination is reached
            if(row == n-1 && col == n-1){
                return distance;
            }

            //explore All Direction
            for(int[] direction : directions){

                // calculate the newRow and newCol
                // suppose current = (1,1) and direction =(-1,-1) ->then : newRow = 1+(-1) = 0
                int newRow = row + direction[0];                      // : newCol = 1+(-1) = 0
                int newCol = col + direction[1];

                //check boundary
                if(newRow >=0 && newRow < n && newCol >=0 && newCol < n ){

                    // check cell is open
                    if(grid[newRow][newCol] == 0){
                        // Mark visited
                        grid[newRow][newCol] = 1;

                        // add new cell to queue
                        queue.offer(new int[]{newRow , newCol , distance+1});
                    }
                }
            }
        }
        return -1;
    }
}
