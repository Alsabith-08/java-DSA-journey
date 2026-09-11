package LeetCodeEx.SlidingWindow;

public class MaxNoOfVowelsSubString_1456 {
    public static void main(String[] args) {

        String s = "abciiidef";
        int k = 3;

        System.out.println(maxVowels(s , k));
    }
    static int maxVowels(String s , int k){

        int count = 0;

        // first window
        for(int i = 0; i< k ; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }

        int maxVowel = count;

        // slide the window
        for(int i= k ; i< s.length() ; i++ ){

            // remove the character leaving the window
            if(isVowel(s.charAt(i - k))){
                count --;
            }

            // add the new Character
            if(isVowel(s.charAt(i))){
                count++;
            }
            maxVowel = Math.max(maxVowel , count);
        }
        return maxVowel;
    }
    static boolean isVowel(char c){
        return c == 'a' ||  c == 'e' ||  c == 'i' ||  c == 'o' ||  c == 'u' ;
    }
}
