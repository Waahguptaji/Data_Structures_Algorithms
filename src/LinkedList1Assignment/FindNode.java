/*
Problem Name: Find a Node in Linked List
Problem Level: MEDIUM
Problem Description:
#### You have been given a singly linked list of integers. Write a function that returns the index/position of an integer data denoted by 'N'(if it exists). -1 otherwise.
##### Note :
    Assume that the Indexing for the singly linked list always starts from 0.

##### Input format :
    The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

    The first line of each test case or query contains the elements of the singly linked list separated by a single space.

    The second line contains the integer value 'N'. It denotes the data to be searched in the given singly linked list.

##### Remember/Consider :
    While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.

##### Output format :
    For each test case/query, print the index/position of 'N' in the singly linked list. -1, otherwise.

    Output for every test case will be printed in a seperate line.*/

package LinkedList1Assignment;
import java.util.Scanner;

public class FindNode {
    public static Node<Integer> takeInput(){
        Node<Integer> head = null, tail = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data: ");
        int data = sc.nextInt();

        while (data != -1){
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return  head;
    }

    public static int search(Node<Integer> head, int elem){
        Node<Integer> node = head;
        int count = 0;
        while (node != null) {
            if (elem == node.data) {
               return count;
            } else {
                node = node.next;
                count++;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the element : ");
        int elem = s.nextInt();
        System.out.println(search(head, elem));
    }
}
