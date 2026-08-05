package BasicProblems;

//  Basic Problems
//  1. Count the frequency of elements in an array.
//  2. Count the frequency of characters in a string.
//  3. Find the first non-repeating character.
//  4. Find duplicate elements in an array.
//  5. Check if two strings are anagrams.

import java.util.Arrays;
import java.util.HashMap;

public class Hashing {
    public static void main(String[] args) {

// 1. Count the Frequency of each element in array
        int[] arr = {2, 4, 4, 4, 6, 7, 8, 8, 0};

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        System.out.println(map);


// 2. Count the frequency of each Character in String
        String string = "alsabithberlin";

        HashMap<Character , Integer> map1 = new HashMap<>();

        for(char ch : string.toCharArray()){
            map1.put(ch , map1.getOrDefault(ch , 0) + 1);
        }
        System.out.println(map1);



// 3. Find the First-non Repeating Character
        String string2 = "alsabithberlin";

        HashMap<Character , Integer> map2 = new HashMap<>();

        for(char ch : string2.toCharArray()){
            map2.put(ch , map2.getOrDefault(ch , 0) +1);
        }
        for(char ch : string2.toCharArray()) {
            if (map2.get(ch) == 1) {
                System.out.println("First Non-Repeating Character : " + ch);
                break;
            }
        }

// 4. find Duplicate Element in an Array
        int[] arr1 ={1,2,3,2,4,5,1};

        HashMap<Integer , Integer> map3 = new HashMap<>();

        for(int num2: arr1){
            map3.put(num2 , map3.getOrDefault(num2 , 0) +1);

            if(map3.get(num2) == 2){
                System.out.println(num2);
            }
        }

// call the checkAnagram
        String s1 = "alsAbith";
        String s2 = "hibsAalt";
        checkAnagram(s1 , s2);

// Anagram Using Sorting
        AnagramInSort(s1, s2);

        if(AnagramInArray(s1 , s2)){
            System.out.println("Anagram");
        }else{
            System.out.println("Not Anagram");
        }
    }

// Various Method to Find A Two String are Anagram or Not

    // 1. Using HashMap
    // 2. Using Sorting Logic
    // 3. Using Arrays

     // 5. Check if two strings are anagrams.
// Using HashMap
    static void checkAnagram(String s1 , String s2){

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if(s1.length() != s2.length()){
            System.out.println("Not Anagram");
            return;
        }

        HashMap<Character , Integer> map = new HashMap<>();

        for(char ch : s1.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0) + 1);
        }
        for(char ch : s2.toCharArray()){
            if(!map.containsKey(ch)){
                System.out.println("Not anagram");
                return;
            }
            map.put(ch ,map.get(ch) -1);

            if(map.get(ch) <0){
                System.out.println("Not Anagram");
                return;
            }
        }
        System.out.println("Anagram");
    }


// Using Sorting
    static void AnagramInSort(String s1 , String s2){
        if(s1.length() != s2.length()){
            System.out.println("Not Anagram");
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if(Arrays.equals(arr1, arr2)){
            System.out.println("Anagram");
        }else{
            System.out.println("Not Anagram");
        }
    }

// Using Array
    static boolean AnagramInArray(String s1 , String s2){

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if(s1.length() != s2.length()){
            System.out.println("Not Anagram");
        }

        int[] count = new int[26];

        for(int i=0 ; i< s1.length(); i++){
            count[s1.charAt(i) -'a']++;
        }

        for (int i = 0; i <s2.length() ; i++) {
            count[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26 ; i++) {
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
