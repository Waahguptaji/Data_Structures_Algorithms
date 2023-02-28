package LinkedList2;

import java.util.LinkedList;

public class CollectionsLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);//it adds at last
        list.add(20);
        list.add(30);
        list.addFirst(40);//it adds at the first of list
        list.set(2,100);//it set the 2nd position 100
        System.out.println(list.size());//it print the size of the list

        //iteration and printing the element of list
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
    }

}
