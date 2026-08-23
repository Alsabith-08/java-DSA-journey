package LeetCodeEx.Arrays;

public class CanPlaceFlower_605 {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,0,1};
        int n =2;

        boolean result = canPlacedFlower(flowerbed , n);
        System.out.println(result);
    }
    static boolean canPlacedFlower(int[] flowerbed , int n){

        for (int i = 0; i <flowerbed.length ; i++) {

            // check if current position is empty
            if(flowerbed[i] == 0){

                // check left side and right side
                boolean leftEmpty = (i==0  || flowerbed[i -1] == 0);
                boolean rightEmpty = (i == flowerbed.length -1 || flowerbed[i+1] == 0);

                if(leftEmpty && rightEmpty){
                    flowerbed[i] = 1;
                    n--;

                    // already planted enough flowers
                    if(n == 0) {
                        return true;
                    }
                }
            }
        }
        return n <= 0;
    }
}
