package LinkedList2;


import java.util.Scanner;

public class ReverseLLRecursiveBest {
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

//    here we are also getting the time complexity O(n) like doublenode way but in this it is easy
    //Logic:
    public static Node<Integer> reverseLLBest(Node<Integer> head){
        if (head == null || head.next == null) {
            return head;
        }

        // here the value of reverse tail is equal to the value of head.next so we don't need to traverse the whole to find the tail to link the last element
        Node<Integer> reversedTail = head.next;
        Node<Integer> smallHead = reverseLLBest(head.next);

        reversedTail.next = head;
        head.next = null;

        return smallHead;
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
        head = reverseLLBest(head);
        print(head);
    }


}
