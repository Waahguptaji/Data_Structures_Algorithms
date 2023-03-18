/*
Assignment Coding Problem Name: Delete every N nodes
Problem Level: MEDIUM
Problem Description: ####Given a linked list and two integers M and N. Traverse the linked list such that you retain M nodes then delete next N nodes, continue the same until end of the linked list. That is, in the given linked list you need to delete N nodes after every M nodes.

`Input format : `

 `Line 1 : Linked list elements (separated by space and terminated by -1)`

 `Line 2 : M`

`Line 3 : N`
#####Sample Input 1 :
    1 2 3 4 5 6 7 8 -1
    2
    2

#####Sample Output 1 :
    1 2 5 6
*/

package LinkedList2Assignment;

import java.util.Scanner;

public class DeleteNNodesAfterM {
    public static Node<Integer> takeInput(){
        Node<Integer> head = null, tail =null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Data");
        int data = sc.nextInt();
        while(data != -1){
            Node<Integer> newNode = new Node<>(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            }else {
                tail.next = newNode;
                tail = tail.next;
            }
            data = sc.nextInt();
        }
        return head;
    }

    public static Node<Integer> deleteNNode(Node<Integer> head, int M, int N){
        Node<Integer> curr = head, delnode;
        while (curr != null ){
              //skip M Nodes
             // The main loop that traverse through the whole list
            for (int count = 1; count < M && curr!= null ; count++) {
                curr = curr.next;
            }
            // If we reached end of list, then break
            if (curr == null){
                break;
            }
            // Start from next node and delete N nodes
            delnode = curr.next;
            for (int count = 1; count <= N && delnode != null ; count++) {
                delnode = delnode.next;
            }
            // Link the previous list with remaining nodes
            curr.next = delnode;
            // Set current pointer for next iteration
            curr = delnode;

        }
        return head;
    }

    public static void print(Node<Integer> head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInput();
        head = deleteNNode(head,2,0);
        print(head);
    }
}
