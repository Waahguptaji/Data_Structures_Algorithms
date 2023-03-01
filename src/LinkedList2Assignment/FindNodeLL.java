/*
Problem Name: Find a node in LL (recursive)
Problem Level: MEDIUM
Problem Description: ####Given a linked list and an integer n you need to find and return index where n is present in the LL. Do this recursively.
####Return -1 if n is not present in the LL.

#####Indexing of nodes starts from 0.
#####Input format :
    Line 1 : Linked list elements (separated by space and terminated by -1)
    Line 2 : Integer n

#####Output format :
    Index
*/
package LinkedList2Assignment;

import java.util.Scanner;

public class FindNodeLL {

    public static Node<Integer> takeInput(){
        Node<Integer> head = null, tail = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the DAta: ");
        int data = sc.nextInt();
        while (data != -1){
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            }else {
                tail.next = newNode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return head;
    }

    //Approach - 01
    public static int searchHelper(Node<Integer> head, int elem, int pos){
        if(head == null){
            return -1;
        }

        if (head.data == elem) {
            return pos;
        }
        int ans = searchHelper(head.next, elem, pos + 1);
        return ans;
    }


    public static int searchRecursive(Node<Integer> head, int elem){
        return searchHelper(head, elem, 0);
    }



    /* Approach - 2
    public static int searchRecursive(Node<Integer> head, int elem){
        if(head == null){
            return -1;
        }

        if (head.data == elem) {
            return 0;
        }
        int smallIndex = searchRecursive(head.next, elem);
        if (smallIndex == -1) {
            return smallIndex;
        }else {
            return smallIndex + 1;
        }
    }
    */



    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        System.out.println(searchRecursive(head, 3));

    }


}
