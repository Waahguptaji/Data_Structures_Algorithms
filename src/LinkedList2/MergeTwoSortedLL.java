package LinkedList2;

import java.util.Scanner;

public class MergeTwoSortedLL {
    public static Node<Integer> takeInput(){
        Node<Integer> head = null, tail = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Data: ");
        int data = sc.nextInt();
        while(data != -1){
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
        return head;
    }



    public static Node<Integer> mergeTwoList(Node<Integer> head1, Node<Integer> head2){
        if (head1==null)
        {
            return head2;
        }
        if (head2==null)
        {
            return head1;
        }

//main logic
        Node<Integer> newHead = null, newTail = null;
        Node<Integer> node1 = head1, node2 = head2;
        if (node1.data < node2.data){
            newHead = node1;
            newTail = node1;
            node1=node1.next;
        }else {
            newHead = node2;
            newTail = node2;
            node2=node2.next;
        }

        while (node1 != null && node2 != null){
            if (node1.data < node2.data){
                newTail.next = node1;
                newTail = newTail.next;
                node1 = node1.next;

            }else{
                newTail.next = node2;
                newTail = newTail.next;
                node2 = node2.next;
            }
        }


        if(node2 == null) {
            newTail.next=node1;

        }
        if (node1 == null) {
            newTail.next=node2;
        }
        return newHead;
    }

    public static void print(Node<Integer> newHead){
        while (newHead!=null){
            System.out.print(newHead.data+ " ");
            newHead =newHead.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node<Integer> head1 = takeInput();
        Node<Integer> head2 = takeInput();
        Node<Integer> newHead = mergeTwoList(head1, head2);
        print(newHead);
    }
}
