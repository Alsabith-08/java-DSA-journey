
// https://leetcode.com/problems/backspace-string-compare/description/
// Approach : Two Pointers + reverse Traversal
// IDEA : right -> left
//         increase skip count
//         character + skip -> skip Character,
//         character + no Skip -> valid Character

// Time Complexity : O(n +m)    , Space Complexity : O(1)
public class BackSpaceStringCompare_844 {
    public static void main(String[] args) {
        String s = "ac##";
        String t = "a#d#";

        System.out.println(check(s,t));
    }
    static boolean check(String s , String t){
        int ps = s.length() -1;                                    // Both pointers start from right
        int pt = t.length() -1;

        while(ps >= 0 || pt >=0){
            ps = getNextValid(s , ps);                           // move each pointer to next character that survives the backspace
            pt = getNextValid(t , pt);

            if(ps < 0 && pt < 0){                                // both are empty -> true
                return true;
            }
            if(ps < 0 || pt < 0){                                 // if not same -> false
                return false;
            }else if(s.charAt(ps) != t.charAt(pt)){               // if both end character are not same -> false
                return false;
            }
            ps--;                                                // move both pointers
            pt--;
        }
        return true;
    }
    static int getNextValid(String str , int end){
        int backSpace_count = 0;

        while(end >= 0){                                   // check last index is #
            if(str.charAt(end) == '#'){
                backSpace_count++;                         // if # count backSpace_count
            }else if(backSpace_count > 0){                 // if backspace > 0 reduce the backspace count
                backSpace_count--;
            }else{                                         // is character break it
                break;
            }
            end--;
        }
        return end;                                         // return where end (index)
    }
}
