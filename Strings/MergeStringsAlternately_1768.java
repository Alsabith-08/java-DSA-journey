package ChatGPT_Problems.Strings;

public class MergeStringsAlternately_1768 {
    public static void main(String[] args) {
        String word1 = "alsa";
        String word2 = "bith";

        String answer = mergeString(word1 , word2);
        System.out.println(answer);
    }

    static String mergeString(String word1 , String word2){

        StringBuilder result = new StringBuilder();

        int i = 0;
        int j = 0;

        while(i < word1.length() || j < word2.length()){

           if(i < word1.length()){
               result.append(word1.charAt(i));
               i++;
           }

           if(j < word2.length()){
               result.append(word2.charAt(j));
               j++;
           }
        }
       return result.toString();
    }
}
