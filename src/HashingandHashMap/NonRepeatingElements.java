package HashingandHashMap;

import java.util.HashSet;

public class NonRepeatingElements {
    static void nonRepeatHashset(int[] arr){
        int n = arr.length;

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> repeatedSet = new HashSet<>();
        // Iterate through the array and populate the sets
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                repeatedSet.add(arr[i]);
            }else {
                set.add(arr[i]);
            }
        }

        // Create a set of non-repeating elements and remove the repeated elements
        HashSet<Integer> nonRepeatedSet = new HashSet<>(set);//Here I am creating a nonRepeatedSet which contain all elements of set
        nonRepeatedSet.removeAll(repeatedSet);//here I am removing the repeated elements

        for(Integer element: nonRepeatedSet){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,-1,1,3,1};
        nonRepeatHashset(arr);
    }
}
