import java.util.HashMap;

public class FindNon_RepeatingCharacter {
    public static void main(String[] args) {
        String str = "aawbcddeffrr";

        HashMap<Character , Integer> map = new HashMap<>();

        // Count Frequency
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(map.containsKey(ch)){
                map.put(ch , map.get(ch)+1);
            }else{
                map.put(ch , 1);
            }
        }

        // Find Non-Repeating Character
        for(int i=0 ; i<str.length(); i++){
            char ch = str.charAt(i);

            if(map.get(ch) == 1){
                System.out.println("First non-repeating character "+ ch);
                return;
            }
        }
        System.out.println("No non-Repeating Character found!");
    }
}
