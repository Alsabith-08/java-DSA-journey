package LeetCodeEx.Strings;

public class ReverseVowels_345 {
    public static void main(String[] args) {
        String s = "Alsa";

        String result = reverseVowel(s);
        System.out.println("Input : " + s);
        System.out.println("Output :" + result);
    }

    static boolean isVowel(char ch) {
        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' ||
                ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    static String reverseVowel(String s) {
        char[] chars = s.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while(left < right){
        // move left until we find a vowel
        while (left < right && !isVowel(chars[left])) {
            left++;
        }
        // move right until we find a vowel
        while (left < right && !isVowel(chars[right])) {
            right--;
        }

        // Swap the vowels
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;

        left++;
        right--;
    }
    return new String(chars);
}
}
