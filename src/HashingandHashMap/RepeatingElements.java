package HashingandHashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;

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


    //Method: By Hashing - HashMap
    //Time Complexity: O(N) && Space Complexity : O(N)
    static void nonRepeatHashMap(int[] arr){
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i],1);//that means only occured for one time
            }else {
                map.put(arr[i], map.get(arr[i]) + 1);//we store the occurence in the value
            }
        }

        //Entryset is divides the Hashmap in to two sets by which we can get the value of Key and their values individually.
        //So using it we can easily print whatever value or key we want.
        for(Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue()==1)//It will see occurence of the key, if it occured for one time that means non repeated
                System.out.print(entry.getKey()+" ");
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,1,0};
        repeatHashing(arr);
    }
}
