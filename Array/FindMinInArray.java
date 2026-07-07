package ChatGPT_Problems;

public class FindMinInArray {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 97, 53, 89, 65, 5, 3};

        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}

