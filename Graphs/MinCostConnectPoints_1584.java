//https://leetcode.com/problems/min-cost-to-connect-all-points/description/
// Time Complexity - O(n*n)
// Space complexity - O(n)
import java.util.Arrays;

public class MinCostConnectPoints_1584 {
    public static void main(String[] args) {
        int[][] points = {
                {0, 0},
                {2, 2},
                {3, 10},
                {5, 2},
                {7, 0}
        };
        int answer = minCostConnectPoints(points);
        System.out.println("minimum cost " + answer);
    }

    // calculates the manhattan Dsitance
     static int getDistance(int[] point1 , int[] point2){
        return Math.abs(point1[0] - point2[0]) +
                Math.abs(point1[1] - point2[1]);
    }

    // Finds the cheapest Unvisited Point
    static int findMinPoint(boolean[] visited , int[] minDist){

        int current = -1;
        for (int i = 0; i < minDist.length; i++) {
            if(!visited[i] && (current == -1 || minDist[i] < minDist[current])){
                current =i;
            }
        }
        return current;
    }

    // update the cheaper connection to another point
    static void updateDistance(int current , int[][] points , boolean[] visited , int[] minDist){
        for (int next = 0; next < points.length; next++) {

            if(!visited[next]){
                int distance = getDistance(points[current] , points[next]);

                if(distance < minDist[next]){
                    minDist[next] = distance;
                }
            }
        }
    }
    // Mininum Cost Connect Points
    static int minCostConnectPoints(int[][] points){
        int n = points.length;

        boolean[] visited = new boolean[n];

        // this always keep the cheapest Distance
        int[] minDist = new int[n];

        Arrays.fill(minDist , Integer.MAX_VALUE);

        minDist[0] = 0;
        int totalCost = 0;

        for(int count = 0; count < n ; count ++){
            int current = findMinPoint(visited , minDist);

            visited[current]= true;
            totalCost += minDist[current];

            updateDistance(current ,points ,  visited , minDist );
        }
        return totalCost;
    }
    
    
    

   
}
