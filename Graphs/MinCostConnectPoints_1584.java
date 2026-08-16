package LeetCodeEx;

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
    static int minCostConnectPoints(int[][] points){
        int n = points.length;

        boolean[] visited = new boolean[n];
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
    static int findMinPoint(boolean[] visited , int[] minDist){

        int current = -1;
        for (int i = 0; i < minDist.length; i++) {
            if(!visited[i] && (current == -1 || minDist[i] < minDist[current])){
                current =i;
            }
        }
        return current;
    }
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

    static int getDistance(int[] point1 , int[] point2){
        return Math.abs(point1[0] - point2[0]) +
                Math.abs(point1[1] - point2[1]);
    }
}
