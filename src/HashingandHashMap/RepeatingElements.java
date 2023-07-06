package HashingandHashMap;

import java.util.HashSet;
public class RepeatingElements {
    static void repeatHashing(int[] arr){
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> repeatedSet = new HashSet<>();//It will store the repeated element
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])){
                if (repeatedSet.add(arr[i])) {//The add() method of HashSet returns true if the element is successfully added to the set,
                    // indicating that it is a new unique element. It returns false if the element is already present in the set, indicating that it is a repeated element.
                    System.out.println(arr[i]);
                }
            }else {
                set.add(arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0};
        repeatHashing(arr);
    }
}
