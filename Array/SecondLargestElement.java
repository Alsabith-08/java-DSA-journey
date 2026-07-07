public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {12, 21, 45, 65, 76, 87, 43};
        System.out.println(secondlargest(arr));
    }
    static int secondlargest(int[] arr){
        int largest =0;
        int slargest = -1;

        for (int i = 1; i <arr.length ; i++) {
            if(arr[i] > largest ){
                slargest = largest;
                largest =arr[i];
            }
            else if(arr[i] < largest && arr[i] > slargest){
                slargest = arr[i];
            }
        }
        return slargest;
    }
}
