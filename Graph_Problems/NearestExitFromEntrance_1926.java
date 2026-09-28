package LeetCodeEx.Graph;

import java.util.LinkedList;
import java.util.Queue;
//import ChatGPT_Problems.LinkedList.LinkedList;

//https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/description/
public class NearestExitFromEntrance_1926 {
    public static void main(String[] args) {

        char[][] maze = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };

        int[] entrance = {1,2};

        System.out.println(nearestExit(maze , entrance));
    }
    public static int nearestExit(char[][] maze , int[] entrance){
        int rows = maze.length;
        int cols = maze[0].length;

        int[][] directions = {
                {-1 ,0},
                {1 , 0},
                {0 , 1},
                {0, -1}
        };

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {
                entrance[0] , entrance[1] , 0}
        );

        maze[entrance[0]][entrance[1]] = '+';

        // BFS
        while(!queue.isEmpty()){
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int distance = current[2];

            // try 4 directions
            for(int[] direction : directions){
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];

                // Check whether the next cell is inside the maze
                if (nextRow < 0 ||
                        nextRow >= rows ||
                        nextCol < 0 ||
                        nextCol >= cols) {

                    continue;
                }
                // check the next cell is inside the maze
                if(maze[nextRow][nextCol] != '.'){
                    continue;
                }

                // mark this cell as visited
                maze[nextRow][nextCol] = '+';

                int newDistance = distance+1;

                // if this cell is on the boundary
                // it is an exit
                if(nextRow ==0 || nextCol == 0 || nextCol == cols-1 || nextRow == rows -1 ){
                    return newDistance;
                }

                // Add the cell to the queue
                queue.add(new int[]{
                        nextRow , nextCol , newDistance
                });
            }
        }
        return -1;
    }

}
