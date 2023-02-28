package LinkedList2;

import java.util.Scanner;

public class DeleteNodeRecursively {
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

    public static  Node<Integer> delete(Node<Integer> head, int pos){
        //if position is greater than the length of the linkedlist
        if (head == null) {
            return head;
        }

        if (pos == 0) {//pehle hi position waala dete krna hai
            head = head.next;//head.next naya head ban jaayega
            return head;
        }else {
            Node<Integer> smallerHead = delete(head.next, pos - 1);
            head.next = smallerHead;
            return head;
        }
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
        head = delete(head, 3);
        print(head);
    }
}
