/*
Problem Name: Eliminate duplicates from LL
Problem Level: MEDIUM
Problem Description:
#### You have been given a singly linked list of integers where the elements are sorted in ascending order. Write a function that removes the consecutive duplicate values such that the given list only contains unique elements and returns the head to the updated list.

##### Input format :
    The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

    The first and the only line of each test case or query contains the elements(in ascending order) of the singly linked list separated by a single space.

##### Remember/Consider :
    While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.

##### Output format :
    For each test case/query, print the resulting singly linked list of integers in a row, separated by a single space.

    Output for every test case will be printed in a seperate line.*/

package LinkedList1Assignment;

import java.util.Scanner;

public class EliminateDuplicate {
    public static Node<Integer> takeInput(){
        Node<Integer> head =  null, tail = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data :");
        int data = sc.nextInt();

        while (data != -1){
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            }else {
                tail.next = newNode;
                tail =tail.next;
            }
            data =sc.nextInt();
        }
        return head;
    }

    public static Node<Integer> eliminate(Node<Integer> head){
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> node =head;
        while (node.next != null ){
            if (node.data.equals(node.next.data)){
                node.next = node.next.next;
            }else {
                node = node.next;
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
        head = eliminate(head);
        print(head);

    }
}
