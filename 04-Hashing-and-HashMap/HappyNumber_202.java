
// https://leetcode.com/problems/happy-number/description/
// Approach : HashSet + Digit Manipulation
// IDEA: Repeatedly sum the squares of a number’s digits using % 10 and / 10, 
//       and use a HashSet to detect cycles until the number becomes 1 (happy) or repeats (unhappy).

// Time Complexity : O(log n)   , space Complexity: O(1)

import java.util.HashSet;


public class HappyNumber_202 {
    public static void main(String[] args){
        int num = 81;

        System.out.println(happyNumber(num));
    }

    static boolean happyNumber(int num){

        HashSet<Integer> set = new HashSet<>();

        while(num != 1 && !set.contains(num)){           // if num is not 1 and not in set then add 
            set.add(num);

            int sum = 0;

            while(num > 0){                              // num > 0 
                int digit = num % 10;                    // digit - get the last number of number
                sum += digit * digit;                    // sum - multiple the digit to digit
                num = num /10;                           // / - remove the last value of digit
            }
        num = sum;                                       // assign sum on num
        }
        return num == 1;                                 // if num == 1 true(Happy Number)    , otherwise ,false(UnHappy Number)
    }
}
