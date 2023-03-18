/*
Assignment Coding Problem
Problem Name: kReverse
Problem Level: MEDIUM
Problem Description: #### Implement kReverse( int k ) in a linked list i.e. you need to reverse first K elements then reverse next k elements and join the linked list and so on.
####Indexing starts from 0. If less than k elements left in the last, you need to reverse them as well. If k is greater than length of LL, reverse the complete LL.

####You don't need to print the elements, just return the head of updated LL.

`Input format : `

 `Line 1 : Linked list elements (separated by space and terminated by -1)`

 `Line 2 : k`

 #####Sample Input 1 :
    1 2 3 4 5 6 7 8 9 10 -1
    4

#####Sample Output 1 :
    4 3 2 1 8 7 6 5 10 9*/

package LinkedList2Assignment;

import java.util.Scanner;

public class kReverse {

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
    public static Node<Integer> kReverses(Node<Integer> head, int k){
        if(head==null || head.next == null || k == 0) {
            return head;
        }

        Node<Integer> curr = head, temp = null, prev = null;

        int count = 0;
        while (curr != null && count < k){//solving the small problem
            temp = curr.next;
            curr.next = prev;
            prev = curr;
             curr = temp;
             count++;
        }

        //here to join the k reverse linked list with other we store the result in head.next
        if (temp != null) {
            head.next = kReverses(temp, k);// here we are passing temp because as we know it will point to the node after the prev.
        }
        return prev;
    }

    public static void print(Node<Integer> head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        head = kReverses(head, 3);
        print(head);
    }


}
