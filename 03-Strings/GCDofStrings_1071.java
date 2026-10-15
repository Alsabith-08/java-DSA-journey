// https://leetcode.com/problems/greatest-common-divisor-of-strings/description/

// Greatest Common Strings 

/*
    Check : str1 + str2 == str2 + str1
    find  : GCD(length1 , length2)
    Return : str1.substring(0, gcdLength)
 */

public class GCDofStrings_1071 {
    public static void main(String[] args) {

        String str1 = "ALSAALSAALSA";
        String str2 = "ALSAALSA";

        System.out.println(gcdOfStrings(str1 , str2));
    }
    static String gcdOfStrings(String str1, String str2){

        if(!(str1 + str2 ).equals(str2 + str1)){
            return "";
        }
        int gcdLength =gcd(str1.length() , str2.length());

        return str1.substring(0 , gcdLength);
    }
    static int gcd(int a , int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
