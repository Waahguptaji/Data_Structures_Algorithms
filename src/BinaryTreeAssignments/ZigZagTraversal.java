/*
*Assignment Coding Problem Name: ZigZag tree
Problem Level: MEDIUM
Problem Description: ####Given a binary tree, print the zig zag order i.e print level 1 from left to right, level 2 from right to left and so on. This means odd levels should get printed from left to right and even level right to left.

 `Input format : `

`Elements in level order form (separated by space)`

`(If any node does not have left or right child, take -1 in its place)`

`Output Format : `

`Elements are printed level wise, each level in new line (separated by space).`


 #####Sample Input :
    5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1

#####Sample Output :
    5
    10 6
    2 3
    9*/
package BinaryTreeAssignments;

import java.util.Scanner;
import java.util.Stack;

public class ZigZagTraversal {
    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner s = new Scanner(System.in);
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes =new QueueUsingLL<>();
        System.out.println("Enter root data:");
        int rootData = s.nextInt();
        if (rootData == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        pendingNodes.enqueue(root);
        while (!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front;
            try {
                front = pendingNodes.dequeue();
            } catch (QueueEmptyException e) {
                return null;
            }
            System.out.println("Enter the left child of"+ front.data);
            int leftChild = s.nextInt();
            if (leftChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
                pendingNodes.enqueue(child);
                front.left = child;
            }

            System.out.println("Enter the right child of"+ front.data);
            int rightChild = s.nextInt();
            if (rightChild != -1) {
                BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightChild);
                pendingNodes.enqueue(child);
                front.right = child;
            }
        }
        return root;
    }

    public static void zigZagLevelOrderUsingStack(BinaryTreeNode<Integer> root){
        if (root == null) {
            return;
        }

        Stack<BinaryTreeNode<Integer>> ms = new Stack<>();//ms-> Main Stack
        ms.push(root);
        Stack<BinaryTreeNode<Integer>> cs = new Stack<>();//cs--> Child Stack
        int level = 1;

        while (!ms.isEmpty()) {
            BinaryTreeNode<Integer> current = ms.pop();
            System.out.print(current.data + " ");

            if (level % 2 == 1) {// if odd then left to right traversal and also push element in child stack left to right
                if (current.left != null) {
                    cs.push(current.left);
                }
                if (current.right != null) {
                    cs.push(current.right);
                }
            }else{// even then right to left traversal and also push element in child stack right to left
                if (current.right != null) {
                    cs.push(current.right);
                }
                if (current.left != null) {
                    cs.push(current.left);
                }
            }

            if (ms.isEmpty()) {// if main stack is empty then transfer all the child stack element in main stack and create a new child stack
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        zigZagLevelOrderUsingStack(root);

    }

}
