import java.util.HashMap;

public class FindDuplicates {
    public static void main(String[] args) {

        int[] arr ={10,20,40,40,80,40,20,50,60,10};

        HashMap<Integer , Integer> map = new HashMap<>();

//        for(int i=0 ; i<arr.length ; i++){
//            if(map.containsKey(arr[i])){
//                map.put(arr[i] , map.get(arr[i]) + 1);
//            }else{
//                map.put(arr[i] , 1);
//            }
//        }

        // OR
        // use the getorDefault (Object key , defaultValue integer) to alternate
        // if the key exists , return its value
        // if the key doesn't exist , returns 0

        for(int num : arr){
            map.put(num, map.getOrDefault(num , 0) + 1);
        }
        for(int key: map.keySet()){
            if(map.get(key) > 1){
                System.out.println(key);
            }
        }
    }
}
