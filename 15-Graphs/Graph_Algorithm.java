
/*   Learn - Revise : 
   1. BFS             - unweighted shortest Path
   2. DFS             - deep traversal / components / cycles
   3. Dijkstra        - weighted shortest path , No negative edges
   4. Bellman-Ford    - weighted shhortest path , negative edges
   5. Prim's          - MST , grow from vertex
   6. Kruskal's       - MST , sort edges
   7. DSU             - groups + cycle Dectection + kruskal
   8. when to choose which algorithm
*/

import java.util.*;
import java.util.Arrays;
import java.util.Queue;

public class Graph_Algorithm {
    public static void main(String[] args) {

        // ------------------------------------------------------------------
        // Unweighted graph for BFS / DFS   [ edges ]
        // ----------------------------------------------------------------
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <6 ; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(2).add(0);
        graph.get(2).add(5);

        graph.get(3).add(1);
        graph.get(4).add(1);
        graph.get(5).add(2);

        System.out.println("\nBFS");
        bfs(graph , 0);

        System.out.println("\nDFS");
        boolean[] visited = new boolean[6];
        dfs(graph , 0 , visited);
        System.out.println();


        //----------------------------------------------------------------------------------------
        // Weighted Graph for Dijkstra / BellmanFord [  edges  ]
        // ------------------------------------------------------------------------------------

        int n = 5;
        List<List<Edge>> weightedGraph = new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            weightedGraph.add(new ArrayList<>());
        }

        addDirectedGraph(weightedGraph ,0,1,4);
        addDirectedGraph(weightedGraph ,0,2,2);
        addDirectedGraph(weightedGraph ,1,2,1);
        addDirectedGraph(weightedGraph ,1,3,5);
        addDirectedGraph(weightedGraph ,2,3,8);
        addDirectedGraph(weightedGraph ,2,4,10);
        addDirectedGraph(weightedGraph ,3,4,2);


        dijkstra(weightedGraph ,0);
        System.out.println();

        int vertices = 4;
        List<Edge> bellmanEdges = new ArrayList<>();

        bellmanEdges.add(new Edge(0,1,4));
        bellmanEdges.add(new Edge(0,2,5));
        bellmanEdges.add(new Edge(1,2,-2));
        bellmanEdges.add(new Edge(2,3,3));
        bellmanEdges.add(new Edge(1,3,4));

        bellmanFord(bellmanEdges , vertices , 0);
        System.out.println();

        // ---------------------------------------------------------------------------
        // Kruskal  &   Prim [ edges ]
        // ---------------------------------------------------------------------------

        List<Edge> mstEdges = new ArrayList<>();

        mstEdges.add(new Edge(0,1,5));
        mstEdges.add(new Edge(0,2,10));
        mstEdges.add(new Edge(0,3,9));
        mstEdges.add(new Edge(1,3,4));
        mstEdges.add(new Edge(2,3,13));
        mstEdges.add(new Edge(2,4,14));
        mstEdges.add(new Edge(3,4,7));
        mstEdges.add(new Edge(3,5,8));
        mstEdges.add(new Edge(4,5,2));

        kruskal(mstEdges , 6);

        Prim(weightedGraph);

        //  ------------------------------------------------------------------------------
        // DSU
        //  ------------------------------------------------------------------------------

        DSU dsu =new DSU(5);
        System.out.println("\nDSU :");

        System.out.println("Add edge : "+dsu.union(0,1));
        System.out.println("Add edge :"+dsu.union(1,2));
        System.out.println("Add edge :"+dsu.union(3,4));
        System.out.println("Add edge :"+dsu.union(0,2));

        System.out.println("Find(2) = "+ dsu.find(2));
    }

    // -------------------------------------------------------------
    // Add Undirected Edge
    // ---------------------------------------------------------
    static void addDirectedGraph(List<List<Edge>> graph , int u , int v , int weight){
        graph.get(u).add(new Edge(u ,v, weight));
        graph.get(v).add(new Edge(v ,u, weight));
    }

    // ------------------------------------------------------------------
    // BFS - Breadth First Search  : explore level by level ,  Data Structure -> Queue
    //----------------------------------------------------------------
    static void bfs(List<List<Integer>> graph, int source){

        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.offer(source);

        while(!queue.isEmpty()){

            int node = queue.poll();
            System.out.print(node + " ");

            for(int neighbour : graph.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        System.out.println();
    }

    // -------------------------------------------------------------------
    // DFS - Depth First Search = go as deep as possible in that node , Data Structure -> Stack / Recursion
    // ------------------------------------------------------------------
    static void dfs(List<List<Integer>> graph , int node ,boolean[] visited  ){
        visited[node] = true;
        System.out.print(node + " ");

        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                dfs(graph , neighbour , visited);
            }
        }
    }

    // -----------------------------------------------------------
    // EDGE class
    // -----------------------------------------------------
    static class Edge{
        int source;
        int destination;
        int weight;

        Edge(int source, int destination , int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // --------------------------------------------------------------
    // Dijkstra = Used to find the Shortest Path or distance in positive WeightEdges ,  Data Structure -> priorityQueue
    // ------------------------------------------------------------
    static void dijkstra(List<List<Edge>> graph , int source){
        int n = graph.size();

        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[source] = 0;

        // priorityQueue is used for gives the smallest weight edges
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{source , 0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();

            int node = current[0];
            int currentDistance = current[1];

            if(currentDistance > dist[node]){
                continue;
            }

            for(Edge edge : graph.get(node)){

                int weight = edge.weight;

                int newDistance = weight + currentDistance;

                if(newDistance < dist[edge.destination]){
                    dist[edge.destination] = newDistance;
                    pq.offer(new int[]{edge.destination , newDistance});
                }
            }
        }
        System.out.println("\nMinimum Distance source " + source + " -> all other node : ");
        for (int i = 0; i <n ; i++) {
            System.out.println(" 0 ->" + i + " = " + dist[i]);
        }
    }

    // -------------------------------------------------------
    // BellmanFord : Used for Negative weight edges to find Shortest Path
    // ------------------------------------------------------
    static void bellmanFord(List<Edge> bellmanEdges , int vertices , int source){

        // create a dist Array with max integer Value
        int[] dist = new int[vertices];
        Arrays.fill(dist , Integer.MAX_VALUE);

        // initially source distance is 0
        dist[source] = 0;

        // go through V-1
        for (int i = 1; i <= vertices -1 ; i++) {

            // for each node , check distance is smaller than before update it
            for(Edge edge : bellmanEdges){

                if(dist[edge.source] != Integer.MAX_VALUE ){
                    // find the newDistance by adding edgeWeight and distanceOfSource that is that travelCost
                    int newDistance = edge.weight + dist[edge.source];

                    // update the newDistance(smallest)
                    if(newDistance < dist[edge.destination] ){
                        dist[edge.destination]  = newDistance;
                    }
                }
            }
        }
        // check negative Cycle
        for (Edge edge : bellmanEdges){

            if (dist[edge.source] != Integer.MAX_VALUE && dist[edge.source] + edge.weight < dist[edge.destination]) {
                System.out.println("Negative weight Cycle Detected");
                return;
            }
        }
        System.out.println("\nBellman-Ford");
        for (int i = 0; i < vertices; i++) {
            System.out.println(" 0 -> " +i + " = "+dist[i]);
        }
    }

    // -------------------------------------------------------------------------
    // DSU
    //-------------------------------------------------------------------------
    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int node) {
            if (parent[node] != node) {
               parent[node] = find(parent[node]);
            }
            return parent[node];
        }

        boolean union(int a , int b){
            int rootA = find(a);
            int rootB = find(b);

            if(rootA == rootB){
                return false;
            }

            if(rank[rootA] < rank[rootB]){
                parent[rootA] = rootB;
            }else if(rank[rootA] > rank[rootB]){
                parent[rootB] = rootA;
            }else{
                parent[rootB] = rootA;
                rank[rootA]++;
            }
            return true;
        }
    }

    // --------------------------------------------------------------
    // Kruskal
    // -------------------------------------------------------------

    static void kruskal(List<Edge> edges , int vertices){

        edges.sort((a,b) -> a.weight - b.weight);

        DSU dsu = new DSU(vertices);

        int totalWeight = 0;
        int edgesUsed = 0;

        System.out.println("MST edges : ");

        for(Edge edge : edges){
            if(dsu.union(edge.source , edge.destination)){
                System.out.println((char)('A' + edge.source) + " - " +
                        (char)('A' +edge.destination) + " : " +
                        edge.weight);

                totalWeight += edge.weight;
                edgesUsed++;

                if(edgesUsed == vertices-1){
                    break;
                }
            }
        }
        System.out.println("Minimum total MST weight : "+ totalWeight);
    }

    // -------------------------------------------------------------
    // Prim
    // ---------------------------------------------------------------
    static void Prim(List<List<Edge>> graph){
        int n = graph.size();

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]- b[1]);

        pq.offer(new int[]{0,0});

        int totalWeight = 0;
        System.out.println("\nPrim MST : ");

        while(!pq.isEmpty()){
            int[] current = pq.poll();

            int node = current[0];
            int weight = current[1];

            if(visited[node]) {
                continue;
            }
            visited[node] = true;
            totalWeight += weight;

            System.out.println("Added vertex "+ node + " with weight "+ weight);

            for(Edge edge : graph.get(node)){
                if(!visited[edge.destination]){
                    pq.offer(new int[]{edge.destination , edge.weight});
                }
            }
        }
        System.out.println("Totla MST weight : "+ totalWeight);
    }
}
