package LinkedList1;

import java.util.Scanner;

public class LinkedListUse {

    public static Node<Integer> takeInput()// here we are returning in node<Integer> type because we want to return the value of head
    {
      Node<Integer> head = null, tail = null; //here we are taking tail to decrease the time complexity from O(n2) to O(n) because we don't have to
                                             // traverse every time till the end to find null
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();

        while (data != -1){
            Node<Integer> newNode = new Node<>(data);
            if(head == null){
                head = newNode;
                tail = newNode;// because when there is one element the tail and head would be the same
            }else {
                //here we are not doing the below method because it increases the time complexity instead we created a tail that stores the end of list,
                // so we do not need to traverse each time
//                Node<Integer> temp = head;
//                while (temp.next != null){
//                    temp = temp.next;//jab tak temp ke next ki value null nahi hoti tab tak aage badte raho,
//                                    // if hogayi then new node ke address ko temp ke next mai daaldo
//                }
//                temp.next = newNode;
                // we're just putting the newNode reference in the tail next and then updating the tail to move further
                tail.next = newNode;
                tail = tail.next; // or tail = new node

            }
            data = s.nextInt();// next number lenge
        }
        return head;
    }

    public static Node<Integer> insert(Node<Integer> head,int data, int pos ){//here we are returning the node<integer> type because in case of pos = 0 the insert function head will do the work of storing in the next of new node
                                                                             // but when we are calling it in  main it still talks about main head
        Node<Integer> newNode = new Node<>(data);

        if (pos ==0){
            newNode.next = head;
            return newNode;// we need to update the head in main function
        }

        int i = 0; //intitially i is on the head so it is zero
        Node<Integer> temp = head;// Temp mai jisko bola hai head pr rehne ko
        while (i< pos - 1){// here pos - 1 isliye agr hume 3rd index pr insert krna hai toh hume 2nd index prr rukhna padega
                          // because 3rd pr insert krne ke liye address toh 2nd ke next mai store hai
            temp = temp.next;// aage badh te jao
            i++;//i ko bhi aage badhao
        }
        //in LinkedList create links before breaking the old ones
        newNode.next = temp.next;//newNode ke next mai that means the one we want to insert
                                //uske next mai aage waale ke next ka address store kar
        temp.next = newNode;//uske baad jo temp ka next hai uske newNode ka address store karo
        return head;
    }


    public static void print(Node<Integer> head){// for printing or accessing the whole linked list we just need head
//        Node<Integer> temp = head;// we are creating the temp to store the value of Head original so
                                 // whenever we need to use it further, so it starts from starting
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next; //it means it stores the address of the next of node that will contain the next nodes
        }
        System.out.println();
//        head = temp; //here we are resetting the value of head from null
//        while (head != null){
//            System.out.print(head.data + " ");
//            head = head.next; //it means it stores the address of the next of node that will contain the next nodes
//        }
    }

    public static void main(String[] args) {

        Node<Integer> head = takeInput();
        head = insert(head, 80, 0);
        print(head);

//        Node<Integer> node1 = new Node<>(10);
//        Node<Integer> node2 = new Node<>(20);
//        Node<Integer> node3 = new Node<>(30);
//        node1.next = node2;//Here we are storing the reference of node 2 in next of node 1
//        node2.next = node3;
//        Node<Integer> head = node1;//head is referring to the node1
//        print(head);
//        print(head);
        //it will print two times because head we are giving is global and the head in print is local


    }

}
