package ChatGPT_Problems.Recursion;

public class SortedArray {
    public static void main(String[] args) {
        int[] arr = {1,4,5,6,7,3};
        int index = 0;

        System.out.println(checkSorted(arr , index));
    }
    static boolean checkSorted(int[] arr , int index){
        if(index == arr.length -1){
            return true;
        }
        return arr[index] < arr[index+1] && checkSorted( arr , index+1);
    }
}
