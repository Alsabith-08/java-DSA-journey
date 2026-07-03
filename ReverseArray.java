
// just swap the two pointer values that all for the reverse the arr
// i from start and  j from last index just swap and increment the i value and decrement the j value
// the condition ( i < j ) break the array is reversed.
public class ReverseArray {
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,7,8};
        //before sorted
        for(int nums : arr) {
            System.out.print(nums + " ");
        }
        System.out.println();

        reverse(arr);
        //After sorted
        System.out.println(Arrays.toString(arr));
        
    }
    static void  reverse(int[] arr){
        int i=0 , j =  arr.length-1;

        while(i < j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
