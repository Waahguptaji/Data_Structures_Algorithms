/*Problem Name: Palindrome LinkedList
Problem Level: MEDIUM
Problem Description:
#### You have been given a head to a singly linked list of integers. Write a function check to whether the list given is a 'Palindrome' or not.

##### Input format :
    The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

    First and the only line of each test case or query contains the the elements of the singly linked list separated by a single space.

##### Remember/Consider :
    While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.

##### Output format :
    For each test case, the only line of output that print 'true' if the list is Palindrome or 'false' otherwise.
*/

package LinkedList1Assignment;

import java.util.Scanner;

public class PalindromeLinkedList {
    public static Node<Integer> takeInput(){
        Node<Integer> head = null, tail = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data: ");
        int data = sc.nextInt();
        while (data!= -1){
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail =tail.next;
            }
            data = sc.nextInt();
        }
        return head;
    }


    public static Node<Integer> reverse(Node<Integer> revHead){
        if (revHead == null){
            return revHead;
        }
        Node<Integer> prev = null, curr = revHead, temp = null;
        while (curr!= null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        revHead = prev;
        return revHead;
    }

    public static boolean isPalindrome(Node<Integer> head, Node<Integer> revHead){
        boolean value = false;
        if (head == null){
            value = true;
        }
        Node<Integer> node = head;
        Node<Integer> revNode = revHead;
        while (node != null && revNode != null) {
            if (revHead.data == node.data) {
                value = true;
            }
            node = node.next;
            revNode = revHead.next;
        }
        return value;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        Node<Integer> revHead = reverse(head);
        System.out.println(isPalindrome(head,revHead));
    }
}
