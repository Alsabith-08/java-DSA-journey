package DSA;

// search in strings

public class SearchInString {
    public static void main(String[] args) {
        String name = "Alsabith";
        char target = 'a';

        System.out.println(Search(name, target));

    }

    static boolean Search(String str, char target) {
        if (str.length() == 0) {
            return false;
        }

        // for loop
        for (int i = 0; i < str.length(); i++) {
            if (target == str.charAt(i)) {
                return true;
            }
        }

//        // for -each loop
//        for(char ch : str.toCharArray()){  //for each loop
//            if(ch == target){
//                return true;
//            }
//        }
        return false;
    }
}
