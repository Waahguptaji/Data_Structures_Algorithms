/*
Problem Name: Print Reverse LinkedList Iteratively
*/

package LinkedList2;


import java.util.Scanner;

public class ReverseLinkedList_Iteratively {

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

    public static Node<Integer> reverse(Node<Integer> head){
        Node<Integer> previous = null, current = head, temp = null;
        while (current != null){
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        head = previous;
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
        head = reverse(head);
        print(head);
    }
}
