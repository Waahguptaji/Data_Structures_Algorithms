package HashingandHashMap;

import java.util.HashMap;

public class RemovesDuplicatesUnsorted {

    //Using HashMap-In hash may Key should be unique and but value can be same.
    //so here we gonna store element in key because if any other same element occurs then it will be override, because as we know
    //key cannot be same
    static void removeDuplicate(int[] arr){
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(arr[i])) {
                System.out.println(arr[i] + " ");
                map.put(arr[i],1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,9,3,1,3,9};
        removeDuplicate(arr);
    }
}
