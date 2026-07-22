import java.util.HashMap;
import java.util.Map;

public class CountFrequencyOfElement {
    public static void main(String[] args) {
        // Array
        int[] arr = {1,2,3,4,3,2,1,6,5};
        count(arr);
    }
    public static void count(int[] arr){

        HashMap<Integer , Integer> map = new HashMap<>();

        // count frequency
        for(int i= 0; i< arr.length ; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i] , map.get(arr[i]) + 1);
            }else{
                map.put(arr[i] , 1);
            }
        }
        System.out.println("key - frequency" );
        // Print Frequency
        for(Map.Entry<Integer , Integer> i : map.entrySet()){
            System.out.println(i.getKey() + " - " + i.getValue());
        }

    }

}
