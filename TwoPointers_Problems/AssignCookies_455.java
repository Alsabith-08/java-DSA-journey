
// https://leetcode.com/problems/assign-cookies/
// Approach : Two Pointers (both on same pointers)
// IDEA : sort both array , both pointer are point to last index
//        cookie(index) is greater than child(index) increase maxSum +1 , decrease both pointers
//        otherWise , decrease child --

// Time Complexity :O(n log n)   , Space Complexity :O(1)

import java.util.Arrays;

public class AssignCookies_455 {
    public static void main(String[] args) {
        int[] children = {1,2,3};
        int[] cookies = {1,1};

        System.out.println(contentChildren(children , cookies));
    }

    public static int contentChildren(int[] g, int[] s) {
            int cookiesNums = s.length;                            // check cookies == 0 , return 0
            if(cookiesNums == 0)  return 0;

            Arrays.sort(g);                                   // sort both array
            Arrays.sort(s);

            int maxNum = 0;                                   // variable called maxNum that count our contentChilderen
            int cookie = s.length - 1;                        // Two Pointers : both are last index
            int child = g.length - 1;

            while(cookie >= 0 && child >=0){                  // check both pointers have atleast one
                if(s[cookie] >= g[child]){                    // cookie >= children
                    maxNum++;                                 // increase maxSum , then move both pointers -1
                    cookie--;
                    child--;
                }
                else{
                    child--;                                  // otherWise , move child pointer
                }
            }

            return maxNum;
        }
    }

