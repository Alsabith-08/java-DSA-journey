public class CountVowels {
    public static void main(String[] args) {
        String s = "Alsabith";
        System.out.println(countVowels(s));
    }
    static int countVowels(String s){

        int count = 0;  // declare the count value as a 0
        // using the for loop to traverse the String 
        for(int i= 0; i< s.length() ; i++){
            // we are going to check  charactr by character(letter by letter) , so using the charAt() method
            char c = s.charAt(i);  
            // check the character is vowels or not 
            // if yes increment the count value 
            // then return count
            if(c =='a'||c =='e'||c =='i'||c =='o'||c =='u'||
                    c =='A'||c =='E'||c =='I'||c =='O'||c =='U')
            {
                count ++;
            }
        }
        return count;
    }
}
