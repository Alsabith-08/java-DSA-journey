package Hashing;

import java.util.HashSet;

// https://leetcode.com/problems/happy-number/description/
// Approach : 
// IDEA: 

// Time Complexity : O()   , space Complexity: O()

public class HappyNumber_202 {
    public static void main(String[] args){
        int num = 81;

        System.out.println(happyNumber(num));
    }

    static boolean happyNumber(int num){

        HashSet<Integer> set = new HashSet<>();

        while(num != 1 && !set.contains(num)){
            set.add(num);

            int sum = 0;

            while(num > 0){
                int digit = num % 10;
                sum += digit * digit;
                num = num /10;
            }
        num = sum;
        }
        return num == 1;
    }
}
