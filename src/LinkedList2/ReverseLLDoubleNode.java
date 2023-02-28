package LinkedList2;


import java.util.Scanner;

// in java there can be only one public class
 class DoubleNode {// we are making this class to return two data
     Node<Integer> head;
     Node<Integer> tail;
}
public class ReverseLLDoubleNode {

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

    public  static  DoubleNode reverseLLDoubleNode(Node<Integer> head){
        if (head == null || head.next == null) {//base CAse
            DoubleNode ans = new DoubleNode();// firs we are creating object of the class to update the data
            ans.head = head;
            ans.tail = head;
            return ans;//returning it contains tail and head
        }

        DoubleNode smallAns = reverseLLDoubleNode(head.next);
        smallAns.tail.next = head;
        head.next = null;

        DoubleNode ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;
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
        DoubleNode ans = reverseLLDoubleNode(head);
        print(ans.head);
    }

}
