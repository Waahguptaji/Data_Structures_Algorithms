/*
* roblem Name: Length of a Singly Linked List(Iterative)
Problem Level: EASY
Problem Description:
#### For a given singly linked list of integers, find and return its length. Do it using an iterative method.

##### Input format :
    The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

    First and the only line of each test case or query contains elements of the singly linked list separated by a single space.

##### Remember/Consider :
    While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.

##### Output format :
    For each test case, print the length of the linked list.

    Output for every test case will be printed in a seperate line.*/
package LinkedList1;

import java.util.LinkedList;
import java.util.Scanner;

public class LengthOfLinkedList {

    public static Node<Integer> takeInput(){
        Node<Integer> head =null, tail = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the Data: ");
        int data = sc.nextInt();

        while (data != -1) {
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

    public static void print(Node<Integer> head){
        int count =0;
        while(head != null){
            count ++;
            head = head.next; //it means it stores the address of the next of node that will contain the next nodes
        }

        System.out.println("the count is : "+ count);
    }


    public static void main(String[] args) {
        Node <Integer> head = takeInput();
        print(head);
    }
}
