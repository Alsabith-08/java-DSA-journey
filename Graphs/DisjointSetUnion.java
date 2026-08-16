public class DisjointSetUnion {
    public static void main(String[] args) {
        disjointSetUnion dsu = new disjointSetUnion(6);

        System.out.println("\nInitially :");
        dsu.printParent();

        // Merge Sets
        dsu.union(0,1);
        dsu.union(1,2);
        dsu.union(3,4);

        System.out.println("\nAfter Unions : ");
        dsu.printParent();

        // check Connection
        System.out.println("\n Are 0 and 2 connected : ");
        System.out.println(dsu.connected(0 , 2));

        System.out.println("\n Are 0 and 3 connected : ");
        System.out.println(dsu.connected(0 , 3));

        // Try connected two Already connected nodes
        System.out.println("\n Trying union(0,2)");

        boolean result = dsu.union(0,2);

        if(result) {
            System.out.println("Union Successfully");
        }else {
            System.out.println("Already Connected - cycle would be Created");
        }

        // connect two different sets

        result = dsu.union(2,3);
        if(result){
            System.out.println("Union Successfully");
        }else {
            System.out.println("Already Connected " );
        }

        System.out.println("\n Final :");
        dsu.printParent();
    }
    static class disjointSetUnion{
        int[] parent;
        int[] rank;

        disjointSetUnion(int n){
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i <n ; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int x){
            if(parent[x] == x){
                return x;
            }
            parent[x]  = find(parent[x]);
            return parent[x];
        }

        boolean union(int a , int b){
            int rootA = find(a);
            int rootB = find(b);

            if(rootA == rootB){
                return false;
            }

            if(rank[rootA] < rank[rootB]){
                parent[rootA]  = rootB;
            }else if(rank[rootA] > rank[rootB]){
                parent[rootB] = rootA;
            }else{
                rank[rootB] = rootA;
                rank[rootA]++;
            }
            return true;
        }

        boolean connected(int a , int b){
            return find(a) == find(b);
        }

        void printParent(){
            System.out.println("Parent Array");

            for (int i = 0; i < parent.length ;i++) {
                System.out.print(parent[i] + " ");
            }
            System.out.println();
        }
    }
}
