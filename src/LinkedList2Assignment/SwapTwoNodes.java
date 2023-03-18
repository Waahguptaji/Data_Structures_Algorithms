/*
* Assignment Coding Problem
Problem Name: Swap two Node of LL
Problem Level: MEDIUM
Problem Description: ####Given a linked list, i & j, swap the nodes that are present at i & j position in the LL. You need to swap the entire nodes, not just the data.

#####Indexing starts from 0. You don't need to print the elements, just swap and return the head of updated LL.

#####Assume i & j given will be within limits. And i can be greater than j also.

`Input format : `

`Line 1 : Linked list elements (separated by space and terminated by -1)`

`Line 2 : i and j (separated by space)`
 #####Sample Input 1 :
    3 4 5 2 6 1 9 -1
    3 4

#####Sample Output 1 :
    3 4 5 6 2 1 9*/
package LinkedList2Assignment;

import java.util.Scanner;

public class SwapTwoNodes {

    public static Node<Integer> takeInput()// here we are returning in node<Integer> type because we want to return the value of head
    {
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

    public static Node<Integer> swap2Node(Node<Integer> head, int i, int j){
        Node<Integer> nodeX = head, nodeY = head, prevX , prevY ;

            for (int count = 0; count < i - 1 ; count++) {
                nodeX = nodeX.next;
            }
            prevX = nodeX;
            nodeX = nodeX.next;
            for (int count = 0; count < j - 1 ; count++) {
                nodeY = nodeY.next;
            }
            prevY = nodeY;
            nodeY = nodeY.next;

        Node<Integer> temp;
        temp = nodeY.next;
        nodeY.next = nodeX.next;
        nodeY.next = temp;

        if (prevX == null) {
            nodeY = head;
            prevY.next = nodeX;
        }
        if (prevY == null) {
            nodeX =head;
            prevX.next = nodeY;
        }
        if (prevX != null && prevY != null) {
                prevX.next =nodeY;
                prevY.next = nodeX;
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
        head = swap2Node(head, 2, 5);
        print(head);
    }
}
