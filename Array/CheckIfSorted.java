package ChatGPT_Problems;

public class CheckIfSorted {
    public static void main(String[] args) {
      int[] arr = {2,4,6,8,18,2};

        for (int i = 0; i < arr.length -1 ; i++) {
            if(arr[i] <= arr[i+1]){

            }
            else{
                System.out.println("false");
                break;
            }
        }
     //   System.out.println("True");
    }
}
