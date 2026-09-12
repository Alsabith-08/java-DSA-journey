package LeetCodeEx.PrefixSum;

public class FindHighestAltitude_1732 {
    public static void main(String[] args) {

        int [] gain = {-5, 1,5,0,-7};

        System.out.println(highestAlt(gain));
    }
    static int highestAlt(int[] gain){

        int currentAlt = 0;
        int maxtAlt = 0;

        for(int val : gain){
            currentAlt += val;
            maxtAlt = Math.max(maxtAlt , currentAlt);
        }
        return maxtAlt;
    }
}
