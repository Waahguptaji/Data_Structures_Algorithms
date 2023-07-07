package HashingandHashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//Method: By Hashing - HashSet.
//Time Complexity: O(N) && Space Complexity : O(N)
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


    //Method: By Hashing - HashMap
    //Time Complexity: O(N) && Space Complexity : O(N)
    static void repeatHashMap(int[] arr){
        int n = arr.length;

        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < n; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i],1);//that means only occured for one time
            }else {
                map.put(arr[i], map.get(arr[i]) + 1);//we store the occurence in the value
            }
        }

        //Entryset is a function  that create two set in Hashmap that store Key and their Value Individually.
        //So using it we can easily print whatever value or key we want.
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue()!=1)//It will see occurence of the key, if it occured more than one time than itis repeated
                System.out.print(entry.getKey()+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,-1,1,3,1};
        nonRepeatHashset(arr);
    }
}
