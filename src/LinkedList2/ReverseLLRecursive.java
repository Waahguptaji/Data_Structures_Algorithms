 /*
Problem Name: Print Reverse LinkedList
Problem Level: MEDIUM
Problem Description:
#### You have been given a singly linked list of integers. Write a function to print the list in a reverse order.

#### To explain it further, you need to start printing the data from the tail and move towards the head of the list, printing the head data at the end.

##### Note :
    You can’t change any of the pointers in the linked list, just print it in the reverse order.

##### Input format :
    The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

    The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.

##### Remember/Constraints :
    While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.

##### Output format :
    For each test case, print the singly linked list of integers in a reverse fashion, in a row, separated by a single space.

    Output for every test case will be printed in a seperate line.
*/

 package LinkedList2;


 import java.util.Scanner;

 public class ReverseLLRecursive {

    public static Node<Integer> takeInput(){
        Node<Integer> head = null, tail = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data: ");
        int data = sc.nextInt();
        while (data!= -1){
            Node<Integer> newNode = new Node<>(data);
            if (head == null){
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

//In this approach the time complexity is O(n2)

    //Logic:-
    public  static Node<Integer> reverse(Node<Integer> head){
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> newHead = reverse(head.next);
        Node<Integer> headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;
    }

    public static void print(Node<Integer> head){
        while (head != null){
            System.out.print(head.data+ " ");
            head = head.next;
        }
        System.out.println();
    }

     public static void main(String[] args) {
         Node<Integer> head = takeInput();
         head = reverse(head);
         print(head);
     }
}
