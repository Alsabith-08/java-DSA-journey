import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyAndRooms {
    public static void main(String[] args) {

        List<List<Integer>> rooms = new ArrayList<>();

        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(Arrays.asList());

        System.out.println(canVisitAllRooms(rooms));

    }
    static void dfs(int room , List<List<Integer>> rooms , boolean[] visited){
        visited[room] = true;
        System.out.println();

        for(int key : rooms.get(room)){
            if(!visited[key]){
                dfs(key , rooms, visited);
            }
        }
    }
    static boolean canVisitAllRooms(List<List<Integer>> rooms){
        boolean[] visited = new boolean[rooms.size()];

        dfs(0 , rooms , visited);

        for(boolean room : visited){
            if(!room){
                return false;
            }
        }
        return true;
    }
}
