
public class ValidAnagram {
    public static void main(String[] args) {

        String str1 = "Deco";
        String str2 = "Dcoe";

        System.out.println(checkAnagram(str1 , str2));
    }
    static boolean checkAnagram(String str1 , String str2){

        str1 = str1.toLowerCase();  // change the strings into lowerCase using toLowerCase() method
        str2 = str2.toLowerCase();

        int m = str1.length();  // in string to find length must put the brackets in last() 
        int n = str2.length();

        if(m != n){  // the 2 strings length not equal return false 
            return false;
        }else {
            int[] count  = new int[26];  // create a count[] array for all alphabets

            for (int i = 0; i < m; i++) {  // put 1 on array based on the first string value is  "Deco"
                count[str1.charAt(i) - 'a' ] ++;
            }
            for (int i = 0; i < n ; i++) {  // remove all 1 on the same array based on the second string value is "Dcoe"
                count[str2.charAt(i) - 'a'] --;
            }

            // so all array is 0 
            // if any value is not a 0
            //return false
            for (int i = 0; i < count.length; i++) {  
                if(count[i] != 0){
                    return false;
                }
            }
        }
      return true;
    }
}
