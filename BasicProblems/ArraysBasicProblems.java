package Revision;

import java.util.Arrays;

/*
  1. Print all elements of an array.
  2. Find the largest and smallest element.
  3. Reverse an array.
  4. Find the second-largest element.
  5. Check whether an element exists in the array (Linear Search).
 */

public class ArraysBasicProblems {
    public static void main(String[] args) {
        int[] arr = {2,5,6,7,9,0,1,2};
        reverse(arr);

        // methods to print the element in Array
        // method :1 use for loop
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i] + " ");
        }
        // method :2 use the enhanced for loop
        for(int num : arr){
            System.out.println(num + " ");
        }
        // method :3 use Arrays.toString Methods
        // it is works only for primitive and objects array
        System.out.println(Arrays.toString(arr));


        // print reverse array
        System.out.println("Reverse an Array : "+Arrays.toString(arr));

        // print the second-largest element
        System.out.println("Second Largest Element : "+Secondlargest(arr));

        // print the largest element
        System.out.println("Largest Element : "+largest(arr));

        // print the smallest element
        System.out.println("Smallest Element :" + smallest(arr));

        // Check the element if exist or not
        System.out.println(check(arr, 6));

    }

    // . Reverse An Array
    public static void reverse(int[] arr){
        int i=0 , j = arr.length-1;

        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    // 4. find the second-largest Element
    public static int Secondlargest(int[] arr){
        int largest = 0;
        int slargest = -1;

        for (int i = 1; i <arr.length ; i++) {
            if(arr[i] > largest){
                slargest = largest;
                largest = arr[i];
            }

            else if(arr[i] < largest && arr[i] > slargest){
                slargest  = arr[i];
            }
        }
        return slargest;
    }

    // 2. find the largest and smallest element
    // largest
    public static int largest(int[] arr){
        int largest = arr[0];
        for (int i = 1; i < arr.length ;i++) {
            if(arr[i] > largest){
                largest = arr[i];
            }
        }
        return largest;
    }

    // 2. find the smallest
    public static int smallest (int[] arr){
        int smallest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < smallest){
               smallest = arr[i];
            }
        }
        return smallest;
    }

    // 5. Check Element if exists in an Array
    public static boolean check(int[] arr , int target){
        for (int i = 0; i < arr.length; i++) {
            if(target == arr[i]){
                return true;
            }
        }
        return false;
    }
}
