package LeetCodeEx;

public class ReverseWords_151 {
    public static void main(String[] args) {
        String s = "the sky is blue  ";

        String answer = reverseWord(s);
        System.out.println("Input  : "+  s);
        System.out.println("Output :" + answer);
    }
    static String reverseWord(String s){
        // remove the space from start and end
        s =s.trim();

        // split words using one or more Spaces
        String[] words = s.split("\\s+");

        StringBuilder result = new StringBuilder();

        // Traverse from last word to first word
        for (int i = words.length -1; i >= 0; i--) {
                result.append(words[i]);

                if(i != 0){
                    result.append(" ");
                }
        }
        return result.toString();
    }
}
