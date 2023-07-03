package HashingandHashMap;

import java.util.HashSet;

public class RemovesDuplicates {


    //Using HashSet
    static  void removes(int[] arr){
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        System.out.println(set);
    }



/*    OPTIMISED

    //Time Complexity: O(N) ans space complexity: O(1)
    static int removes(int[] arr){
        int n = arr.length;
        int k = 0;

        for (int i = 1; i < n ; i++) {
                if (arr[k] != arr[i]) {// if element is not equal
                    k++;
                    arr[k] = arr[i];
                }
            }
        return k+1 ;//length of unique element array
    }
 */

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,3,3,4,4};
        removes(arr);
    }
}
