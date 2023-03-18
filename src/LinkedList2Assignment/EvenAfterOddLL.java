/*
* Problem Name: Even after Odd LinkedList
Problem Level: MEDIUM
Problem Description: ####Arrange elements in a given Linked List such that, all even numbers are placed after odd numbers. Respective order of elements should remain same.

#### Note: Input and Output has already managed for you. You don't need to print the elements, instead return the head of updated LL.

##### Input format:
    Linked list elements (separated by space and terminated by -1)
##### Output format:
    Print the elements of updated Linked list.

 #####Sample Input 1 :
    1 4 5 2 -1

#####Sample Output 1 :
    1 5 4 2
 */

package LinkedList2Assignment;

import java.util.Scanner;

public class EvenAfterOddLL {

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

//    public static Node<Integer> evenOdd(Node<Integer> head){
//        if (head == null || head.next == null) {
//            return head;
//        }
//        Node<Integer> current = head;
//        Node<Integer> oddHead = null, oddTail = null;
//        Node<Integer> evenHead = null, evenTail = null;
//        //here we are taking input from main linked list to new created two seperate linked list for odd and even
//        while (current.next != null){
//            if (current.data % 2 == 0 ){
//                if (evenHead == null) {
//                    evenHead = current;
//                    evenTail = current;
//                }else {
//                evenTail.next = current;
//                evenTail = evenTail.next;
//            }
//            }else{
//                if (oddHead == null) {
//                    oddHead = current;
//                    oddTail = current;
//                }else {
//                    oddTail.next = current;
//                    oddTail = oddTail.next;
//                }
//            }
//            current = current.next;
//        }
//        //if whole list is even or whole list is odd
//        if (oddHead == null) {
//            head = oddHead;
//        }else {
//            oddHead.next = evenHead;
//        }
//
//        evenTail.next = null;
//        return head;
//    }

    public static Node EvenAfterOdd(Node head) {
        if (head == null) {
            return null;
        }

        Node<Integer> evenHead = null;
        Node<Integer> oddHead = null;
        Node<Integer> evenTail = null;
        Node<Integer> oddTail = null;
        Node<Integer> current = head;

        while (current.next != null) {
            if (current.data % 2 == 0) {
                if (evenHead == null) {
                    evenHead = evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }

            } else {
                if (oddHead == null) {
                    oddHead = oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            }
            current = current.next;
        }

//        if (current.data % 2 == 0) {
//            evenTail.next = current;
//            evenTail = current;
//        }

        if (evenHead == null) {
            head = oddHead;
        } else if (oddHead == null) {
            head = evenHead;
        } else {
            head = evenHead;
            evenTail.next = oddHead;
            oddTail.next = null;
        }
        return head;
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
        head = EvenAfterOdd(head);
        print(head);

    }
}
