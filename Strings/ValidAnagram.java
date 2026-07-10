package ChatGPT_Problems;

public class ValidAnagram {
    public static void main(String[] args) {

        String str1 = "Deco";
        String str2 = "Dcoe";

        System.out.println(checkAnagram(str1 , str2));
    }
    static boolean checkAnagram(String str1 , String str2){

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        int m = str1.length();
        int n = str2.length();

        if(m != n){
            return false;
        }else {
            int[] count  = new int[26];

            for (int i = 0; i < m; i++) {
                count[str1.charAt(i) - 'a' ] ++;
            }
            for (int i = 0; i < n ; i++) {
                count[str2.charAt(i) - 'a'] --;
            }
            for (int i = 0; i < count.length; i++) {
                if(count[i] != 0){
                    return false;
                }
            }
        }
      return true;
    }
}
