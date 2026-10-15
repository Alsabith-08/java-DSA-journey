package LeetCodeEx.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix_542 {
    public static void main(String[] args) {
        int [][] matrix = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };

        int[][] result = updateMatrix(matrix);
        System.out.println("Result :");

        for(int[] row : result){
            System.out.println(Arrays.toString(row));
        }
    }

    static int[][] updateMatrix(int[][] matrix) {

        // get matrix size
        int rows = matrix.length;
        int cols = matrix[0].length;

        // create queue
        Queue<int[]> queue = new LinkedList<>();

        // Add all 0 cells to the queue and otherwise all 1s becomes -1. ->(-1 means not been visited)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (matrix[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                } else {
                    matrix[r][c] = -1;
                }
            }
        }

        // direction
        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        // BFS
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // check boundary
                if (newRow < rows && newCol < cols && newRow >= 0 && newCol >= 0) {

                    if (matrix[newRow][newCol] == -1) {

                        // calculate distance
                        matrix[newRow][newCol] = matrix[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
                return matrix;
            }
        }
