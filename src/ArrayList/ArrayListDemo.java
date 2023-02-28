package ArrayList;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(); //as it is generic, so we can only use non-primitive data type
        ArrayList<String> list2 = new ArrayList<>();

        System.out.println(list1.size());//tells the number of elements in arraylist
        list1.add(15);//adds the elements
        list1.add(10);
        list1.add(20);
        list1.add(2,50);//add the element at index 2 and shift the element in 2nd index by one
        System.out.println(list1.size());
        System.out.println(list1.get(2));//get the element at index 2


        //foreach loop-> it is good for quick traversal but we cannot edit the element for that we had to use the for loop
        for (int elem: list1) {// It says -->for each int element in list1
            System.out.print(elem + " ");
            elem = 100;//we cannot change the element in foreach loop
        }
        System.out.println();

        for (int i = 0; i < list1.size() ; i++) {
            System.out.print(list1.get(i) + " ");
        }

        list1.remove(1);// remove the element at 1st index
        list1.set(0,22);// exchange the element at 0th index by 2



    }
}
