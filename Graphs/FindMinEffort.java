
import java.util.Arrays;
import java.util.PriorityQueue;

public class FindMinEffort {
    public static void main(String[] args) {
        int[][] heights = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };

        int answer = minimumEffortPath(heights);

        System.out.println("Minimum Effort : "+answer);
    }

    static class Pair{
        int efforts;
        int row;
        int col;

        Pair(int efforts , int row , int col){
            this.efforts = efforts;
            this.row = row;
            this.col = col;
        }
    }
    static int minimumEffortPath(int[][] heights){
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] effort = new int[rows][cols];

        for(int[] row : effort){
            Arrays.fill(row , Integer.MAX_VALUE);
        }

        int[][] directions = {
                {-1 ,0 },
                 {1, 0},
                {0 , -1},
                {0 , 1}
        };


        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.efforts - b.efforts);

        effort[0][0] = 0;
        pq.offer(new Pair (0,0,0));

        while(!pq.isEmpty()){

            Pair current = pq.poll();

            int currentEffort = current.efforts;
            int row = current.row;
            int col = current.col;

            if(row == rows-1 && col == cols-1){
                return currentEffort;
            }

            for(int[] direction : directions){

                int newRow = row+direction[0];
                int newCol = col + direction[1];

                if(newRow < 0 || newCol <0 || newRow >= rows || newCol >= cols){
                    continue;
                }

                int difference = Math.abs(heights[row][col] - heights[newRow][newCol]);

                int newEffort = Math.max(difference , currentEffort);

                if(newEffort < effort[newRow][newCol]){
                    effort[newRow][newCol] = newEffort;

                    pq.offer(new Pair(newEffort , newRow , newCol));
                }
            }
        }
        return 0;
    }
}
