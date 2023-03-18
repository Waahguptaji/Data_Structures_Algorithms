/*
* Assignment Coding Problem
Problem Name: Bubble Sort (Iterative) LinkedList
Problem Level: MEDIUM
Problem Description: ####Sort a given linked list using Bubble Sort (iteratively). While sorting, you need to swap the entire nodes, not just the data.

#####You don't need to print the elements, just sort the elements and return the head of updated LL.

`Input format : Linked list elements (separated by space and terminated by -1)``
 #####Sample Input 1 :
    1 4 5 2 -1

#####Sample Output 1 :
    1 2 4 5
*/

package LinkedList2Assignment;

import java.util.Scanner;

public class BubbleSort_iteratively {
    public static Node<Integer> takeInput() {
        Node<Integer> head = null, tail = null;
        System.out.println("Enter the Data: ");
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        while (data != -1){
            Node<Integer> newNode = new Node<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;// because when there is one element the tail and head would be the same
            }else {
                tail.next = newNode;
                tail = tail.next; // or tail = new node

            }
            data = s.nextInt();// next number lenge
        }
        return head;
    }

    public static int findLengthOfLL(Node<Integer> head){
        int count = 0;
        while (head != null){
            head  = head.next;
            count++;
        }
        return  count;
    }

    public static Node<Integer> bubbleSort(Node<Integer> head){
        if (head == null || head.next == null) {
            return head;
        }
        int n = findLengthOfLL(head);
        Node<Integer> node1 = null, node2 = null;

        int temp;
        for (int i = 0; i < n; i++) {
            node1 = head;
            node2 = head.next;
            for (int j = 0; j < n-i && node2 != null ; j++) {
                if (node1.data > node2.data) {
                    temp = node2.data;
                    node2.data = node1.data;
                    node1.data = temp;
                }
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return head;
    }

    public static void print(Node<Integer> head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next; //it means it stores the address of the next of node that will contain the next nodes
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        head = bubbleSort(head);
        print(head);
    }
}
