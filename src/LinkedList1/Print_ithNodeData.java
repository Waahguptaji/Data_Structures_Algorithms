/*
* Coding Problem
Problem Name: Print i-th Node Data
Problem Level: EASY
Problem Description:
#### For a given a singly linked list of integers and a position 'i', print the node data at the 'i-th' position.

##### Note :
    Assume that the Indexing for the singly linked list always starts from 0.

    If the given position 'i',  is greater than the length of the given singly linked list, then don't print anything.


##### Input format :
    The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

    The first line of each test case or query contains the elements of the singly linked list separated by a single space.

    The second line contains the value of 'i'. It denotes the position in the given singly linked list.

##### Remember/Consider :
    While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.

#####Output format :
    For each test case, print the node data at the 'i-th' position of the linked list(if exists).

    Output for every test case will be printed in a seperate line.*/

package LinkedList1;

import java.util.Scanner;

public class Print_ithNodeData {
    public static Node<Integer> takeInput() {
        Node<Integer> head = null, tail = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data: ");
        int data = sc.nextInt();

        while (data != -1) {
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public static void printNodeData(Node<Integer> head, int pos) {
        int count = 0;
        Node<Integer> temp=head;
            while (count!= pos && temp!=null) {
                temp = temp.next; //it means it stores the address of the next of node that will contain the next nodes
                count++;
            }
        if (count == pos && temp!=null) {
            System.out.print(temp.data);
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        printNodeData(head, 10);
    }
}
