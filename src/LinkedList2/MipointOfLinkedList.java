//Midpoint of a LinkedList
package LinkedList2;

import java.util.Scanner;

public class MipointOfLinkedList {

    public static Node<Integer> takeInput(){
            Node<Integer> head = null, tail = null;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the data: ");
            int data = sc.nextInt();

            while (data != -1){
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
            return  head;
    }

    public static void midpointUsingCount(Node<Integer> head){
        Node<Integer> tempHead = head;
        int count = 0;
        //for getting length
        while (tempHead!= null){
            tempHead =tempHead.next;
            count++;
        }

        tempHead =head;//reseting the value
        int length = 0;
        while (length != count/2 && tempHead != null){
            tempHead = tempHead.next;
            length++;
        }
        if (length == count/2 &&  tempHead != null){
            System.out.println("The midpoint is: " + tempHead.data);
        }

        if ( count/2 == 0 && length == count/2  &&  tempHead != null){
            System.out.println("The midpoint is: " + tempHead.data);
        }

    }
    public static void midpointUsingPointer(Node<Integer> head){
        //here we doing it by two pointer approach in which we are taking fast and slow. Slow move one and fast move two so,
        //when fast is at the end of linkedlist the slow will be at mid, and we return slow
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        while(fast.next != null && fast.next.next != null){// these  are two conditon because of even and odd both
            // fast pointer is taking two steps at a time
            fast = fast.next.next;
           // slow pointer is taking one step at a time
            slow = slow.next;
        }
        System.out.println("The mid point is: " + slow.data);
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        midpointUsingPointer(head);
        midpointUsingCount(head);
    }
}
