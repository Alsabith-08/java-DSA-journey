package LeetCodeEx.Strings;

// https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/description/
public class MinimumNoOfChairs_3168 {
    public static void main(String[] args) {
         String s = "ELELEEL";

        System.out.println(minChairs(s));
    }
    static int minChairs(String s){
        int people = 0;
        int chair = 0;

        for(char ch : s.toCharArray()){
            if (ch =='E'){
                people += 1;
                if(chair < people){
                    chair += 1;
                }
            }else{
                people -= 1;
            }
        }
        return chair;
    }
}
