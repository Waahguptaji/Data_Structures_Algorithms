package LinkedList2;

import java.util.Scanner;

public class CircularDoublyLLUSe {

    public static DoublyNode<Integer> takeInput() {
        DoublyNode<Integer> head = null, tail = null, prev = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data: ");
         int data = sc.nextInt();
        while (data != -1) {
            DoublyNode<Integer> newNode = new DoublyNode<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                newNode.prev = newNode;

            } else {
                tail.next = newNode;
                newNode.prev = tail.next;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public  static DoublyNode<Integer> insert(DoublyNode<Integer> head,int data, int pos){

        DoublyNode<Integer> newNode = new DoublyNode<>(data);

        if(pos == 0){
            newNode.next = head;
            DoublyNode<Integer> lastNode = head.prev;//beacause of circular head ke previos mai lastNode ka adress hoga
            lastNode.next = newNode;
            newNode.prev = lastNode;
            head = newNode;
            head.next.prev = newNode;
            return head;
        }

        int i = 0; //intitially i is on the head so it is zero
        DoublyNode<Integer> temp = head;// Temp mai jisko bola hai head pr rehne ko
        while (i != pos - 1 ){
            temp = temp.next;// aage badh te jao
            i++;//i ko bhi aage badhao
        }
        //in LinkedList create links before breaking the old ones
        newNode.next = temp.next;//newNode ke next mai that means the one we want to insert
                               //uske next mai aage waale ke next ka address store kar
        newNode.prev = temp;//newNode ke prev mai that means the one we want to insert
        temp.next = newNode;//uske baad jo temp ka next hai uske newNode ka address store karo
        newNode.next.prev = newNode;
        return head;
    }


//    Print function will be same
    public static void print(DoublyNode<Integer> head){
        while (head !=null){
            System.out.print(head.data+ " ");
            head = head.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {
        DoublyNode<Integer> head = takeInput();
        head = insert(head, 80, 0);
        print(head);
    }

}
