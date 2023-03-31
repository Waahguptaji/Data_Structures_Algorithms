/*
Assignment Coding Problem Name: Nodes without sibling
Problem Level: MEDIUM
Problem Description: ####Given a binary tree, print all nodes that don’t have a sibling.
#####Edit : Print the elements in different lines. And order of elements doesn't matter.

#####Input format :
    Elements in level order form (separated by space). If any node does not have left or right child, take -1 in its place.

#####Output format :
    Print nodes separated by new line.

 #####Sample Input :
    5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1

#####Sample Output :
    9

*/

package BinaryTreeAssignments;

import java.util.Scanner;

public class NodesWithoutSibling {
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
    public static void printTreeLevelWise(BinaryTreeNode<Integer> root){
        QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes =new QueueUsingLL<>();
        pendingNodes.enqueue(root);
        if (root == null) {
            return ;
        }
        while(!pendingNodes.isEmpty()){
            BinaryTreeNode<Integer> front;
            try {
                front = pendingNodes.dequeue();// root ko nikala

            } catch (QueueEmptyException e) {
                return;
            }
            System.out.print(front.data + ": ");//root ko print karaya
            if (front.left != null){
                System.out.print("L:" + front.left.data + ",");
                pendingNodes.enqueue(front.left);
            }else{// == null
                System.out.print("L:-1 ");
            }

            if (front.right != null){
                System.out.print("R:" + front.right.data );
                pendingNodes.enqueue(front.right);
            }else{// == null
                System.out.print("R:-1 ");
            }
            System.out.println();
        }
    }

    public static void withoutSibling(BinaryTreeNode<Integer> root ){
        if (root == null) {
            return;
        }


        if (root.left != null && root.right == null) {
            System.out.println(root.left.data);
        } else if (root.left == null && root.right != null) {
            System.out.println(root.right.data);
        }
        withoutSibling(root.left);
        withoutSibling(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        withoutSibling(root);
    }
}
