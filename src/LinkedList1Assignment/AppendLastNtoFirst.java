/*

Problem Name: AppendLastNToFirst
Problem Level: MEDIUM
Problem Description:
#### You have been given a singly linked list of integers along with an integer 'N'. Write a function to append the last 'N' nodes towards the front of the singly linked list and returns the new head to the list.

##### Input format :
    The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

    The first line of each test case or query contains the elements of the singly linked list separated by a single space.

    The second line contains the integer value 'N'. It denotes the number of nodes to be moved from last to the front of the singly linked list.

##### Remember/Consider :
    While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.

##### Output format :
    For each test case/query, print the resulting singly linked list of integers in a row, separated by a single space.

    Output for every test case will be printed in a seperate line.*/
package LinkedList1Assignment;

import java.util.Scanner;

public class AppendLastNtoFirst {
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

    public static Node<Integer> append(Node<Integer> head, int pos){
        Node<Integer> node = head, tempNode = null, newHead = null;// we are creating the temp to store the value of Head original so
                                     // whenever we need to use it further, so it starts from starting

        if (pos == 0) {
            return head;
        }
        int count = 0;

        while (node != null){
           node =node.next;
           count++;
        }

        if (count < pos) {
            return head;
        }

        node = head; //here we are resetting the value of head from null

        int i =0;
        while (i != count - pos -1 ){//-1 because ek pehle rukenge wrna next waala store karlega ek extra kaa
            node = node.next;
            i++;
        }

        tempNode = node.next;//here we are storing the node.next which is going to be the new head of the linkedlist
        node.next = null;
        newHead = tempNode;
        //here we are traversing the new linked list  until the end so we can append the first one at the end
        while (tempNode.next !=null){
            tempNode = tempNode.next;
        }
        tempNode.next = head;
        head =newHead;
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
        head = append(head, 3);
        print(head);

    }


}
