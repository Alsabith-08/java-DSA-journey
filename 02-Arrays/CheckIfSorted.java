
public class CheckIfSorted {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        System.out.println(checkSorted(arr));

    }
    static boolean checkSorted(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            
            // for ascending order
//            if(arr[i] <= arr[i+1]){
//
//            }else{
//                return false;
//            }

            // for descending order
            if(arr[i] >= arr[i+1]){

            }else{
                return false;
            }
        }
        return true;
    }
}
