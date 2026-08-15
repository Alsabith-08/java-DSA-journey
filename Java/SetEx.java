package Collection;

import java.util.*;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;

public class SetEx {
    public static void main(String[] args) {
        //Set - it doesn't allow duplicate values
        //    - doesn't  support index values

        // HashSet - no order
        Set<Integer> nums = new HashSet<Integer>();
        nums.add(5);  //it doesn't maintain  order ...
        nums.add(7);  //it doesn't allow duplicate values
        nums.add(4);  // use add method to add the value
        nums.add(2);
        nums.remove(2);  //use the remove method to remove the element in the arrays

        //System.out.println(nums.get(2));  // HashSet doesn't  support index values
//        for(int n : nums){
//            System.out.println(n);
//        }

        // TreeSet - sorting order...
        Set<Integer> nums1 = new TreeSet<Integer>();
        nums1.add(54);  //it's maintain sorting order ...
        nums1.add(76);  //it doesn't allow duplicate values
        nums1.add(43);  // use add method to add the value
        nums1.add(22);
        nums1.remove(2);  //use the remove method to remove the element in the arrays

//        for(int n1 : nums1) {
//            System.out.println(n1);
//        }

        // use the iterator instead of for loop
        Iterator<Integer> values =  nums1.iterator();  // iterator is used to traverse the array
        while(values.hasNext()){  // the hasNext() gives the next next element in the array
            System.out.println(values.next());  // the next() print the single element at a time
        }
    }
}

