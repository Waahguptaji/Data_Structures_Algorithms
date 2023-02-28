/*
* Coding Problem
Problem Name: Delete a Node from Linked List
Problem Level: MEDIUM
Problem Description:
#### You have been given a linked list of integers. Your task is to write a function that deletes a node from a given position, 'pos'.

##### Note :
    Assume that the Indexing for the linked list always starts from 0.

    If the position is greater than or equal to the length of the linked list, you should return the same linked list without any change.
    *  ##### Sample Input 1 :
    1
    3 4 5 2 6 1 9 -1
    3

##### Sample Output 1 :
    3 4 5 6 1 9*/

package LinkedList1;

import java.util.Scanner;

public class DeleteNode {

    public static Node<Integer> takeInput()// here we are returning in node<Integer> type because we want to return the value of head
    {
        Node<Integer> head = null, tail = null;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the data : ");
        int data = s.nextInt();

        while (data != -1){
            Node<Integer> newNode = new Node<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;// because when there is one element the tail and head would be the same
            }else {
                // we're just putting the newNode reference in the tail next and then updating the tail to move further
                tail.next = newNode;
                tail = tail.next; // or tail = new node

            }
            data = s.nextInt();// next number lenge
        }
        return head;
    }


    public static Node<Integer> delete(Node<Integer> head, int pos ){

        if (head == null) {
            return head;

        }
        if (pos ==0){
            return head.next;
        }

        int i =0;
        Node<Integer> temp = head;
        while(i< pos -1){
            temp = temp.next;
            i++;
        }
        // then we had to create the link between the next of temp and next of the node which came after the node we wanted to delete.
        //when we create the link the existing link will break itself
        temp.next = temp.next.next;//here we are going to next of the next of temp.
        //temp.next.next --> we can only do this if we are sure that temp.next is not NULL
        return head;// we need to update the head in main function
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
        head = delete(head, 0);
        print(head);

    }
}
