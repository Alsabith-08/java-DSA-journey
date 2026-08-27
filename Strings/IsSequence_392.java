//https://leetcode.com/problems/is-subsequence/description/

public class IsSequence_392 {
    public static void main(String[] args) {
        String s = "abc";
        String t = "aadsbc";

        System.out.println(sequence(s , t));
    }
    static boolean sequence(String s , String t) {

      int i = 0;  // pointer for s
      int j = 0;  // pointer for t

      while(i < s.length() && j < t.length()){
          // compare character by character : if equal move i and always move the j
          if(s.charAt(i) == t.charAt(j)){
              i++;
          }
          j++;
      }
      // Final Check : if i reached the end of s, every character was found
      return i == s.length();
    }
}
