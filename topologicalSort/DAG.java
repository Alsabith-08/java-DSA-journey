package ChatGPT_Problems.TopologicalSort;

import java.util.ArrayList;
import java.util.List;

public class DAG {
    public static void main(String[] args) {
        
        int vertices = 4;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices ; i++) {
            graph.add(new ArrayList<>());
        }
        
        graph.get(0).add(1);
        graph.get(0).add(2);
        graph.get(1).add(3);
        graph.get(2).add(3);

        for (int i = 0; i < vertices; i++) {
            System.out.println(i+ " ->" + graph.get(i));
        }
        
        
    }
}
