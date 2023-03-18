/*
Given a linked list and two keys in it, swap nodes for two given keys. Nodes should be swapped by changing links. Swapping data of nodes may be expensive in many situations when data contains many fields. It may be assumed that all keys in the linked list are distinct.

Examples:

Input: 10->15->12->13->20->14,  x = 12, y = 20
Output: 10->15->20->13->12->14

Input: 10->15->12->13->20->14,  x = 10, y = 20
Output: 20->15->12->13->10->14
*/
package LinkedList2Assignment;
import java.util.Scanner;

public class SwapTwoNodesAtData {

    public static Node<Integer> takeInput() {
        Node<Integer> head = null, tail = null;
        System.out.println("Enter the Data: ");
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        while (data != -1){
            Node<Integer> newNode = new Node<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;// because when there is one element the tail and head would be the same
            }else {
                tail.next = newNode;
                tail = tail.next; // or tail = new node

            }
            data = s.nextInt();// next number lenge
        }
        return head;
    }

    public static void search(Node<Integer> head, int x, int y){

    }

    public static Node<Integer> swap2Node(Node<Integer> head, int x, int y){
        // Nothing to do if x and y are same
        if (x == y) {
            return head;
        }

        //Search
        Node<Integer> p = head, prev = null;
        while (p != null && p.data != x){
            prev = p;
            p = p.next;
        }
        Node<Integer> pX = p;
        Node<Integer> prevX = prev;

        p = head;
        prev = null;
        while (p != null && p.data != y){
            prev = p;
            p = p.next;
        }
        Node<Integer> pY = p;
        Node<Integer> prevY = prev;

        //Swapping
        Node<Integer> temp;
        temp = pY.next;
        pY.next = pX.next;
        pX.next = temp;


        //making new head in case of if one of the element is at head
        if (prevX == null){
            pY = head;
            prevY.next = pX;
        }

        if (prevY == null){
            pX = head;
            prevX.next = pY;
        }

        //This condition when the Nodes Are at internally or between
        if ( prevX != null && prevY != null) {
            prevX.next = pY;
            prevY.next = pX;
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
        head = swap2Node(head, 2, 5);
        print(head);
    }
}

