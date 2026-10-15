
// https://leetcode.com/problems/string-compression/description/

import java.util.Arrays;

public class StringCompression_443 {
    public static void main(String[] args) {
        char[] chars = {'a' , 'a' , 'b' , 'b','b','c','c'};

        int length = compress(chars);

        System.out.println("Compressed length :" + length);

        for (int i = 0; i < length; i++) {
            System.out.print(chars[i] + " ");
        }
        //             OR
        System.out.print("Compressed Array :"+Arrays.toString(Arrays.copyOf(chars , length)));

    }

    static int compress(char[] chars){

        // initialize Pointers
        int read = 0;     // read - first element
        int write = 0;    // write - first position


        while(read < chars.length){

            // get the current character
            char current = chars[read];

            // count consecutive occurrences
            int count = 0;
            while(read < chars.length && chars[read] == current){
                read++;
                count++;
            }

            // write the character
            chars[write] = current;
            write++;

            // write count
            if(count > 1){
                String countString = String.valueOf(count);   // "2"

                for(char digit : countString.toCharArray()){  // 2
                    chars[write] = digit;
                    write++;
                }
            }
        }
        return write;
    }
}
