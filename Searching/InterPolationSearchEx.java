package DSA;

public class InterPolationSearchEx {
    public static void main(String[] args) {
        int[] arr ={1,2,4,8,16,32,64,128,512,1024};

        int index = interpolationSearch(arr , 32);

        if(index != -1){
            System.out.println("element found at " + index);
        }
        else{
            System.out.println("element not found");
        }

    }
    static int interpolationSearch(int[] arr , int value){
        int low = 0;
        int high = arr.length -1;

        while(value <= arr[high] && value >= arr[low] && low <= high){

            int probe = low + (high - low) * (value - arr[low]) /
                        (arr[high] - arr[low]);

            if(arr[probe] == value){
                return probe;
            }
            else if(arr[probe] < value){
                low = probe + 1;
            }
            else{
                high = probe -1;
            }
        }
        return -1;
    }
}
