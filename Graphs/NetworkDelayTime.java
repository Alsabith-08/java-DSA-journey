import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };
        int n = 4;
        int k = 2;

        int result = networkDelayTime(times , n, k);

        System.out.println("Network Delay TIme : " + result);
    }

    static class Pair{
        int node;
        int distance;

        Pair(int node , int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    static int networkDelayTime(int[][] times , int n , int k){

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i <=n ; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int weight = time[2];

            graph.get(u).add(new Pair(v , weight));
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);

        pq.offer(new Pair(k , 0));

        while(!pq.isEmpty()){

            Pair current = pq.poll();

            int currentNode = current.node;
            int currentDistance = current.distance;

            if(currentDistance > dist[currentNode]){
                continue;
            }

            for(Pair edge : graph.get(currentNode)){

                int nextNode = edge.node;
                int edgeWeight = edge.distance;

                int newDistance = currentDistance + edgeWeight;

                if(newDistance < dist[nextNode]){
                    dist[nextNode] = newDistance;

                    pq.offer(new Pair (nextNode , newDistance));
                }
            }
        }
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            answer = Math.max(answer , dist[i]);
        }
       return answer;
    }
}
