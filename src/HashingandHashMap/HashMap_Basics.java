package HashingandHashMap;
// Importing HashMap class


import java.util.HashMap;

//n Java, HashMap is a part of Java’s collection since Java 1.2.This class is found in java.util package.
// It provides the basic implementation of the Map interface of Java.
// HashMap in Java stores the data in (Key, Value) pairs, and you can access them by an index of another type (e.g. an Integer). One object is used as a key (index) to another object (value).
// *** If you try to insert the duplicate key in HashMap, it will replace the element of the corresponding key.

/*
*Points to remember
-> Java HashMap contains values based on the key.
-> Java HashMap contains only unique keys.
-> Java HashMap may have one null key and multiple null values.
-> Java HashMap is non synchronized.
-> Java HashMap maintains no order.
-> The initial default capacity of Java HashMap class is 16 with a load factor of 0.75.
*/
public class HashMap_Basics {

    //HashMap takes More space complexity but decrease the Time complexity by Half
    public static void main(String[] args) {

        // Create an empty hash map by declaring object
        // of string and integer type
        HashMap<String, Integer> map = new HashMap<>();//we can give a length if we want otherwise it is dynamic

        // Adding elements to the Map
        // using standard put() method
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);

        // Print size and content of the Map
        System.out.println("Size of map is:- "
                + map.size());

        // Printing elements in object of Map
        System.out.println(map);

        // Checking if a key is present and if
        // present, print value by passing
        // random element
        if (map.containsKey("vishal")) {

            // Mapping
            Integer a = map.get("vishal");

            // Printing value for the corresponding key
            System.out.println("value for key"
                    + " \"vishal\" is:- " + a);
        }
    }
}

