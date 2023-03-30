/*
* Coding Problem Name: Is node present?
Problem Level: EASY
Problem Description: ####Given a Binary Tree and an integer x, check if node with data x is present in the input binary tree or not.
Return true or false.

#####Input format :
    Line 1: Elements in level order form (separated by space)
    (If any node does not have left or right child, take -1 in its place)
    Line 2 : Integer x

#####Output Format :
    true or false
 #####Sample Input :
    8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
    7

#####Sample Output :
    true
*/
package BinaryTree;

import java.util.Scanner;

public class IsNodePresent {

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

    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int n){
        if (root == null) {//Base Case
            return false;
        }

        if (root.data == n){
            return true;
        }
        else {
            return (isNodePresent(root.left, n) || isNodePresent(root.right, n));
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        System.out.println(isNodePresent(root, 7));
    }

}
