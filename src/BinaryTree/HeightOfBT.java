/*
* Coding Problem Name: Height of binary tree
Problem Level: EASY
Problem Description: ####Given a binary tree, find and return the height of given tree.

#####Input format :
    Nodes in the level order form (separated by space). If any node does not have left or right child, take -1 in its place

#####Output format :
    Height

#####Constraints :
####**_1 <= N <= 10^5_**
 #####Sample Input :
    10
     9
    4
    -1
    -1
     5
     8
    -1
    6
    -1
    -1
    3
    -1
    -1
    -1
#####Sample Output :
    5
*/

package BinaryTree;

import java.util.Scanner;

public class HeightOfBT {

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

    public static int heightBT(BinaryTreeNode<Integer> root){
        if (root == null) {// Base Case
            return 0;
        }

        int lh = heightBT(root.left);
        int rh = heightBT(root.right);

        return 1 + Math.max(lh,rh);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        System.out.println(heightBT(root));
    }
}
