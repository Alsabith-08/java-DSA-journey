import java.util.*;

public class DijkstraShortestPath {
    public static void main(String[] args) {

        int n = 5;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add Edges
        graph.get(0).add(new Edge(1,4));
        graph.get(0).add(new Edge(2,1));
        graph.get(0).add(new Edge(3,10));
        graph.get(1).add(new Edge(3,2));
        graph.get(2).add(new Edge(3,1));
        graph.get(3).add(new Edge(4,3));

        int source = 0;
        int destination = 4;

        List<Integer> path = dijkstra(graph , source , destination);

        if(path.isEmpty()){
            System.out.println("No Path Exists");
        }else{
            for (int i = 0; i <path.size() ; i++) {
                System.out.print(path.get(i));

                if(i != path.size() -1){
                    System.out.print(" -> ");
                }
            }
        }

    }
    static class Edge{
        int destination;
        int weight;

        Edge(int destination , int weight){
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Pair{
        int node;
        int distance;

        Pair(int node , int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    static List<Integer> dijkstra(ArrayList<ArrayList<Edge>> graph , int source , int destination){

        int n = graph.size();

        //shortest distance from source
        int[] dist = new int[n];

        // parent of every node
        int[] parent = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        Arrays.fill(parent , -1);

        dist[source] = 0;

        //priority Queue
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);

        pq.offer(new Pair(source , 0));

        while(!pq.isEmpty()){
            Pair current = pq.poll();

            int currentNode = current.node;
            int currentDistance = current.distance;

            if(currentDistance > dist[currentNode]){
                continue;
            }

            for(Edge edge : graph.get(currentNode)){
                int nextNode = edge.destination;
                int weight = edge.weight;

                int newDistance = weight + currentDistance;

                if(newDistance < dist[nextNode]){
                    dist[nextNode] = newDistance;

                    parent[nextNode] = currentNode;

                    pq.offer(new Pair(nextNode , newDistance));
                }
            }
        }
        if(dist[destination] == Integer.MAX_VALUE){
            return new ArrayList<>();
        }

        // Reconstruct Path
        ArrayList<Integer> path = new ArrayList<>();

        int current = destination;

        while(current != -1){
            path.add(current);
            current = parent[current];
        }

        // currently destination -> source
        Collections.reverse((path));

        System.out.println("Shortest Distance = " + dist[destination]);

        return path;
    }
}
