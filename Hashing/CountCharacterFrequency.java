import java.util.HashMap;

public class CountCharacterFrequency {
    public static void main(String[] args) {

        String str = "alsabithberlinitachi";
        HashMap<Character , Integer> map = new HashMap<>();

        for(int i=0; i<str.length() ; i++){
            char ch = str.charAt(i);

            if(map.containsKey(ch)){
                map.put(ch , map.get(ch)+1);
            }else{
                map.put(ch , 1);
            }
        }
        System.out.println("Characters Frequencies");
        for(char key : map.keySet()){
            System.out.println(key + " = " + map.get(key));
        }
    }
}
