package LinkedList2;

import java.util.Scanner;

public class InsertLLRecursively {

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
    
    public static Node<Integer> insert(Node<Integer> head, int pos, int elem) {
        //Base Case 
        if (pos == 0) {
            Node<Integer> newNode = new Node<>(elem);
            newNode.next = head;
            return newNode;
        }
        //if the position exceeds the size of the linkedlist
        if (head == null) {
            return head;
        }

        head.next = insert(head.next, pos -1, elem);
        return  head;
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
        head = insert(head, 3 , 6);
        print(head);
    }
}
